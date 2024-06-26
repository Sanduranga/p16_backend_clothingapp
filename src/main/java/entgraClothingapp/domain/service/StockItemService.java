package entgraClothingapp.domain.service;

import entgraClothingapp.application.dto.request.CreateStockItemDto;
import entgraClothingapp.application.dto.response.StockItemDto;
import entgraClothingapp.domain.entity.StockClearItems;
import entgraClothingapp.external.repository.StockItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StockItemService {
    private StockItemRepository stockItemRepository;

    public StockClearItems addItem(CreateStockItemDto createStockItemDto) {
        StockClearItems stockClearItems = new StockClearItems();
        stockClearItems.setId(createStockItemDto.getId());
        stockClearItems.setBuyingPrice(createStockItemDto.getBuyingPrice());
        stockClearItems.setStatus(createStockItemDto.getStatus());
        stockClearItems.setItemColor(createStockItemDto.getItemColor());
        stockClearItems.setItemTitle(createStockItemDto.getItemTitle());
        stockClearItems.setItemType(createStockItemDto.getItemType());
        stockClearItems.setMaterialName(createStockItemDto.getMaterialName());
        stockClearItems.setDescription(createStockItemDto.getDescription());
        stockClearItems.setItemSize(createStockItemDto.getItemSize());
        stockClearItems.setSellerName(createStockItemDto.getSellerName());
        stockClearItems.setStartingPrice(createStockItemDto.getStartingPrice());
        stockClearItems.setCode(createStockItemDto.getCode());
        stockClearItems.setNumberOfItems(createStockItemDto.getNumberOfItems());
        stockClearItems.setStockClearingPrice(createStockItemDto.getStockClearingPrice());
        return stockItemRepository.save(stockClearItems);
    }

    public List<StockClearItems> getAllItems() {
        return  stockItemRepository.findAll();
    }

    public ResponseEntity<StockItemDto> getItem(Integer id) {
        StockItemDto stockItemDto = new StockItemDto();
        Optional<StockClearItems> optionalItem = stockItemRepository.findById(id);
        if(optionalItem.isPresent()){
            StockClearItems stockClearItems = optionalItem.get();
            stockItemDto.setBuyingPrice(stockClearItems.getBuyingPrice());
            stockItemDto.setItemColor(stockClearItems.getItemColor());
            stockItemDto.setItemTitle(stockClearItems.getItemTitle());
            stockItemDto.setItemType(stockClearItems.getItemType());
            stockItemDto.setId(stockClearItems.getId());
            stockItemDto.setDescription(stockClearItems.getDescription());
            stockItemDto.setItemSize(stockClearItems.getItemSize());
            stockItemDto.setSellerName(stockClearItems.getSellerName());
            stockItemDto.setStartingPrice(stockClearItems.getStartingPrice());
            stockItemDto.setCode(stockClearItems.getCode());
            stockItemDto.setNumberOfItems(stockClearItems.getNumberOfItems());
            return ResponseEntity.ok(stockItemDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteItem(Integer id) {
        Optional<StockClearItems> optionalSaleItems = stockItemRepository.findById(id);
        if(optionalSaleItems.isPresent()){
            stockItemRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
