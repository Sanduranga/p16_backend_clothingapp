package entgraClothingapp.application.dto.request;

import lombok.Data;

@Data
public class CreateSaleItemDto {
    private long itemsCode;
    private float salePercentage;
    private float salePrice;
}
