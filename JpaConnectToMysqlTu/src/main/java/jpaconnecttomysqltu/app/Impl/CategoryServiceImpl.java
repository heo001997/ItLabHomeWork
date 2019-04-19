package jpaconnecttomysqltu.app.Impl;

import jpaconnecttomysqltu.app.model.Category;
import jpaconnecttomysqltu.app.repository.CategoryRepository;
import jpaconnecttomysqltu.app.repository.TypeRepository;
import jpaconnecttomysqltu.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    TypeServiceImpl typeService;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findByType(String typeName, int pageIndex, int pageSize) {
        int typeId = typeService.getTypeByName(typeName).getId();
        Page<Category> categories = categoryRepository.findByTypeId(typeId, new PageRequest(pageIndex, pageSize));
        return categories.getContent();
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getCategoryByTypeId(int typeId) {
        List<Category> categoryList = categoryRepository.findByTypeId(typeId);
        return categoryList;
    }

    @Override
    public Category getCategoryByName(String name) {
        Category category = categoryRepository.findByName(name);
        return category;
    }

    @Override
    public Category save(Category category) {
        categoryRepository.save(category);
        return category;
    }
}
