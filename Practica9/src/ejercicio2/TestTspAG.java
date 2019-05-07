package ejercicio2;

import java.util.List;

import us.lsi.ag.IndexChromosome;
import us.lsi.ag.IndexProblemAG;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agstopping.StoppingConditionFactory;

public class TestTspAG {
	private static final String fichero = "./ficheros/TSP.txt";

	public static void main(String[] args) {
		setCondiciones();
		
		IndexProblemAG<List<Ciudad>> problem = new ProblemTspAG(fichero);
		AlgoritmoAG<IndexChromosome> alg = 
				AlgoritmoAG.<IndexChromosome>create(ChromosomeType.IndexPermutation,problem);
		
		alg.ejecuta();
		IndexChromosome sol = alg.getBestChromosome();
		System.out.println("Ciclo encontrado:");
		System.out.println(problem.getSolucion(sol));
		System.out.println("Coste del ciclo: "+problem.fitnessFunction(sol)*-1);
    }
	
	private static void setCondiciones() {
		//Condiciones evolutivas
		AlgoritmoAG.CROSSOVER_RATE = 0.8;
		AlgoritmoAG.MUTATION_RATE = 0.5;
		AlgoritmoAG.ELITISM_RATE = 0.25;
		AlgoritmoAG.POPULATION_SIZE = 300;
		
		//Condiciones de parada
		StoppingConditionFactory.FITNESS_MIN=.0;
		StoppingConditionFactory.NUM_GENERATIONS=1000;
		StoppingConditionFactory.SOLUTIONS_NUMBER_MIN=3;
	}

}
