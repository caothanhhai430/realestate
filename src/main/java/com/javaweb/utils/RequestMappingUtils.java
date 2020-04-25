package com.javaweb.utils;

import com.javaweb.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class RequestMappingUtils {

    public static void handleMapping(HttpServletRequest req, HttpServletResponse resp,Object caller){
        String path = req.getPathInfo() == null ? "/" : req.getPathInfo();
        try {
            for (final Method method : caller.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(RequestMapping.class)) {
                    RequestMapping annotInstance = method.getAnnotation(RequestMapping.class);
                    if ((path.equals(annotInstance.value())||
                            (path.length()<2 && annotInstance.value().length()<2))
                            && annotInstance.method().getMethod().equals(req.getMethod())) {
                        method.setAccessible(true);
                        method.invoke(caller, req, resp);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
