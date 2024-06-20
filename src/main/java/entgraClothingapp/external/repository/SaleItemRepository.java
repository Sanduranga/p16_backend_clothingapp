package entgraClothingapp.external.repository;

import entgraClothingapp.domain.entity.SaleItems;
import jakarta.transaction.Transactional;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface SaleItemRepository extends JpaRepository<SaleItems, Integer> {
    Optional<SaleItems> findByCode(String code);
    
    @Modifying
    @Transactional
    @Query("DELETE FROM SaleItems i WHERE i.code = ?1")
    void deleteByCode(String code);
}
