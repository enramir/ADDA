package ejercicio1;

import java.util.Map;

import org.jgrapht.graph.SimpleWeightedGraph;

import us.lsi.ag.ValuesInRangeChromosome;
import us.lsi.ag.ValuesInRangeProblemAG;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.graphs.GraphsReader;

public class TestColoreadoAG {
	public static void main(String[] args) {
		
		AlgoritmoAG.ELITISM_RATE  = 0.30;
		AlgoritmoAG.CROSSOVER_RATE = 0.8;
		AlgoritmoAG.MUTATION_RATE = 0.7;
		AlgoritmoAG.POPULATION_SIZE = 50;
		
		StoppingConditionFactory.NUM_GENERATIONS = 100;
		StoppingConditionFactory.SOLUTIONS_NUMBER_MIN = 1;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionFactory.StoppingConditionType.SolutionsNumber;
		
		SimpleWeightedGraph<Ciudad,Carretera> fichero =  
				GraphsReader.newGraph("ficheros/Andalucia.txt",
						Ciudad::create, 
						Carretera::create,
						()->new SimpleWeightedGraph<Ciudad,Carretera>(
								Ciudad::create,Carretera::create),
						Carretera::getKm);
		
		ValuesInRangeProblemAG<Integer, Map<Ciudad,Integer>> p = new ColoreadoAG();
		
		AlgoritmoAG<ValuesInRangeChromosome<Integer>> ap = AlgoritmoAG.create(ChromosomeType.Range,p);
		ap.ejecuta();
		
		Map<Ciudad, Integer> solucion = p.getSolucion(ap.getBestChromosome());
		 System.out.println("Número cromático-->" + solucion);
		
		
	}

}