package com.memorynotfound.spring.security.web.model.implement;

import com.memorynotfound.spring.security.web.model.entity.Dictionary;
import com.memorynotfound.spring.security.web.model.repository.DictionaryRepository;
import com.memorynotfound.spring.security.web.model.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public Dictionary editExistedWord(String tempWord, String mean, String type) {
        Dictionary dictionary = dictionaryRepository.findByWord(tempWord);

        if (dictionary == null){
            throw new NullPointerException();
        }
        dictionary.setMean(mean);
        dictionary.setType(type);

        return dictionaryRepository.save(dictionary);
    }

    @Override
    public void deleteWord(String word) {
        dictionaryRepository.delete(dictionaryRepository.findByWord(word));
    }
}
