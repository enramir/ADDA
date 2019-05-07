package ejercicio;

import java.util.HashMap;
import java.util.Map;

import us.lsi.common.Tuple;
import us.lsi.common.Tuple2;

public class SolucionCaballoBT {

	private Map<Tuple2<Integer,Integer>, Integer> tablero;

	public static SolucionCaballoBT create(Map<Tuple2<Integer, Integer>, Integer> tab) {
		return new SolucionCaballoBT(tab)  ;
	}

	private SolucionCaballoBT(Map<Tuple2<Integer,Integer>, Integer> tab) {
		tablero = new HashMap<>(tab);
	}

	public String toString() {
		String s = "";

		int tam = ProblemaCaballo.getLado();

		for(int i=0; i<tam; i++) {
			for(int j=0; j<tam; j++) {
				if(j > 0) {
					s = s + " ";
				}
				Integer v = tablero.get(Tuple.create(i,j));
				if(v != null) {
					if(v < 10)
						s = s + " " + v;
					else
						s = s + v;
				}else {
					s = s + " X";
				}
			}
			s = s + "\n";
		}
		return s;
	}


}
