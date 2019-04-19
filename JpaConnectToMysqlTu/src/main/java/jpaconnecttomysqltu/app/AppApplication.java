package jpaconnecttomysqltu.app;

import jpaconnecttomysqltu.app.Impl.CategoryServiceImpl;
import jpaconnecttomysqltu.app.Impl.ItemCategoryServiceImpl;
import jpaconnecttomysqltu.app.Impl.TypeServiceImpl;
import jpaconnecttomysqltu.app.model.Category;
import jpaconnecttomysqltu.app.model.Item;
import jpaconnecttomysqltu.app.model.ItemCategory;
import jpaconnecttomysqltu.app.repository.ItemCategoryRepository;
import jpaconnecttomysqltu.app.repository.ItemRepository;
import jpaconnecttomysqltu.app.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;

import java.util.List;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

    @Autowired
    TypeServiceImpl typeService;

    @Autowired
    CategoryServiceImpl categoryService;

    @Autowired
    ItemCategoryRepository itemCategoryRepository;

    @Autowired
    ItemCategoryServiceImpl itemCategoryService;

    @Autowired
    ItemRepository itemRepository;

    public void run(String... arg){
        // Show all table/entity value
        System.out.println(typeService.findAll());
        System.out.println(categoryService.findAll());
        System.out.println(itemCategoryRepository.findAll());
        System.out.println(itemRepository.findAll() +"\n");

        // find categories by type name
        String typeName = "type1";
        System.out.println(categoryService.findByType(typeName, 0, 10) + "\n");

        //find items by category’s name
        String categoryName = "cat1";
        int categoryId = categoryService.getCategoryByName(categoryName).getId();
        Page<ItemCategory> itemCategoryPage = itemCategoryService.findByCategoryId(categoryId, 0, 10);
        itemCategoryPage.forEach(currCategoryPage ->
                System.out.println(itemRepository.findById(currCategoryPage.getItemId()))
        );
        System.out.println();

        // update/save Category
        Category category = new Category(111, "Demo22", 111);
        categoryService.save(category);
    }

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
}
