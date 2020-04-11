package com.javaweb.repository.impl;

import com.javaweb.builder.CustomerSearchBuilder;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.paging.Pageable;
import com.javaweb.utils.EntityUtils;

import javax.annotation.ManagedBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ManagedBean
public class CustomerRepository extends SimpleRepository<CustomerEntity>{

    public List<CustomerEntity> findAll(CustomerSearchBuilder builder,Pageable pageable){
        StringBuilder sql = new StringBuilder();
        List<Object> parameters = new ArrayList<>();
        String prefix = "customer";
        sql.append("SELECT customer.* FROM ").append(getTableName()).append(" "+prefix);
        if(builder.getStaffId()!=null){
            sql.append(" INNER JOIN staff_customer assign ON " + prefix + ".id = assign.customerid");
        }
        sql.append(" " + buildQuery(builder,prefix,parameters));
        sql.append(" " + EntityUtils.toPaginaitonSql(pageable,parameters));
        List<CustomerEntity> list = findAll(sql.toString(),parameters);
        return list;
    }

    public long count(CustomerSearchBuilder builder){
        StringBuilder sql = new StringBuilder();
        List<Object> parameters = new ArrayList<>();
        String prefix = "customer";
        sql.append("SELECT count(*) FROM ").append(getTableName()).append(" "+prefix);
        if(builder.getStaffId()!=null){
            sql.append(" INNER JOIN staff_customer assign ON " + prefix + ".id = assign.customerid");
        }
        sql.append(" " + buildQuery(builder,prefix,parameters));

        return super.count(sql.toString(),parameters);
    }



    private String buildQuery(CustomerSearchBuilder builder, String prefix,List<Object> parameters){
        CustomerSearchBuilder singleFieldBuilder = new CustomerSearchBuilder.Builder()
                .setName(builder.getName())
                .setPhone(builder.getPhone())
                .setEmail(builder.getEmail())
                .build();
        Map<String,Object> map = EntityUtils.toMap(singleFieldBuilder);
        String where = EntityUtils.toQuerySql(map,prefix,parameters);

        String qlString = "";
        qlString +=  " WHERE 1=1 ";

        if(!where.isEmpty()){
            qlString = qlString+   where;
        }
        if(builder.getStaffId()!=null){
            qlString = qlString + " AND staffid = ?";
            parameters.add(builder.getStaffId());
        }
        return qlString;
    }


}
