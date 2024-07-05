package entgraClothingapp.application.dto.response;

import lombok.Data;

@Data
public class StockItemDto {
    private long id;
    private String code;
    private String itemTitle;
    private String itemType;
    private String sellerName;
    private String itemColor;
    private String itemSize;
    private String materialName;
    private String description;
    private String status;
    private int numberOfItems;
    private int buyingPrice;
    private float startingPrice;
    private float profitPercentage;
    private float salePercentage;
    private float salePrice;
    private int stockClearingPrice;
}
