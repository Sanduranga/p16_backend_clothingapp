package entgraClothingapp.application.dto.response;

import entgraClothingapp.domain.entity.Items;
import lombok.Data;

@Data
public class StockItemDto {
    private Items items;
    private float stockClearingPrice;
}
