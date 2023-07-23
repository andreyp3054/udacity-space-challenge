import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    File phase1 = new File("phase-1.txt");
    File phase2 = new File("phase-2.txt");
    Scanner read1 = new Scanner(phase1);
    Scanner read2 = new Scanner(phase2);
    ArrayList<Item> item = new ArrayList<>();
    ArrayList<Rocket> fleet = new ArrayList<>();
    int numberOfCrashedRockets = 0;
    int totalCost = 0;

    int numberOfU1Rockets = 0;
    int numberOfU2Rockets = 0;

    public Simulation() throws FileNotFoundException {
    }

    public ArrayList<Item> loadItems(String user) {
        System.out.println("LOADING ITEMS...");
        if (user.equals("1")) {
            loadPhase1();
        } else if (user.equals("2")) {
            loadPhase2();
        } else if (user.equals("12")) {
            loadPhase1();
            loadPhase2();
        }
        return item;
    }

    public ArrayList<Item> loadPhase1() {
        System.out.print("Loading Phase 1: ");
        while (read1.hasNextLine()) {
            String temporary = read1.nextLine();
            String[] splitter = temporary.split("=", 2);
            Item temporaryItem = new Item(splitter[0], Integer.parseInt(splitter[1]));
            item.add(temporaryItem);
        }
        System.out.println(item.size() + " items loaded for Phase 1");
        System.out.println(item.size() + " total loaded items");
        return item;
    }

    public ArrayList<Item> loadPhase2() {
        System.out.print("Loading Phase 2: ");
        int phaseItems = 0;
        while (read2.hasNextLine()) {
            String temporary = read2.nextLine();
            String[] splitter = temporary.split("=", 2);
            Item temporaryItem = new Item(splitter[0], Integer.parseInt(splitter[1]));
            item.add(temporaryItem);
            phaseItems++;
        }
        System.out.println(phaseItems + " items loaded for Phase 2");
        System.out.println(item.size() + " total loaded items");
        return item;
    }


    public ArrayList<Rocket> loadU1(ArrayList<Item> item) {
        Rocket rocketU1 = new U1();
        numberOfU1Rockets++;
        for (int i = 0; i < item.size(); i++) {
            if (rocketU1.canCarry(item.get(i))) {
                rocketU1.carry(item.get(i));
                System.out.println(item.get(i) + " item is loaded");
                item.remove(i);
                i = -1;
                if (rocketU1.getCargoCarried() == rocketU1.getCargoLimit()) {
                    fleet.add(rocketU1);
                    System.out.println(fleet.size() + " ROCKET IS ADDED");
                    rocketU1 = new U1();
                    numberOfU1Rockets++;
                    i = -1;
                }
            } else if (i == item.size() - 1 && rocketU1.getCargoCarried() < rocketU1.getCargoLimit()) {
                if (!rocketU1.canCarry(item.get(i))) {
                    i = 0;
                    fleet.add(rocketU1);
                    System.out.println(fleet.size() + " ROCKET IS ADDED");
                    rocketU1 = new U1();
                    numberOfU1Rockets++;
                    i = -1;
                }
            }
            if (item.size() == 0 && rocketU1.getCargoCarried() != 0) {
                fleet.add(rocketU1);
                System.out.println(fleet.size() + " ROCKET IS ADDED");
            }
        }

        System.out.println(fleet.size() + " ROCKETS IN THE FLEET");
        return fleet;
    }


    public ArrayList<Rocket> loadU2(ArrayList<Item> item) {
        Rocket rocketU2 = new U2();
        numberOfU2Rockets++;
        for (int i = 0; i < item.size(); i++) {
            if (rocketU2.canCarry(item.get(i))) {
                rocketU2.carry(item.get(i));
                System.out.println(item.get(i) + " item is loaded");
                item.remove(i);
                i = -1;
                if (rocketU2.getCargoCarried() == rocketU2.getCargoLimit()) {
                    fleet.add(rocketU2);
                    System.out.println(fleet.size() + " ROCKET IS ADDED");
                    rocketU2 = new U2();
                    numberOfU2Rockets++;
                    i = -1;
                }
            } else if (i == item.size() - 1 && rocketU2.getCargoCarried() < rocketU2.getCargoLimit()) {
                if (!rocketU2.canCarry(item.get(i))) {
                    i = 0;
                    fleet.add(rocketU2);
                    System.out.println(fleet.size() + " ROCKET IS ADDED");
                    rocketU2 = new U2();
                    numberOfU2Rockets++;
                    i = -1;
                }
            }
            if (item.size() == 0) {
                fleet.add(rocketU2);
                System.out.println(fleet.size() + " ROCKET IS ADDED");
            }
        }
        return fleet;
    }

    public int runSimulation(ArrayList<Rocket> fleet) {
        for (Rocket rocket : fleet) {
            while (!rocket.launch() || !rocket.land()) {
//                rocket.launch();
//                rocket.land();
                numberOfCrashedRockets++;
            }
        }
        System.out.println(numberOfCrashedRockets + " Crashes");
        System.out.println(fleet.size() + numberOfCrashedRockets + " Total Rockets Used");
        totalCost = (fleet.size() + numberOfCrashedRockets) * fleet.get(0).getRocketCost();
        System.out.println("Total cost including the crashed ones: " + totalCost + " MILLION");
        return totalCost;
    }
}

