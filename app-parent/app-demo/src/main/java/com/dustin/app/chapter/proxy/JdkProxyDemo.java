package com.dustin.app.chapter.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author dustin_zhou
 * @title: JdkProxyDemo
 * @projectName app-parent
 * @description: TODO
 * @date 2020/4/15 16:01
 */
public class JdkProxyDemo implements InvocationHandler {
    //真实对象
    private Object target=null;
    /**
     * 建立代理对象和真实对象的代理关系，并返回代理对象
     * @param target:真实对象
     * @return 代理对象
     */
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("进入代理逻辑方法");
        System.err.println("在调用真实对象之前的服务");
        Object obj = method.invoke(target, args);
        System.err.println("在调用真实对象之后的服务");
        return obj;
    }

    public static void testJdkProxy(){
        JdkProxyDemo jdkProxyDemo=new JdkProxyDemo();
        IHelloWorld proxy = (IHelloWorld) jdkProxyDemo.bind(new HelloWorldImpl());
        proxy.sayHelloWorld();
    }
}
