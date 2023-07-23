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

        System.out.println("Type in [1] to load phase 1 items; [2] to load phase [2]; [12] for both");
        user = keyboard.nextLine();
        simulate.loadItems(user);
//        simulate.runSimulation(simulate.loadU2(simulate.loadItems(user)));

        // Why 12 on the second U2 is 0 items loaded? YOU have to reset something
        // 3. e format ang code
        //4. e print sa last ahay pinakabarato or tipid nga type of rocket

    }
}