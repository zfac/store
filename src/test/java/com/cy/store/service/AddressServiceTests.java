package com.cy.store.service;


import com.cy.store.entity.Address;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTests {

    @Autowired
    private IAddressService addressService;

    @Test
    public void addNewAddress(){
        try {
            Integer uid = 20;
            String username = "管理员";
            Address address = new Address();
            address.setName("张三");
            address.setPhone("13083546806");
            address.setAddress("江苏");
            addressService.addNewAddress(uid,username,address);
            System.out.println("OK");
        }catch (ServiceException e){
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getByuid(){
        Integer uid = 9;
        List<Address> list = addressService.getByUid(uid);
        System.out.println(list.size());
        for (Address address : list) {
            System.out.println(address);
        }
    }

    @Test
    public void setDefault(){
        Integer aid = 12;
        Integer uid = 9;
        String username = "系统管理员";
        addressService.setDefault(aid,uid,username);
        System.out.println("OK");
    }


    @Test
    public void delete(){
        Integer aid = 10;
        Integer uid = 9;
        String username = "汉武帝";
        addressService.delete(aid,uid,username);
        System.out.println("OK");

    }
}
