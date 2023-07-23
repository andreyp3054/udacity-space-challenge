import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Simulation simulate = new Simulation();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type in [1] to load phase 1 items; [2] to load phase [2]; [12] for both");
        String user = keyboard.nextLine();
        // Just change loadU1 to "loadU2" to simulate U2 Rockets
        simulate.runSimulation(simulate.loadU1(simulate.loadItems(user)));

        int totalCostU1 = simulate.totalCost;

        Simulation second = new Simulation();

        System.out.println("Type in [1] to load phase 1 items; [2] to load phase [2]; [12] for both");
        user = keyboard.nextLine();
        second.runSimulation(second.loadU2(second.loadItems(user)));
        int totalCostU2 = second.totalCost;

        if (totalCostU1 < totalCostU2) {
            System.out.println("U1 Rocket: " + totalCostU1 + " Million is cheaper than " + "U2 Rockets: " + totalCostU2 + " Million");
        } else if (totalCostU2 < totalCostU1) {
            System.out.println("U2 Rocket: " + totalCostU2 + " Million is cheaper than " + "U1 Rocket: " + totalCostU1 + " Million");
        }

    }
}