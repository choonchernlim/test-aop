package com.choonchernlim.testAOP.example5.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

/**
 * An aspect to generate sequence diagram based on an user action. The output can be pasted at
 * https://www.websequencediagrams.com to generate the image.
 */
@Aspect
public class MyAspect {

    private final Collection<String> list = new ArrayList<String>();

    private final Stack<String> stack = new Stack<String>();

    @Around("execution(* com.choonchernlim.testAOP.example5..*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        final String previousClass = !stack.isEmpty() ? stack.peek() : "root";

        final String currentClass = joinPoint.getSignature().getDeclaringType().getSimpleName();
        final String currentMethod = joinPoint.getSignature().getName();

        stack.push(currentClass);

        list.add(String.format("%s -> +%s : %s", previousClass, currentClass, currentMethod));

        final Object result = joinPoint.proceed();

        list.add(String.format("%s --> -%s : %s", currentClass, previousClass, result));

        stack.pop();

        if (stack.isEmpty()) {
            System.out.println("#######################");
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("#######################");
        }

        return result;
    }

}