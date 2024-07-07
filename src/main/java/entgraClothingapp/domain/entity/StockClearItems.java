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
        private Long itemsCode;

        @JsonIgnoreProperties("stockClearItems")   // to avoid json looping
        @OneToOne // making a one-to-one relationship with the Items entity.
        @MapsId
        private Items items;

        private int stockClearingPrice;

    }