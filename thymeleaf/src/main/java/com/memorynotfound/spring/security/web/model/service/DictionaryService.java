package com.memorynotfound.spring.security.web.model.service;

import com.memorynotfound.spring.security.web.model.entity.Dictionary;

import java.util.List;

public interface DictionaryService {
    List<Dictionary> findAll ();
    Dictionary addNewWord(String word, String mean, String type);
    Dictionary editExistedWord(String word, String mean, String type);
    void deleteWord(String word);
}
