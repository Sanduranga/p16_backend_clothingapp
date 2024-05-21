package entgraClothingapp.external.repository;

import entgraClothingapp.domain.entity.SaleItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SaleItemRepository extends JpaRepository<SaleItems, Integer> {
}
