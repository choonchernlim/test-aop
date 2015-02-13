package com.choonchernlim.testAOP.example4;

import com.choonchernlim.testAOP.example4.service.Example4SomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Example4SomeService someService = context.getBean(Example4SomeService.class);

        System.out.println("Final Output: " + someService.query());
    }

}
