package jpaconnecttomysqltu.app.service;

import jpaconnecttomysqltu.app.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findByType(String typeName, int pageIndex, int pageSize);
    List<Category> findAll();
    List<Category> getCategoryByTypeId (int typeId);
    Category getCategoryByName (String name);
    Category save(Category category);
}
