package DAO;

import javax.swing.*;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Izabela on 2017-01-06.
 */
public class Connector {

    private Connection connection;
    private CallableStatement callableStatement;
    private PreparedStatement preparedStatement;

    public Connector() throws Exception{
        Properties properties = new Properties();
        properties.load(new FileInputStream("hoteldatabase.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String dburl = properties.getProperty("dburl");

        connection = DriverManager.getConnection(dburl,user,password);

        System.out.println("DB connection successful to: " + dburl);
    }

    public void addUser(String login, String password, String name, String surname, String PESEL, String IDNumber, String type) throws SQLException {
        callableStatement = connection.prepareCall("{call dodaj_uzytkownika(?,?,?,?,?,?,?)}");

        callableStatement.setString(1, login);
        callableStatement.setString(2, password);
        callableStatement.setString(3, name);
        callableStatement.setString(4, surname);
        callableStatement.setString(5, PESEL);
        callableStatement.setString(6, IDNumber);
        callableStatement.setString(7, type);

        callableStatement.execute();
    }

    public String logIn(String login, String password) throws SQLException{
        preparedStatement = connection.prepareStatement("SELECT `typ` FROM `users` WHERE `login`=? AND `haslo`=?");

        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();

        if(!resultSet.next()){
            return null;
        }
        else {
            return resultSet.getString(1);
        }
    }
}