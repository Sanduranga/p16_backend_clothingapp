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

// this is sales store items controller *****************************

public class SaleItemController {

    private SaleItemService saleItemService;

    @PostMapping("/add-item")  
    public ResponseEntity<SaleItems> addItem(@RequestBody CreateSaleItemDto createSaleItemDto) {
        return saleItemService.addItem(createSaleItemDto);
    }

    @GetMapping("/get-items")   // get all items
    public ResponseEntity<List<SaleItems>> getItems() {
        return saleItemService.getAllItems();
    }
    @GetMapping("/get-item") // get one item using its id
    public ResponseEntity<SaleItemDto> getItem(@RequestParam long code) {
        return saleItemService.getItem(code);
    }

    @DeleteMapping("/delete-item")
    public ResponseEntity<Void> deleteItem(@RequestParam long code) {
        return  saleItemService.deleteItem(code);
    }
}
