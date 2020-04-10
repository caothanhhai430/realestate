package com.javaweb.AOP;

import com.javaweb.JPA.EntityManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TransactionalAOP {

    @Before("execution(@com.javaweb.annotation.Transactional * *.*(..))")
    public void hello(JoinPoint joinPoint){
        System.out.println(joinPoint.toString());
        EntityManager.getEntityManager().beginTransaction();
    }
    @After("execution(@com.javaweb.annotation.Transactional * *.*(..))")
    public void hello2(JoinPoint joinPoint){
        System.out.println(joinPoint.toString());
        EntityManager.getEntityManager().handleTransaction();
    }
}
