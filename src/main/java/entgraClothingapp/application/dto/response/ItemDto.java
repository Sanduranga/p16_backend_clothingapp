package entgraClothingapp.application.dto.response;

import lombok.Data;

@Data
public class ItemDto {
    private long code;
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
}
