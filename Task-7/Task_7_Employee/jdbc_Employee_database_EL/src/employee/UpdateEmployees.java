package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateEmployees {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/elevate_labs", "root", "1234");

		Statement statement=connection.createStatement();
	
		statement.execute("update employees set name='Harsha' where id=2");
		
		connection.close();
		
		System.out.println("Successfully updated the data from DB");
	}

}
