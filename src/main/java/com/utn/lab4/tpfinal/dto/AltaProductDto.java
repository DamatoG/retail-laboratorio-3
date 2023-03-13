package com.utn.lab4.tpfinal.dto;

import com.utn.lab4.tpfinal.model.ProductType;

public class AltaProductDto {

    private String name;
    private ProductType type;
    private String description;
    private String category_name;
    private String brand;


    public AltaProductDto(String name, ProductType type, String description, String category_name, String brand) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.brand = brand;
        this.category_name = category_name;
    }

    public AltaProductDto(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
