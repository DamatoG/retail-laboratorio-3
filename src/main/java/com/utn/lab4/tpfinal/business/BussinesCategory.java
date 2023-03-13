package com.utn.lab4.tpfinal.business;

import com.utn.lab4.tpfinal.dto.AltaCategoryDto;
import com.utn.lab4.tpfinal.model.Category;

import java.util.ArrayList;

public interface BussinesCategory {

    Category createCategory (AltaCategoryDto dto);
    Category updateCategory (Category c);
    boolean deleteCategory (String id);
    Category getCategory (String id);
    ArrayList<Category> getAllCategories();

}
