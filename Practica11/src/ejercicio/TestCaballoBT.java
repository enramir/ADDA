package ejercicio;

import us.lsi.bt.AlgoritmoBT;

public class TestCaballoBT {

	public static void main(String[] args) {
		
		AlgoritmoBT.numeroDeSoluciones = 2;
		AlgoritmoBT.isRandomize = false;
		
		ProblemaCaballo.setLado(6);
		ProblemaCaballo.setIposx(1);
		ProblemaCaballo.setIposy(1);
		
		Estado_Caballo estadoInicial = Estado_Caballo.create();
		AlgoritmoBT<SolucionCaballoBT, Integer, Estado_Caballo> alg = AlgoritmoBT.create(estadoInicial);
		alg.ejecuta();
		
		if(alg.getSoluciones().isEmpty()) {
			System.out.println("No se encuentra alguna solución.");
			
		}else {
			int i = 1;
			for(SolucionCaballoBT sol: alg.getSoluciones()) {
				System.out.println("Solución nº "+(i++)+"\n"+sol);
			}
		}

	}

}
