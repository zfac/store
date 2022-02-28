package com.cy.store.mapper;


import com.cy.store.entity.Cart;
import com.cy.store.entity.CartVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.plaf.PanelUI;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartMapperTests {
    @Autowired
    private CartMapper cartMapper;

    @Test
    public void insert(){
        Cart cart = new Cart();
        cart.setUid(1);
        cart.setPid(2);
        cart.setNum(3);
        cart.setPrice(4L);
        Integer rows = cartMapper.insert(cart);
        System.out.println(rows);
    }


    @Test
    public void updateNumByCid(){
        Integer cid = 1;
        Integer num = 10;
        String modifiedUser = "购物车管理员";
        Date modifiedTime = new Date();
        Integer rows = cartMapper.updateNumByCid(cid, num, modifiedUser, modifiedTime);
        System.out.println(rows);
    }

    @Test
    public void findByUidAndPid(){
        Integer uid = 1;
        Integer pid = 2;
        Cart result = cartMapper.findByUidAndPid(uid, pid);
        System.out.println(result);
    }


    @Test
    public void findVoByUid(){
        List<CartVO> list = cartMapper.findVOByUid(9);
        System.out.println(list);
    }

    @Test
    public void findByCid(){
        Integer cid = 3;
        Cart result = cartMapper.findByCid(cid);
        System.out.println(result);
    }

    @Test
    public void findVOByCids(){
        Integer[] cids = {2,3};
        List<CartVO> list = cartMapper.findVOByCids(cids);
        for (CartVO cartVO : list) {
            System.out.println(cartVO);
        }
    }
}
