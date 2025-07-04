package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchEmployees {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/elevate_labs","root","1234");
		
		Statement statement=connection.createStatement();		
		
		ResultSet resultSet=statement.executeQuery("select * from employees");
		while(resultSet.next()) {
			System.out.print("Id:");
			System.out.println(resultSet.getInt(1));
			System.out.print("Name:");
			System.out.println(resultSet.getString(2));
			System.out.print("Department:");
			System.out.println(resultSet.getString(3));
			System.out.print("Salary:");
			System.out.println(resultSet.getDouble(4));
			
			System.out.println("----------------");
			
		}
		connection.close();
		
		System.out.println("Successfully fetched data from DB");

	}

}
