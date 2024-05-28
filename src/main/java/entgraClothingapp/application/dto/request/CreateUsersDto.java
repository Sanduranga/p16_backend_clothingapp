package entgraClothingapp.application.dto.request;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class CreateUsersDto {
    private String email;
    private String name;
    private String password;
    private String userType;
}
