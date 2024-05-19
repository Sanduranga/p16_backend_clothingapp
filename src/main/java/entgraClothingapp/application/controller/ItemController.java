package entgraClothingapp.application.controller;

import entgraClothingapp.application.dto.response.GeneralItemDto;
import entgraClothingapp.application.dto.response.GeneralUserDto;
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

public class ItemController {
        private ItemService itemService;

    @PostMapping("/add-item")
    public ResponseEntity<Items> addItem(@RequestBody GeneralItemDto generalItemDto) {
        Items createdItem = itemService.addItem(generalItemDto);
        return ResponseEntity.ok(createdItem);
    }

    @GetMapping("/get-items")
    public ResponseEntity<List<Items>> getItems() {
        List<Items> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }
    @GetMapping("/get-item")
    public ResponseEntity<GeneralItemDto> getItem(@RequestParam Integer id) {
        return itemService.getItem(id);
    }
}
