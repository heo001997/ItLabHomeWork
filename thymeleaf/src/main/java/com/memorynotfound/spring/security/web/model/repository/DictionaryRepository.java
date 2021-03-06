package com.memorynotfound.spring.security.web.model.repository;

import com.memorynotfound.spring.security.web.model.entity.Dictionary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary, Integer> {
    List<Dictionary> findAll();
    Dictionary save(Dictionary dictionary);
    void delete(Dictionary dictionary);
    Dictionary findById(int id);
    Page<Dictionary> findByWord(String word, Pageable pageable);
}
