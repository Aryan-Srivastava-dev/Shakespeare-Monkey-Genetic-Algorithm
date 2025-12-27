package ShakespeareMonkey;
import java.util.*;

public class Population {
    List<DNA> members;
    int geneLength;
    double mutationRate;
    String target;
    Random rand = new Random();

    public Population(String target, int size, int geneLength, double mutationRate) {
        this.target = target;
        this.geneLength = geneLength;
        this.mutationRate = mutationRate;
        members = new ArrayList<>();
        for(int i=0; i<size; i++) {
            members.add(new DNA(geneLength));
        }
    }

    public void evaluate() {
        for(DNA member: members) {
            member.fitness = Fitness.evaluate(target, member);
        }
    }

    public DNA selectParent() {
        DNA best = null;
        for(int i=0; i<3; i++) {
            DNA candidate = members.get(rand.nextInt(members.size()));
            if(best == null || candidate.fitness > best.fitness)
                best = candidate;
        }

        return best;
    }

    public DNA crossover(DNA p1, DNA p2) {
        int split = rand.nextInt(geneLength);
        DNA child = new DNA(geneLength);
        for(int i=0; i<geneLength; i++) {
            child.genes[i] = (i < split) ? p1.genes[i] : p2.genes[i];
        }

        return child;
    }

    public DNA getBest() {
        DNA best = members.getFirst();
        for(DNA member: members) {
            if(member.fitness > best.fitness)
                best = member;
        }

        return best;
    }

    public void evolve() {
        evaluate();
        List<DNA> nextGen = new ArrayList<>();

        nextGen.add(new DNA(getBest()));

        while(nextGen.size() < members.size()) {
            DNA p1 = selectParent();
            DNA p2 = selectParent();
            DNA child = crossover(p1, p2);
            child.mutate(mutationRate);
            nextGen.add(child);
        }

        members = nextGen;
    }
}
