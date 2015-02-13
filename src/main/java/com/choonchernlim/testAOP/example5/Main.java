package com.choonchernlim.testAOP.example5;

import com.choonchernlim.testAOP.example5.service.Example5SomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Example5SomeService someService = context.getBean(Example5SomeService.class);

        System.out.println("Final Output: " + someService.query());
    }

}
