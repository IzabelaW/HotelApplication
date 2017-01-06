package DAO;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by Izabela on 2017-01-06.
 */
public class Connector {

    private Connection connection;

    public Connector() throws Exception{
        Properties properties = new Properties();
        properties.load(new FileInputStream("hoteldatabase.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String dburl = properties.getProperty("dburl");

        connection = DriverManager.getConnection(dburl,user,password);

        System.out.println("DB connection successful to: " + dburl);
    }
}
