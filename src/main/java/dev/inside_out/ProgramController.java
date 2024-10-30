package dev.inside_out;
import java.util.ArrayList;
import java.util.List;

public class ProgramController {
    private List<Emotion> emotions = new ArrayList<>();
    private List<Moment> moments = new ArrayList<>();

    public ProgramController(){
        createEmotions();

    }

    private void createEmotions() {
        emotions.add(new Emotion(1, "Joy"));
        emotions.add(new Emotion(2, "Sadness"));
        emotions.add(new Emotion(3, "Anger"));
        emotions.add(new Emotion(4, "Disgust"));
        emotions.add(new Emotion(5, "Fear"));
        emotions.add(new Emotion(6, "Anxiety"));
        emotions.add(new Emotion(7, "Envy"));
        emotions.add(new Emotion(8, "Shame"));
        emotions.add(new Emotion(9, "Boredom"));
        emotions.add(new Emotion(10, "Nostalgia"));
    }


    public List<Emotion> getEmotions() {
        return emotions;
    }

    public List<Moment> getMoments() {
        return moments;
    }
 
}
