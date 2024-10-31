package dev.inside_out;
import java.time.LocalDate;

public class Moment {
    private Integer id;  
    private String titleOfMoment;
    private LocalDate dateOfMoment;
    private String description;
    private Emotion emotion;

    public Moment(String title, LocalDate date, String description, Emotion emotion) {
        this.titleOfMoment = title;
        this.dateOfMoment = date;
        this.description = description;
        this.emotion = emotion;
    }
   

    public String getTitleOfMoment() {
        return titleOfMoment;
    }

    public void setTitleOfMoment(String titleOfMoment) {
        this.titleOfMoment = titleOfMoment;
    }

    public LocalDate getDateOfMoment() {
        return dateOfMoment;
    }

    public void setDateOfMoment(LocalDate dateOfMoment) {
        this.dateOfMoment = dateOfMoment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }
   
    
    
    @Override
    public String toString() {
        return "Datos del momento \n"+ "Title: " + titleOfMoment + "\n" +
                "Date: " + dateOfMoment + "\n" +
                "Description: " + description + "\n" +
                "Emotion: " + emotion.getNameOfEmotion()+"\n";
    }
    
    
}
