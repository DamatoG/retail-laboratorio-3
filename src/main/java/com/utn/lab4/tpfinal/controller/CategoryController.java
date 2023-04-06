package com.utn.lab4.tpfinal.controller;

import com.utn.lab4.tpfinal.business.BussinesCategory;
import com.utn.lab4.tpfinal.dto.AltaCategoryDto;
import com.utn.lab4.tpfinal.exception.BadRequestException;
import com.utn.lab4.tpfinal.exception.RegistroNotFoundException;
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
    public ResponseEntity<Object> getProducts (){
        return ResponseHandler.generateResponse("Datos recuperados con exito",
                HttpStatus.OK,
                bussinesCategory.getAllCategories());
    }

    //Consultar producto por su id
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategorieById(@PathVariable String id) {
        Category c = null;
        c = bussinesCategory.getCategory(id);
        if (c == null) {
            throw new RegistroNotFoundException("El producto con id " + id + "no existe");
        }
        return ResponseHandler.generateResponse("Datos recuperados con exito", HttpStatus.OK, c);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createCategory(@RequestBody AltaCategoryDto dto) {
        if (dto.getName_category() == null || dto.getDescription_category() == null ){
            throw new BadRequestException("Los campos name, description son obligatorios");
        }
        return ResponseHandler.generateResponse("La categoria fue creado con exito", HttpStatus.CREATED, bussinesCategory.createCategory(dto) );

    }
}

