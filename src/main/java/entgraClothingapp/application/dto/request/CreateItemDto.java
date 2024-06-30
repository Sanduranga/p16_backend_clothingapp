package entgraClothingapp.application.dto.request;

import lombok.Data;
@Data
public class CreateItemDto {
        private int id;
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
        private int startingPrice;
        private int profitPercentage;
        private int salePercentage;
        private int salePrice;
        private int stockClearingPrice;
}
