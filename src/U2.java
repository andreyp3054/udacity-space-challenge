public class U2 extends Rocket {
    private static final int ROCKET_COST = 120;
    private static final int ROCKET_WEIGHT = 18 * 1000;
    private static final int MAX_WEIGHT = 29 * 1000;
    private static final int CARGO_LIMIT = MAX_WEIGHT - ROCKET_WEIGHT;
    private static int cargoCarried;

    public U2() {
        super(ROCKET_COST, MAX_WEIGHT, ROCKET_WEIGHT, cargoCarried, CARGO_LIMIT);
    }

    public boolean launch() {
        double launchExplosionChance = 0.04 * ((double) getCargoCarried() / getCargoLimit());
        return Math.random() >= launchExplosionChance;
    }

    public boolean land() {
        double landCrashChance = 0.08 * ((double) getCargoCarried() / getCargoLimit());
        return Math.random() >= landCrashChance;

    }
}