package dev.inside_out.models;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Emotion> createEmotions() {
        List<Emotion> emotions = new ArrayList<>();
        emotions.add(new Emotion(1, "Alegría"));
        emotions.add(new Emotion(2, "Tristeza"));
        emotions.add(new Emotion(3, "Ira"));
        emotions.add(new Emotion(4, "Asco"));
        emotions.add(new Emotion(5, "Miedo"));
        emotions.add(new Emotion(6, "Ansiedad"));
        emotions.add(new Emotion(7, "Envidia"));
        emotions.add(new Emotion(8, "Vergüenza"));
        emotions.add(new Emotion(9, "Aburrimiento"));
        emotions.add(new Emotion(10, "Nostalgia"));
        return emotions;
    }
}
