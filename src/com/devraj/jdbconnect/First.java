package com.devraj.jdbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class First {

	public static void main(String[] args) {
		 First fs = new First();
		 
		 fs.connection1(01, "Devraj", "Singh");
		 fs.connection1(02, "Payal", "Dayama");
		 fs.connection1(03, "Prasad", "Gedhade");
		 fs.connection1(04, "Shriya", "Soni");
		 fs.connection1(05, "Shraddha", "Chavan");
		 fs.connection1(06, "Swapnil", "Mailare");
	}
	
	public void connection1(int sno, String fname, String lname) {
		Connection connection = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","dvrj@0005");
			
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO friends(s_n, f_name, l_name) VALUES(?, ?, ?)");
//			PreparedStatement stmt = connection.prepareStatement("DELETE FROM friends");
			stmt.setLong(1, sno);
			stmt.setString(2, fname);
			stmt.setString(3, lname);
			
			
			
			int check = stmt.executeUpdate();
			
			System.out.println("1 for success 0 for failed "+check);
			
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
