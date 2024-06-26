package entgraClothingapp.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class SaleItems {
    @Id
    private Integer id;
    private String code;
    private String itemTitle;
    private String itemType;
    private String sellerName;
    private String status;
    private String itemColor;
    private String itemSize;
    private String materialName;
    private String description;
    private Integer numberOfItems;
    private Integer salePrice;
    private Integer salePercentage;
    private Integer stockClearingPrice;
    private Integer buyingPrice;
    private Integer startingPrice;
    private Integer profitPercentage;
}
