package jpaconnecttomysqltu.app.repository;

import jpaconnecttomysqltu.app.model.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Integer> {
    List<ItemCategory> findByCategoryId(int categoryId);
    List<ItemCategory> findAll();
}
