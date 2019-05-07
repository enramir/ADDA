package ejercicio1;

import us.lsi.graphs.GraphsReader;
import java.util.function.Supplier;
import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import tipos.Calle;
import tipos.Estacion;


public class ProblemaBicicletas {

	
	public static ProblemaBicicletas create(String fichero) {
		return new ProblemaBicicletas(fichero);
	}

	private Graph<Estacion,Calle> grafo;		
	
	private ProblemaBicicletas(String fichero) {
		super();
		leeDatos(fichero);		
	}

	public void leeDatos(String fichero){	
		Supplier<Graph<Estacion,Calle>> factoriaGrafos = () -> new SimpleDirectedWeightedGraph<Estacion,Calle>(Estacion::create, Calle::create);
		grafo = GraphsReader.newGraph(fichero, Estacion::create, Calle::create, factoriaGrafos, Calle::getWeight);

		
		for(Calle c: grafo.edgeSet()){
			grafo.setEdgeWeight(c, c.getMinutos());
		}		
	}

	public Graph<Estacion, Calle> getGrafo() {
		return grafo;
	}	
	
}
