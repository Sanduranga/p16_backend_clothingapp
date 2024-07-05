package entgraClothingapp.application.controller;

import entgraClothingapp.domain.compositeResponse.CompositeRes;
import entgraClothingapp.domain.service.CompositeResService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/composite")
@CrossOrigin
@AllArgsConstructor
public class CompositeController {
    private CompositeResService compositeResService;

    @GetMapping("/all-items")
    public ResponseEntity<CompositeRes> getAllData() {
        CompositeRes response = compositeResService.getAllData();
        return ResponseEntity.ok(response);
    }

//    @DeleteMapping("/all-delete-item")
//    public ResponseEntity<Void> deleteItem(@RequestParam String code) {
//        return compositeResService.deleteItem(code);
//    }
}
