 public class U2 extends Rocket {
     private static final int rocketCostU2 = 120;
     private static final int rocketWeightU2 = 18 * 1000;
     private static final int maxWeightU2 = 29 * 1000;
     private static final int cargoLimit = maxWeightU2 - rocketWeightU2;
     private static int cargoCarried;

     public U2() {
         super(rocketCostU2, maxWeightU2, rocketWeightU2, cargoCarried, cargoLimit);
     }

     public boolean launch() {
         double launchExplosionChance = 4 * ((double) getCargoCarried() / getCargoLimit());
         double random = (Math.random() * 100 + 1);
         return !(random <= launchExplosionChance);
     }

     public boolean land() {
         double landCrashChance = 8 * ((double) getCargoCarried() / getCargoLimit());
         double random = (Math.random() * 100 + 1);
         return !(random <= landCrashChance);
     }
 }