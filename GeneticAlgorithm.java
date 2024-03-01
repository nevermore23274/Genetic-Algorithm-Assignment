public class GeneticAlgorithm {
    int populationSize;
    double mutationRate;
    double crossoverRate;
    Individual[] population;

    public GeneticAlgorithm(int populationSize, double mutationRate, double crossoverRate) {
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
        this.population = new Individual[populationSize];
        initializePopulation();
    }

    private void initializePopulation() {
        for (int i = 0; i < populationSize; i++) {
            // Random size between 1 and 65536
            int randomSize = 1 + (int) (Math.random() * 65536);
            population[i] = new Individual(randomSize);
        }
    }

    public void evolve() {
        Individual[] newPopulation = new Individual[populationSize];

        // elitism: carry over the best individual
        newPopulation[0] = getFittestIndividual();

        for (int i = 1; i < populationSize; i++) {
            Individual parent1 = selectParent();
            Individual parent2 = selectParent();
            Individual offspring = crossover(parent1, parent2);
            mutate(offspring);
            newPopulation[i] = offspring;
        }

        population = newPopulation;
    }

    private Individual selectParent() {
        // Tournament selection
        int tournamentSize = 10;
        Individual best = null;
        for (int i = 0; i < tournamentSize; i++) {
            int randomIndex = (int) (Math.random() * populationSize);
            Individual competitor = population[randomIndex];
            if (best == null || competitor.fitness > best.fitness) {
                best = competitor;
            }
        }
        return best;
    }

    private Individual crossover(Individual parent1, Individual parent2) {
        if (Math.random() < crossoverRate) {
            int midpoint = (parent1.waterSystemSize + parent2.waterSystemSize) / 2;
            midpoint = Math.min(Math.max(midpoint, 1000), 10000);
            return new Individual(midpoint);
        } else {
            return new Individual(parent1.waterSystemSize);
        }
    }

    private void mutate(Individual individual) {
        if (Math.random() < mutationRate) {
            // Random value between -50 and 50
            int mutationAmount = (int) (Math.random() * 100) - 50;
            int newSize = individual.waterSystemSize + mutationAmount;
            newSize = Math.min(Math.max(newSize, 1000), 10000);
            individual.waterSystemSize = newSize;
            individual.fitness = individual.calculateFitness();
        }
    }

    public Individual getFittestIndividual() {
        Individual fittest = population[0];
        for (int i = 1; i < populationSize; i++) {
            if (population[i].fitness > fittest.fitness) {
                fittest = population[i];
            }
        }
        return fittest;
    }
}
