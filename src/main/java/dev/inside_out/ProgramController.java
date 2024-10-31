package dev.inside_out;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramController {
    private List<Emotion> emotions = new ArrayList<>();
    private List<Moment> moments = new ArrayList<>();

    public ProgramController() {
        createEmotions();

    }

    private void createEmotions() {
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
    }

    public void startProgram() {
        Scanner scanner = new Scanner(System.in);
        boolean programRuning = true;

        while (programRuning) {
            System.out.println("My diario:\n1. Añadir momento\n2. Ver todos los momentos disponibles\n3. Eliminar un momento\n4. Filtrar los momentos\n5. Salir");
            System.out.print("Seleccione una opción:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createMoment(scanner);
                    break;
                case 2:
                    showAllMoments();
                    break;
                case 3:
                    System.out.println("Here will be another menu");
                    break;
                case 4:
                    System.out.println("Here will be another menu");
                    break;
                case 5:
                    System.out.println("До зустрічі!");
                    programRuning = false;
                    break;
                default:
                    System.out.println("Wrong choice!");
                    break;
            }
        }
    }

    void createMoment(Scanner scanner) {

        System.out.print("Ingrese título del momento: ");
        String title = scanner.nextLine();

        System.out.print("Ingrese fecha del momento (dd/mm/yyyy): ");
        String dateString = scanner.nextLine();

        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.print("Ingrese descripción del momento: ");
        String description = scanner.nextLine();

        System.out.print("Ingrese la emoción (1-10): \n");
        for (int index = 0; index < emotions.size(); index++) {
            System.out.println((index + 1) + ". " + emotions.get(index).getNameOfEmotion());

        }
        System.out.print("Seleccione una opción:");
        int choice = scanner.nextInt();

        Emotion emotion = emotions.get(choice - 1);
        Moment moment = new Moment(title, date, description, emotion);
        moments.add(moment);
        System.out.print(moment);
        System.out.print("Momento añadido correctamente \n");

    }

    public void showAllMoments() {
        if (moments.isEmpty()) {
            System.out.println("No hay momentos para mostrar.");
        } else {
            for (int index = 0; index < moments.size(); index++) {
                System.out.println(moments.get(index));
            }
        }

    }

    public List<Emotion> getEmotions() {
        return emotions;
    }

    public List<Moment> getMoments() {
        return moments;
    }

}
