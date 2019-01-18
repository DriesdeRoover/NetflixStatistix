package nl.avans.Repository;

import java.util.ArrayList;

public class Episode {
    private ArrayList<String> episodeData = new ArrayList<>();
    private String title;
    private String duration;
    private String ageInd;
    private String language;
    private String genre;
    private String looksLike;

    public Episode(String title, String duration, String ageInd, String language, String genre, String looksLike) {
        this.episodeData = episodeData;
        this.title = title;
        this.duration = duration;
        this.ageInd = ageInd;
        this.language = language;
        this.genre = genre;
        this.looksLike = looksLike;
    }
    public Episode(){
        this.episodeData = episodeData;
        this.title = title;
        this.duration = duration;
        this.ageInd = ageInd;
        this.language = language;
        this.genre = genre;
        this.looksLike = looksLike;
    }

    @Override
    public String toString() {
        return title + duration +
                ageInd +
                language +
                genre +
                looksLike + "\n";
    }

    public ArrayList<String> getEpisodeData() {
        return episodeData;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public String getAgeInd() {
        return ageInd;
    }

    public String getLanguage() {
        return language;
    }

    public String getGenre() {
        return genre;
    }

    public String getLooksLike() {
        return looksLike;
    }
}
