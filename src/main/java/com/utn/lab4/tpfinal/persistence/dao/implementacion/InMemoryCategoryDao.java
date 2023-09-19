package com.utn.lab4.tpfinal.persistence.dao.implementacion;

import com.utn.lab4.tpfinal.model.Category;
import com.utn.lab4.tpfinal.model.Product;
import com.utn.lab4.tpfinal.persistence.dao.CategoryDao;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InMemoryCategoryDao implements CategoryDao {

    private ArrayList <Category> categoriyList = new ArrayList<>();


    @Override
    public Category createCategory(Category c) {
        c.setIdCategory(generarId());
        this.categoriyList.add(c);
        System.out.println("Se guardo la categoria correctamente");
        return c;
    }

    private String generarId(){
        return UUID.randomUUID().toString().toUpperCase().substring(0,6);
    }


    @Override
    public Category findCategoryById(String id) {

        for (Category c: categoriyList) {
            //System.out.println("La capa de persistenicia esta buscando el producto");
            if (c.getIdCategory().equals(id)) {
                //System.out.println("Categoria encontrado");
               return c;
            }else {System.out.println("No existe un producto con ese id");}
        }
        return null;
    }


    @Override
    public Category updateCategory(Category category) {
        for (Category c: categoriyList){
            if (c.getIdCategory().equals( category.getIdCategory())){
                c.setDescriptionCategory(category.getDescriptionCategory());
                c.setNameCategory(category.getNameCategory());

                return c;
            }
        }
        return null;
    }

    @Override
    public boolean deleteCategory(String id) {
        System.out.println("capa de persistencia metodo delete");
        for (Category c: categoriyList){
            if(c.getIdCategory().equals(id)){
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
            if (c.getNameCategory().toLowerCase().equals(name_category.toLowerCase())) {
                //System.out.println("Categoria encontrado");
                return c;
            }else {System.out.println("No existe un producto con ese id");}
        }
        return null;
    }

    @Override
    public ArrayList<String> getCategoriesNames() {
        ArrayList<String> categoriesNames = new ArrayList<>();

        for(Category c: categoriyList){
            categoriesNames.add(c.getNameCategory());
        }
        return categoriesNames;
    }

    @Override
    public ArrayList<Category> findAllCategory() {
        return categoriyList;
    }


    public ArrayList<Product> orderByPrice(String id, String order_price){
        ArrayList<Product> listaOrdenada = new ArrayList<>();

        for (Category c: categoriyList) {
            if (c.getIdCategory().equals(id)){
                listaOrdenada = c.getListProduct();

                if (order_price.equals("asc")) {
                    Collections.sort(listaOrdenada, Comparator.comparing(Product::getPrice));
                }

                else {
                    Collections.sort(listaOrdenada, Comparator.comparing(Product::getPrice));
                    Collections.reverse(listaOrdenada);
                }
            }

        }

        return listaOrdenada;
    }

    @Override
    public ArrayList<Product> getByBrand (String id, String brand){
        ArrayList<Product> listByBrand = new ArrayList<>();


        return listByBrand;
    }
}
