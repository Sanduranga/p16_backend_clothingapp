package entgraClothingapp.external.repository;

import entgraClothingapp.domain.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ItemRepository extends JpaRepository<Items, Integer> {
}
