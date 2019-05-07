package ejercicio4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import us.lsi.common.Streams2;
import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;


public class Ejercicio4 {
	private static int numItems;
	private static final Integer volumenMaximo = 15;

	public static void main(String[] args) {
		SolutionPLI alg = AlgoritmoPLI.getSolution(defineProblema("ficheros/Ejercicio4.txt"));

		System.out.println("Matriz de distribución:");
		for (int i = 1; i <= numItems; i++) {
			for (int j = 0; j < numItems; j++) {
				double x = alg.getSolution()[i * numItems + j];
				System.out.print(Math.round(x) + " ");
			}
			System.out.println();
		}

		System.out.println("Nº de contenedores necesarios: " + alg.getGoal());
		System.out.println("Coeficientes de la función objetivo: "
				+ Arrays.toString(Arrays.copyOfRange(alg.getSolution(), 0, numItems)));
	}

	private static String defineProblema(String fichero) {
		List<ArticuloContenedor> datos = cargaDatos(fichero);
		numItems = datos.size();

		// Función Objetivo
		String res = funcionObjetivo();
		
		// Todo contenedor no puede tener artículos cuyo volumen total supere el máximo
		res+= maximoPorContenedor(datos);

		// Todo artículo debe estar en uno y solo un contenedor
		res+=todosArticulosContenidos();

		// Variables de tipo binario
		res+=tipoVariables();
		
		return res;
	}
	// funcionObjetivo
	private static String funcionObjetivo() {		
		return "min: " + IntStream.range(0, numItems).boxed().map(i -> String.format("y%d", i))
				.collect(Collectors.joining("+", "", ";\n"));
	}
	//maximoPorContenedor
	private static String maximoPorContenedor(List<ArticuloContenedor> datos) {
		return IntStream.range(0, numItems).boxed().map(i->maxContenedor(datos, i)).collect(Collectors.joining("", "", "\n"));
	}	
	private static String maxContenedor(List<ArticuloContenedor> datos, int i) {
		return IntStream.range(0, numItems).boxed()
					.map(j -> String.format("%d*x%d_%d", datos.get(j).getVolumen(), i, j))
					.collect(Collectors.joining("+", "", String.format(" <= %d*y%d;", volumenMaximo, i)));
	}
	//todosArticulosContenidos
	private static String todosArticulosContenidos() {
		return IntStream.range(0, numItems).boxed().map(j->restriccionArticulo(j)).collect(Collectors.joining("", "", "\n"));
	}
	private static String restriccionArticulo(int j) {
		return  IntStream.range(0, numItems).boxed().map(i -> String.format("x%d_%d", i, j))
					.collect(Collectors.joining("+", "", " = 1;"));
	}
	//tipoVariables
	private static String tipoVariables() {
		String res = "bin " + IntStream.range(0, numItems).boxed().map(i -> String.format("y%d", i))
				.collect(Collectors.joining(",", "", ";\n"));
		
		res = res + "bin " + todosParesEnFilas(numItems,numItems).map(p -> String.format("x%d_%d", p.i, p.j))
				.collect(Collectors.joining(",", "", ";\n"));
		
		return res;
	}

	//Lectura del fichero
	private static List<ArticuloContenedor> cargaDatos(String fichero) {
		return Streams2.fromFile(fichero).map(ArticuloContenedor::create).collect(Collectors.toList());
	}
	// La matriz recorrida por filas
	static Stream<Pair> todosParesEnFilas(Integer n, Integer m){
		return IntStream.range(0,n).boxed().flatMap(i->IntStream.range(0,m).mapToObj(j->Pair.of(i, j)));
	}
	// La matriz recorrida por columnas
	static Stream<Pair> todosParesEnColumnas(Integer n, Integer m){
		return IntStream.range(0,n).boxed().flatMap(i->IntStream.range(0,m).mapToObj(j->Pair.of(j, i)));
	}
	// Xij
	private static class Pair {
		Integer i, j;

		public static Pair of(Integer a, Integer b) {
			return new Pair(a, b);
		}

		public Pair(Integer a, Integer b) {
			super();
			this.i = a;
			this.j = b;
		}

	}

}
