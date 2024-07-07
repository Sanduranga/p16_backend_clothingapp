package entgraClothingapp.application.dto.request;

import lombok.Data;

@Data
public class CreateStockItemDto {
    private long itemsCode;
    private int stockClearingPrice;
}
