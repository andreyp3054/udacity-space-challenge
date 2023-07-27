import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public ArrayList<Item> loadItems(String filePath) {
        ArrayList<Item> item = new ArrayList<>();
        try {
            Scanner phaseFile = new Scanner(new File(filePath));
            while (phaseFile.hasNextLine()) {
                String temporary = phaseFile.nextLine();
                String[] splitter = temporary.split("=");
                Item temporaryItem = new Item(splitter[0], Integer.parseInt(splitter[1]));
                item.add(temporaryItem);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Missing file");
        }
        return item;
    }


    public ArrayList<Rocket> loadU1(ArrayList<Item> item) {
        ArrayList<Rocket> fleetU1 = new ArrayList<>();
        Rocket rocketU1 = new U1();
        for (Item i : item) {
            if (rocketU1.canCarry(i)) {
                rocketU1.carry(i);
            } else if (!rocketU1.canCarry(i)) {
                fleetU1.add(rocketU1);
                rocketU1 = new U1();
                rocketU1.carry(i);
            }
        }
        if (rocketU1.getCargoCarried() != 0) {    // if the last rocket has item, add to fleet
            fleetU1.add(rocketU1);
        }
        return fleetU1;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> item) {
        ArrayList<Rocket> fleetU2 = new ArrayList<>();
        Rocket rocketU2 = new U2();
        for (Item i : item) {
            if (rocketU2.canCarry(i)) {
                rocketU2.carry(i);
            } else if (!rocketU2.canCarry(i)) {
                fleetU2.add(rocketU2);
                rocketU2 = new U2();
                rocketU2.carry(i);
            }
        }
        if (rocketU2.getCargoCarried() != 0) {    // if the last rocket has item, add to fleet
            fleetU2.add(rocketU2);
        }
        return fleetU2;
    }

    public Results runSimulation(ArrayList<Rocket> fleet) {
        int totalCost = 0;
        int successfulRockets = 0;
        int crashedRockets = 0;
        for (Rocket rocket : fleet) {
            totalCost += rocket.getRocketCost();
            successfulRockets++;
            while (!rocket.launch() || !rocket.land()) {
                totalCost += rocket.getRocketCost();
                crashedRockets++;
            }
        }
        return new Results(totalCost, successfulRockets, crashedRockets);
    }
}
