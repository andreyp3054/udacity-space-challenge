public class U1 extends Rocket {
    private static final int ROCKET_COST = 100;
    private static final int ROCKET_WEIGHT = 10 * 1000;
    private static final int MAX_WEIGHT = 18 * 1000;
    private static final int CARGO_LIMIT = MAX_WEIGHT - ROCKET_WEIGHT;
    private static int cargoCarried;

    public U1() {
        super(ROCKET_COST, MAX_WEIGHT, ROCKET_WEIGHT, cargoCarried, CARGO_LIMIT);
    }

    public boolean launch() {
        double launchExplosionChance = 0.05 * ((double) getCargoCarried() / getCargoLimit());
        return Math.random() >= launchExplosionChance;
    }

    public boolean land() {
        double landCrashChance = 0.01 * ((double) getCargoCarried() / getCargoLimit());
        return Math.random() >= landCrashChance;

    }

}