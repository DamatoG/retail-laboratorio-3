package com.utn.lab4.tpfinal.business;

import com.utn.lab4.tpfinal.business.impl.ProductBusinessImple;
import com.utn.lab4.tpfinal.dto.AltaProductDto;
import com.utn.lab4.tpfinal.model.Category;
import com.utn.lab4.tpfinal.model.Product;
import com.utn.lab4.tpfinal.persistence.dao.CategoryDao;
import com.utn.lab4.tpfinal.persistence.dao.ProductDao;
import com.utn.lab4.tpfinal.persistence.dao.implementacion.InMemoryCategoryDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static com.utn.lab4.tpfinal.model.ProductType.celulares;

@ExtendWith(MockitoExtension.class)
public class ProductBusinessTest {

    @Mock
    private ProductDao productDaoMock;

    @Mock
    private InMemoryCategoryDao categoryDaoMock;


    //A businessProductImplementation le inyecto las dependencias categoryDaoMock y categoryDaoMock
    @InjectMocks
    private ProductBusinessImple implementation;


    @Test
    public void test_createProduct_OK(){


        Category c = new Category();
        c.setNameCategory("Otros");

        Product p = new Product("Samsung S24", celulares, "Celular s23", "Otros", "celulares", 1000);
        AltaProductDto productoEsperado = new AltaProductDto("Samsung S24", celulares, "Celular s23", "Otros", "celulares", 1000);

        Mockito.when(productDaoMock.save(Mockito.<Product>any())).thenReturn(p);
        Mockito.when(categoryDaoMock.findCategoryByName("Otros")).thenReturn(c);

        Product resultProduct = implementation.createProduct(productoEsperado);

        assertEquals(productoEsperado.getName(), resultProduct.getNameProduct());
        assertEquals(productoEsperado.getBrand(), resultProduct.getBrand());
        assertEquals(productoEsperado.getType(), resultProduct.getType());
        assertEquals(productoEsperado.getCategory_name(), resultProduct.getCategoryName());
        assertEquals(productoEsperado.getPrice(), resultProduct.getPrice());

    }

    @Test
    public void test_deleteProduct_OK(){
        Product p = new Product();

        Mockito.when(productDaoMock.deleteProduct(Mockito.any())).thenReturn(true);
        Mockito.when(productDaoMock.findProductById(Mockito.<String>any())).thenReturn(p);

        assertTrue(implementation.deleteProduct(p.getIdProduct()));
    }

}
