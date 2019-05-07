package test;

import ejercicio1.ProblemaBicicletas;
import ejercicio1.ProblemaBicicletasPD;
import tipos.Calle;
import tipos.Estacion;
import us.lsi.graphs.GraphView;
import us.lsi.pd.AlgoritmoPD;

public class TestBicicletasPD {

	public static void main(String[] args) {

		ProblemaBicicletas s = ProblemaBicicletas.create("ficheros/mapa.txt");
		GraphView<Estacion, Calle> grafo = GraphView.create(s.getGrafo());
		

		int i = grafo.getIndex(new Estacion("Estacion0"));
		int j = grafo.getIndex(new Estacion("Estacion3"));

		ProblemaBicicletasPD<Estacion, Calle> problema = ProblemaBicicletasPD.create(i, j, grafo);

		var alg = AlgoritmoPD.createPD(problema);
		alg.ejecuta();
		
		System.out.println(alg.getSolucion());

	}

}
