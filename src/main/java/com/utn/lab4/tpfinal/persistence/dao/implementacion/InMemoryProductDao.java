package com.utn.lab4.tpfinal.persistence.dao.implementacion;

import com.utn.lab4.tpfinal.model.Product;
import com.utn.lab4.tpfinal.persistence.dao.ProductDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        Product productActualizable = findProductById(p.getId_product());
            if (productActualizable != null){
                productActualizable.setName_product(p.getName_product());
                productActualizable.setDescription_product(p.getDescription_product());
                productActualizable.setAtributes(p.getAtributes());
                productActualizable.setBrand(p.getBrand());
                productActualizable.setCategory_name(p.getCategory_name());
                productActualizable.setPrice(p.getPrice());
                productActualizable.setType(p.getType());
            }
        return productActualizable;
    };

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

    public List<Product> filtrarProducts(String type, String brand, String category) {
        ArrayList<Product> productsFiltrados = new ArrayList<>();

//        if (type != null){
//            this.productList.stream().filter(product -> (product.getType().equals(type)));
//        }
        System.out.println("FILTRANDO DENTRO DE PERSISTENCIA");

       return productList.stream()
               .filter(product ->
                       (type == null || product.getType().equals(type)) &&
                       (brand == null || product.getBrand().equals(brand)) &&
                       (category == null || product.getCategory_name().equals(category))
               ).collect(Collectors.toList());
}
}
