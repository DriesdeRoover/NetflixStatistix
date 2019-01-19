package nl.avans.Connection;

import java.sql.*;

public class DatabaseConnection {
    private static java.sql.Connection connection;// DatabaseConnection-data

    //Responsible for connecting with the database
    public static void connect() {
        String connectionUrl = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=NetflixStatistix;integratedSecurity=true;";
        connection = null;

        try {
            // 'Import' the driver.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Get a connection with the database.
            connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Get data from the database using a given query
    public static ResultSet getData(String givenQuery) {
        ResultSet resultSet;
        Statement statement;

        try {
            //Create a SQL statement from a given query
            statement = connection.createStatement();
            resultSet = statement.executeQuery(givenQuery);
            return resultSet;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //disconnect from the database
    public static void disconnect()    {
        //Disconnect from the database
        if (connection != null)
            try {
                connection.close();
            } catch(Exception e){
                System.out.println(e.getStackTrace());
            }
    }

    //To retrieve the column names of a table in the database
    public static DatabaseMetaData getMetaData() throws Exception{
        DatabaseMetaData metadata = connection.getMetaData();
        return metadata;
    }
}