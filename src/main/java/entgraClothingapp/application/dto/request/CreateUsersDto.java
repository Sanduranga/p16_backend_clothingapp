package entgraClothingapp.application.dto.request;

import lombok.Data;

@Data
public class CreateUsersDto {
    private String email;
    private String name;
    private String password;
    private String userType;
}
