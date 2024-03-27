package jdbc_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class personCRUD {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "root");
        return connection;
    }

    public int signUpPerson(Person person) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String query = "INSERT INTO PERSON VALUES (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, person.getId());
        preparedStatement.setString(2, person.getName());
        preparedStatement.setLong(3, person.getPhone());
        preparedStatement.setString(4, person.getEmail());
        preparedStatement.setString(5, person.getPassword());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public void loginPerson(String email, String password) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String query = "SELECT email, password FROM person WHERE email=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String em = resultSet.getString("email");
            String pass = resultSet.getString("password");
            if (pass.equals(password)) {
                System.out.println("Login success");
            } else {
                System.out.println("Invalid password");
            }
        } else {
            System.out.println("The email does not exist");
        }
    }
}

