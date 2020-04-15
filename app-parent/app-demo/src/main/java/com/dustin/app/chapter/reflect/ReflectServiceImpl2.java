package com.dustin.app.chapter.reflect;

import java.lang.reflect.InvocationTargetException;

/**
 * @author dustin_zhou
 * @title: ReflectServiceImpl
 * @projectName app-parent
 * @description: TODO
 * @date 2020/4/15 15:36
 */
public class ReflectServiceImpl2 {

    private String name;

    public ReflectServiceImpl2(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.err.println("Hello" + name);

    }

    public ReflectServiceImpl2 getInstance() {
        ReflectServiceImpl2 object = null;
        try {
            object = (ReflectServiceImpl2) Class.forName("com.dustin.app.chapter.reflect.ReflectServiceImpl2").getConstructor(String.class).newInstance("张三");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }
}
