package nl.avans.Connection;

import javax.swing.*;
import java.sql.*;

public class DatabaseConnection {
    private static java.sql.Connection connection;           // DatabaseConnection-data

    public static void connect()   {                // Responsible for establishing a connection
        String connectionUrl = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=NetflixStatistix;integratedSecurity=true;";
        connection = null;

        try {
            // 'Import' the driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            connection = DriverManager.getConnection(connectionUrl);
        }

        catch (Exception e)   {
            e.printStackTrace();
        }
    }

    public static ResultSet getData(String givenQuery)   {
        ResultSet resultSet;
        Statement statement;

        try {
            //Create a SQL statement from a given query
            statement = connection.createStatement();
            resultSet = statement.executeQuery(givenQuery);
            return resultSet;
        }

        catch (Exception e)   {
            e.printStackTrace();
            return null;
        }
    }
}