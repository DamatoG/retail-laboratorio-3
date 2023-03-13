package com.utn.lab4.tpfinal.model;

import java.util.ArrayList;

public class Category {

    private String id_category;
    private String name_category;
    private String description_category;
    private ArrayList <Product> list_product = new ArrayList<>();

    public Category() {
        this.name_category = name_category;
    }

    public String getId_category() {
        return id_category;
    }

    public void setId_category(String id_category) {
        this.id_category = id_category;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

    public String getDescription_category() {
        return description_category;
    }

    public void setDescription_category(String description_category) {
        this.description_category = description_category;
    }

    public ArrayList<Product> getList_product() {
        return list_product;
    }

    public void setList_product(ArrayList<Product> list_product) {
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
