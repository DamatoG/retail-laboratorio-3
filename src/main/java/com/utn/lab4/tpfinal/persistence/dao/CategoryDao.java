package com.utn.lab4.tpfinal.persistence.dao;

import com.utn.lab4.tpfinal.model.Category;
import com.utn.lab4.tpfinal.model.Product;

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
    ArrayList<Product> getByBrand(String id, String brand);
}
