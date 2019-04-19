package jpaconnecttomysqltu.app.repository;

import jpaconnecttomysqltu.app.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByTypeId(int typeId);
    Page<Category> findByTypeId(int typeId, Pageable pageable);
    Category findByName(String name);
    List<Category> findAll();
    Category save(Category category);
}
