package com.example.demo.jdkProxy;

import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * @author duwen.fu
 * @version 1.0
 * @date 2020/8/6 22:48
 */
public class ServiceInvocationHandler implements InvocationHandler {
    /**
     * 目标对象
     */
    private Object target;

    /**
     * 构造函数
     *
     * @param target
     */
    public ServiceInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    /**
     * 实现InvocationHandler接口的方法
     *
     * 执行目标对象的方法，并进行增强
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;
        System.out.println("代理类方法，进行增强。。。");
        System.out.println("事务开始。。。");
        // 执行目标方法对象
        result = method.invoke(target, args);
        System.out.println("事务结束。。。");
        return result;
    }

    /**
     * 创建代理实例
     *
     * @return
     * @throws Throwable
     */
    public Object getProxy() throws Throwable {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                this.target.getClass().getInterfaces(), this);
        // 这样写只返回了目标对象，没有生成代理对象
        // return null;
    }
}
