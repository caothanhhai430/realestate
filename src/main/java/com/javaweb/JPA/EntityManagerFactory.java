package com.javaweb.JPA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EntityManagerFactory {
	private static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/estate_caothanhhai_82019?characterEncoding=utf8";
			String user = "root";
			String password = "Messi3069";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static EntityManager createEntityManager(){
		return new EntityManager(getConnection());
	}

}
