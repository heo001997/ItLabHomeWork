package jpaconnecttomysqltu.app.repository;

import jpaconnecttomysqltu.app.model.ItemCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategory, Integer> {
    Page<ItemCategory> findByCategoryId(int categoryId, Pageable pageable);
    List<ItemCategory> findAll();
}
