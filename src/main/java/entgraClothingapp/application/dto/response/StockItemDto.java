package entgraClothingapp.application.dto.response;

import entgraClothingapp.domain.entity.Items;
import lombok.Data;

@Data
public class StockItemDto {
    private long itemsCode;
    private Items items;
    private float stockClearingPrice;
}
