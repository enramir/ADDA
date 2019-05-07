package ejercicio2;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.alg.interfaces.HamiltonianCycleAlgorithm;
import org.jgrapht.alg.interfaces.SpanningTreeAlgorithm;
import org.jgrapht.alg.interfaces.VertexColoringAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.alg.tour.HeldKarpTSP;
import org.jgrapht.graph.SimpleWeightedGraph;

import ejercicio1.Carretera;
import ejercicio1.Ciudad;
import us.lsi.graphs.GraphsReader;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleWeightedGraph<Ciudad,Carretera> grafo = cargaGrafo("./ficheros/Andalucia.txt");
		caminoMasCorto(grafo, "Huelva", "Almeria");
		spanningTree(grafo);
		cicloHamilton(grafo);
		coloreado(grafo);

	}
	private static void coloreado(SimpleWeightedGraph<Ciudad,Carretera> grafo) {
		System.out.println("================COLOREADO================");
		VertexColoringAlgorithm<Ciudad> alg = new GreedyColoring(grafo);
		VertexColoringAlgorithm.Coloring<Ciudad> coloreado = alg.getColoring();
		System.out.println("Nº cromático "+coloreado.getNumberColors());
		System.out.println("Color de cada ciudad: ");
		coloreado.getColors().entrySet().forEach(e->System.out.println(e.getKey()+" ->"+e.getValue()));
		System.out.println("Clases de colores: "+coloreado.getColorClasses());
		
	}
	
	private static void cicloHamilton(SimpleWeightedGraph<Ciudad,Carretera> grafo) {
		System.out.println("================HAMILTON================");
		HamiltonianCycleAlgorithm<Ciudad, Carretera> alg = new HeldKarpTSP<>();
		GraphPath<Ciudad, Carretera> gp = alg.getTour(grafo);
		if(gp!=null) {
			System.out.println("Ruta de ciudades: "+gp.getVertexList());
			System.out.println("Total de kilómetros: "+gp.getWeight());
            System.out.println("Carreteras visitadas: "+gp.getLength());
		}else {
			System.out.println("No se puede");
		}
	}
	
	private static void spanningTree(SimpleWeightedGraph<Ciudad,Carretera> grafo) {
		System.out.println("================ÁRBOL================");
		SpanningTreeAlgorithm<Carretera> alg = new KruskalMinimumSpanningTree<>(grafo);
		SpanningTreeAlgorithm.SpanningTree<Carretera> arbol = alg.getSpanningTree();
		System.out.println("Carreteras: "+arbol.getEdges());
		System.out.println("Total de kilómetros: "+arbol.getWeight());
	}
	
	private static void caminoMasCorto(SimpleWeightedGraph<Ciudad,Carretera> grafo, String origen, String destino) {
		System.out.println("================CAMINO MÁS CORTO================");
		Ciudad from = Ciudad.create(origen);
		Ciudad to = Ciudad.create(destino);
		
		var alg = new DijkstraShortestPath<>(grafo);
		var gp = alg.getPath(from, to);
		System.out.println("La ruta más corta desde "+origen+" hasta "+destino+": "+gp.getVertexList());
		System.out.println("Total de kilómetros: "+gp.getWeight());
		System.out.println("Carreteras visitadas: "+gp.getLength());
		
	}

	private static SimpleWeightedGraph<Ciudad,Carretera> cargaGrafo(String f){
			return GraphsReader.newGraph("./ficheros/Andalucia.txt",
					Ciudad::create, 
					Carretera::create,
					()->new SimpleWeightedGraph<Ciudad,Carretera>(
							Ciudad::create,Carretera::create),
					Carretera::getKms);
	}

}
