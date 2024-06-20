package entgraClothingapp.domain.compositeResponse;

import entgraClothingapp.domain.entity.Items;
import entgraClothingapp.domain.entity.SaleItems;
import entgraClothingapp.domain.entity.StockClearItems;
import lombok.Data;


import java.util.List;

@Data
public class CompositeRes {

    private List<Items> itemsData;
    private List<SaleItems> saleItemsData;
    private List<StockClearItems> stockClearItemsData;

    public CompositeRes() {}

    public CompositeRes(List<Items> itemsData, List<SaleItems> saleItemsData,List<StockClearItems> stockClearItemsData) {
        this.itemsData = itemsData;
        this.saleItemsData = saleItemsData;
        this.stockClearItemsData = stockClearItemsData;
    }
}
