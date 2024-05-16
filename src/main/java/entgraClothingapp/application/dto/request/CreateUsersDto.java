package entgraClothingapp.application.dto.request;

import lombok.Data;

@Data
public class CreateUsersDto {
    private String name;
    private String email;
    private String password;
    private String userType;
}
