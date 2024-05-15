package entgraClothingapp.domain.service;

import entgraClothingapp.application.dto.request.CreateUsersDto;
import entgraClothingapp.domain.entity.Users;
import entgraClothingapp.external.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    public ResponseEntity<Users> saveUser(CreateUsersDto createUsersDto) {
        Users user = new Users();
        user.setName(createUsersDto.getName());
        user.setEmail(createUsersDto.getEmail());
        userRepository.save(user);
        return ResponseEntity.status(201).build();
    }

}