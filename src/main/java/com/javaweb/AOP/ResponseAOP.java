package com.javaweb.AOP;

import com.javaweb.annotation.RestController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Aspect
public class ResponseAOP {

    @AfterReturning(pointcut = "execution(@com.javaweb.annotation.RequestMapping * *.*(..))",returning = "retVal")
    public void requestMapping(Object retVal, JoinPoint joinPoint) throws IOException {
        if(joinPoint.getTarget().getClass().isAnnotationPresent(RestController.class)){
            HttpServletResponse resp = (HttpServletResponse) joinPoint.getArgs()[1];
            resp.setContentType("application/json;");
            new ObjectMapper().writeValue(resp.getOutputStream(),retVal);
        }
    }
}
