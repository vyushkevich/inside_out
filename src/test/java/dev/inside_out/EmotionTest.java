package dev.inside_out;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class EmotionTest {
    
    @Test
    void testCreateEmotions() {
        List<Emotion> emotions = Emotion.createEmotions();

        assertFalse(emotions.isEmpty());
    }

    @Test
    void testGetId() {
        Emotion emotion = new Emotion(1, "Happy");

        assertEquals(1, emotion.getId());
    }

    @Test
    void testGetNameOfEmotion() {
        Emotion emotion = new Emotion(1, "Happy");

        assertEquals("Happy", emotion.getNameOfEmotion());
    }
}
