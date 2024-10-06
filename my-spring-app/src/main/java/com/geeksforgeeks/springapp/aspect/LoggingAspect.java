package com.geeksforgeeks.springapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.geeksforgeeks.springapp.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before method: " + joinPoint.getSignature().getName());
    }

    // Log after the execution of any method in com.geeksforgeeks.springapp.controller package
    @After("execution(* com.geeksforgeeks.springapp.controller.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("After method: " + joinPoint.getSignature().getName());
    }

}

// 1. DDL: Data Definition Language
// CREATE, ALTER, DROP
// TRUNCATE TABLE Employee

// 2. DML: Data Manipulation Language
// INSERT, UPDATE, DELETE, SELECT