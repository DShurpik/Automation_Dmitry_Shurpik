package Lecture21;

import lombok.SneakyThrows;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test1 {

    Connection connection;
    Statement statement;

    @SneakyThrows //для замены throws and try/catch
    @BeforeTest
    public void preconditions(){
        Connection connection = DriverManager.getConnection("");
        Statement statement = connection.createStatement();
    }

    @SneakyThrows
    @Test
    public void select_test(){
        ResultSet resultSet = statement.executeQuery("SELECT * FROM USER");

    }

}
