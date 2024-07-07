package entgraClothingapp.external.repository;

import entgraClothingapp.domain.entity.StockClearItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface StockItemRepository extends JpaRepository<StockClearItems, Long> {

    Optional<StockClearItems> findByItemsCode(Long itemsCode);
    void deleteByItemsCode(Long itemsCode);
}
