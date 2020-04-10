package com.javaweb.utils;

import com.javaweb.annotation.Column;
import com.javaweb.paging.Pageable;
import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EntityUtils {
    public static String toInsertSql(Object entity, List<Object> parameters) {
        StringBuilder fields = new StringBuilder("");
        StringBuilder params = new StringBuilder("");
        Class<?> aClass = entity.getClass();
        while(aClass!=null) {
            for(Field field : aClass.getDeclaredFields()) {
                field.setAccessible(true);
                Object data = null;
                try {
                    data = field.get(entity);
                    if(data==null) {
                        continue;
                    }
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if(field.isAnnotationPresent(Column.class)) {
                    if(fields.length()>0){
                        fields.append(",");
                        params.append(",");
                    }
                    Column column = field.getAnnotation(Column.class);
                    fields.append(column.name());
                    params.append("?");
                    parameters.add(data);
                }
            }
            aClass = aClass.getSuperclass();
        }
        String sql =  " (" + fields.toString() + ")" + " VALUES(" + params.toString() + ")";
        return sql;

    }

    public static String createUpdateSql(Object obj, List<Object> parameters){
        StringBuilder params = new StringBuilder("");
        Class<?> aClass = obj.getClass();
        Long id = null;
        while(aClass!=null) {
            for(Field field : aClass.getDeclaredFields()) {
                field.setAccessible(true);
                Object data = null;
                try {
                    data = field.get(obj);
                    if(data==null || field.getName().equals("id")) {
                        if(field.getName().equals("id")) id = (Long) data;
                        continue;
                    }
                } catch (IllegalArgumentException|IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if(field.isAnnotationPresent(Column.class)) {
                    if(params.length()>0) {
                        params.append(", ");
                    }
                    parameters.add(data);
                    Column column = field.getAnnotation(Column.class);
                    params.append(column.name()+"=?");
                }
            }
            aClass = aClass.getSuperclass();
        }
        parameters.add(id);
        return params.toString();
    }


    public static String toQuerySql(Map<String,Object> map,String prefix) {
        StringBuilder where = new StringBuilder();
        if(map==null) return "";
        Set<String> set = map.keySet();
        for (String key : set) {
            Object obj = map.get(key);

            if(obj instanceof String) {
                where.append(" AND "+ prefix+"."+key +" LIKE '%"+ obj + "%'");
            }else if(obj instanceof Integer || obj instanceof Long ) {
                where.append(" AND "+ prefix+"." + key +"="+ String.valueOf(obj));
            }
        }
        return where.toString();
    }


    public static <T> Map<String,Object> toMap(Object dto) {
        Map<String,Object> map = new HashMap<>();
        try {
            Class<?> cl = dto.getClass();
            while(cl!=null) {
                Field[] fields = cl.getDeclaredFields();

                for(Field field : fields) {
                    field.setAccessible(true);
                    Object obj = field.get(dto);

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

    public static String toPaginaitonSql(Pageable pageable) {
        StringBuilder where = new StringBuilder();

        if(pageable!=null && pageable.getPage()!=null && pageable.getSize()!=null) {
            where.append("LIMIT ");
            where.append(((pageable.getPage()-1)*pageable.getSize())+","+pageable.getSize());
        }

        return where.toString();
    }

    public static <T> T toModel(Object obj,Class<T> zClass) {
        ModelMapper modelMapper = new ModelMapper();
        return (T) modelMapper.map(obj,zClass);

    }
}
