package employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddEmployee {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/elevate_labs","root","1234");
		Statement statement = connection.createStatement();
		statement.execute("insert into employees values(1,'tharun','IT',20000),(2,'harsha','Support',10000),(3,'sharat','IT',15000)");
		connection.close();
		System.out.println("Successfully inserted data into DB");
	}
	
}
