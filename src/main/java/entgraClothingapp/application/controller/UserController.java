package entgraClothingapp.application.controller;

import entgraClothingapp.application.dto.request.CreateUsersDto;
import entgraClothingapp.application.dto.response.GeneralUserDto;
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

    @GetMapping("/get-user")
    public ResponseEntity<GeneralUserDto> getUser(@RequestParam String email){
        return userService.getUser(email);
    }

    @PostMapping("/add-user")
    public ResponseEntity<Users> addUser(@RequestBody CreateUsersDto creatUserDto) {
        Users createdUser = userService.addUser(creatUserDto);
       return ResponseEntity.ok(createdUser);
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
