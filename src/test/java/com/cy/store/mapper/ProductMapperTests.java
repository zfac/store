package com.cy.store.mapper;

import com.cy.store.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTests {
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void findHotList(){
        List<Product> list = productMapper.findHotList();
        System.out.println(list.size());
        for (Product product : list) {
            System.out.println(product);
        }
    }

    @Test
    public void findById(){
        Integer id = 10000001;
        Product result = productMapper.findById(id);
        System.out.println(result);
    }
}
