package entgraClothingapp.domain.service;

import entgraClothingapp.application.dto.request.CreateItemDto;
import entgraClothingapp.application.dto.response.ItemDto;
import entgraClothingapp.domain.entity.Items;
import entgraClothingapp.external.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService {
        private final ItemRepository itemRepository;

    public Items addItem(CreateItemDto createItemDto) {
        Items items = new Items();
        items.setItemTitle(createItemDto.getItemTitle());
        items.setItemType(createItemDto.getItemType());
        items.setItemColor(createItemDto.getItemColor());
        items.setItemSize(createItemDto.getItemSize());
        items.setBuyingPrice(createItemDto.getBuyingPrice());
        items.setMaterialName(createItemDto.getMaterialName());
        items.setProfitPercentage(createItemDto.getProfitPercentage());
        items.setSellerName(createItemDto.getSellerName());
        items.setSellingPrice(createItemDto.getSellingPrice());
        items.setDescription(createItemDto.getDescription());
        items.setCode(createItemDto.getCode());
        items.setNumberOfItems(createItemDto.getNumberOfItems());
        items.setStatus(createItemDto.getStatus());
        return itemRepository.save(items);
    }

    public List<Items> getAllItems() {
        return itemRepository.findAll();
    }

    public ResponseEntity<ItemDto> getItem(Integer id) {
        ItemDto itemDto = new ItemDto();
        Optional<Items> optionalItem = itemRepository.findById(id);
        if(optionalItem.isPresent()){
            Items items = optionalItem.get();
            itemDto.setId(items.getId());
            itemDto.setCode(items.getCode());
            itemDto.setItemTitle(items.getItemTitle());
            itemDto.setItemType(items.getItemType());
            itemDto.setItemColor(items.getItemColor());
            itemDto.setItemSize(items.getItemSize());
            itemDto.setBuyingPrice(items.getBuyingPrice());
            itemDto.setMaterialName(items.getMaterialName());
            itemDto.setProfitPercentage(items.getProfitPercentage());
            itemDto.setSellerName(items.getSellerName());
            itemDto.setSellingPrice(items.getSellingPrice());
            itemDto.setDescription(items.getDescription());
            itemDto.setNumberOfItems(items.getNumberOfItems());
            itemDto.setStatus(items.getStatus());
            return ResponseEntity.ok(itemDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> deleteItem(Integer id) {
        Optional<Items> optinalItem = itemRepository.findById(id);
        if(optinalItem.isPresent()){
            itemRepository.deleteById(id);
            return ResponseEntity.ok("Item deleted successfully!");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> updateItem(Integer id, CreateItemDto createItemDto) {
        Optional<Items> optionalItem = itemRepository.findById(id);
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
            items.setSellingPrice(createItemDto.getSellingPrice());
            items.setDescription(createItemDto.getDescription());
            items.setCode(createItemDto.getCode());
            items.setNumberOfItems(createItemDto.getNumberOfItems());
            items.setStatus(createItemDto.getStatus());
            itemRepository.save(items);
            return ResponseEntity.ok("Item updated successfully!");

        }else {
            return ResponseEntity.notFound().build();
        }
    }
}