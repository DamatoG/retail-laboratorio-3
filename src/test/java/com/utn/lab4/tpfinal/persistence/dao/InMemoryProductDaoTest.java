package com.utn.lab4.tpfinal.persistence.dao;

import com.utn.lab4.tpfinal.model.Product;
import com.utn.lab4.tpfinal.persistence.dao.implementacion.InMemoryProductDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class InMemoryProductDaoTest{

    @InjectMocks
    InMemoryProductDao inMemoryProductDao;

    @Test
    public void test_save_OK() {
        Product p = new Product("Tv", "OTros", "TV", 1100);

        inMemoryProductDao.save(p);
        assertEquals(1, inMemoryProductDao.findAll().size());
    }
    }

