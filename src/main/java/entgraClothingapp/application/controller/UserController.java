package entgraClothingapp.application.controller;

import entgraClothingapp.application.dto.request.CreateUsersDto;
import entgraClothingapp.domain.entity.Users;
import entgraClothingapp.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/users")
@CrossOrigin
@AllArgsConstructor

public class UserController {

    private UserService userService;

    @GetMapping("/get-users")
    public String getUsers(){
        return "get-user-called-successfully";
    }

    @PostMapping("/add-user")
    public ResponseEntity<Users> addUser(@RequestBody CreateUsersDto creatUserDto) {
        return userService.saveUser(creatUserDto);
//        return ResponseEntity.ok(createdUser);
    }

//    @PostMapping("/post-users")
//    public String postUser(){
//        return "post-user-called-successfully";
//    }
//
//    @PutMapping("/update-user")
//    public String updateUser(){
//        return "put-user-called-successfully";
//    }
//
//    @DeleteMapping("/delete-user")
//    public String deleteUser(){
//        return "delete-user-called-successfully";
//    }
}
