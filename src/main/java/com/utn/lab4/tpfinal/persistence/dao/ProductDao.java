package com.utn.lab4.tpfinal.persistence.dao;

import com.utn.lab4.tpfinal.model.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductDao {

    Product save(Product p);
    Product findProductById(String id);
    Product updateProduct (Product p);
    boolean deleteProduct(String id);

    ArrayList<Product> findAll();
    List<Product> filtrarProducts(String type, String brand, String category);

}
