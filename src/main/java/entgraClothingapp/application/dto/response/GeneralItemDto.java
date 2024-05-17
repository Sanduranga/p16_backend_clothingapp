package entgraClothingapp.application.dto.response;

import lombok.Data;

@Data
public class GeneralItemDto {
    private String name;
    private String itemTitle;
    private String itemIs;
    private String sellingType;
    private Integer buyingPrice;
    private Integer stockClearingPrice;
    private Integer sellingPrice;
    private Integer normalPercentage;
    private Integer salePercentage;
    private String itemColor;
    private String itemSize;
    private String materialName;
    private String description;
}
