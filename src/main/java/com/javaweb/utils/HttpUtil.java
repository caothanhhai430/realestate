package com.javaweb.utils;

import java.io.BufferedReader;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

public class HttpUtil {
	private String value;
	
	public HttpUtil(String value) {
		this.value = value;
	}
	
	public static HttpUtil of(BufferedReader reader) {
		StringBuilder data = new StringBuilder();
		String line;
		try {
			while((line = reader.readLine())!=null) {
				data.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HttpUtil(data.toString());
	}
	
	public  <T>T toModel(Class<T> tclass){
		Object t = null;
		try {
			 ObjectMapper obj = new ObjectMapper();
			 t = (T) obj.readValue(value,tclass);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (T) t;
	}
	
}
