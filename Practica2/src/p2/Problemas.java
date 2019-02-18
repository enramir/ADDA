package p2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problemas {
	
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		
		l1.add(2);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		
		l2.add(5);
		l2.add(5);
		l2.add(11);
		l2.add(9);

		System.out.println(ListaCuadradosPrimos(10));
		System.out.println(ListaCuadradosPrimosWhile(10));
		System.out.println(MismoSignoDif(l1,l2));
		System.out.println(ListaCuadradosPrimosRecursiva(10));
		//System.out.println(MismoSignoDifWhile(l1,l2));

	}
	
	//Problema 1-----------------------------------------
	
	//Iterativo // Generar la lista de los cuadrados de los números primos hasta un número dado.
	public static List<Integer> ListaCuadradosPrimosWhile(Integer n){
		List<Integer> res = new ArrayList<>();
		Integer i = 1;
		while(i <= n) {
			if (esPrimo(i)) {
				res.add(i * i);
			}
			i++;
		}
		return res;
		
	}
	//Java10 // Generar la lista de los cuadrados de los números primos hasta un número 'n' dado.
	public static List<Integer> ListaCuadradosPrimos(Integer n){ 
		return IntStream.rangeClosed(2,n).filter(x->esPrimo(x))
				.mapToObj(x -> (x*x)).collect(Collectors.toList());
	}
	
	//Recursiva // Generar la lista de los cuadrados de los números primos hasta un número 'n' dado.
	
	public static List<Integer> ListaCuadradosPrimosRecursiva(int n){
		return ListaCuadradosPrimosRecursiva(1, n, new ArrayList<>());
	}
	
	private static List<Integer> ListaCuadradosPrimosRecursiva(int i, int n, List<Integer> res){
		if(i>n) {
			return res;
		}else {
			if(esPrimo(i)) {
				res.add(i * i);
			}
		}
		return ListaCuadradosPrimosRecursiva(i+1, n, res);
	}
	
	
	//Problema 2---------------------------------------------
	
	//Iterativo
	/*public static Boolean MismoSignoDifWhile(List<Integer> l1, List<Integer> l2) {
		
	}
	*/
	//Java 10
	public static Boolean MismoSignoDif(List<Integer> l1, List<Integer> l2){
		//Range -> [1,2,....., ls.size()-1]
		return IntStream.range(1, l1.size()).allMatch(
				x-> (l1.get(x)- l1.get(x-1))* (l2.get(x)- l2.get(x-1))> 0 ||      
				(l1.get(x)-l1.get(x-1) == 0 && (l2.get(x)-l2.get(x-1))==0));
				
	}
	
	public static boolean esPrimo(Integer n) { //Decidir si un número n es primo.
		Integer i = 2;
		Boolean res = true;
		while(i < n && res) {
			if(n % i != 0) {
				i++;
			}else {
				res = false;
			}
			
		}
		return res;
		
	}

}
