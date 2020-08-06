package com.example.demo.jdkProxy;

/**
 * @author duwen.fu
 * @version 1.0
 * @date 2020/8/6 22:49
 */
public class Test {
    /**
     * jdk动态代理会生成一个动态代理类，生成相应的字节码，然后通过ClassLoader加载字节码；
     *
     * 该实例继承了Proxy类，并实现了业务接口，在实现的方法里通过反射调用了InvocationHandler接口实现类的invoke()回调方法；
     *
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable {
        UserService userService = new UserServiceImpl();
        ServiceInvocationHandler handler = new ServiceInvocationHandler(userService);

        // 根据目标生成代理对象
        UserService proxy = (UserService) handler.getProxy();
        proxy.addUser();
    }
}
