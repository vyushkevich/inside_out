package dev.inside_out.controler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dev.inside_out.models.Emotion;
import dev.inside_out.models.Moment;

public class ProgramController {
    private List<Emotion> emotions = new ArrayList<>();
    private List<Moment> moments = new ArrayList<>();

    public ProgramController() {
        this.emotions = Emotion.createEmotions();
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
                    deleteMoment(scanner);
                    break;
                case 4:
                    filterOfMoments(scanner);
                    break;
                case 5:
                    System.out.println("Hasta la próxima!!!");
                    programRuning = false;
                    break;
                default:
                    System.out.println("No es una opción correcta!");
                    break;
            }
        }
        scanner.close();
    }

    public void createMoment(Scanner scanner) {

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

    public void filterOfMoments(Scanner scanner){
        System.out.println("Filtrar por:\n1. Emoción\n2. Fecha");
        System.out.print("Ingrese una opción:");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                sortByEmotion(scanner);
                break;
            case 2:                
                sortByMonth(scanner);
                break;
            default:
                System.out.println("No es una opción correcta!");
                break; 
        }

    }

    public void sortByMonth(Scanner scanner) {
        System.out.println("Ingrese el mes (1-12): ");
        int month = scanner.nextInt();
        scanner.nextLine();

        List<Moment> sortedMoments = moments.stream().filter(moment -> moment.getDateOfMoment().getMonthValue() == month).toList();

        if (sortedMoments.isEmpty()){
            System.out.println("No se encontraron momentos para la fecha seleccionada.");
        } else {
            System.out.println("Lista de momentos por mes " + month + ":");
            sortedMoments.forEach(System.out::println);
        }
    }

    public void sortByEmotion(Scanner scanner) {
        System.out.println("Ingrese la emoción (1-10): ");
        int emotionId = scanner.nextInt();
        scanner.nextLine();

        List<Moment> sortedMoments = moments.stream()
        .filter(moment -> moment.getEmotion().getId()== emotionId)
        .toList();

        if (sortedMoments.isEmpty()){
            System.out.println("No se encontraron momentos para:");
        } else {
            System.out.println("Lista de momentos por emoción: " + emotions.get(emotionId-1).getNameOfEmotion());
            sortedMoments.forEach(System.out::println);
        }
       
    }

    public void deleteMoment(Scanner scanner) {
        System.out.println("Ingrese el id del momento que desea eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Moment moment : moments) {
            if (moment.getIdOfMoment() == id) {
                moments.remove(moment);
                System.out.println("Momento eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un momento con el id ingresado.");
    }

    public List<Emotion> getEmotions() {
        return emotions;
    }

    public List<Moment> getMoments() {
        return moments;
    }

}
