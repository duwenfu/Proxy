package com.example.demo.jdkProxy;

/**
 * @author duwen.fu
 * @version 1.0
 * @date 2020/8/6 22:48
 */
public class UserServiceImpl implements UserService{

    @Override
    public void addUser() {
        System.out.println("增加一个用户。。。");
    }

    @Override
    public void editUser() {
        System.out.println("编辑一个用户。。。");
    }
}
