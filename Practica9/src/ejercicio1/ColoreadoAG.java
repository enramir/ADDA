package ejercicio1;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleWeightedGraph;

import us.lsi.ag.ValuesInRangeChromosome;
import us.lsi.ag.ValuesInRangeProblemAG;
import us.lsi.common.Lists2;
import us.lsi.common.Maps2;
import us.lsi.common.Sets2;
import us.lsi.graphs.GraphsReader;


public class ColoreadoAG implements ValuesInRangeProblemAG<Integer,Map<Ciudad,Integer>> {

	public static Graph<Ciudad,Carretera> grafo;
	public static List<Ciudad> ciudades;
	
	public static void cargaDatos(String fichero) {
	 grafo = GraphsReader.newGraph(fichero,
				Ciudad::create,
				Carretera::create,
				()-> new SimpleWeightedGraph<Ciudad, Carretera>(Carretera.class), 
				Carretera::getKm);
	 
	 ciudades = Lists2.newList(grafo.vertexSet());
	}

	
	public Integer getVariableNumber() {
		return ciudades.size();
	}

	
	public Integer getMax(Integer i) {
		return ciudades.size()-1;
	}

	
	public Integer getMin(Integer i) {
		return 0;
	}

	public Double fitnessFunction(ValuesInRangeChromosome<Integer> cr) {
		Map<Ciudad,Integer> mps = getSolucion(cr);
		Double NCOLORES = (double) Sets2.newSet(mps.values()).size();
		Double RKO = (double)grafo.edgeSet().stream().filter(e->mps.get(e.getSource())==mps.get(e.getTarget())).count();
		Double fitness = -NCOLORES - 1000001 * (RKO * RKO);//Un numero grande da igual cual sea
		return fitness; // un menos delante de NCOLORES para minimizar
		
	}

	public Map<Ciudad,Integer> getSolucion(ValuesInRangeChromosome<Integer> cr) {
		List<Integer> solucion = cr.decode();
		Map<Ciudad,Integer> mps = Maps2.newHashMap();
		IntStream.range(0,solucion.size()).forEach(i -> mps.put(ciudades.get(i), solucion.get(i)));
		return mps;
	}

}