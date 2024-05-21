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

    public Items addItem(CreateItemDto CreateItemDto) {
        Items item = new Items();
        item.setItemTitle(CreateItemDto.getItemTitle());
        item.setItemColor(CreateItemDto.getItemColor());
        item.setItemSize(CreateItemDto.getItemSize());
        item.setBuyingPrice(CreateItemDto.getBuyingPrice());
        item.setMaterialName(CreateItemDto.getMaterialName());
        item.setProfitPercentage(CreateItemDto.getProfitPercentage());
        item.setSellingType(CreateItemDto.getSellingType());
        item.setItemIs(CreateItemDto.getItemIs());
        item.setSellingPrice(CreateItemDto.getSellingPrice());
        item.setDescription(CreateItemDto.getDescription());
        item.setCode(CreateItemDto.getCode());
        return itemRepository.save(item);
    }

    public List<Items> getAllItems() {
        return itemRepository.findAll();
    }

    public ResponseEntity<ItemDto> getItem(Integer id) {
        ItemDto itemDto = new ItemDto();
        Optional<Items> optionalItem = itemRepository.findById(id);
        if(optionalItem.isPresent()){
            Items item = optionalItem.get();
            itemDto.setItemTitle(item.getItemTitle());
            itemDto.setItemColor(item.getItemColor());
            itemDto.setItemSize(item.getItemSize());
            itemDto.setBuyingPrice(item.getBuyingPrice());
            itemDto.setMaterialName(item.getMaterialName());
            itemDto.setProfitPercentage(item.getProfitPercentage());
            itemDto.setSellingType(item.getSellingType());
            itemDto.setItemIs(item.getItemIs());
            itemDto.setSellingPrice(item.getSellingPrice());
            itemDto.setDescription(item.getDescription());
            return ResponseEntity.ok(itemDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}