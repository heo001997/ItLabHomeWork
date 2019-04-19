package jpaconnecttomysqltu.app.repository;

import jpaconnecttomysqltu.app.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
    Type findByName(String name);
    Type findById(int id);
    List<Type> findAll();
}
