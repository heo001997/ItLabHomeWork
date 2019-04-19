package jpaconnecttomysqltu.app.Impl;

import jpaconnecttomysqltu.app.model.ItemCategory;
import jpaconnecttomysqltu.app.repository.ItemCategoryRepository;
import jpaconnecttomysqltu.app.repository.ItemRepository;
import jpaconnecttomysqltu.app.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class ItemCategoryServiceImpl implements ItemCategoryService {

    @Autowired
    ItemCategoryRepository itemCategoryRepository;

    @Override
    public Page<ItemCategory> findByCategoryId(int categoryId, int pageIndex, int pageSize) {
        return itemCategoryRepository.findByCategoryId(categoryId, new PageRequest(pageIndex, pageSize));
    }
}
