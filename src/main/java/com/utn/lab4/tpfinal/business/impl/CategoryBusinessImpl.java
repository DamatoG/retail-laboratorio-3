package com.utn.lab4.tpfinal.business.impl;

import com.utn.lab4.tpfinal.business.BussinesCategory;
import com.utn.lab4.tpfinal.dto.AltaCategoryDto;
import com.utn.lab4.tpfinal.exception.BadRequestException;
import com.utn.lab4.tpfinal.model.Category;
import com.utn.lab4.tpfinal.model.Product;
import com.utn.lab4.tpfinal.persistence.dao.implementacion.InMemoryCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CategoryBusinessImpl implements BussinesCategory {

    @Autowired
    InMemoryCategoryDao dao;

    @Override
    public Category createCategory(AltaCategoryDto categoryDto) {

        Category newCategory = new Category();
        if (dao.findCategoryByName(categoryDto.getName_category()) != null){
            throw new BadRequestException("Ya existe un nombre con esa categoria");
        }
        newCategory.setNameCategory(categoryDto.getName_category());
        newCategory.setDescriptionCategory(categoryDto.getDescription_category());
        return dao.createCategory(newCategory);
    }

    @Override
    public Category updateCategory(String id, Category c) {
            dao.updateCategory(c);
            return c;
    }

    @Override
    public boolean deleteCategory(String id) {dao.deleteCategory(id);return true;}

    @Override
    public Category getCategory(String id) {return dao.findCategoryById(id);}

    @Override
    public ArrayList<Category> getAllCategories() {
        return dao.findAllCategory();
    }

    @Override
    public ArrayList<Product> orderByPrice(String id, String order_price) {
        return dao.orderByPrice(id, order_price);
    }
}
