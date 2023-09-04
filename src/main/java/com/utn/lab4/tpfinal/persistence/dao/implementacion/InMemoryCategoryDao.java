package com.utn.lab4.tpfinal.persistence.dao.implementacion;

import com.utn.lab4.tpfinal.model.Category;
import com.utn.lab4.tpfinal.model.Product;
import com.utn.lab4.tpfinal.persistence.dao.CategoryDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class InMemoryCategoryDao implements CategoryDao {

    Category c1 = new Category();
    private ArrayList <Category> categoriyList = new ArrayList<>();


    @Override
    public Category createCategory(Category c) {
        c.setId_category(generarId());
        this.categoriyList.add(c);
        System.out.println("Se guardo la categoria correctamente");
        return c;
    }

    private String generarId(){
        return UUID.randomUUID().toString().toUpperCase().substring(0,6);
    }

    private ArrayList <Product> productList = new ArrayList<>();

    @Override
    public Category findCategoryById(String id) {

        for (Category c: categoriyList) {
            //System.out.println("La capa de persistenicia esta buscando el producto");
            if (c.getId_category().equals(id)) {
                //System.out.println("Categoria encontrado");
               return c;
            }else {System.out.println("No existe un producto con ese id");};
        }
        return null;
    }



    ;

    @Override
    public Category updateCategory(Category category) {
        for (Category c: categoriyList){
            if (c.getId_category() == category.getId_category()){
                c.setDescription_category(category.getDescription_category());
                c.setName_category(category.getName_category());

                return c;
            }
        }
        return null;
    }

    @Override
    public boolean deleteCategory(String id) {
        System.out.println("capa de persistencia metodo delete");
        for (Category c: categoriyList){
            if(c.getId_category().equals(id)){
                System.out.println("Categoria eliminada");
                categoriyList.remove(c);
                return true;
            }
        }
        return false;

    }

    @Override
    public Category findCategoryByName(String name_category) {
        for (Category c: categoriyList) {
            //System.out.println("La capa de persistenicia esta buscando el producto");
            if (c.getName_category().toLowerCase().equals(name_category.toLowerCase())) {
                //System.out.println("Categoria encontrado");
                return c;
            }else {System.out.println("No existe un producto con ese id");};
        }
        return null;
    }

    @Override
    public ArrayList<String> getCategoriesNames() {
        ArrayList<String> categoriesNames = new ArrayList<>();

        for(Category c: categoriyList){
            categoriesNames.add(c.getName_category());
        };
        return categoriesNames;
    }



    @Override
    public ArrayList<Category> findAllCategory() {
        return categoriyList;
    }
}
