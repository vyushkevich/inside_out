package dev.inside_out;

public class Emotion {
    private Integer id;
    private String nameOfEmotion;

    public Emotion (Integer id, String name) {
        this.id = id;
        this.nameOfEmotion = name;
    }

    public Integer getId() {
        return id;
    }

    public String getNameOfEmotion() {
        return nameOfEmotion;
    }
}
