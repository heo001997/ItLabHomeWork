package com.memorynotfound.spring.security;

import com.memorynotfound.spring.security.web.controller.HomeController;
import com.memorynotfound.spring.security.web.model.entity.Dictionary;
import com.memorynotfound.spring.security.web.model.implement.DictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Run implements CommandLineRunner {

    @Autowired
    DictionaryServiceImpl dictionaryService;

    @Autowired
    HomeController homeController;

    @Override
    public void run(String... strings) {
        System.out.println(dictionaryService.findAll());
        dictionaryService.addNewWord("Nguyễn Tiến Tú", "Boi đẹp chai check lỗi tiếng Việt", "Siêu đẹp trai thử insert tiếng Việt");
        try{
            dictionaryService.editExistedWordById(1, "demo mean 1 fixed times 2", "demo type 1 fixed times 2");
        } catch (NullPointerException e){
            System.out.println("Cannot find element, please check your syntax");
        }
        dictionaryService.deleteWordById(2);

        // put in database
        homeController.importData("F:\\spring-boot-spring-security-thymeleaf-form-login-example\\thymeleaf\\src\\main\\resources\\dict\\vnedict.txt", "VE");
    }

    public static void main(String[] args) {
        SpringApplication.run(Run.class, args);
    }
}
