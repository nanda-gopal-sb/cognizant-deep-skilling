package com.library.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.library.service.BookService.*(..))")
    public void beforeServiceMethod() {
        System.out.println("Entering BookService method");
    }

    @After("execution(* com.library.service.BookService.*(..))")
    public void afterServiceMethod() {
        System.out.println("Leaving BookService method");
    }
}