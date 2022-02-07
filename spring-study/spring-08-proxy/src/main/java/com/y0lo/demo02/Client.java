package com.y0lo.demo02;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
/*        userService.add();
        userService.delete();
        userService.update();
        userService.query();*/
        UserServiceProxy userServiceProxy = new UserServiceProxy();
        userServiceProxy.setUserService(userService);
        userServiceProxy.add();
        userServiceProxy.delete();
        userServiceProxy.update();
        userServiceProxy.query();
    }
}
