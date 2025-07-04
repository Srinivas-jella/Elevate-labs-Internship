package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteEmployee {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/elevate_labs","root","1234");
	
	Statement statement=connection.createStatement();
	
	statement.execute("delete from employees where id=3");
	
	connection.close();
	
	System.out.println("Successfully deleted data from DB");
}
}
