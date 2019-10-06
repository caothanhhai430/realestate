package com.javaweb.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtils {

	@SuppressWarnings("unchecked")
	public static <T> T toModel(Class<T> tclass, HttpServletRequest req) {
		Object t = null;
		try {
			t = tclass.newInstance();
			Map<String, String[]> map = req.getParameterMap();;
			BeanUtils.populate(t, req.getParameterMap());
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (T) t;
	}
	
}
