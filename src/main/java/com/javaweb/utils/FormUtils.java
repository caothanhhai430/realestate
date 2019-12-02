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
//			BeanUtils.populate(t, map);
			 for(final Map.Entry<String, String[]> entry : map.entrySet()) {
		            // Identify the property name and value(s) to be assigned
		            final String name = entry.getKey();
		            final String[] obj = entry.getValue();
		            if (name == null || obj == null || (obj.length==1 && obj[0].equals(""))) {
		            	continue;
		            }
	            	BeanUtils.setProperty(t, name, obj);
		    }
			
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (T) t;
	}
	
}
