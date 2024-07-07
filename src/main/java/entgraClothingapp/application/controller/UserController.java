package entgraClothingapp.application.controller;

import entgraClothingapp.application.dto.request.CreateUsersDto;
import entgraClothingapp.application.dto.response.UserDto;
import entgraClothingapp.domain.entity.Users;
import entgraClothingapp.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/users")
@CrossOrigin
@AllArgsConstructor

public class UserController {

    private UserService userService;

    @GetMapping("/get-user")
    public ResponseEntity<UserDto> getUser(@RequestParam String email, @RequestParam String password){
        return userService.getUser(email, password);
    }

    @GetMapping("/get-users")
    public ResponseEntity<List<Users>> getUser(){
        return userService.getUsers();
    }

    @PostMapping("/add-user")
    public ResponseEntity<Users> addUser(@RequestBody CreateUsersDto creatUserDto) {
        return userService.addUser(creatUserDto);
    }

    @DeleteMapping("/delete-user")
    public ResponseEntity<Void> deleteUser(@RequestParam String email){
        return userService.deleteUser(email);
    }
}
