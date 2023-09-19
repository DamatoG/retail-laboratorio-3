package com.utn.lab4.tpfinal.controller;

import com.utn.lab4.tpfinal.business.BussinesCategory;
import com.utn.lab4.tpfinal.dto.AltaCategoryDto;
import com.utn.lab4.tpfinal.exception.BadRequestException;
import com.utn.lab4.tpfinal.exception.RegistroNotFoundException;
import com.utn.lab4.tpfinal.model.Product;
import com.utn.lab4.tpfinal.util.ResponseHandler;
import com.utn.lab4.tpfinal.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    BussinesCategory bussinesCategory;

    //Consultar todos las categorias existentes
    @GetMapping()
    public ResponseEntity<Object>getProducts (){
        return ResponseHandler.generateResponse("Datos recuperados con exito",
                HttpStatus.OK,
                bussinesCategory.getAllCategories());
    }

    //Consultar categoria por su id
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategorieById(@PathVariable String id) {
        Category c = bussinesCategory.getCategory(id);
        if (c == null) {
            throw new RegistroNotFoundException("La categoria con id " + id + " no existe");
        }
        return ResponseHandler.generateResponse("Datos recuperados con exito", HttpStatus.OK, c);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createCategory(@RequestBody AltaCategoryDto dto) {
        if (dto.getName_category() == null || dto.getDescription_category() == null ){
            throw new BadRequestException("Los campos name, description son obligatorios");
        }
        return ResponseHandler.generateResponse("La categoria fue creada con exito", HttpStatus.CREATED, bussinesCategory.createCategory(dto) );

    }


    @GetMapping("/order/{id}")
    public ResponseEntity<Object> orderBy(
            @PathVariable String id,
            @RequestParam(name = "order_by") String order_by
        ){
        Category c = bussinesCategory.getCategory(id);
        //Error si la categoria no existe
        if (c == null) {
            throw new BadRequestException("La categoria con id "+  id + " no existe");
            //Error si order_by no tiene el valor asc o desc
        } else if ( order_by != "asc" && order_by != "desc") {
            throw new BadRequestException("order_by puede tener el valor asc o desc unicamente");
        }
        return ResponseHandler.generateResponse("Datos recuperados con exito", HttpStatus.OK, bussinesCategory.orderByPrice(id, order_by));
    };


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable String id){
        Category c = bussinesCategory.getCategory(id);
        if (c == null ) {
            throw new RegistroNotFoundException("La categoria con id " + id + " no existe");
        }
        bussinesCategory.deleteCategory(id);
        return ResponseHandler.generateResponse("La categoria se elimino correctamente", HttpStatus.OK, null);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateCategory(@PathVariable String id, @RequestBody Category c){
        if (bussinesCategory.getCategory(id) == null){
            throw new RegistroNotFoundException("La categoria con id " + id + " no existe");
        }
       bussinesCategory.updateCategory(id, c);

        return ResponseHandler.generateResponse("El producto "+ id + " fue actualizado con exito", HttpStatus.OK, c);
    }
}