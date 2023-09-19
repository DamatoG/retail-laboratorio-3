package com.utn.lab4.tpfinal.model;


import java.util.Map;

public class Product {
    private String id_product;
    private String name_product;
    private String description_product;
    private String category_name;
    private String brand;
    private int price;
    private Map <String, String> atributes;
    private ProductType type;

    public Product(){}
    public Product(String name_product, String category_name, String brand, int price) {
        this.name_product = name_product;
        this.category_name = category_name;
        this.brand = brand;
        this.price = price;
    }

    public Product(String name_product, ProductType type, String description_product, String category_name, String brand, int price) {
        this.name_product = name_product;
        this.description_product = description_product;
        this.category_name = category_name;
        this.type = type;
        this.brand = brand;
        this.price = price;
    }


    public String getIdProduct() {
        return id_product;
    }

    public void setIdProduct(String id_product) {
        this.id_product = id_product;
    }

    public String getDescriptionProduct() {
        return description_product;
    }

    public void setDescriptionProduct(String description_product) {
        this.description_product = description_product;
    }

    public String getCategoryName() {
        return category_name;
    }

    public void setCategoryName(String category_name) {
        this.category_name = category_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Map<String, String> getAtributes() {
        return atributes;
    }

    public void setAtributes(Map<String, String> atributes) {
        this.atributes = atributes;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getNameProduct() {
        return name_product;
    }

    public void setNameProduct(String name_product) {
        this.name_product = name_product;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id_product='" + id_product + '\'' +
                ", name_product='" + name_product + '\'' +
                ", description_product='" + description_product + '\'' +
                ", category_name='" + category_name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", atributes=" + atributes +
                ", type=" + type +
                '}';
    }
}
