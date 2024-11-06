package dev.inside_out;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class ProgramControllerTest {
   @Test
    public void testSortByMonth() {
        ProgramController controller = new ProgramController();
        controller.getMoments().add(new Moment("Vacation", LocalDate.of(2023, 1, 15), "Great time!", controller.getEmotions().get(0)));
        controller.getMoments().add(new Moment("Birthday", LocalDate.of(2023, 5, 10), "Celebration", controller.getEmotions().get(1)));
        controller.getMoments().add(new Moment("Concert", LocalDate.of(2023, 5, 22), "Amazing music!", controller.getEmotions().get(2)));
        controller.getMoments().add(new Moment("Workshop", LocalDate.of(2023, 7, 4), "Learned a lot", controller.getEmotions().get(3)));

        // Simulate input for the month of May (5)
        String simulatedInput = "5\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Redirect System.out to capture the output
        var outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));

        
        controller.sortByMonth(scanner);

        String output = outputStream.toString();
        assertTrue(output.contains("Lista de momentos por mes 5"));
        assertTrue(output.contains("Birthday"));
        assertTrue(output.contains("Concert"));
        assertFalse(output.contains("Vacation"));
        assertFalse(output.contains("Workshop"));

        System.setOut(System.out);
    }
}