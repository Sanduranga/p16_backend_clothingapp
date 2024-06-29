package entgraClothingapp.application.controller;

import entgraClothingapp.application.dto.request.CreateItemDto;
import entgraClothingapp.application.dto.response.ItemDto;
import entgraClothingapp.domain.entity.Items;
import entgraClothingapp.domain.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/items")
@CrossOrigin
@AllArgsConstructor

// this is normal store items controller *****************************

public class ItemController {
    private ItemService itemService;

    @PostMapping("/add-item")
    public ResponseEntity<Items> addItem(@RequestBody CreateItemDto createItemDto) {
        Items createdItem = itemService.addItem(createItemDto);
        return ResponseEntity.status(201).body(createdItem);
    }

    @GetMapping("/get-items") // get all items
    public ResponseEntity<List<Items>> getAllItems() {
        List<Items> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }
    @GetMapping("/get-item")  // get one item using its id
    public ResponseEntity<ItemDto> getItem(@RequestParam Integer id) {
        return itemService.getItem(id);
    }
    @DeleteMapping("/delete-item")
    public ResponseEntity<Void> deleteItem(@RequestParam Integer id) {
        return itemService.deleteItem(id);
    }
    @PutMapping("/update-item")
    public ResponseEntity<String> updateItem (@RequestBody CreateItemDto createItemDto) {
        return itemService.updateItem(createItemDto);
    }
}
