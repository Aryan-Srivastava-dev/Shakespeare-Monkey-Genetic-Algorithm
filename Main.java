package ShakespeareMonkey;

public class Main {
    public static void main(String[] args) {
        String target = "This is guessable - Machine";
        int popSize = 1000;
        int geneLength = target.length();
        double mutationRate = 0.01;
        int gen = 1;

        Population pop = new Population(target, popSize, geneLength, mutationRate);
        pop.evaluate();

        while(pop.getBest().fitness < 1.0) {
            pop.evolve();
            DNA best = pop.getBest();
            System.out.println("Generation: " + gen++);
            System.out.println("Mutation Rate: " + (mutationRate * 100) + "%");
            System.out.println("Current best: " + String.valueOf(best.genes));
            System.out.println("Fitness of the best: " + best.fitness);
            System.out.println();
        }

        System.out.println("Target length: " + target.length());
    }
}
