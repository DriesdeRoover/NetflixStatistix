package nl.avans.Connection;

import javax.swing.*;
import java.sql.*;

public class DatabaseConnection {
    private static java.sql.Connection connection;           // DatabaseConnection-data

    public static void connect()   {                // Responsible for establishing a connection
        String connectionUrl = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=Netflix;integratedSecurity=true;";
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
            statement = connection.createStatement();
            resultSet = statement.executeQuery(givenQuery);
            return resultSet;
        }

        catch (Exception e)   {
            e.printStackTrace();
            return null;
        }
    }

    public static ResultSet getDataWithPreparedStatement(String givenQuery)   {
        ResultSet resultSet;
        PreparedStatement statement;
        JComboBox contentBox = new JComboBox();

        try {
            statement = connection.prepareStatement(givenQuery);
            statement.setString(1, (String) contentBox.getSelectedItem());
            resultSet = statement.executeQuery();
            return resultSet;
        }

        catch (Exception e)   {
            e.printStackTrace();
            return null;
        }
    }

       public static void disconnect()    {         // cuts off the connection
        if (connection != null) try { connection.close(); } catch(Exception e)          {/*VUL ACTIE IN*/}
    }
}