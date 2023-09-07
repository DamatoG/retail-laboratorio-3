package com.utn.lab4.tpfinal.business.impl;

import com.utn.lab4.tpfinal.business.BusinessProduct;
import com.utn.lab4.tpfinal.dto.AltaProductDto;
import com.utn.lab4.tpfinal.exception.BadRequestException;
import com.utn.lab4.tpfinal.model.Category;
import com.utn.lab4.tpfinal.model.Product;
import com.utn.lab4.tpfinal.persistence.dao.CategoryDao;
import com.utn.lab4.tpfinal.persistence.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductBusinessImple implements BusinessProduct {

    @Autowired
    ProductDao productoDao;

    @Autowired
    CategoryDao categoryDao;

    //Este metodo recibe crea un nuevo producto.
    // Recibe como parametro un dto (una version simplificada del objeto)
    // Implementa

    @Override
    public Product createProduct(AltaProductDto dto) {
        Product product = new Product();
        product.setNameProduct(dto.getName());
        product.setType(dto.getType());
        product.setDescriptionProduct(dto.getDescription());
        product.setBrand(dto.getBrand());
        product.setCategoryName(dto.getCategory_name());
        product.setPrice(dto.getPrice());

        Category c = categoryDao.findCategoryByName(dto.getCategory_name());
        if (c == null){
            //c = categoryDao.findCategoryByName("Otros");
            throw new BadRequestException("La categoria seleccionada no existe. Las categorias disponibles son: " + categoryDao.getCategoriesNames().toString());
        }

        c.addProductToCategory(product);
        return this.productoDao.save(product);
    }

    @Override
    public Product updateProduct(String id, Product p) {
        if (productoDao.findProductById(id) == null){
            throw new BadRequestException("El producto con id "+p.getIdProduct()+" no existe");
        }
        p.setIdProduct(id);
        return this.productoDao.updateProduct(p);
    }

    @Override
    public boolean deleteProduct(String id) {
        Category c = categoryDao.findCategoryByName(productoDao.findProductById(id).getCategoryName());
        if (c != null) {
            c.removeProductToCategory(productoDao.findProductById(id));
            productoDao.deleteProduct(id);
        }
        this.productoDao.deleteProduct(id);
        return true;
    }

    @Override
    public Product getProduct(String id) {
        return this.productoDao.findProductById(id);
    }

    @Override
    public List<Product> getProductsByAttribute(String type, String brand, String category) {
        System.out.println(this.productoDao.filtrarProducts(type, brand, category));
        return this.productoDao.filtrarProducts(type, brand, category);

    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return this.productoDao.findAll();
    }

}

