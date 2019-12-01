package com.javaweb.converter;

import org.modelmapper.ModelMapper;

public class DTOConverter {
	@SuppressWarnings("unchecked")
	public static <T> T toModel(Object obj,Class<T> zClass) {
		ModelMapper modelMapper = new ModelMapper();
		return (T) modelMapper.map(obj,zClass); 
		
	}
}
