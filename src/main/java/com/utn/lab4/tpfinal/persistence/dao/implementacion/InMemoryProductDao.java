package com.utn.lab4.tpfinal.persistence.dao.implementacion;

import com.utn.lab4.tpfinal.model.Product;
import com.utn.lab4.tpfinal.persistence.dao.ProductDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

import static java.lang.Integer.parseInt;

@Component
public class InMemoryProductDao implements ProductDao {

    private ArrayList <Product> productList = new ArrayList<>();


    @Override
    public Product save(Product p) {
        p.setId_product(generarId());
        this.productList.add(p);

        System.out.println("Se guardo el producto correctamente");
        return p;
    }

    private String generarId(){
        return UUID.randomUUID().toString().toUpperCase().substring(0,6);
    }


    @Override
    public Product findProductById(String id) {

        for (Product p: productList) {
            System.out.println("La capa de persistenicia esta buscando el producto");
            if (p.getId_product().equals(id)) {
                System.out.println("Producto encontrado");
               return p;
            }else {System.out.println("No existe un producto con ese id");};
        }
        return null;
    }

    @Override
    public Product updateProduct(Product p) {
        for (Product product: productList){
            if (product.getId_product() == p.getId_product()){
                product.setDescription_product(p.getDescription_product());
                product.setAtributes(p.getAtributes());
                product.setBrand(p.getBrand());
                product.setCategory_name(p.getCategory_name());
                product.setPrice(p.getPrice());
                product.setType(p.getType());

                return product;
            }
        }
        return null;
    }

    @Override
    public boolean deleteProduct(String id) {
        System.out.println("capa de persistencia metodo delete");
        for (Product p: productList){
            if(p.getId_product().equals(id)){
                System.out.println("Producto eliminado");
                productList.remove(p);
                return true;
            }
        }
        return false;

    }



    @Override
    public ArrayList<Product> findAll() {
        return productList;
    }
}
