package dev.inside_out;

import java.util.Scanner;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        ProgramController controller = new ProgramController();        
        controller.startProgram();
       
    }

    
}
