package com.quhaodian.umall.data.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ObjectFactory {

    private static ApplicationContext context;

    public static ApplicationContext get(){
        if (context==null){
            context=new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        }
        return context;
    }
}
