package entgraClothingapp.external.repository;

import entgraClothingapp.domain.entity.Items;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ItemRepository extends JpaRepository<Items, Long> {

    @EntityGraph(value = "Items.detail", type = EntityGraph.EntityGraphType.LOAD)
    Optional<Items> findById(long id);

    Optional<Items> findByCode(String code);
    void deleteByCode(String code);
}
