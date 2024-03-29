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


@RestController
@RequestMapping ("/products") //Indica la url base
public class ProductController {

    @Autowired
    BusinessProduct businessProduct;

    //Consultar todos los productos existentes
    @GetMapping()
    public ResponseEntity<Object> getProducts (){
        return ResponseHandler.generateResponse("Datos recuperados con exito", HttpStatus.OK, businessProduct.getAllProducts());
    }

    //Consultar producto por su id
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProducto(@PathVariable String id) {
        Product producto = businessProduct.getProduct(id);
        if (producto == null) {
            throw new RegistroNotFoundException("El producto con id " + id + "no existe");
        }
        return ResponseHandler.generateResponse("Datos recuperados con exito", HttpStatus.OK, producto);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createProduct(@RequestBody AltaProductDto dto){
        if (dto.getName() == null || dto.getType() == null || dto.getDescription() == null || dto.getBrand() == null
        ){
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

    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateProduct(@PathVariable String id, @RequestBody Product p){
        System.out.println(id + " controler");

        businessProduct.updateProduct(id, p);

        return ResponseHandler.generateResponse("El producto "+ id + " fue actualizado con exito", HttpStatus.OK, p);
    }

    @GetMapping("/filter")
    public ResponseEntity<Object> getProductByAtribute(
            @RequestParam(name = "tipo_producto", required = false) String tipoProducto,
            @RequestParam(name = "marca", required = false) String marca,
            @RequestParam(name = "categoria", required = false) String categoria
    ){
        return ResponseHandler.generateResponse("Datos recuperados con exito", HttpStatus.OK, businessProduct.getProductsByAttribute(tipoProducto, marca, categoria));
    };

}
