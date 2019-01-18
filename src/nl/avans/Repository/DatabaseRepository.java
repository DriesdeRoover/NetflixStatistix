package nl.avans.Repository;

import nl.avans.Connection.DatabaseConnection;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DatabaseRepository {

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

    public ArrayList<Episode> getAllEpisodeData(String name){
        ArrayList<Episode> episodeList = new ArrayList<>();
        DatabaseConnection.connect();
        try {
            ResultSet rs = DatabaseConnection.getData( "SELECT * " +
                    "FROM Aflevering " +
                    "JOIN Serie ON Serie.SerieNaam = Aflevering.SerieNaam " +
                    "WHERE Serie.SerieNaam = '" + name + "';");
            while (rs.next()) {
                //episodeList = new ArrayList<>();

                    episodeList.add(new Episode(rs.getString("Titel"), rs.getString("Tijdsduur"),
                            rs.getString("LeeftijdsIndicatie"), rs.getString("Taal"), rs.getString("Genre"),
                            rs.getString("LijktOp")));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return episodeList;
    }

    public ArrayList<String> getFilms() {
        ArrayList<String> filmList = new ArrayList<>();

        DatabaseConnection.connect();
        try {
            ResultSet rs = DatabaseConnection.getData("SELECT * FROM Film");
            while (rs.next()) {
                filmList.add(rs.getString("Titel"));
            }

        } catch (Exception e) {
            System.out.println("An Error Occurred: " + e.getMessage());
        }
        return filmList;
    }

}

//episodeList.add(rs.getString("Titel")+ rs.getString("Tijdsduur")
//                        + rs.getString("LeeftijdsIndicatie") + rs.getString("Taal") + rs.getString("Genre")
//                        + rs.getString("LijktOp") );
// episodeList.add(rs.getString("Tijdsduur"));
//                episodeList.add(rs.getString("LeeftijdsIndicatie"));
//                episodeList.add(rs.getString("Taal"));
//                episodeList.add(rs.getString("Genre"));
//                episodeList.add(rs.getString("LijktOp"));
//                episodeList.add("\n");
//episodeList.add(e.toString());
