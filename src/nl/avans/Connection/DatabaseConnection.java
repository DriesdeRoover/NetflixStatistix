package nl.avans.Connection;

import nl.avans.Repository.SeriePanel;

import java.sql.*;

public class DatabaseConnection {
    private static java.sql.Connection connection;// DatabaseConnection-data
    private static SeriePanel sp;


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

    public static ResultSet getDataWithPreparedStatement(String givenQuery) {
        ResultSet resultSet;
        PreparedStatement statement;

        try {
            //Create a SQL statement from a given query
            statement = connection.prepareStatement(givenQuery);
            statement.setString(1, sp.getComboboxValue());
            resultSet = statement.executeQuery();
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
                System.out.println(e.getStackTrace());
            }
    }

    //To retrieve the column names of a table in the database
    public static DatabaseMetaData getMetaData() throws Exception{
        DatabaseMetaData metadata = connection.getMetaData();
        return metadata;
    }
}