package com.utn.lab4.tpfinal.business;

import com.utn.lab4.tpfinal.dto.AltaProductDto;
import com.utn.lab4.tpfinal.model.Product;

import java.util.ArrayList;
import java.util.List;

public interface BusinessProduct {

    //Crear nuevo producto
    Product createProduct(AltaProductDto dto);

    //Actualizar producto
    Product updateProduct(String id, Product p);

    //Eliminar producto
    boolean deleteProduct(String id);

    //Consultar producto segun id
     Product getProduct(String id);

    //Consultar productos segun atributo
    List<Product> getProductsByAttribute(String type, String brand, String category);


    ArrayList<Product> getAllProducts();
}
