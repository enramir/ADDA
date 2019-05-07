package ejercicio3;
import java.util.Arrays;

import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;


public class Ejercicio3 {

	public static void main(String[] args) {
		Integer numItems = 6;
		SolutionPLI alg = AlgoritmoPLI.getSolutionFromFile("ficheros/Ejercicio3.txt");
		
		System.out.println("Matriz de distribuci�n:");
		for (int i = 1; i <= numItems; i++){
			for (int j = 0; j < numItems; j++){
				double x = alg.getSolution()[i*numItems + j];
				System.out.print(Math.round(x) + " ");
			}
			System.out.println();
		}
		
		System.out.println("N� de contenedores necesarios: "+alg.getGoal());
		System.out.println("Coeficientes de la funci�n objetivo: "+Arrays.toString(Arrays.copyOfRange(alg.getSolution(), 0, numItems)));		
	}
}

