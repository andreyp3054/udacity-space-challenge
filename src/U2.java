 public class U2 extends Rocket {
        private final int rocketCostU2 = 120;
        private final int rocketWeightU2 = 18 * 1000;
        private final int maxWeightU2 = 29* 1000;
        private  int cargoCarried;
        private final int cargoLimit = maxWeightU2 - rocketWeightU2;

        public U2(){
            setRocketCost(rocketCostU2);
            setMaxWeight(maxWeightU2);
            setRocketWeight(rocketWeightU2);
            setCargoCarried(cargoCarried);
            setCargoLimit(cargoLimit);

        }
        public boolean launch() {
            double launchExplosionChance = 0.04 * ((double) cargoCarried / cargoLimit);
            double random = (Math.random() * 100) + 1;
            if (random <= launchExplosionChance) {
                return false;
            } else {
                return true;
            }
        }
        public boolean land() {
            double landCrashChance = 0.08 * ((double) cargoCarried / cargoLimit);
            double random = (Math.random() * 100) + 1;
            if (random <= landCrashChance) {
                return false;
            } else {
                return true;
            }
        }
    }