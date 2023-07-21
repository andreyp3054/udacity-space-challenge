import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
public class Simulation {
    File phase1 = new File("phase-1.txt");
    File phase2 = new File("phase-2.txt");
    Scanner read1 = new Scanner(phase1);
    Scanner read2 = new Scanner(phase2);
    Scanner scanner = new Scanner(System.in);
    ArrayList<Item> item = new ArrayList<>();
    ArrayList<Rocket> fleetU1 = new ArrayList<>();
    ArrayList<Rocket> fleetU2 = new ArrayList<>();
    ArrayList<Rocket> combinedFleet = new ArrayList<>();
    int numberOfCrashedRockets = 0;


    int numberOfU1Rockets = 0;
    int numberOfU2Rockets = 0;
    int totalRocketsUsed = 0;
    ArrayList<Item> clone = new ArrayList<>();

    public Simulation() throws FileNotFoundException {
    }

    public ArrayList<Item> loadItems() {
        System.out.println("LOADING ITEMS...");
        loadPhase1();
        loadPhase2();
        return item;
    }

    public ArrayList<Item> loadPhase1() {
        System.out.print("Loading Phase 1: ");
        while (read1.hasNextLine()) {
            String temporary = read1.nextLine();
            String[] splitter = temporary.split("=", 2);
            Item temporaryItem = new Item(splitter[0], Integer.parseInt(splitter[1]));
            item.add(temporaryItem);
            clone.add(temporaryItem);
        }
        System.out.println(item.size() + " items loaded for Phase 1");
        return item;
    }

    public ArrayList<Item> loadPhase2() {
        System.out.print("Loading Phase 2: ");
        while (read2.hasNextLine()) {
            String temporary = read2.nextLine();
            String[] splitter = temporary.split("=", 2);
            Item temporaryItem = new Item(splitter[0], Integer.parseInt(splitter[1]));
            item.add(temporaryItem);
            clone.add(temporaryItem);
        }
        System.out.println(8 + " items loaded for Phase 2");
        System.out.println(item.size() + " total loaded items");
        System.out.println(item.size() + " total loaded CLONE items");
        return item;
    }


public ArrayList<Rocket> loadU1 (ArrayList<Item> clone) {
        Rocket rocketU1 = new U1();
        numberOfU1Rockets++;
        for(int i = 0; i < clone.size(); i++) {
            if (rocketU1.canCarry(clone.get(i))) {
                rocketU1.carry(clone.get(i));
                System.out.println(clone.get(i) + " item is loaded");
                clone.remove(i);
                i = -1;
                if (rocketU1.getCargoCarried() == rocketU1.getCargoLimit()) {
                    combinedFleet.add(rocketU1);
                    System.out.println(combinedFleet.size() + " ROCKET IS ADDED");
                    rocketU1 = new U1();
                    numberOfU1Rockets++;
                    i = -1;
                }
            } else if (i == clone.size() - 1 && rocketU1.getCargoCarried() < rocketU1.getCargoLimit()) {
                if (!rocketU1.canCarry(clone.get(i))) {
                    i = 0;
                    combinedFleet.add(rocketU1);
                    System.out.println(combinedFleet.size() + " ROCKET IS ADDED");
                    rocketU1 = new U1();
                    numberOfU1Rockets++;
                    i = -1;
                }
            }
            if(clone.size() == 0){
                combinedFleet.add(rocketU1);
                System.out.println(combinedFleet.size() + " ROCKET IS ADDED");
            }
        }

    System.out.println(combinedFleet.size() + " ROCKETS IN THE FLEET");
        return combinedFleet;
}


    public ArrayList<Rocket> loadU2 (ArrayList<Item> clone) {
        Rocket rocketU2 = new U2();
        numberOfU2Rockets++;
        for(int i = 0; i < clone.size(); i++) {
            if (rocketU2.canCarry(clone.get(i))) {
                rocketU2.carry(clone.get(i));
                System.out.println(clone.get(i) + " item is loaded");
                clone.remove(i);
                i = -1;
                if (rocketU2.getCargoCarried() == rocketU2.getCargoLimit()) {
                    combinedFleet.add(rocketU2);
                    System.out.println(combinedFleet.size() + " ROCKET IS ADDED");
                    rocketU2 = new U2();
                    numberOfU2Rockets++;
                    i = -1;
                }
            } else if (i == clone.size() - 1 && rocketU2.getCargoCarried() < rocketU2.getCargoLimit()) {
                if (!rocketU2.canCarry(clone.get(i))) {
                    i = 0;
                    combinedFleet.add(rocketU2);
                    System.out.println(combinedFleet.size() + " ROCKET IS ADDED");
                    rocketU2 = new U2();
                    numberOfU2Rockets++;
                    i = -1;
                }
            }
            if(clone.size() == 0){
                combinedFleet.add(rocketU2);
                System.out.println(combinedFleet.size() + " ROCKET IS ADDED");
            }
        }
        System.out.println(numberOfU2Rockets);
//        System.out.println(fleetU2.size() + " ROCKETS IN THE FLEET");
        return combinedFleet;
    }
//    public ArrayList<Rocket> combineFleet(){
//       fleetU1.addAll(fleetU2);
//       combinedFleet = fleetU1;
//       System.out.println("COMBINED FLEET SIZE " + combinedFleet.size());
//       return combinedFleet;
//    }
    public int runSimulation(ArrayList<Rocket> combinedFleet){
        int overallCost = 0;
////////////////////////////LATEST//////////
//                 while (i != combinedFleet.size()){
//                     combinedFleet.get(i).launch();
//                     combinedFleet.get(i).land();
//                     while(!combinedFleet.get(i).launch() || !combinedFleet.get(i).land()){
//                         combinedFleet.get(i).launch();
//                         combinedFleet.get(i).land();
//                         numberOfCrashedRockets++;
//                     }
//                     i++;
//                 }
        for (int i = 0; i < combinedFleet.size(); i++){
            while(!combinedFleet.get(i).launch() || !combinedFleet.get(i).land()) {
                combinedFleet.get(i).launch();
                combinedFleet.get(i).land();
                numberOfCrashedRockets++;
            }
        }
        System.out.println(numberOfCrashedRockets + " Crashes");
        overallCost = (combinedFleet.size() + numberOfCrashedRockets) * combinedFleet.get(0).getRocketCost();
        System.out.println("Overall cost: " + overallCost + " MILLION");
        return overallCost;
    }
    }










//    public ArrayList<Rocket> loadU1 (ArrayList<Item> item) {
//        boolean soloRocket = false;
//        System.out.println(clone.size());
//        Rocket rocketU1 = new U1();
//        numberOfRockets++;
//        int failItemCounter = 0;
//        boolean newRocketDueToFull = false;
//        int failItemIndex = 0;
//
//        for (int i = 0; i < clone.size(); i++) {
//            if (soloRocket && rocketU1.canCarry(clone.get(i))) {
//                i = 0;
//                rocketU1.carry(clone.get(i));
//                System.out.println(clone.get(i) + " Tertiary: item is carried");
//                fleet.add(rocketU1);
//                System.out.println(fleet.size() + " ROCKET ADDED TO FLEET");
//                clone.remove(i);
//                i = -1;
//            } else if (rocketU1.canCarry(clone.get(i))) {
//                rocketU1.carry(clone.get(i));
//                System.out.println(clone.get(i) + " item is carried");
//                clone.remove(i);
//                i = -1;
//                if (rocketU1.getCargoCarried() == rocketU1.getCargoLimit()) {
//                    fleet.add(rocketU1);
//                    System.out.println(fleet.size() + " ROCKET ADDED TO FLEET");
//                    rocketU1 = new U1();
//                    numberOfRockets++;
//                    newRocketDueToFull = true;
//                    i = -1;
//                }
//            } else if (!rocketU1.canCarry(clone.get(i))) {
//                failItemCounter++;
//                if (failItemCounter == 1) {
//                    failItemIndex = clone.indexOf(clone.get(i));
//                }
//            }
//            if (newRocketDueToFull) {
//                i = failItemIndex - 1;
//                failItemIndex = 0;
//                failItemCounter = 0;
//                newRocketDueToFull = false;
//            }
//            if (i == clone.size() - 1 && clone.size() != 0) { //ELSE NEWLY ADDED
//                i = 0;
//                System.out.println(clone.get(i) + " Secondary: item is carried");
//                fleet.add(rocketU1);
//                System.out.println(fleet.size() + " ROCKET ADDED TO FLEET");
//                clone.remove(clone.get(i));
//                rocketU1 = new U1();
//                numberOfRockets++;
//                i = -1;
//                soloRocket = true;
//            }
//        }
//        System.out.println("Clone size" + clone.size());
//        System.out.println("Fleet size : " + fleet.size());
//        return fleet;
//    }
//}





//                } if (!rocketU1.canCarry(item.get(i)) && failItemCounter == 1) {
//                    rocketU1.carry(clone.get(i));
//                    clone.remove(i);
//                    fleet.add(rocketU1);
//                    rocketU1 = new U1();
//                    numberOfRockets++;
//                    i = -1;
//                }













//    public ArrayList<Rocket> loadU1(ArrayList<Item> item) {
//        Rocket rocketU1 = new U1();
//        ArrayList<Item> empty = new ArrayList<>();
//        numberOfRockets++;
//        for (int z = 0; z <= 3; z++) {
//            for (int i = 0; i < clone.size(); i++) {
//                if(!empty.contains(item.get(i))){
//                    if (rocketU1.canCarry(item.get(i)) != 3) {
//                        if (rocketU1.canCarry(item.get(i)) == 1) {
//                            rocketU1.carry(item.get(i));
//                            empty.add(item.get(i));
//                            clone.remove(item.get(i));
//                        } else if (rocketU1.canCarry(item.get(i)) == 2) {
//                            rocketU1.carry(item.get(i));
//                            empty.add(item.get(i));
//                            rocketU1 = new U1();
//                            clone.remove(item.get(i));
//                            i = 0;
//                        }
//                    }
//                }
//                }
//            }
//        return fleet;
//    }
