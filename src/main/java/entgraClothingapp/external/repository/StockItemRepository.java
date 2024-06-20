package entgraClothingapp.external.repository;

import entgraClothingapp.domain.entity.StockClearItems;
import jakarta.transaction.Transactional;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface StockItemRepository extends JpaRepository<StockClearItems, Integer> {
    Optional<StockClearItems> findByCode(String code);
    
    @Modifying
    @Transactional
    @Query("DELETE FROM StockClearItems i WHERE i.code = ?1")
    void deleteByCode(String code);
}
