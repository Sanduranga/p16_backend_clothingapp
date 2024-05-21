package entgraClothingapp.application.controller;

import entgraClothingapp.application.dto.request.CreateSaleItemDto;
import entgraClothingapp.application.dto.response.SaleItemDto;
import entgraClothingapp.domain.entity.SaleItems;
import entgraClothingapp.domain.service.SaleItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/sale-items")
@CrossOrigin
@AllArgsConstructor
public class SaleItemController {

    private SaleItemService saleItemService;

    @PostMapping("/add-items")
    public ResponseEntity<SaleItems> addItem(@RequestParam CreateSaleItemDto createSaleItemDto) {
        SaleItems creteSaleItem = saleItemService.addItem(createSaleItemDto);
        return ResponseEntity.ok(creteSaleItem);
    }

    @GetMapping("/get-items")
    public ResponseEntity<List<SaleItems>> getItems() {
        List<SaleItems> saleItems = saleItemService.getAllItems();
        return ResponseEntity.ok(saleItems);
    }
    @GetMapping("/get-item")
    public ResponseEntity<SaleItemDto> getItem(@RequestParam Integer id) {
        return saleItemService.getItem(id);
    }
}