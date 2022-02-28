package com.cy.store.mapper;

import com.cy.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.plaf.PanelUI;
import java.util.Date;
import java.util.List;

@SpringBootTest
/*
RunWith表示启动这个单元测试类(单元测试类是不能够运行的)，需要传递一个参数，必须是springrunner的实列类型
 */
@RunWith(SpringRunner.class)
public class AddressMapperTests {

    @Autowired
    private AddressMapper addressMapper;
    @Test
    public void insert(){
        Address address = new Address();
        address.setUid(120);
        address.setName("秦始皇");
        address.setPhone("10001");
        address.setAddress("咸阳");
        //System.out.println(address);
        Integer rows = addressMapper.insert(address);
        System.out.println(rows);
    }

    @Test
    public void countByUid(){
        Integer uid = 120;
        Integer count = addressMapper.countByUid(uid);
        System.out.println(count);
    }

    @Test
    public void findByUid(){
        Integer uid = 9;
        List<Address> list = addressMapper.findByUid(uid);
        System.out.println(list.size());
        for (Address address : list) {
            System.out.println(address);
        }
    }


    @Test
    public void updateNonDefaultByUid(){
        Integer uid = 9;
        Integer rows = addressMapper.updateNonDefaultByUid(uid);
        System.out.println(rows);
    }

    @Test
    public void updateDefaultByAid(){
        Integer aid = 12;
        String modifiedUser = "管理员";
        Date modifiedTime = new Date();
        Integer integer = addressMapper.updateDefaultByAid(aid, modifiedUser, modifiedTime);
        System.out.println(integer);
    }

    @Test
    public void findByAid(){
        Integer aid = 12;
        Address result = addressMapper.findByAid(aid);
        System.out.println(result);
    }


    @Test
    public void deleteByAid(){
        Integer aid = 4;
        Integer rows = addressMapper.deleteByAid(aid);
        System.out.println(rows);
    }

    @Test
    public void findLastModified(){
        Integer uid = 9;
        Address result = addressMapper.findLastModified(uid);
        System.out.println(result);
    }
}
