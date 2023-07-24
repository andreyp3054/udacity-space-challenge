import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        String phase1FilePath = "SpaceMission/src/resources/phase-1.txt";
        String phase2FilePath = "SpaceMission/src/resources/phase-2.txt";
        Simulation simulate = new Simulation();

        ArrayList<Item> phase1List = simulate.loadItems(phase1FilePath);
        ArrayList<Item> phase2List = simulate.loadItems(phase2FilePath);
        ArrayList<Item> completeItems = mergeItems(phase1List, phase2List);
        ArrayList<Rocket> loadedItems = simulate.loadU1(completeItems);

        PrintResult resultU1 = simulate.runSimulation(loadedItems);


    }

    public static ArrayList<Item> mergeItems(ArrayList<Item> baseList, ArrayList<Item> phase2List) {   //to merge items and sort them
        baseList.addAll(phase2List);
        Collections.sort(baseList); //sort items in ascending weight
        return baseList;
    }

//        public String compareRocketTypes(int U1, int U2){
//
//        }
}