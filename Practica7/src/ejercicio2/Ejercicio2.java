package ejercicio2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.common.Streams2;
import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;

public class Ejercicio2 {
	private static final Integer inversionTotal=75, maximoPorProducto=1;
	
	public static void main(String[] args) {
		SolutionPLI alg = AlgoritmoPLI.getSolution(defineProblema("ficheros/Ejercicio2.txt"));
		System.out.println("Coeficientes de la función objetivo:");
		for (int i = 0; i < alg.getNumVar(); i++) {
			System.out.println("x_"+i+" = "+alg.getSolution(i)+"; ");
		}
		System.out.println("Valor resultante: "+alg.getGoal());
	}
	
	private static String defineProblema(String fichero) {
		List<ProductoInversion> datos = cargaDatos(fichero);
		
		//Función Objetivo
		String res = funcionObjetivo(datos);

		//El total invertido en todos los productos no puede superar un máximo
		res = res + inversionMaxima(datos);

		//El máximo a invertir por producto no puede superar el capital requerido 
		res = res + maximoPorProducto(datos.size());//en % ejemplo x0<=1....

		// Sin tipo para las variables (valores reales) 
		return res;
	}
	
	//funcionObjetivo
	private static String funcionObjetivo(List<ProductoInversion> datos) {
		return "max: " + IntStream.range(0, datos.size()).boxed()
				.map(i -> String.format("%d*x%d", datos.get(i).getBeneficio(), i))
				.collect(Collectors.joining("+", "", ";\n"));//(delimitador, prefijo, sufijo)
	}
	//inversionMaxima
	private static String inversionMaxima(List<ProductoInversion> datos) {
		return IntStream.range(0, datos.size()).boxed()
				.map(i -> String.format("%d*x%d",  datos.get(i).getCapital(), i))
		        .collect(Collectors.joining("+", "", String.format(" <= %d;\n", inversionTotal)));
	}
	
	//maximoPorProducto
	private static String maximoPorProducto(int numItems) {
		 return IntStream.range(0, numItems).boxed()
				 .map(i -> String.format("x%d <= %d;", i, maximoPorProducto))
			     .collect(Collectors.joining("\n", "", "\n"));
	}

	//Lectura del fichero de datos
	private static List<ProductoInversion> cargaDatos(String fichero) {
		return Streams2.fromFile(fichero).map(ProductoInversion::create).collect(Collectors.toList());
	}


}
