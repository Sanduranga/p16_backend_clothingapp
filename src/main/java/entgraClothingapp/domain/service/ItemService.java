package entgraClothingapp.domain.service;

import entgraClothingapp.application.dto.response.GeneralItemDto;
import entgraClothingapp.domain.entity.Items;
import entgraClothingapp.external.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
        item.setNormalPercentage(generalItemDto.getNormalPercentage());
        item.setItemIs(generalItemDto.getItemIs());
        item.setName(generalItemDto.getName());
        item.setSellingPrice(generalItemDto.getSellingPrice());
        item.setDescription(generalItemDto.getDescription());
        return itemRepository.save(item);
    }

    public List<Items> getAllItems() {
        return itemRepository.findAll();
    }
}