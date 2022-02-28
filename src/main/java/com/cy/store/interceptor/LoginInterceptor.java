package com.cy.store.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义一个拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 检测全局session对象中是否有uid数据，如果有则放行；如果没有重定向到登陆页面
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 处理器(url+Controller:映射)
     * @return 如果返回值为true表示放行当前得请求，如果返回值为false，则表示拦截当前得请求
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //HttpServletRequest对象来获取session对象
        Object obj = request.getSession().getAttribute("uid");
        System.out.println(obj);
        if(obj == null){
            //如果没有登陆过系统，重定向到login.html页面
            response.sendRedirect("/web/login.html");
            //结束后续得调用
            return false;
        }
        //请求放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
