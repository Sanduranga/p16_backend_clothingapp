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
    private Integer id;
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
