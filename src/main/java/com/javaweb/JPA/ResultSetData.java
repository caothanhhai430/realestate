package com.javaweb.JPA;

import com.javaweb.mapper.impl.ResultSetMapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultSetData {
    private ResultSet resultSet;

    private ResultSetData(){

    }

    public static ResultSetData of(ResultSet resultSet){
        ResultSetData resultSetData = new ResultSetData();
        resultSetData.resultSet = resultSet;
        return resultSetData;
    }

    public List<Object> getResultList(Class zclass){
        List<Object> results = new ResultSetMapper().rowMapper(resultSet, zclass);
        return results;
    }

    public List<Map<String,Object>> getResultMap(Class zclass){
        List<Map<String,Object>> results = new ResultSetMapper().getMap(resultSet, zclass);
        return results;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

}
