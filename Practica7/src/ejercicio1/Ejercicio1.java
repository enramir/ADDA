package ejercicio1;

import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;

public class Ejercicio1 {

	public static void main(String[] args) {
		SolutionPLI alg = AlgoritmoPLI.getSolutionFromFile("ficheros/Ejercicio1.txt");
		System.out.println("Coeficientes de la función objetivo:");	

		for (int i = 0; i < alg.getNumVar(); i++) {
			System.out.println("x_" + i + " = " + alg.getSolution(i) + ";");
		}
		System.out.println("Valor resultante: " + alg.getGoal());
		
	}
}
