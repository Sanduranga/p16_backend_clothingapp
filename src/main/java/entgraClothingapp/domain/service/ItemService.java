package entgraClothingapp.domain.service;

import entgraClothingapp.application.dto.response.GeneralItemDto;
import entgraClothingapp.application.dto.response.GeneralUserDto;
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

    public Items addItem(GeneralItemDto generalItemDto) {
        Items item = new Items();
        item.setItemTitle(generalItemDto.getItemTitle());
        item.setItemColor(generalItemDto.getItemColor());
        item.setItemSize(generalItemDto.getItemSize());
        item.setBuyingPrice(generalItemDto.getBuyingPrice());
        item.setMaterialName(generalItemDto.getMaterialName());
        item.setNormalPercentage(generalItemDto.getNormalPercentage());
        item.setSalePercentage(generalItemDto.getSalePercentage());
        item.setSellingType(generalItemDto.getSellingType());
        item.setStockClearingPrice(generalItemDto.getStockClearingPrice());
        item.setItemIs(generalItemDto.getItemIs());
        item.setName(generalItemDto.getName());
        item.setSellingPrice(generalItemDto.getSellingPrice());
        item.setDescription(generalItemDto.getDescription());
        return itemRepository.save(item);
    }

    public List<Items> getAllItems() {
        return itemRepository.findAll();
    }

    public ResponseEntity<GeneralItemDto> getItem(Integer id) {
        GeneralItemDto generalItemDto = new GeneralItemDto();
        Optional<Items> optionalItem = itemRepository.findById(id);
        if(optionalItem.isPresent()){
            Items item = optionalItem.get();
            generalItemDto.setItemTitle(item.getItemTitle());
            generalItemDto.setItemColor(item.getItemColor());
            generalItemDto.setItemSize(item.getItemSize());
            generalItemDto.setBuyingPrice(item.getBuyingPrice());
            generalItemDto.setMaterialName(item.getMaterialName());
            generalItemDto.setNormalPercentage(item.getNormalPercentage());
            generalItemDto.setSalePercentage(item.getSalePercentage());
            generalItemDto.setSellingType(item.getSellingType());
            generalItemDto.setStockClearingPrice(item.getStockClearingPrice());
            generalItemDto.setItemIs(item.getItemIs());
            generalItemDto.setName(item.getName());
            generalItemDto.setSellingPrice(item.getSellingPrice());
            generalItemDto.setDescription(item.getDescription());
            return ResponseEntity.ok(generalItemDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}