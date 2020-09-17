package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connector {
	private static final String jdbc_url = "jdbc:derby:connecting-creating-DB;create=true";
	Connection conn;
	
	public connector(){
		try{
			
			this.conn= DriverManager.getConnection(jdbc_url);
			
			if (this.conn!=null)
				System.out.println("Made connection to db");
			else
				System.out.println("didnt connect to db");
			
		}catch(SQLException e){}

	}
	
}
