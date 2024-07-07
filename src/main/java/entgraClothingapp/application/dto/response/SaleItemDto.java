package entgraClothingapp.application.dto.response;

import entgraClothingapp.domain.entity.Items;
import lombok.Data;

@Data
public class SaleItemDto {
    private long itemsCode;
    private float salePercentage;
    private float salePrice;
    private Items items;
}
