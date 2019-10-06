package com.javaweb.Helper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class ObjectToMap {
		
	public static <T> Map<String,Object> toMap(Object dto) {
		Map<String,Object> map = new HashMap<>();
		try {
			Class<?> cl = dto.getClass();
			while(cl!=null) {
				Field[] fields = cl.getDeclaredFields();
				
				for(Field field : fields) {
					field.setAccessible(true);
//					String data = BeanUtils.getProperty(dto, field.getName());		
					Object obj = field.get(dto);
					
//					String fieldType = field.getType().getName();
//					if(data!=null) {
//						if (fieldType.equals(Integer.class.getName())){
//							obj = Integer.valueOf(data);
//						}else if (fieldType.equals(String.class.getName())){
//							obj = String.valueOf(data);
//						}else if (fieldType.equals(Timestamp.class.getName())){
//							obj = Timestamp.valueOf(data);
//						}
//					}
//					
					if(obj!=null) {
						map.put(field.getName(), obj);
					}
				}
				cl = cl.getSuperclass();
			}
			} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
							
		return map;
	}
	
}
