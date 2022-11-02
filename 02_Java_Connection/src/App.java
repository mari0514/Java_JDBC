// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException {
        
        try {
            getConnection();
        } catch (SQLException e) {
            System.out.println("Unable to connect to the database!");
        }
        
    }
    
    public static void getConnection() throws SQLException {
        // credentials
        String url = "jdbc:mysql://127.0.0.1:3306/employee_database";
        String user = "root";
        String password = "Mm19980514";

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = null;
        int rowAffected = 0;
        
        System.out.println("Connection Successful");
        resultSet = statement.executeQuery("SELECT * FROM employee_table");
        System.out.println("able to make select all");
        
        while(resultSet.next()) {
            System.out.println(
                resultSet.getInt("id") + 
                "~ Name: " +
                resultSet.getString("name") + " | Department: " +
                resultSet.getString("department") + " | Salary: " +
                resultSet.getInt("salary")
            );
        }

        rowAffected = statement.executeUpdate("UPDATE employee_table SET salary = 100000 WHERE id = 2");
        System.out.println(rowAffected + " row(s) affected!");

        resultSet = statement.executeQuery("SELECT * FROM employee_table");

        while(resultSet.next()) {
            System.out.println(
                resultSet.getInt("id") + 
                "~ Name: " +
                resultSet.getString( "name") + " | Department: " +
                resultSet.getString( "department" + " | Salary: ") +
                resultSet.getString( "salary")
            );
        }

    }
}
