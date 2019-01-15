package nl.avans.Connection;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
    private static java.sql.Connection connection;// DatabaseConnection-data


    public static void connect() {                // Responsible for establishing a connection
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
    public static void disconnect()    {
        //Disconnect from the database
        if (connection != null)
            try {
                connection.close();
            } catch(Exception e){
                System.out.println("An Error Occurred: " + e.getMessage());
            }
    }

    //To retrieve the column names of a table in the database
    public static DatabaseMetaData getMetaData() throws Exception{
        DatabaseMetaData metadata = connection.getMetaData();
        return metadata;
    }
}