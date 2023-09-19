package com.utn.lab4.tpfinal.persistence.dao;
import com.utn.lab4.tpfinal.model.Category;
import com.utn.lab4.tpfinal.persistence.dao.implementacion.InMemoryCategoryDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class InMemoryCategoryDaoTest{

    @InjectMocks
    InMemoryCategoryDao inMemoryCategoryDao;

    @Test
    public void test_save_OK() {
        Category c = new Category("Tv", "televisores");

        inMemoryCategoryDao.createCategory(c);
        assertEquals(1, inMemoryCategoryDao.findAllCategory().size());
    }
}