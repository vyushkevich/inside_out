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
                    System.out.println("Eliminar Momento");
                    break;
                case 4:
                    filterOfMoments(scanner);
                    break;
                case 5:
                    System.out.println("Hasta la próxima!!!");
                    programRuning = false;
                    break;
                default:
                    System.out.println("No es la elección correcta!");
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

    private void filterOfMoments(Scanner scanner){
        System.out.println("Filtrar por:\n1. Emoción\n2. Fecha");
        System.out.print("Ingrese una opción:");
        Integer option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                sortByEmotion(scanner);
                break;
            case 2:                
                sortByMonth(scanner);
                break;
            default:
                System.out.println("No es la elección correcta!");
                break; 
            
        }

    }

    private void sortByMonth(Scanner scanner) {
        System.out.println("Ingrese el mes (1-12): ");
        Integer month = scanner.nextInt();
        scanner.nextLine();

        List<Moment> sortedMoments = moments.stream().filter(moment -> moment.getDateOfMoment().getMonthValue() == month).toList();

        if (sortedMoments.isEmpty()){
            System.out.println("No se encontraron momentos para la fecha seleccionada.");
        } else {
            System.out.println("Lista de momentos por mes " + month + ":");
            sortedMoments.forEach(System.out::println);
        }
    }

    private void sortByEmotion(Scanner scanner) {
        System.out.println("Ingrese la emotion (1-10): ");
        Integer emotionId = scanner.nextInt();
        scanner.nextLine();

        List<Moment> sortedMoments = moments.stream()
        .filter(moment -> moment.getEmotion().getId()== emotionId)
        .toList();

        if (sortedMoments.isEmpty()){
            System.out.println("No se encontraron momentos para.");
        } else {
            System.out.println("Lista de momentos por emoció: " + emotions.get(emotionId-1).getNameOfEmotion());
            sortedMoments.forEach(System.out::println);
        }
       
    }

    public List<Emotion> getEmotions() {
        return emotions;
    }

    public List<Moment> getMoments() {
        return moments;
    }

}
