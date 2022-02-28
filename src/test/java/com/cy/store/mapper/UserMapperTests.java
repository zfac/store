package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

//springbootTest表示标注当前的类是一个测试类，不会随同项目一块打包发送
@SpringBootTest
/*
RunWith表示启动这个单元测试类(单元测试类是不能够运行的)，需要传递一个参数，必须是springrunner的实列类型
 */
@RunWith(SpringRunner.class)
public class UserMapperTests {

    /**
     * 爆红的原因是：idea有检测功能，接口时不能够直接创建bean的(动态代理技术来解决)
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 单元测试方法：就可以单独独立运行，不用启动整个项目，可以做单元测试
     * 1、必须用Test修饰
     * 2、返回值类型必须是void
     * 3、方法的参数列表不指定任何类型
     * 4、方法的反问修饰符必须是public
     */
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("tim");
        user.setPassword("123");

        Integer insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void findByUsername(){
        User tim = userMapper.findByUsername("tim");
        System.out.println(tim);
    }


    /*Integer uid, String password, String modifiedUser, Date modifiedTime*/
    @Test
    public void updatePasswordByUid(){
        userMapper.updatePasswordByUid(6,"321","管理员",new Date());
    }

    /*Integer uid*/
    @Test
    public void findByUid(){
        System.out.println(userMapper.findByUid(6));
    }


    @Test
    public void updateInfoByUid(){
        User user = new User();
        user.setUid(6);
        user.setPhone("123456789");
        user.setEmail("123456@qq.com");
        user.setGender(1);
        Integer integer = userMapper.updateInfoByUid(user);
        System.out.println(integer);
    }


    /*
    @Test
    public void updateAvatarByUid(){
        userMapper.updateAvatarByUid(9,"/upload/avatar.png","管理员",new Date());
    }

     */
}
