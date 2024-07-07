package entgraClothingapp.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NamedEntityGraph(name = "Items.detail", attributeNodes = {
        // making an entity graph for optimized fetching of associated saleItems and stockClearItems
        @NamedAttributeNode("saleItems"),
        @NamedAttributeNode("stockClearItems")
        })

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Items {
    @Id // Specifies the primary key of an entity.
    private Long code;

    private String itemTitle;
    private String itemType;
    private String sellerName;
    private String status;
    private String itemColor;
    private String itemSize;
    private String materialName;
    private String description;
    private int numberOfItems;
    private int buyingPrice;
    private float startingPrice;
    private float profitPercentage;

    @JsonIgnoreProperties("items")
    @OneToOne(mappedBy = "items", cascade = CascadeType.ALL, orphanRemoval = true)
    // making a one-to-one relationship with the SaleItems entity. 
    private SaleItems saleItems;

    @JsonIgnoreProperties("items")
    @OneToOne(mappedBy = "items", cascade = CascadeType.ALL, orphanRemoval = true)
    private StockClearItems stockClearItems;

}
