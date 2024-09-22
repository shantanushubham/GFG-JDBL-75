package com.geeksforgeeks.springapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before ( "execution(*com.geeksforgeeks.springapp.controller.*(..))" )
    public void logBefore(JoinPoint joinPoint) {
        System.out.println ("Method called: " + joinPoint.getSignature ().getName ());
    }

    @After ( "execution(*com.geeksforgeeks.springapp.controller.*(..))" )
    public void logAfter(JoinPoint joinPoint) {
        System.out.println ("Method execution finished: " + joinPoint.getSignature ().getName ());
    }
}
