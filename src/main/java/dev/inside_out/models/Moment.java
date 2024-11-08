package dev.inside_out.models;
import java.time.LocalDate;

public class Moment {
    private int idOfMoment;  
    private static int idCounter = 1; 
    private String titleOfMoment;
    private LocalDate dateOfMoment;
    private String description;
    private Emotion emotion;

    public Moment(String title, LocalDate date, String description, Emotion emotion) {
        this.titleOfMoment = title;
        this.dateOfMoment = date;
        this.description = description;
        this.emotion = emotion;
        this.idOfMoment = idCounter++;
    }
   
    public String getTitleOfMoment() {
        return titleOfMoment;
    }

    public LocalDate getDateOfMoment() {
        return dateOfMoment;
    }

    public String getDescription() {
        return description;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public Integer getIdOfMoment() {
        return idOfMoment;
    }

    @Override
    public String toString() {
        return "Datos del momento \n"+ "Title: " + titleOfMoment + "\n" +
                "Date: " + dateOfMoment + "\n" +
                "Description: " + description + "\n" +
                "Emotion: " + emotion.getNameOfEmotion()+"\n";
    }
}
