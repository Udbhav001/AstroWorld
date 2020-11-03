package com.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CurdOperation {
	private static Connection cn;
	public static Connection createConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//factory method it creates object of driver class
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/astroworld", "root", "root");//coneection string or connecton url
		}                                //protocol  //name eor ip address of the machine where db has been install
		//3306 is port no
		catch(SQLException|ClassNotFoundException cse)
		{
			System.out.println(cse);
		}
		return cn;
	}
}
