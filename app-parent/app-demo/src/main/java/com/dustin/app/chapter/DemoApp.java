package com.dustin.app.chapter;

import com.dustin.app.chapter.proxy.CglibProxyDemo;
import com.dustin.app.chapter.proxy.JdkProxyDemo;

/**
 * @author dustin_zhou
 * @title: DemoApp
 * @projectName app-parent
 * @description: TODO
 * @date 2020/4/15 16:16
 */
public class DemoApp {
    public static void main(String[] args) {
        JdkProxyDemo.testJdkProxy();
        CglibProxyDemo.testCglibProxy();
    }
}
