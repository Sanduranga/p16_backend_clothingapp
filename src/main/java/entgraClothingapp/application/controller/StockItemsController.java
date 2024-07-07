package entgraClothingapp.application.controller;

import entgraClothingapp.application.dto.request.CreateStockItemDto;
import entgraClothingapp.application.dto.response.StockItemDto;
import entgraClothingapp.domain.entity.StockClearItems;
import entgraClothingapp.domain.service.StockItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/stock-clear-items")
@CrossOrigin
@AllArgsConstructor

// this is stock clearing store items controller *****************************

public class StockItemsController {
    private final StockItemService stockItemService;

    @PostMapping("/add-item")
    public ResponseEntity<StockClearItems> addItem(@RequestBody CreateStockItemDto createStockItemDto) {
       return stockItemService.addItem(createStockItemDto);
    }

    @GetMapping("/get-items")  // get all items
    public ResponseEntity<List<StockClearItems>> getItems() {
        return stockItemService.getAllItems();
    }

    @GetMapping("/get-item")  // get one item using its id
    public ResponseEntity<StockItemDto> getItem(@RequestParam long code) {
        return stockItemService.getItem(code);
    }

    @DeleteMapping("/delete-item")
    public ResponseEntity<Void> deleteItem(@RequestParam long code) {
        return  stockItemService.deleteItem(code);
    }
}
