package entgraClothingapp.application.dto.response;

import lombok.Data;

@Data
public class SaleItemDto {
    private Integer id;
    private String code;
    private String itemTitle;
    private String itemType;
    private String sellerName;
    private String itemColor;
    private String itemSize;
    private String materialName;
    private String description;
    private String status;
    private Integer numberOfItems;
    private Integer buyingPrice;
    private Integer salePrice;
    private Integer salePercentage;
    private Integer startingPrice;
    private Integer profitPercentage;
}
