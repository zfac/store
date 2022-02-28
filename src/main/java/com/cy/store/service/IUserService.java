package com.cy.store.service;

import com.cy.store.entity.User;

/**
 * 用户模块业务层的接口
 */
public interface IUserService {
    /**
     * 用户的注册
     * @param user
     */
    public void reg(User user);

    /**
     * 用户登陆功能
     * @param username 用户名
     * @param password 用户密码
     * @return 当前匹配的用户数据，如果没有则返回null
     */
    User login(String username,String password);

    /**
     *
     * @param uid 用户的id
     * @param username 用户名
     * @param oldPassword 用户老密码
     * @param newPassword 用户新密码
     */
    public void changePassword(Integer uid,
                               String username,
                               String oldPassword,
                               String newPassword);

    /**
     * 根据用户的id查询用户的数据
     * @param id 用户的id
     * @return 用户的数据
     */
    User getByUid(Integer id);


    /**
     * 更新用户的数据操作
     * @param uid 用户的id
     * @param username 用户的名称
     * @param user 用户对象的数据
     */
    public void changeInfo(Integer uid,String username,User user);


    /**
     * 修改用户的头像
     * @param uid 用户的id
     * @param avatar 用户头像
     * @param username 用户的名称
     */

    public void changeAvatar(Integer uid,
                             String avatar,
                             String username);




}
