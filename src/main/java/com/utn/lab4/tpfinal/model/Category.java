package com.utn.lab4.tpfinal.model;

import java.util.ArrayList;

public class Category {

    private String id_category;
    private String name_category;
    private String description_category;
    private ArrayList <Product> list_product = new ArrayList<>();


    public String getIdCategory() {
        return id_category;
    }

    public void setIdCategory(String id_category) {
        this.id_category = id_category;
    }

    public String getNameCategory() {
        return name_category;
    }

    public void setNameCategory(String name_category) {
        this.name_category = name_category;
    }

    public String getDescriptionCategory() {
        return description_category;
    }

    public void setDescriptionCategory(String description_category) {
        this.description_category = description_category;
    }

    public ArrayList<Product> getListProduct() {
        return list_product;
    }

    public void setListProduct(ArrayList<Product> list_product) {
        this.list_product = list_product;
    }

    public boolean addProductToCategory (Product p){
        this.list_product.add(p);
        return true;
    }

    public boolean removeProductToCategory (Product p){
        this.list_product.remove(p);
        return true;
    }

}
