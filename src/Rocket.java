public abstract class Rocket implements SpaceShip {
    private int rocketCost;
    private int currentWeight;
    private int rocketWeight;
    private int totalCost;
    private int maxWeight;

    private int cargoCarried;
    private int cargoLimit;

    public int getRocketCost() {
        return rocketCost;
    }

    public void setRocketCost(int rocketCost) {
        this.rocketCost = rocketCost;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getRocketWeight() {
        return rocketWeight;
    }

    public void setRocketWeight(int rocketWeight) {
        this.rocketWeight = rocketWeight;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getCargoCarried() {
        return cargoCarried;
    }

    public void setCargoCarried(int cargoCarried) {
        this.cargoCarried = cargoCarried;
    }

    public int getCargoLimit() {
        return cargoLimit;
    }

    public void setCargoLimit(int cargoLimit) {
        this.cargoLimit = cargoLimit;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    public Rocket(int rocketCost, int maxWeight, int rocketWeight, int cargoCarried, int cargoLimit) {
        this.rocketCost = rocketCost;
        this.maxWeight = maxWeight;
        this.rocketWeight = rocketWeight;
        this.cargoCarried = cargoCarried;
        this.cargoLimit = cargoLimit;
    }

    @Override
    public void carry(Item item) {
        this.cargoCarried += item.weight;
    }

    @Override

    public boolean canCarry(Item item) {
        return item.weight + getCargoCarried() <= getCargoLimit();
    }
}


