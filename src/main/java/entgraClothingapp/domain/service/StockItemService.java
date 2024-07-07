package entgraClothingapp.domain.service;

import entgraClothingapp.application.dto.request.CreateStockItemDto;
import entgraClothingapp.application.dto.response.StockItemDto;
import entgraClothingapp.domain.entity.Items;
import entgraClothingapp.domain.entity.StockClearItems;
import entgraClothingapp.external.repository.ItemRepository;
import entgraClothingapp.external.repository.StockItemRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StockItemService {
    private final ItemRepository itemRepository;
    private final StockItemRepository stockItemRepository;

    @Transactional
    public ResponseEntity<StockClearItems> addItem(CreateStockItemDto createStockItemDto) {
        Items item = itemRepository.findByCode(createStockItemDto.getItemsCode())
                .orElse(null);
        if (item != null) {
            item.setStatus("stockClearingStore"); // change item's state
            StockClearItems stockClearItem = new StockClearItems();
            stockClearItem.setItems(item);
            stockClearItem.setItemsCode(createStockItemDto.getItemsCode());
            stockClearItem.setStockClearingPrice(createStockItemDto.getStockClearingPrice());
            stockItemRepository.save(stockClearItem);
            return ResponseEntity.status(201).body(stockClearItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    public ResponseEntity<List<StockClearItems>> getAllItems() {
        List<StockClearItems> stockClearItems = stockItemRepository.findAll();
        return ResponseEntity.ok(stockClearItems);
    }

    @Transactional
    public ResponseEntity<StockItemDto> getItem(Long code) {
        StockItemDto stockItemDto = new StockItemDto();
        Optional<StockClearItems> optionalItem = stockItemRepository.findByItemsCode(code);
        if(optionalItem.isPresent()){
            StockClearItems stockClearItems = optionalItem.get();
            stockItemDto.setStockClearingPrice(stockClearItems.getStockClearingPrice());
            stockItemDto.setItems(stockClearItems.getItems());
            return ResponseEntity.ok(stockItemDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    public ResponseEntity<Void> deleteItem(Long code) {
        Items item = itemRepository.findByCode(code).orElse(null);
        if(item != null){
            item.setStockClearItems(null); // update the stockClearItem of Items entity as `null`
            item.setStatus("normalStore"); // update the status of Items entity as `normalStore`
            itemRepository.save(item);
        // since `orphanRemoval = true`, when update `item.storeClearItem` as `null`, relevant `storeClearItem` entity will be automatically removed from the database.
        return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
