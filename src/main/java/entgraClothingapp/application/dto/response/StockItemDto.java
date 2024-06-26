package entgraClothingapp.application.dto.response;

import lombok.Data;

@Data
public class StockItemDto {
    private Integer id;
    private Integer stockClearingPrice;
    private Integer buyingPrice;
    private Integer startingPrice;
    private Integer numberOfItems;
    private String code;
    private String itemTitle;
    private String itemType;
    private String sellerName;
    private String itemColor;
    private String itemSize;
    private String materialName;
    private String description;
    private String status;
}
