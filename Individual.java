public class Individual {
    int waterSystemSize;
    double fitness;

    public Individual(int waterSystemSize) {
        this.waterSystemSize = waterSystemSize;
        this.fitness = calculateFitness();
    }

    public double calculateFitness() {
        if (waterSystemSize < 1000) {
            return 0.0;
        } else if (waterSystemSize > 10000) {
            return 0.5;
        } else {
            return (waterSystemSize + 150.0) / 140.0;
        }
    }
}
