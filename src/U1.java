public class U1 extends Rocket {
    private static final int rocketCostU1 = 100;
    private static final int rocketWeightU1 = 10 * 1000;
    private static final int maxWeightU1 = 18 * 1000;
    private static final int cargoLimit = maxWeightU1 - rocketWeightU1;
    private static int cargoCarried;

    public U1() {
        super(rocketCostU1, maxWeightU1, rocketWeightU1, cargoCarried, cargoLimit);
    }

    public boolean launch() {
        double launchExplosionChance = 5 * ((double) getCargoCarried() / getCargoLimit());
        double random = (Math.random() * 100 + 1);
        return !(random <= launchExplosionChance);
    }

    public boolean land() {
        double landCrashChance = 1 * ((double) getCargoCarried() / getCargoLimit());
        double random = (Math.random() * 100 + 1);
        return !(random <= landCrashChance);
    }

}
