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
        return itemService.addItem(createItemDto);
    }

    @GetMapping("/get-items") // get all items
    public ResponseEntity<List<Items>> getAllItems() {
       return itemService.getAllItems();
    }

    @GetMapping("/get-item")  // get one item using its id
    public ResponseEntity<ItemDto> getItem(@RequestParam long code) {
        return itemService.getItem(code);
    }

    @DeleteMapping("/delete-item")
    public ResponseEntity<Void> deleteItem(@RequestParam Long code) {
        return itemService.deleteItem(code);
    }

    @PutMapping("/update-item")
    public ResponseEntity<Items> updateItem ( @RequestBody CreateItemDto createItemDto) {
        return itemService.updateItem(createItemDto);
    }
}
