import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        String phase1FilePath = "UdacitySpaceChallenge/src/resources/phase-1.txt";
        String phase2FilePath = "UdacitySpaceChallenge/src/resources/phase-2.txt";
        Simulation simulate = new Simulation();

        ArrayList<Item> phase1List = simulate.loadItems(phase1FilePath);
        ArrayList<Item> phase2List = simulate.loadItems(phase2FilePath);
        //Sort items in ascending weight
        ArrayList<Item> sortedPhase1List = sorter(phase1List);
        ArrayList<Item> sortedPhase2List = sorter(phase2List);

        //U1 Simulation
        ArrayList<Rocket> phase1U1Fleet = simulate.loadU1(sortedPhase1List);
        ArrayList<Rocket> phase2U1Fleet = simulate.loadU1(sortedPhase2List);
        Results phase1U1 = simulate.runSimulation(phase1U1Fleet);
        Results phase2U1 = simulate.runSimulation(phase2U1Fleet);

        //Print U1 Result
        System.out.println(printResults(phase1U1, phase2U1, "U1"));
        //Save U1 Total Cost
        int totalCostU1 = addPhasesOfRockets(phase1U1.getTotalCost(), phase2U1.getTotalCost());

        //U2 Simulation
        ArrayList<Rocket> phase1U2Fleet = simulate.loadU2(sortedPhase1List);
        ArrayList<Rocket> phase2U2Fleet = simulate.loadU2(sortedPhase2List);
        Results phase1U2 = simulate.runSimulation(phase1U2Fleet);
        Results phase2U2 = simulate.runSimulation(phase2U2Fleet);

        //Print U2 Result
        System.out.println(printResults(phase1U2, phase2U2, "U2"));
        //Save U2 Total Cost
        int totalCostU2 = addPhasesOfRockets(phase1U2.getTotalCost(), phase2U2.getTotalCost());

        //Print Conclusion
        System.out.println("U1 TotalCost: " + totalCostU1);
        System.out.println("U2 TotalCost: " + totalCostU2);
        System.out.println(compareResults(totalCostU1, totalCostU2));

    }

    public static ArrayList<Item> sorter(ArrayList<Item> sortedItems) { //to sort items in ascending weights
        Collections.sort(sortedItems);
        return sortedItems;
    }

    public static String printResults(Results phase1Fleet, Results phase2Fleet, String rocketType) {
        return "Phase 1 " + rocketType + " Fleet:" + "\n # of Successfully Launched Rockets: " + phase1Fleet.getSuccessfulRockets() + "\n # of Crashed Rockets : " + phase1Fleet.getCrashedRockets() + "\n # Phase 1 " + rocketType + " Fleet Total Rockets Used: " + phase1Fleet.getTotalRocketsUsed() + "\n # Phase 1 " + rocketType + " Total Cost: " + phase1Fleet.getTotalCost() + "\nPhase 2 " + rocketType + " Fleet:" + "\n # of Successfully Launched Rockets: " + phase2Fleet.getSuccessfulRockets() + "\n # of Crashed Rockets : " + phase2Fleet.getCrashedRockets() + "\n # Phase 2 " + rocketType + " Fleet Total Rockets Used: " + phase2Fleet.getTotalRocketsUsed() + "\n # Phase 2 " + rocketType + " Total Cost: " + phase2Fleet.getTotalCost() + "\n";
    }

    public static String compareResults(int U1TotalCost, int U2TotalCost) {
        String outcome;
        if (U1TotalCost < U2TotalCost) {
            outcome = "Conclusion: U1 is cheaper than U2";
        } else {
            outcome = "Conclusion: U2 is cheaper than U1";
        }
        return outcome;
    }

    public static int addPhasesOfRockets(int phase1Cost, int phase2Cost) {
        return phase1Cost + phase2Cost;
    }
}