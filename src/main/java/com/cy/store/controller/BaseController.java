package com.cy.store.controller;

import com.cy.store.controller.ex.*;
import com.cy.store.service.ex.*;
import com.cy.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * 表示控制层的基类
 */
public class BaseController {
    /*操作成功的状态码*/
    public static final int OK = 200;


    //请求处理方法，这个方法的返回值就是需要传递给前端的数据
    //自动将异常传递给此方法的参数列表上
    //当前项目中产生了异常，被统一拦截到此方法中，这个方法此时就充当的是请求处理方法，方法的返回值直接给前端
    @ExceptionHandler({ServiceException.class,FileUploadException.class})//用于统一处理抛出的异常
    //所有ServiceExcpetion抛出的异常，都会使用这个异常
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>();
        if(e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户名被占用");
        }else if(e instanceof UserNotFoundException){
            result.setState(5001);
            result.setMessage("用户数据不存在的异常");
        }else if(e instanceof PasswordNotMatchException){
            result.setState(5002);
            result.setMessage("用户的密码错误的异常");
        }else if(e instanceof InsertException){
            result.setState(5000);
            result.setMessage("注册时产生了未知的异常");
        }else if(e instanceof UpdateException){
            result.setState(5001);
            result.setMessage("更新数据时产生的异常");
        }else if(e instanceof FileEmptyException){
            result.setState(6000);
        }else if(e instanceof FileSizeException){
            result.setState(6001);
        }else if(e instanceof FileTypeException){
            result.setState(6002);
        }else if(e instanceof FileStateException){
            result.setState(6003);
        }else if(e instanceof FileUploadIOException){
            result.setState(6004);
        }else if(e instanceof AddressCountLimitException){
            result.setState(4003);
        }else if(e instanceof AddressNotFoundException){
            result.setState(4004);
        }else if(e instanceof AccessDeniedException){
            result.setState(4005);
        }else if(e instanceof DeleteException){
            result.setState(5002);
        }else if(e instanceof ProductNotFoundException){
            result.setState(4006);
        }else if(e instanceof CartNotFoundException){
            result.setState(4007);
        }
        return result;
    }

    /**
     * 获取session对象中的uid
     * @param session session对象
     * @return 当前登陆的用户uid的值
     */
    protected final Integer getuidFromSession(HttpSession session){
        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
        return uid;
    }


    /**
     * 获取当前登陆用户的username
     * @param session session对象
     * @return 当前登陆用户的用户名
     *
     * 在实现类中重写父类中的toString()，不是句柄信息的输出
     */
    protected final String getUsernameFromSession(HttpSession session){
        String username = session.getAttribute("username").toString();
        return username;
    }

}
