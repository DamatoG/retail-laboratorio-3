package com.utn.lab4.tpfinal.controller;

import com.utn.lab4.tpfinal.business.BusinessProduct;
import com.utn.lab4.tpfinal.dto.AltaProductDto;
import com.utn.lab4.tpfinal.exception.BadRequestException;
import com.utn.lab4.tpfinal.exception.RegistroNotFoundException;
import com.utn.lab4.tpfinal.util.ResponseHandler;
import com.utn.lab4.tpfinal.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping ("/products") //Indica la url base
public class ProductController {

    @Autowired
    BusinessProduct businessProduct;

    //Consultar todos los productos existentes
    @GetMapping()
    public ResponseEntity<Object> getProducts (){
        businessProduct.getAllProducts();
        ArrayList<Product> products;
        return ResponseHandler.generateResponse("Datos recuperados con exito", HttpStatus.OK, businessProduct.getAllProducts());
    }

    //Consultar producto por su id
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProducto(@PathVariable String id) {
        Product producto = null;
        producto = businessProduct.getProduct(id);
        if (producto == null) {
            throw new RegistroNotFoundException("El producto con id " + id + "no existe");
        }
        return ResponseHandler.generateResponse("Datos recuperados con exito", HttpStatus.OK, producto);
    }
//    @GetMapping("/{id}")
//    public Product getProducto(@PathVariable String id) {
//        return businessProduct.getProduct(id);
//    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> crearProducto(@RequestBody AltaProductDto dto){
        if (dto.getName() == null || dto.getType() == null || dto.getDescription() == null || dto.getBrand() == null){
            throw  new BadRequestException("Los campos name, type, description y brand son obligatorios");
        }
        return ResponseHandler.generateResponse("El producto fue creado con exito", HttpStatus.CREATED, businessProduct.createProduct(dto) );

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable String id){
        Product p = businessProduct.getProduct(id);
        if (p == null){
            throw new RegistroNotFoundException("El producto con id " + id + "no existe");
        }
        businessProduct.deleteProduct(id);
        return ResponseHandler.generateResponse("el producto se elimino correctamente", HttpStatus.OK, null);

    };


    /*@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product crearProduct(@RequestBody AltaProductDto dto){
        return this.businessProduct.createProduct(dto);
    }*/

}
