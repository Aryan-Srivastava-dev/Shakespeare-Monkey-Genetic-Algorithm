package ShakespeareMonkey;

public class Fitness {
    public static double evaluate(String target, DNA member) {
        double fitness = 0;
        for(int i=0; i<target.length(); i++) {
            if(target.charAt(i) == member.genes[i])
                fitness++;
        }

        return fitness / target.length();
    }
}
