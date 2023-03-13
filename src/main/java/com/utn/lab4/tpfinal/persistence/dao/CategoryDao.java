package com.utn.lab4.tpfinal.persistence.dao;

import com.utn.lab4.tpfinal.model.Category;

import java.util.ArrayList;
import java.util.List;

public interface CategoryDao {
    Category createCategory (Category c);
    Category findCategoryById (String id);
    Category updateCategory(Category category);
    List<Category> findAllCategory();
    boolean deleteCategory (String id);
    Category findCategoryByName(String name_category);
    ArrayList<String> getCategoriesNames();
}
