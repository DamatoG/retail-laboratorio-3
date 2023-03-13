package com.utn.lab4.tpfinal.business;

import com.utn.lab4.tpfinal.dto.AltaProductDto;
import com.utn.lab4.tpfinal.model.Product;

import java.util.ArrayList;

public interface BusinessProduct {

    //Crear nuevo producto
    Product createProduct(AltaProductDto dto);

    //Actualizar producto
    Product updateProduct(AltaProductDto dto);

    //Eliminar producto
    boolean deleteProduct(String id);

    //Consultar producto segun id
     Product getProduct(String id);

    //Consultar productos segun atributo
    ArrayList<Product> getProductsByAttribute();


    ArrayList<Product> getAllProducts();
}
