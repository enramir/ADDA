package ejercicio3;
import java.util.Arrays;

import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;


public class Ejercicio3 {

	public static void main(String[] args) {
		Integer numItems = 6;
		SolutionPLI alg = AlgoritmoPLI.getSolutionFromFile("ficheros/Ejercicio3.txt");
		
		System.out.println("Matriz de distribución:");
		for (int i = 1; i <= numItems; i++){
			for (int j = 0; j < numItems; j++){
				double x = alg.getSolution()[i*numItems + j];
				System.out.print(Math.round(x) + " ");
			}
			System.out.println();
		}
		
		System.out.println("Nº de contenedores necesarios: "+alg.getGoal());
		System.out.println("Coeficientes de la función objetivo: "+Arrays.toString(Arrays.copyOfRange(alg.getSolution(), 0, numItems)));		
	}
}

