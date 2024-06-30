package entgraClothingapp.domain.service;

import entgraClothingapp.application.dto.request.CreateUsersDto;
import entgraClothingapp.application.dto.response.UserDto;
import entgraClothingapp.domain.entity.Users;
import entgraClothingapp.external.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    public ResponseEntity<UserDto> getUser(String email, String password) {
        UserDto userDto = new UserDto();
        Optional<Users> optionalUsers = userRepository.findByEmail(email);
        if(optionalUsers.isPresent()) {
            Users user = optionalUsers.get();
            if (user.getPassword().equals(password)) {
                userDto.setEmail(user.getEmail());
                userDto.setName(user.getName());
                return ResponseEntity.ok(userDto);
            } else {
                userDto.setEmail(user.getEmail());
                userDto.setName("");
                return ResponseEntity.status(401).body(userDto);
            }          
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Users> addUser(CreateUsersDto createUsersDto) {
        Optional<Users> optinalUser = userRepository.findByEmail(createUsersDto.getEmail());
        if (optinalUser.isPresent()) {
            // here it checks wheather the email is already taken or not
            return ResponseEntity.status(401).body(null);
        }else{
        Users user = new Users();
        user.setName(createUsersDto.getName());
        user.setEmail(createUsersDto.getEmail());
        user.setPassword(createUsersDto.getPassword());
        userRepository.save(user);
        return ResponseEntity.status(201).body(user);
        }
    }

}