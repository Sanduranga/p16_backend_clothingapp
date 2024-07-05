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
        StockClearItems stockClearItem = stockItemService.addItem(createStockItemDto);
        return ResponseEntity.status(201).body(stockClearItem);
    }

    @GetMapping("/get-items")  // get all items
    public ResponseEntity<List<StockClearItems>> getItems() {
        List<StockClearItems> stockClearItems = stockItemService.getAllItems();
        return ResponseEntity.ok(stockClearItems);
    }
    @GetMapping("/get-item")  // get one item using its id
    public ResponseEntity<StockItemDto> getItem(@RequestParam long id) {
        return stockItemService.getItem(id);
    }
    @DeleteMapping("/delete-item")
    public ResponseEntity<Void> deleteItem(@RequestParam long id) {
        return  stockItemService.deleteItem(id);
    }
}
