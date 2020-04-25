package com.javaweb.AOP;

import com.javaweb.utils.RequestMappingUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
public class HandleRequestAOP {

    @Before("execution(@com.javaweb.annotation.HandleRequest * *.*(..))")
    public void handleRequest(JoinPoint joinPoint) {
        RequestMappingUtils.handleMapping((HttpServletRequest) joinPoint.getArgs()[0],
                (HttpServletResponse) joinPoint.getArgs()[1],joinPoint.getTarget());
    }
}
