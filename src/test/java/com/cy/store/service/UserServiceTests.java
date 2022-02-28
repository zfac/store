package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.rowset.serial.SQLOutputImpl;
import javax.sql.rowset.serial.SerialException;

//springbootTest表示标注当前的类是一个测试类，不会随同项目一块打包发送
@SpringBootTest
/*
RunWith表示启动这个单元测试类(单元测试类是不能够运行的)，需要传递一个参数，必须是springrunner的实列类型
 */
@RunWith(SpringRunner.class)
public class UserServiceTests {

    /**
     * 爆红的原因是：idea有检测功能，接口时不能够直接创建bean的(动态代理技术来解决)
     */
    @Autowired
    private IUserService userService;
    /**
     * 单元测试方法：就可以单独独立运行，不用启动整个项目，可以做单元测试
     * 1、必须用Test修饰
     * 2、返回值类型必须是void
     * 3、方法的参数列表不指定任何类型
     * 4、方法的反问修饰符必须是public
     */
    @Test
    public void reg(){
        try {
            User user = new User();
            user.setUsername("test03");
            user.setPassword("123");
            userService.reg(user);
            System.out.println("ok");
        }catch (ServiceException e){
            //获取类的对象，在获取类的名称
            System.out.println(e.getClass().getSimpleName());
            //获取异常的具体描述信息
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void login(){
        User user = userService.login("test03", "456");
        System.out.println(user);
    }



    @Test
    public void changePassword(){
        userService.changePassword(8,"test03","123","456");
    }


    @Test
    public void getByUid(){
        User byUid = userService.getByUid(6);
        System.out.println(byUid);
    }


    @Test
    public void changeInfo(){
        User user = new User();
        user.setPhone("98754321");
        user.setEmail("78897");
        user.setGender(0);
        userService.changeInfo(6,"管理员",user);
    }

    /*
    @Test
    public void changeAvatar(){
        userService.changeAvatar(9,
                                    "/upload/test.pgn",
                                    "小明");
    }

     */

}
