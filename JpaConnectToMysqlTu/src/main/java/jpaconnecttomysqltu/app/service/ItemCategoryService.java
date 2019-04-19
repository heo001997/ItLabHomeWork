package jpaconnecttomysqltu.app.service;

import jpaconnecttomysqltu.app.model.ItemCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemCategoryService {
    Page<ItemCategory> findByCategoryId (int categoryId, int pageIndex, int pageSize);
}
