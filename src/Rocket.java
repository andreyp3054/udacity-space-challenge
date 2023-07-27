public abstract class Rocket implements SpaceShip {
    private final int rocketCost;
    private final int rocketWeight;
    private int totalCost;
    private final int maxWeight;

    private int cargoCarried;
    private final int cargoLimit;

    public int getRocketCost() {
        return rocketCost;
    }

    public int getCargoCarried() {
        return cargoCarried;
    }


    public int getCargoLimit() {
        return cargoLimit;
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
        this.cargoCarried += item.weight();
    }

    @Override

    public boolean canCarry(Item item) {
        return item.weight() + getCargoCarried() <= getCargoLimit();
    }
}


