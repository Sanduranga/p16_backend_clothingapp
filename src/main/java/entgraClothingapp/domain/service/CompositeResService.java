package entgraClothingapp.domain.service;

import entgraClothingapp.domain.compositeResponse.CompositeRes;
import entgraClothingapp.domain.entity.Items;
import entgraClothingapp.domain.entity.SaleItems;
import entgraClothingapp.domain.entity.StockClearItems;
import entgraClothingapp.external.repository.ItemRepository;
import entgraClothingapp.external.repository.SaleItemRepository;
import entgraClothingapp.external.repository.StockItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompositeResService {
    private final ItemRepository itemRepository;
    private final SaleItemRepository saleItemRepository;
    private  final StockItemRepository stockClearItemsRepository;

    public CompositeRes getAllData() {
        List<Items> itemsData = itemRepository.findAll();
        List<SaleItems> saleItemsData = saleItemRepository.findAll();
        List<StockClearItems> stockClearItemsData = stockClearItemsRepository.findAll();
        return new CompositeRes(itemsData, saleItemsData, stockClearItemsData);
    }

    public ResponseEntity<Void> deleteItem( String code) {
        Optional<Items> optional1 = itemRepository.findByCode(code);
        if(optional1.isPresent()){
            itemRepository.deleteByCode(code);
            return ResponseEntity.noContent().build();
        }else {
            Optional<SaleItems> optional2 = saleItemRepository.findByCode(code);
            if (optional2.isPresent()) {
                saleItemRepository.deleteByCode(code);
                return ResponseEntity.noContent().build();}
            else {
                Optional<StockClearItems> optional3 = stockClearItemsRepository.findByCode(code);
                if (optional3.isPresent()) {
                    stockClearItemsRepository.deleteByCode(code);
                    return ResponseEntity.noContent().build();
                } else {
                    return ResponseEntity.notFound().build();
                }
            }}}}
