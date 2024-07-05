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

public SaleItems addItem(CreateSaleItemDto createSaleItemDto) {
    Items items = itemRepository.findById(createSaleItemDto.getId())
            .orElseThrow(() -> new RuntimeException("Item not found in the item's entity"));
            items.setStatus("saleStore"); // change item's state

    SaleItems saleItems = new SaleItems();
    saleItems.setItems(items);
    saleItems.setSalePrice(createSaleItemDto.getSalePrice());
    saleItems.setSalePercentage(createSaleItemDto.getSalePercentage());
    return saleItemRepository.save(saleItems);
}

    public List<SaleItems> getAllItems() {
        return  saleItemRepository.findAll();
    }

    public ResponseEntity<SaleItemDto> getItem(Long id) {
        SaleItemDto saleItemDto = new SaleItemDto();
        Optional<SaleItems> optionalItem = saleItemRepository.findById(id);
        if(optionalItem.isPresent()){
            SaleItems saleItem = optionalItem.get();
            saleItemDto.setSalePrice(saleItem.getSalePrice());
            saleItemDto.setId(saleItem.getId());
            saleItemDto.setSalePercentage(saleItem.getSalePercentage());
            return ResponseEntity.ok(saleItemDto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    public ResponseEntity<Void> deleteItem(Long id) {
       SaleItems saleItems = saleItemRepository.findById(id).orElse(null);
        if(saleItems != null){
            Items item = saleItems.getItems();
                if(item != null){
                    item.setSaleItems(null); // update the saleItem of Items entity as `null`
                    item.setStatus("normalStore"); // update the status of Items entity as `normalStore`
                    itemRepository.save(item);
                }
                // saleItemRepository.delete(saleItems);
                return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
