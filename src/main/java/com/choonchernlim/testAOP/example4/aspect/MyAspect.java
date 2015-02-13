package com.choonchernlim.testAOP.example4.aspect;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.ArrayList;
import java.util.Collection;

/**
 * An aspect to generate sequence diagram based on an user action.
 */
@Aspect
public class MyAspect {

    private final Collection<String> list = new ArrayList<String>();
    private int level = 0;

    @Around("execution(* com.choonchernlim.testAOP.example4..*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        final String currentSignature = joinPoint.getSignature().toString();

        list.add(StringUtils.repeat("\t", level++) + " -> " + currentSignature);

        final Object result = joinPoint.proceed();

        list.add(StringUtils.repeat("\t", --level) + " <- " + result);

        if (level == 0) {
            System.out.println("#######################");
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("#######################");
        }

        return result;
    }

}