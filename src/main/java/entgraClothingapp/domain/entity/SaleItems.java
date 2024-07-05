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

    public class SaleItems {
        @Id // Specifies the primary key of an entity.
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @JsonIgnoreProperties("saleItems") // to avoid json looping
        @OneToOne() // making a one-to-one relationship with the Items entity.
        @JoinColumn(name = "itemId") // leaveraging relational data bases methodes Specifies the foreign key in the SaleItems table that refers to the primary key of the Items table.
        private Items items;

        private float salePrice;
        private float salePercentage;

    }
