package com.javaweb.converter;

import org.modelmapper.ModelMapper;

public class DTOConverter {
	@SuppressWarnings("unchecked")
	public static <T> T convertToDTO(Object entity,Class<T> zClass) {
		ModelMapper modelMapper = new ModelMapper();
		return (T) modelMapper.map(entity,zClass); 
		
	}
}
