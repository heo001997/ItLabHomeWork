package com.memorynotfound.spring.security.web.model.service;

import com.memorynotfound.spring.security.web.model.entity.Dictionary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.List;

public interface DictionaryService {
    List<Dictionary> findAll ();
    Dictionary addNewWord(String word, String mean, String type);
    Dictionary editExistedWordById(int id, String mean, String type);
    void deleteWordById(int id);
    List<Dictionary> findByWord(String word, int pageIndex, int pageSize);
}
