package nl.avans.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connection {

    public ResultSet Connection(String query) {
        // Dit zijn de instellingen voor de verbinding. Vervang de databaseName indien deze voor jou anders is.
        String connectionUrl = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=Netflix;integratedSecurity=true;";

        // nl.avans.Connection.Connection beheert informatie over de connectie met de database.
        java.sql.Connection con = null;

        // Statement zorgt dat we een SQL query kunnen uitvoeren.
        Statement stmt = null;

        // ResultSet is de tabel die we van de database terugkrijgen.
        // We kunnen door de rows heen stappen en iedere kolom lezen.
        ResultSet rs = null;

        try {
            // 'Importeer' de driver die je gedownload hebt.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            con = DriverManager.getConnection(connectionUrl);
            System.out.println("connected");

            // Stel een SQL query samen.
            String SQL = query;
            stmt = con.createStatement();
            // Voer de query uit op de database.
            rs = stmt.executeQuery(query);


        }


        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (Exception e) {
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
            }
            if (con != null) try {
                con.close();
            } catch (Exception e) {
            }
        }
        return rs;
    }

}
