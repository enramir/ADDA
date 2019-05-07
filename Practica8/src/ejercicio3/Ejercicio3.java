package ejercicio3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;


public class Ejercicio3 {
	
	public static void main(String[] args) {
		Graph<String, DefaultEdge> g = new SimpleDirectedGraph<String,DefaultEdge>(DefaultEdge.class);
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		
		g.addEdge("A", "B");
		g.addEdge("B", "C");
		
		Graph<String, DefaultWeightedEdge> g1 = new DefaultDirectedWeightedGraph<String,DefaultWeightedEdge>(DefaultWeightedEdge.class);
		g1.addVertex("A");
		g1.addVertex("B");
		g1.addVertex("C");
		
		g1.addEdge("A", "B");
		g1.addEdge("B", "C");
		
		g1.setEdgeWeight(g1.getEdge("A", "B"),3);
		g1.setEdgeWeight(g1.getEdge("B", "C"),3);
		System.out.println(g);
		System.out.println(g1);
		System.out.println(g1.getEdgeWeight(g1.getEdge("A", "B")));
		
		Graph<Integer,DefaultEdge> g2 = new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
		for(int i=1; i<=100; i++) { //creo 100 vértices
			g2.addVertex(i);
		}
		for(int i=1; i<=100; i++) {
			for(int j=i+1; j<=100; j++) {
				g2.addEdge(i, j);
			}
		}
		System.out.println(":" + g2);
		
		Graph<String,DefaultEdge> g3 = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
		
		g3.addVertex("A");
		g3.addVertex("B");
		g3.addVertex("C");
		g3.addVertex("D");
		g3.addVertex("E");
		g3.addVertex("F");
		
		g3.addEdge("A", "B");
		g3.addEdge("B", "D");
		g3.addEdge("B", "C");
		g3.addEdge("B", "E");
		g3.addEdge("C", "F");
		g3.addEdge("E", "F");
		
		System.out.println(g3);
		
		Iterator<String> itAnchura = new BreadthFirstIterator<String, DefaultEdge>(g3,"A");
		List<String> ls = new ArrayList<>();
		itAnchura.forEachRemaining(v->ls.add(v));
		/*while(itAnchura.hasNext()) {
			String v = itAnchura.next();
			ls.add(v);
		}*/ //Se puede hacer de las dos formas
		System.out.println(ls);
		
	}
	


}
