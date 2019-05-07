package ejercicio2;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleWeightedGraph;

import us.lsi.ag.IndexChromosome;
import us.lsi.ag.IndexProblemAG;
import us.lsi.graphs.GraphsReader;

public class ProblemTspAG implements IndexProblemAG<List<Ciudad>> {

	private static Graph<Ciudad, Carretera> grafo;
	private static List<Ciudad> ciudades;
	private static Double TOTAL_KMS; //Penalizamos caminos 

	public ProblemTspAG(String ficheroGrafo) {
		grafo = cargaGrafo(ficheroGrafo);
		ciudades = new ArrayList<>(grafo.vertexSet());
		TOTAL_KMS = grafo.edgeSet().stream().mapToDouble(Carretera::getKm).sum();

	}
	private static Graph<Ciudad, Carretera> cargaGrafo(String f) {
		return GraphsReader.newGraph(f, Ciudad::create, Carretera::create, 
				()-> new SimpleWeightedGraph<>(Ciudad::create, Carretera::create),Carretera::getKm);

	}
	public Integer getObjectsNumber() {
		return ciudades.size();

	}
	public List<Ciudad> getSolucion(IndexChromosome chromosome){
		List<Integer> ciudadesCromosoma = chromosome.decode();
		List<Ciudad> res = new ArrayList<>();
		ciudadesCromosoma.forEach(i->res.add(ciudades.get(i)));
		res.add(res.get(0));
		return res;
	}

	public Double fitnessFunction(IndexChromosome cromosoma) {
		List<Ciudad> solucion = getSolucion(cromosoma);
		return -coste(solucion);

	}
	private Double coste(List<Ciudad> solucion) {
		Double res = .0;
		for(int i=0; i<solucion.size()-1; i++) {
			if(grafo.containsEdge(solucion.get(i), solucion.get(i+1))) {
				res+=grafo.getEdge(solucion.get(i), solucion.get(i+1)).getKm();
			}else {
				res+=TOTAL_KMS;
			}
		}
		return res;
	}
	
}




