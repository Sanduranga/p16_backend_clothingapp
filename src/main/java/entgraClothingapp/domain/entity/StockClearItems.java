package entgraClothingapp.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class StockClearItems {
    @Id // Specifies the primary key of an entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnoreProperties("stockClearItems")   // to avoid json looping
    @OneToOne // making a one-to-one relationship with the Items entity.
    @JoinColumn(name = "itemId") // leaveraging relational data bases methodes Specifies the foreign key in the StockClearItem's table that refers to the primary key of the Items table.
    private Items items;

    private int stockClearingPrice;

}