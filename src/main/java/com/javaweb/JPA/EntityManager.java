package com.javaweb.JPA;

import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EntityManager {
    private static EntityManager entityManager;
    private Connection connection;

    private boolean willRollback;
    private boolean isOpenedTransacton;

    public void setOpenedTransacton(boolean openedTransacton) {
        isOpenedTransacton = openedTransacton;
    }

    public boolean isOpenedTransacton() {
        return isOpenedTransacton;
    }

    public void setWillRollback(boolean willRollback) {
        this.willRollback = willRollback;
    }

    public boolean isWillRollback() {
        return willRollback;
    }

    public void handleTransaction(){
        if(isOpenedTransacton &&  !willRollback){
            commit();
        }else rollback();
    }

    public static EntityManager getEntityManager(){
        if(entityManager == null || entityManager.connection==null) entityManager = EntityManagerFactory.createEntityManager();
        return entityManager;
    }

    public EntityManager(Connection connection){
        this.connection = connection;
    }

    public Connection getConnection(){
        if(connection==null) connection = EntityManager.getEntityManager().getConnection();
        return connection;
    }


    public void beginTransaction(){
        try {
            connection.setAutoCommit(false);
            isOpenedTransacton = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void commit(){
        try {
            connection.commit();
            connection.setAutoCommit(true);
            System.out.println("COMMIT SUCCESSFUL   ");
        } catch (SQLException e) {
            System.out.println("COMMIT FAILED");
            rollback();
            e.printStackTrace();
        }
    }

    public void rollback(){
        try {
            connection.rollback();
            isOpenedTransacton = false;
            willRollback = false;
            System.out.println("ROLLBACK SUCCESSFUL");
        } catch (SQLException e) {
            System.out.println("ROLLBACK FAILED");
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ResultSet createQuery(String query,List<Object> parameters,String type){
        Connection connection = entityManager.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection != null) {
            try {
                if(type=="EXECUTE_QUERY"){
                    statement = connection.prepareStatement(query);
                 }else if(type=="EXECUTE_UPDATE"){
                    statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                 }
                int index = 1;
                for (Object obj: parameters ) {
                    statement.setObject(index,obj);
                    index++;
                }
                if(type=="EXECUTE_QUERY"){
                    resultSet = statement.executeQuery();
                }else if(type=="EXECUTE_UPDATE"){
                    statement.executeUpdate();
                    resultSet = statement.getGeneratedKeys();
                }
                return resultSet;
            } catch (SQLException e) {
                willRollback = true;
                e.printStackTrace();
            }
        }
        return resultSet;
    }


    public ResultSet createExecuteQuery(String query, List<Object> parameters){
        return createQuery(query,parameters,"EXECUTE_UPDATE");
    }
    public ResultSet createQuery(String query, List<Object> parameters){
        return createQuery(query,parameters,"EXECUTE_QUERY");
    }
}

