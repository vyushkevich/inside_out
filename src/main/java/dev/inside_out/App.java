package dev.inside_out;

import dev.inside_out.controler.ProgramController;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        ProgramController controller = new ProgramController();        
        controller.startProgram(); 
    }  
}
