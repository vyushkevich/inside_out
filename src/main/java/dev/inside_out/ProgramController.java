package dev.inside_out;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void startProgram() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("My diario:\n1. Añadir momento\n2. Ver todos los momentos disponibles\n3. Eliminar un momento\n4. Filtrar los momentos\n5. Salir");
        System.out.print("Seleccione una opción:");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Here will be another menu");
                break;
            case 2:
                System.out.println("Here will be another menu");
                break;
            case 3:
                System.out.println("Here will be another menu");
                break;
            case 4:
                System.out.println("Here will be another menu");
                break;
            case 5:
                System.out.println("Here will be another menu");
                break;
            default:
                System.out.println("Wrong choice!");
                break;
        }
    }

    public List<Emotion> getEmotions() {
        return emotions;
    }

    public List<Moment> getMoments() {
        return moments;
    }
 
}
