package entgraClothingapp.external.repository;

import entgraClothingapp.domain.entity.SaleItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface SaleItemRepository extends JpaRepository<SaleItems, Long> {

    Optional<SaleItems> findByItemsCode(Long itemsCode);
    void deleteByItemsCode(Long itemsCode);
}
