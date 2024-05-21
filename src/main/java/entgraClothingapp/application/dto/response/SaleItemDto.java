package entgraClothingapp.application.dto.response;

import lombok.Data;

@Data
public class SaleItemDto {
    private String code;
    private Integer salePercentage;
    private Integer buyingPrice;
    private Integer sellingPrice;
    private Integer salePrice;
}
