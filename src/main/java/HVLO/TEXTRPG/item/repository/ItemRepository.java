package HVLO.TEXTRPG.item.repository;

import HVLO.TEXTRPG.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> getItemsByEnemyId(Long enemyId);
}

