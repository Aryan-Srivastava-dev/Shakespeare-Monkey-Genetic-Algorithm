# Shakespeare-Monkey-Genetic-Algorithm
A Java implementation of the Shakespeare's Monkey Genetic Algorithm problem.

# How it works
- Initialization - A random array of characters is created for each member of the population.
- Evaluation - Each member's genes is scored on the basis of how many characters in them are similar to the target string.
- Selection - Parents are selected through Tournament Selection to breed next generation.
- Crossover - Pairs of parents swap genetic material at random split point.
- Mutation - Random character flips to maintain genetic diversity.
- Repeat - The process repeats itself until 100% fitness is achieved for the best member.

# Result
Generation: 44
Mutation Rate: 1.0%
Current best: Thisqis guessable - Machine
Fitness of the best: 0.9629629629629629

Generation: 45
Mutation Rate: 1.0%
Current best: Thisqis guessable - Machine
Fitness of the best: 0.9629629629629629

Generation: 46
Mutation Rate: 1.0%
Current best: This is guessable - Machine
Fitness of the best: 1.0

Target length: 27

# What I learnt
- More the mutation rate, more will be the randomness in the population and hence the fitness will seldom (or never) converge to 1. To deal with this, the mutation rate is generally taken between 0.01 to 0.05 or 1 / geneLength.
- More the population, more will be the diversity to choose from, but it has a limit.
- The Tournament Selection method is better than the bucket/pie selection method since less space consumed and only the best member survives. The tournament selection is done usually between 1 to 5 randomly selected members but the optimal is among 3.
- Code is optimised using less object creation and proper referencing.
