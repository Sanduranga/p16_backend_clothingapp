package entgraClothingapp.external.repository;

import entgraClothingapp.domain.entity.StockClearItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StockItemRepository extends JpaRepository<StockClearItems, Integer> {
}
