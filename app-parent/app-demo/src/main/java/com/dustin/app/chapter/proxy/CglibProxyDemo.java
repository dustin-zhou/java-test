package com.dustin.app.chapter.proxy;

import com.dustin.app.chapter.reflect.ReflectServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author dustin_zhou
 * @title: CglibProxyDemo
 * @projectName app-parent
 * @description: TODO
 * @date 2020/4/15 16:20
 */
public class CglibProxyDemo implements MethodInterceptor {

    /**
     * 生成代理对象
     *
     * @param target:Class类(真实对象)
     * @return 返回Class类的代理对象
     */
    public Object getProxy(Class target) {
        //enhancer增强类对象
        Enhancer enhancer = new Enhancer();
        //设置对象类型
        enhancer.setSuperclass(target);
        //定义代理对象为当前对象，要求当前对象实现MethodInterceptor方法
        enhancer.setCallback(this);
        //生成并返回代理对象
        return enhancer.create();
    }

    /**
     * 代理逻辑方法
     * @param proxy：代理对象
     * @param method 方法
     * @param args 方法参数
     * @param methodProxy：方法代理
     * @return 代理逻辑返回
     * @throws Throwable 异常
     */
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.err.println("调用真实对象前");
        Object result = methodProxy.invokeSuper(proxy, args);
        System.err.println("调用真实对象后");
        return result;
    }

    public static void testCglibProxy(){
        CglibProxyDemo cpd=new CglibProxyDemo();
        ReflectServiceImpl proxy = (ReflectServiceImpl) cpd.getProxy(ReflectServiceImpl.class);
        proxy.sayHello("张三");
    }
}
