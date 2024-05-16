package entgraClothingapp.domain.service;

import entgraClothingapp.application.dto.request.CreateUsersDto;
import entgraClothingapp.application.dto.response.GeneralUserDto;
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

    public ResponseEntity<GeneralUserDto> getUser(String email) {
        GeneralUserDto generalUserDto = new GeneralUserDto();
        Optional<Users> optionalUsers = userRepository.findByEmail(email);
        if(optionalUsers.isPresent()) {
            Users user = optionalUsers.get();
            generalUserDto.setEmail(user.getEmail());
            generalUserDto.setName(user.getName());
            return ResponseEntity.ok(generalUserDto);
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