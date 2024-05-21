package entgraClothingapp.application.dto.response;

import lombok.Data;

@Data
public class ItemDto {
    private String code;
    private String itemTitle;
    private String itemIs;
    private String sellingType;
    private Integer buyingPrice;
    private Integer sellingPrice;
    private Integer profitPercentage;
    private String itemColor;
    private String itemSize;
    private String materialName;
    private String description;
}
