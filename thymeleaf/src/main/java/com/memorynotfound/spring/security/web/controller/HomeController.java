package com.memorynotfound.spring.security.web.controller;

import com.memorynotfound.spring.security.web.model.entity.Dictionary;
import com.memorynotfound.spring.security.web.model.implement.DictionaryServiceImpl;
import com.memorynotfound.spring.security.web.model.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    DictionaryServiceImpl dictionaryService;

    @Autowired
    DictionaryRepository dictionaryRepository;

    @GetMapping("/")
    public String root(Model model) {
        model.addAttribute("words", dictionaryService.findAll());
        return "index";
    }

    @PostMapping("/search")
    public String search(Model model, @ModelAttribute(name = "dictionary") Dictionary dictionary){
        List<Dictionary> dictionaries = dictionaryService.findByWord(dictionary.getWord(), 0, 5);

        Dictionary dictionaryResult = null;
        for (Dictionary temp: dictionaries){
            if (dictionary.getType().equals(temp.getType())){
                dictionaryResult = temp;
            }
        }

        model.addAttribute("dictionaryResult", dictionaryResult);
        return "index";
    }

    @GetMapping("/admin")
    public String adminIndex() {
        return "admin/index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }

    @GetMapping("/show")
    public String showList(String word, BindingResult result, Model model) {
        model.addAttribute(dictionaryService.findAll());
        return "index";
    }

    @GetMapping("/importdata")
    public void importData(String dbPath, String type){
        try {
            FileReader reader = new FileReader(dbPath);
            BufferedReader br = new BufferedReader(reader);
            String[] stringArray;
            String line;
            while ((line = br.readLine()) != null){
                stringArray = line.split(":");
                if (stringArray.length >= 2){
                    dictionaryRepository.save(new Dictionary(0, stringArray[0].trim(), stringArray[1].trim(), type));
                }
            }
            System.out.println("Done");
        } catch (IOException e) {
            System.out.println("IOException");
        }

    }
}
