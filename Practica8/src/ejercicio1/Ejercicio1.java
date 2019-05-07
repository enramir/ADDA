package ejercicio1;

import java.io.PrintWriter;

import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.io.DOTExporter;
import org.jgrapht.io.IntegerComponentNameProvider;

import us.lsi.common.Files2;
import us.lsi.graphs.GraphsReader;


public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleWeightedGraph<Ciudad,Carretera> grafo =  
				GraphsReader.newGraph("./ficheros/Andalucia.txt",
						Ciudad::create, 
						Carretera::create,
						()->new SimpleWeightedGraph<Ciudad,Carretera>(
								Ciudad::create,Carretera::create),
						Carretera::getKms);
						
		DOTExporter<Ciudad,Carretera> de = new DOTExporter<Ciudad,Carretera>(
				new IntegerComponentNameProvider<>(),
				x->x.getNombre(), 
				x->x.getNombre()+"--"+x.getKms()+" kms");
		
		
		PrintWriter pw = Files2.getWriter("./ficheros/Andalucia.gv");
		de.exportGraph(grafo, pw);
	}

}
