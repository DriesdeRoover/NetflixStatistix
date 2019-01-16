package nl.avans.Repository;

import nl.avans.Connection.DatabaseConnection;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DatabaseRepository {

    private static SeriePanel sp;
    private DatabaseConnection databaseConnection;

    public DatabaseRepository() {
        this.databaseConnection = databaseConnection;
    }

    public ArrayList<String> getSerieData(){
        ArrayList<String> serieList = new ArrayList<>();

        DatabaseConnection.connect();
        try {
            ResultSet rs = DatabaseConnection.getData("SELECT * FROM Serie");
            while (rs.next()) {
                serieList.add(rs.getString("SerieNaam"));
            }

        } catch (Exception e) {
            System.out.println("An Error Occurred: " + e.getMessage());
        }
        return serieList;
    }

    public ArrayList<String> getProfileName(){
        ArrayList<String> profileList = new ArrayList<>();

        DatabaseConnection.connect();
        try {
            ResultSet rs = DatabaseConnection.getData("SELECT * FROM Profiel");
            while (rs.next()) {
                profileList.add(rs.getString("ProfielNaam"));
            }

        } catch (Exception e) {
            System.out.println("An Error Occurred: " + e.getMessage());
        }
        return profileList;
    }

    public ArrayList<String> getAllEpisodeData(String serieName){
        ArrayList<String> episodeList = new ArrayList<>();
        DatabaseConnection.connect();

        try {
            ResultSet rs = DatabaseConnection.getData( "SELECT * " +
                    "FROM Aflevering " +
                    "JOIN Serie ON Serie.SerieNaam = Aflevering.SerieNaam " +
                    "WHERE Serie.SerieNaam = '" + serieName + "';");
            while (rs.next()) {
                //episodeList = new ArrayList<>();
                episodeList.add(rs.getString("Titel"));
                episodeList.add(rs.getString("Tijdsduur"));
                episodeList.add(rs.getString("LeeftijdsIndicatie"));
                episodeList.add(rs.getString("Taal"));
                episodeList.add(rs.getString("Genre"));
                episodeList.add(rs.getString("LijktOp"));
                //episodeList.add(e.toString());
                episodeList.toString();

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return episodeList;
    }

}
