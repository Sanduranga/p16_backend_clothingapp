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

    public ResponseEntity<UserDto> getUser(String email) {
        UserDto userDto = new UserDto();
        Optional<Users> optionalUsers = userRepository.findByEmail(email);
        if(optionalUsers.isPresent()) {
            Users user = optionalUsers.get();
            userDto.setEmail(user.getEmail());
            userDto.setName(user.getName());
            return ResponseEntity.ok(userDto);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    public Users addUser(CreateUsersDto createUsersDto) {
        Users user = new Users();
        user.setName(createUsersDto.getName());
        user.setEmail(createUsersDto.getEmail());
        user.setPassword(createUsersDto.getPassword());
        user.setUsertype(createUsersDto.getUserType());
        return userRepository.save(user);
    }

}