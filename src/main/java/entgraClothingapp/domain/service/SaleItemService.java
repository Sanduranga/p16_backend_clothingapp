package entgraClothingapp.domain.service;

import entgraClothingapp.application.dto.request.CreateSaleItemDto;
import entgraClothingapp.application.dto.response.SaleItemDto;
import entgraClothingapp.domain.entity.Items;
import entgraClothingapp.domain.entity.SaleItems;
import entgraClothingapp.external.repository.ItemRepository;
import entgraClothingapp.external.repository.SaleItemRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SaleItemService {
    private final ItemRepository itemRepository;
    private final SaleItemRepository saleItemRepository;

    @Transactional
    public ResponseEntity<SaleItems> addItem(CreateSaleItemDto createSaleItemDto) {
        Items item = itemRepository.findByCode(createSaleItemDto.getItemsCode())
                .orElse(null);
        if (item != null){
            item.setStatus("saleStore"); // change item's state
            SaleItems saleItem = new SaleItems();
            saleItem.setItems(item);
            saleItem.setItemsCode(createSaleItemDto.getItemsCode());
            saleItem.setSalePrice(createSaleItemDto.getSalePrice());
            saleItem.setSalePercentage(createSaleItemDto.getSalePercentage());
            saleItemRepository.save(saleItem);
            return ResponseEntity.ok(saleItem);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    public ResponseEntity<List<SaleItems>> getAllItems() {
        List<SaleItems> saleItems = saleItemRepository.findAll();
        return ResponseEntity.ok(saleItems);
    }

    @Transactional
    public ResponseEntity<SaleItemDto> getItem(Long code) {
        SaleItemDto saleItemDto = new SaleItemDto();
        Optional<SaleItems> optionalItem = saleItemRepository.findByItemsCode(code);
        if(optionalItem.isPresent()){
            SaleItems saleItem = optionalItem.get();
            saleItemDto.setSalePrice(saleItem.getSalePrice());
            saleItemDto.setSalePercentage(saleItem.getSalePercentage());
            saleItemDto.setItems(saleItem.getItems());
            return ResponseEntity.ok(saleItemDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    public ResponseEntity<Void> deleteItem(Long code) {
       Items item = itemRepository.findByCode(code).orElse(null);
        if(item != null){
            item.setSaleItems(null); // update the saleItem of Items entity as `null`
            item.setStatus("normalStore"); // update the status of Items entity as `normalStore`
            itemRepository.save(item);
                // since `orphanRemoval = true`, when update `item.setSaleItems` as `null`, relevant `SaleItems` entity will be automatically removed from the database.
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
