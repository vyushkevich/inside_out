package dev.inside_out;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        ProgramController controller = new ProgramController();        
        controller.startProgram(); 
    }  
}
