import org.w3c.dom.ls.LSOutput;

import java.io.FileNotFoundException;
import java.sql.Array;
import java.sql.SQLOutput;
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
    ArrayList<Rocket> fleet = new ArrayList<>();

    int numberOfRockets = 0;
    ArrayList<Item> clone = new ArrayList<>();

    public Simulation() throws FileNotFoundException {
    }

    public ArrayList<Item> loadItems() {
        System.out.println("LOADING ITEMS...");
        loadPhase1();
//        loadPhase2();
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

//    public ArrayList<Item> loadPhase2() {
//        System.out.print("Loading Phase 2: ");
//        while (read2.hasNextLine()) {
//            String temporary = read2.nextLine();
//            String[] splitter = temporary.split("=", 2);
//            Item temporaryItem = new Item(splitter[0], Integer.parseInt(splitter[1]));
//            item.add(temporaryItem);
//            clone.add(temporaryItem);
//        }
//        System.out.println(8 + " items loaded for Phase 2");
//        System.out.println(item.size() + " total loaded items");
//        System.out.println(item.size() + " total loaded CLONE items");
//        return item;
//    }

    public ArrayList<Rocket> loadU1 (ArrayList<Item> item) {
        System.out.println(clone.size());
        Rocket rocketU1 = new U1();
        numberOfRockets++;
        int failItemCounter = 0;
        boolean newRocketDueToFull = false;
        int failItemIndex = 0;
//        while(clone.size() != 0) {
            for (int i = 0; i < clone.size(); i++) {
                if (rocketU1.canCarry(clone.get(i))) {
                    rocketU1.carry(clone.get(i));
                    System.out.println(clone.get(i) + " item is carried");
                    clone.remove(i);
                    i = -1;
                    if (rocketU1.getCargoCarried() == rocketU1.getCargoLimit()) {
                        fleet.add(rocketU1);
                        rocketU1 = new U1();
                        numberOfRockets++;
                        newRocketDueToFull = true;
                        i = -1;
                    }
                } else if (!rocketU1.canCarry(clone.get(i))) {
                    failItemCounter++;
                    if (failItemCounter == 1) {
                        failItemIndex = clone.indexOf(clone.get(i));
                    }
                } if(newRocketDueToFull) {
                    i = failItemIndex - 1;
                     failItemIndex = 0;
                     newRocketDueToFull = false;
                }
                if(i == clone.size() - 1 && clone.size() != 0){
                    i = 0;
                    System.out.println(clone.get(i) + " NO ADDING ITEMS LEFT : item is carried");
                    fleet.add(rocketU1);
                    clone.remove(clone.get(i));
                    rocketU1 = new U1();
                    numberOfRockets++;
                }



//                } if (!rocketU1.canCarry(item.get(i)) && failItemCounter == 1) {
//                    rocketU1.carry(clone.get(i));
//                    clone.remove(i);
//                    fleet.add(rocketU1);
//                    rocketU1 = new U1();
//                    numberOfRockets++;
//                    i = -1;
//                }
            }
//        }
        System.out.println("Clone size" + clone.size());
        System.out.println("Fleet size : " + fleet.size());
        return fleet;
        }
    }













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
