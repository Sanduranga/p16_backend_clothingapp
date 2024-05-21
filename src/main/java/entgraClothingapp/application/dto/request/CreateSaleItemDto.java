package entgraClothingapp.application.dto.request;

import lombok.Data;

@Data
public class CreateSaleItemDto {
    private String code;
    private Integer salePercentage;
    private Integer buyingPrice;
    private Integer sellingPrice;
    private Integer salePrice;
}
