package com.utn.lab4.tpfinal.business.impl;

import com.utn.lab4.tpfinal.business.BussinesCategory;
import com.utn.lab4.tpfinal.dto.AltaCategoryDto;
import com.utn.lab4.tpfinal.model.Category;
import com.utn.lab4.tpfinal.persistence.dao.implementacion.InMemoryCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CategoryBussinesImple implements BussinesCategory {

    @Autowired
    InMemoryCategoryDao dao;

    @Override
    public Category createCategory(AltaCategoryDto categoryDto) {

        Category newCategory = new Category();
        newCategory.setName_category(categoryDto.getName_category());
        newCategory.setDescription_category(categoryDto.getDescription_category());
        return dao.createCategory(newCategory);
    }

    @Override
    public Category updateCategory(Category c) {
        if (dao.findCategoryById(c.getId_category()) != null) {
            dao.updateCategory(c);
            return c;
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteCategory(String id) {
        dao.deleteCategory(id);
        return true;
    }

    @Override
    public Category getCategory(String id) {
        return dao.findCategoryById(id);

    }

    @Override
    public ArrayList<Category> getAllCategories() {
        return dao.findAllCategory();
    }
}
