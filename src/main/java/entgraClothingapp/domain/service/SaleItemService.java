package entgraClothingapp.domain.service;

import entgraClothingapp.application.dto.request.CreateSaleItemDto;
import entgraClothingapp.application.dto.response.SaleItemDto;
import entgraClothingapp.domain.entity.SaleItems;
import entgraClothingapp.external.repository.SaleItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SaleItemService {
    private final SaleItemRepository saleItemRepository;

    public SaleItems addItem(CreateSaleItemDto createSaleItemDto) {
        SaleItems saleItem = new SaleItems();
        saleItem.setId(createSaleItemDto.getId());
        saleItem.setBuyingPrice(createSaleItemDto.getBuyingPrice());
        saleItem.setStatus(createSaleItemDto.getStatus());
        saleItem.setItemColor(createSaleItemDto.getItemColor());
        saleItem.setItemTitle(createSaleItemDto.getItemTitle());
        saleItem.setItemType(createSaleItemDto.getItemType());
        saleItem.setMaterialName(createSaleItemDto.getMaterialName());
        saleItem.setDescription(createSaleItemDto.getDescription());
        saleItem.setItemSize(createSaleItemDto.getItemSize());
        saleItem.setSalePrice(createSaleItemDto.getSalePrice());
        saleItem.setSellerName(createSaleItemDto.getSellerName());
        saleItem.setSalePercentage(createSaleItemDto.getSalePercentage());
        saleItem.setCode(createSaleItemDto.getCode());
        saleItem.setStartingPrice(createSaleItemDto.getStartingPrice());
        saleItem.setNumberOfItems(createSaleItemDto.getNumberOfItems());
        return saleItemRepository.save(saleItem);
    }

    public List<SaleItems> getAllItems() {
        return  saleItemRepository.findAll();
    }

    public ResponseEntity<SaleItemDto> getItem(Integer id) {
        SaleItemDto saleItemDto = new SaleItemDto();
        Optional<SaleItems> optionalItem = saleItemRepository.findById(id);
        if(optionalItem.isPresent()){
            SaleItems saleItem = optionalItem.get();
            saleItemDto.setBuyingPrice(saleItem.getBuyingPrice());
            saleItemDto.setSalePrice(saleItem.getSalePrice());
            saleItemDto.setItemColor(saleItem.getItemColor());
            saleItemDto.setItemTitle(saleItem.getItemTitle());
            saleItemDto.setItemType(saleItem.getItemType());
            saleItemDto.setId(saleItem.getId());
            saleItemDto.setDescription(saleItem.getDescription());
            saleItemDto.setItemSize(saleItem.getItemSize());
            saleItemDto.setSellerName(saleItem.getSellerName());
            saleItemDto.setSalePercentage(saleItem.getSalePercentage());
            saleItemDto.setCode(saleItem.getCode());
            saleItemDto.setNumberOfItems(saleItem.getNumberOfItems());
            return ResponseEntity.ok(saleItemDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteItem(Integer id) {
       Optional<SaleItems> optionalSaleItems = saleItemRepository.findById(id);
       if(optionalSaleItems.isPresent()){
           saleItemRepository.deleteById(id);
           return ResponseEntity.noContent().build();
       }else {
           return ResponseEntity.notFound().build();
       }
    }
}
