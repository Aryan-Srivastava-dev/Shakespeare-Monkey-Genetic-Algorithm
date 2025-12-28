package ShakespeareMonkey;
import java.util.Random;

public class DNA {
    char[] genes;
    double fitness;
    static Random rand = new Random();

    public DNA(int geneLength) {
        genes = new char[geneLength];
        for(int i=0; i<geneLength; i++) {
            genes[i] = (char)(rand.nextInt(91) + 32);
        }
    }

    public DNA(DNA other) {
        this.fitness = other.fitness;
        this.genes = other.genes.clone();
    }

    public void mutate(double mutationRate) {
        for(int i=0; i<genes.length; i++) {
            if(rand.nextDouble() < mutationRate) {
                char ch = (char)(rand.nextInt(91) + 32);
                while(ch == genes[i]) {
                    ch = (char)(rand.nextInt(91) + 32);
                }
                genes[i] = ch;
            }
        }
    }
}

