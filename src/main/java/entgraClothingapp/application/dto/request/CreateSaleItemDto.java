package entgraClothingapp.application.dto.request;

import lombok.Data;

@Data
public class CreateSaleItemDto {
    private Integer id;
    private Integer numberOfItems;
    private Integer buyingPrice;
    private Integer salePercentage;
    private Integer salePrice;
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
