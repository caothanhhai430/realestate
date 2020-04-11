package com.javaweb.repository.impl;

import com.javaweb.entity.TransactionEntity;
import com.javaweb.paging.Pageable;
import com.javaweb.utils.EntityUtils;
import org.modelmapper.internal.Pair;

import javax.annotation.ManagedBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean
public class TransactionRepository extends SimpleRepository<TransactionEntity>{

    public List<TransactionEntity> findAll(Long customerId,Integer type,Pageable pageable){
        List<Object> parameters = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM ").append(getTableName()).append(" where customerid = ?")
                .append(" AND type = ? order by createddate desc");
        parameters.add(customerId);
        parameters.add(type);
        sql.append(" " + EntityUtils.toPaginaitonSql(pageable,parameters));
        List<TransactionEntity> list = findAll(sql.toString(),parameters);
        return list;
    }


    public long count(Long customerId,Integer type){
        List<Object> parameters = new ArrayList<>();
        StringBuilder sql = new StringBuilder();

        String prefix = "customer";
        sql.append("SELECT count(*) FROM ").append(getTableName()).append(" where customerid = ?")
                .append(" AND type = ? order by createddate");
        parameters.add(customerId);
        parameters.add(type);
        return super.count(sql.toString(),parameters);
    }


    public void deleteByCustomerId(List<Long> ids){
        String arrId = 	ids.stream().map(i -> "?").collect(Collectors.joining(","));
        String sql = "DELETE FROM transaction  WHERE customerid IN (" + arrId + ")";
        entityManager.createExecuteQuery(sql,new ArrayList<>(ids));
    }

    public void deleteByCustomerId(Long id){
        this.deleteByCustomerId(Arrays.asList(id));
    }

}
