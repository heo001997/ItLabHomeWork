package com.memorynotfound.spring.security.web.model.implement;

import com.memorynotfound.spring.security.web.model.entity.Dictionary;
import com.memorynotfound.spring.security.web.model.repository.DictionaryRepository;
import com.memorynotfound.spring.security.web.model.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Component
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    DictionaryRepository dictionaryRepository;

    @Override
    public List<Dictionary> findAll() {
        return dictionaryRepository.findAll();
    }

    @Override
    public Dictionary addNewWord(String word, String mean, String type) {
        return dictionaryRepository.save(new Dictionary(0, word, mean, type));
    }

    @Override
    public Dictionary editExistedWordById(int id, String mean, String type) {
        Dictionary dictionary = dictionaryRepository.findById(id);

        if (dictionary == null){
            throw new NullPointerException();
        }
        dictionary.setMean(mean);
        dictionary.setType(type);

        return dictionaryRepository.save(dictionary);
    }

    @Override
    public void deleteWordById(int id) {
        dictionaryRepository.delete(dictionaryRepository.findById(id));
    }

    @Override
    public List<Dictionary> findByWord(String word, int pageIndex, int pageSize) {
        Page<Dictionary> dictionaries = dictionaryRepository.findByWord(word, new PageRequest(pageIndex, pageSize));
        return dictionaries.getContent();
    }

}
