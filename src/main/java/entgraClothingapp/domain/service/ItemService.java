package entgraClothingapp.domain.service;

import entgraClothingapp.application.dto.request.CreateItemDto;
import entgraClothingapp.application.dto.response.ItemDto;
import entgraClothingapp.domain.entity.Items;
import entgraClothingapp.external.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService {
        private final ItemRepository itemRepository;

    public ResponseEntity<Items> addItem(CreateItemDto createItemDto) {
        Optional<Items> sameCodeItem = itemRepository.findByCode(createItemDto.getCode());
        // here checking whether item code is already having data base
        if(sameCodeItem.isPresent()){
            Items item = sameCodeItem.get();
            item.setNumberOfItems(item.getNumberOfItems() + 1);
            itemRepository.save(item);
            return ResponseEntity.status(201).body(item);
        }else {
            Items item = new Items();
            item.setItemTitle(createItemDto.getItemTitle());
            item.setItemType(createItemDto.getItemType());
            item.setItemColor(createItemDto.getItemColor());
            item.setItemSize(createItemDto.getItemSize());
            item.setBuyingPrice(createItemDto.getBuyingPrice());
            item.setMaterialName(createItemDto.getMaterialName());
            item.setProfitPercentage(createItemDto.getProfitPercentage());
            item.setSellerName(createItemDto.getSellerName());
            item.setStartingPrice(createItemDto.getStartingPrice());
            item.setDescription(createItemDto.getDescription());
            item.setCode(createItemDto.getCode());
            item.setNumberOfItems(createItemDto.getNumberOfItems());
            item.setStatus(createItemDto.getStatus());
            itemRepository.save(item);
            return ResponseEntity.status(201).body(item);
        }
    }

    public ResponseEntity<List<Items>> getAllItems() {
        List<Items> items = itemRepository.findAll();
        return ResponseEntity.ok(items);
    }

    public ResponseEntity<ItemDto> getItem(long code) {
        ItemDto itemDto = new ItemDto();
        Optional<Items> optionalItem = itemRepository.findById(code);
        if(optionalItem.isPresent()){
            Items items = optionalItem.get();
            itemDto.setCode(items.getCode());
            itemDto.setItemTitle(items.getItemTitle());
            itemDto.setItemType(items.getItemType());
            itemDto.setItemColor(items.getItemColor());
            itemDto.setItemSize(items.getItemSize());
            itemDto.setBuyingPrice(items.getBuyingPrice());
            itemDto.setMaterialName(items.getMaterialName());
            itemDto.setProfitPercentage(items.getProfitPercentage());
            itemDto.setSellerName(items.getSellerName());
            itemDto.setStartingPrice(items.getStartingPrice());
            itemDto.setDescription(items.getDescription());
            itemDto.setNumberOfItems(items.getNumberOfItems());
            itemDto.setStatus(items.getStatus());
            return ResponseEntity.ok(itemDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @Transactional
    public ResponseEntity<Void> deleteItem(Long code) {
        Optional<Items> optinalItem = itemRepository.findByCode(code);
        if(optinalItem.isPresent()){
            itemRepository.deleteByCode(code);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Items> updateItem(CreateItemDto createItemDto) {
        Optional<Items> optionalItem = itemRepository.findByCode(createItemDto.getCode());
        if(optionalItem.isPresent()){
            Items items = optionalItem.get();
            items.setItemTitle(createItemDto.getItemTitle());
            items.setItemType(createItemDto.getItemType());
            items.setItemColor(createItemDto.getItemColor());
            items.setItemSize(createItemDto.getItemSize());
            items.setBuyingPrice(createItemDto.getBuyingPrice());
            items.setMaterialName(createItemDto.getMaterialName());
            items.setProfitPercentage(createItemDto.getProfitPercentage());
            items.setSellerName(createItemDto.getSellerName());
            items.setStartingPrice(createItemDto.getStartingPrice());
            items.setDescription(createItemDto.getDescription());
            items.setCode(createItemDto.getCode());
            items.setNumberOfItems(createItemDto.getNumberOfItems());
            items.setStatus(createItemDto.getStatus());
            return ResponseEntity.ok(items);

        }else {
            return ResponseEntity.notFound().build();
        }
    }
    
}