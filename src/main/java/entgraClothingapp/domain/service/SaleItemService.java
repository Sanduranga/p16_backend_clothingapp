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
        saleItem.setBuyingPrice(createSaleItemDto.getBuyingPrice());
        saleItem.setSalePrice(createSaleItemDto.getSalePrice());
        saleItem.setSellingPrice(createSaleItemDto.getSellingPrice());
        saleItem.setSalePercentage(createSaleItemDto.getSalePercentage());
        saleItem.setCode(createSaleItemDto.getCode());
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
            saleItemDto.setSalePrice(saleItem.getSalePrice());
            saleItemDto.setSellingPrice(saleItem.getSellingPrice());
            saleItemDto.setSalePercentage(saleItem.getSalePercentage());
            saleItemDto.setSellingPrice(saleItem.getSellingPrice());
            saleItemDto.setCode(saleItem.getCode());
            return ResponseEntity.ok(saleItemDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
