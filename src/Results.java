public class Results {
    private final int totalCost;
    private final int successfulRockets;
    private final int crashedRockets;
    private final int totalRocketsUsed;

    public int getTotalCost() {
        return totalCost;
    }

    public int getSuccessfulRockets() {
        return successfulRockets;
    }

    public int getCrashedRockets() {
        return crashedRockets;
    }

    public int getTotalRocketsUsed() {
        return totalRocketsUsed;
    }

    public Results(int totalCost, int successfulRockets, int crashedRockets) {
        this.totalCost = totalCost;
        this.successfulRockets = successfulRockets;
        this.crashedRockets = crashedRockets;
        totalRocketsUsed = successfulRockets + crashedRockets;
    }
}
