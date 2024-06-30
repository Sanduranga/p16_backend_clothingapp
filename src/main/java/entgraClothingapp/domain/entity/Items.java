package entgraClothingapp.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String itemTitle;
    private String itemType;
    private String sellerName;
    private String status;
    private String itemColor;
    private String itemSize;
    private String materialName;
    private String description;
    private int numberOfItems;
    private int salePrice;
    private int salePercentage;
    private int stockClearingPrice;
    private int buyingPrice;
    private int startingPrice;
    private int profitPercentage;
}
