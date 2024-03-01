public class Main {
    public static void main(String[] args) {
        // Test cases
        int[] testSizes = {500, 2000, 15000};

        System.out.println("\n+----------------------- Test Cases ------------------------+");
        System.out.printf("| %-22s | %-32s |\n", "Water System Size (kl)", "Health of Diamondback Population");
        System.out.println("+------------------------+----------------------------------+");
        for (int size : testSizes) {
            Individual testIndividual = new Individual(size);
            System.out.printf("| %-22d | %-32.2f |\n", size, testIndividual.fitness);
        }
        System.out.println("+------------------------+----------------------------------+");

        // Run the genetic algo
        GeneticAlgorithm ga = new GeneticAlgorithm(1000000, 0.005, 0.7);
        double previousBestFitness = 0.1;
        double bestFitness;
        int generationCount = 0;
        // Set maximum to prevent infinite loops
        int maxGenerations = 10000;
        // Define how much the fitness should improve to continue
        double fitnessThreshold = 0.01;

        while (generationCount < maxGenerations) {
            ga.evolve();
            bestFitness = ga.getFittestIndividual().fitness;

            // Stop if improvement is less than the threshold
            if (Math.abs(bestFitness - previousBestFitness) < fitnessThreshold) {
                break;
            }

            previousBestFitness = bestFitness;
            generationCount++;
        }

        Individual optimalIndividual = ga.getFittestIndividual();
        System.out.println("\n+------------------- Final Analysis --------------------+");
        System.out.printf("| Optimal water system size: %-26d |\n", optimalIndividual.waterSystemSize);
        System.out.printf("| Health of Diamondback population: %-19.2f |\n", optimalIndividual.fitness);
        System.out.println("+-------------------------------------------------------+");
        System.out.println("| Number of generations processed: " + generationCount + "                    |");
        System.out.println("+-------------------------------------------------------+\n");
    }
}
