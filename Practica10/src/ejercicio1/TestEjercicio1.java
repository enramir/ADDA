package ejercicio1;

import java.util.Arrays;

import us.lsi.pd.AlgoritmoPD;

public class TestEjercicio1 {

	public static void main(String[] args) {
		
		AlgoritmoPD.isRandomize = false;
		Ejercicio1 p = Ejercicio1.create(Arrays.asList(2,0,5,4,1,0));
		var a = AlgoritmoPD.createPDR(p);
		a.ejecuta();
		
		if(a.getSolucion() == null) {
			System.out.println("No hay solución");
		} else {
			System.out.println("Solución: " + a.getSolucion());
			System.out.println("Nº de saltos: " + a.getSolucion().size());
		}
	}

}
