import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        Simulation simulate = new Simulation();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type in [1] to load phase 1 items; [2] to load phase [2]; [12] for both");
        String user = keyboard.nextLine();
        // Just change loadU1 to "loadU2" to simulate U2 Rockets
        simulate.runSimulation(simulate.loadU1(simulate.loadItems(user)));
    }
}