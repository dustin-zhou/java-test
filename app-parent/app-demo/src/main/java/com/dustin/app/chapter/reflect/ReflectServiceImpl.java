package com.dustin.app.chapter.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author dustin_zhou
 * @title: ReflectServiceImpl
 * @projectName app-parent
 * @description: TODO
 * @date 2020/4/15 15:36
 */
public class ReflectServiceImpl {

    public void sayHello(String name) {
        System.err.println("Hello" + name);

    }

    public ReflectServiceImpl getInstance(){
        ReflectServiceImpl object=null;
        try {
            object = (ReflectServiceImpl) Class.forName("com.dustin.app.chapter.reflect.ReflectServiceImpl").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }


    public Object reflectMethod(){
        Object returnObj=null;
        ReflectServiceImpl target = new ReflectServiceImpl();
        try {
            Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
            returnObj=method.invoke(target,"张三");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return returnObj;
    }
}
