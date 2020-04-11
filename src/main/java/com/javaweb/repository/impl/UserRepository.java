package com.javaweb.repository.impl;

import com.javaweb.JPA.EntityManager;
import com.javaweb.entity.UserEntity;

import javax.annotation.ManagedBean;
import javax.management.Query;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ManagedBean
public class UserRepository extends SimpleRepository<UserEntity>{
    EntityManager entityManager = EntityManager.getEntityManager();

    public List<Map<String,Object>> findAssignByBuildingId(Long id){
        String query = "select u.id,u.fullname,IF(buildingid is not null,'checked','')" +
                " as checked from user u left join (select * from assignmentstaff where buildingid=?) assign " +
                " on u.id=assign.staffid  " +
                "inner join (select * from user_role ur inner join role r on ur.role_id=r.id" +
                "  where type=0) role on u.id=role.user_id "+
                " where u.status = 1 order by u.id";
        List<Map<String,Object>> results = entityManager.createQuery(query, Arrays.asList(id))
                                            .getResultMap(UserEntity.class);
        return results;
    }

   public List<Map<String,Object>> findAssignByCustomerId(Long id){
        String query = "select u.id,u.fullname,IF(customerid is not null,'checked','')" +
                " as checked from user u left join (select * from staff_customer where customerid=?) assign" +
                " on u.id=assign.staffid " +
                " inner join (select * from user_role ur inner join role r " +
                "on ur.role_id=r.id  where type=0) role on u.id=role.user_id" +
                " where u.status = 1 order by id";
        List<Map<String,Object>> results = entityManager.createQuery(query, Arrays.asList(id))
                .getResultMap(UserEntity.class);
        return results;
    }

    public List<Map<String,Object>> findAllActiveStaff() {
        List<Map<String,Object>> results = entityManager.createQuery("select u.id,u.fullname from user u	inner join " +
                "(select * from user_role ur inner join role r on ur.role_id=r.id  " +
                "where type=0) role on u.id=role.user_id where u.status=1 order by id").getResultMap(UserEntity.class);
        return results;
    }

    private void assignBuilidngForStaff(Long staffId,  Long buildingId) {
        String query = "INSERT INTO assignmentstaff(staffid,buildingid) values (?,?)";
        entityManager.createExecuteQuery(query,Arrays.asList(staffId,buildingId));
    }

    public void assignBuildingForStaff(List<Long> staffId, Long buildingId){
        staffId.forEach(e->assignBuilidngForStaff(e,buildingId));
    }

    private void assignCustomerForStaff(Long staffId,  Long customerId) {
        String query = "INSERT INTO staff_customer(staffid,customerid) values (?,?)";
        entityManager.createExecuteQuery(query,Arrays.asList(staffId,customerId));
    }

    public void assignCustomerForStaff(List<Long> staffId, Long customerId){
        staffId.forEach(e->assignCustomerForStaff(e,customerId));
    }

    public void deleteAssignmentStaffByCustomerId(List<Long> ids){
        String arrId = 	ids.stream().map(i -> "?").collect(Collectors.joining(","));
        String sql = "DELETE FROM staff_customer  WHERE customerid IN (" + arrId + ")";
        entityManager.createExecuteQuery(sql,new ArrayList<>(ids));
    }

    public void deleteCustomerStaffByCustomerId(Long id){
        this.deleteAssignmentStaffByCustomerId(Arrays.asList(id));
    }


    public void deleteAssignmentStaffByBuildingId(List<Long> ids){
        String arrId = 	ids.stream().map(i -> "?").collect(Collectors.joining(","));
        String sql = "DELETE FROM assignmentstaff  WHERE buildingid IN (" + arrId + ")";
        entityManager.createExecuteQuery(sql,new ArrayList<>(ids));
    }

    public void deleteAssignmentStaffByBuildingId(Long id){
        this.deleteAssignmentStaffByBuildingId(Arrays.asList(id));
    }

}
