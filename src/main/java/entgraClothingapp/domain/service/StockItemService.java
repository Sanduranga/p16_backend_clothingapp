package entgraClothingapp.domain.service;

import entgraClothingapp.application.dto.request.CreateStockItemDto;
import entgraClothingapp.application.dto.response.StockItemDto;
import entgraClothingapp.domain.entity.Items;
import entgraClothingapp.domain.entity.StockClearItems;
import entgraClothingapp.external.repository.ItemRepository;
import entgraClothingapp.external.repository.StockItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StockItemService {
    private ItemRepository itemRepository;
    private StockItemRepository stockItemRepository;

    public StockClearItems addItem(CreateStockItemDto createStockItemDto) {
        Items items = itemRepository.findById(createStockItemDto.getId())
                .orElseThrow(() -> new RuntimeException("Item not found in the item's entity"));
                items.setStatus("stockClearingStore"); // change item's state

        StockClearItems stockClearItems = new StockClearItems();
        stockClearItems.setItems(items);
        stockClearItems.setStockClearingPrice(createStockItemDto.getStockClearingPrice());
        return stockItemRepository.save(stockClearItems);
    }

    public List<StockClearItems> getAllItems() {
        return  stockItemRepository.findAll();
    }

    public ResponseEntity<StockItemDto> getItem(Long id) {
        StockItemDto stockItemDto = new StockItemDto();
        Optional<StockClearItems> optionalItem = stockItemRepository.findById(id);
        if(optionalItem.isPresent()){
            StockClearItems stockClearItems = optionalItem.get();
            stockItemDto.setId(stockClearItems.getId());
            return ResponseEntity.ok(stockItemDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteItem(Long id) {
        StockClearItems stockClearItems = stockItemRepository.findById(id).orElse(null);
        if(stockClearItems != null){
            Items item = stockClearItems.getItems();
                if(item != null){
                    item.setStockClearItems(null); // update the stockClearItem of Items entity as `null`
                    item.setStatus("stockClearingStore"); // update the status of Items entity as `normalStore`
                    itemRepository.save(item);
                }
                stockItemRepository.delete(stockClearItems);
                return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
