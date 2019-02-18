package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.Tree;

public class Ejercicios {
	//EJERCICIO1

	//Suma de las etiquetas del árbol(binario)que son pares(asumiendo que son de tipo entero).(Java) 
	public static int sumaPares(BinaryTree<Integer> t) {
		int res = 0;
		switch(t.getType()) {
		case Empty:
			break;
		case Leaf:
			if(t.getLabel()%2==0) {
				res = t.getLabel();
			}
			break;
		case Binary:
			if(t.getLabel()%2==0) {
				res = t.getLabel();
			}
			res = res + sumaPares(t.getLeft()) + sumaPares(t.getRight());
			break;
		}
		return res;
	}

	//Suma de las etiquetas del árbol(n-ario)que son pares(asumiendo que son de tipo entero).(Java) 
	public static int sumaPares(Tree<Integer> t) {
		int res = 0;
		switch(t.getType()) {
		case Empty:
			break;
		case Leaf:
			if(t.getLabel()%2==0) {
				res = t.getLabel();
			}
			break;
		case Nary:
			if(t.getLabel()%2==0) {
				res = t.getLabel();
			}
			res = res + t.getChildren().stream().mapToInt(x->sumaPares(x)).sum();

		}
		return res;

	}

	//EJERCICIO2
	public static <E> List<E> recorridoPostOrden(BinaryTree<E> t){
		List<E> res = new ArrayList<>();
		switch(t.getType()) {
		case Empty:
			break;
		case Leaf:
			res.add(t.getLabel());
			break;
		case Binary:
			res.addAll(recorridoPostOrden(t.getLeft()));
			res.addAll(recorridoPostOrden(t.getRight()));
			res.add(t.getLabel());
			break;
		}
		return res;
	}

	public static int raizIterativo(int a) {
		int n = 0;
		int res = 0;
		
		while(n*n<=a) {
			res = n;
			n++;
		}
		return res;

	}

	public static int raizRecursivo(int a) {
		return raizRecursividad(a,0,0);

	}
	private static int raizRecursividad(int a, int r, int n) {
	    int res = 0;
		if(!(n*n<=a)) {
			res = r;
		} else {
			r = n;
			n = n+1;
			raizRecursividad(a,r,n);
		}
		return res;
	}

	public static int raizStream(int a) {
		List<Integer> ls = IntStream.rangeClosed(0, a)
				.filter(n->n*n<=a)
				.boxed()
				.collect(Collectors.toList());
		return ls.get(ls.size()-1);

	}
	
	public static int raizIterativoBinaria(int a) {
		int i = 1;
		int j = a;
		int res = 1;
		
		while(!(j-i<=0)) {
			int n = (i+j)/2;
			if(n*n<=a) {
				res = n;
				i = n+1;
			} else {
				j=n;
			}
			
		}
		return res;

	}
	//Utilice tipos genéricos para implementar la función cuentaX(t, x) 
	//dicha función cuenta el número de veces que el elemento x se repite en el árbol t.
	//1ºPARCIAL 17/18
	public static <E> Integer cuentaX(Tree<E> t, E x) {
		Integer res = 0;
		switch(t.getType()) {
		case Empty:
			break;
		case Leaf:
			if(t.getLabel().equals(x)) {
				res = res + 1;
			}
			break;
		case Nary:
			if(t.getLabel().equals(x)) {
				res = res + 1;
			}
			for(int i = 0; i<t.getNumOfChildren(); i++) {
				res = res + cuentaX(t.getChild(i),x);
			}
			break;
		}
		return res;
	}
	//Ejercicio100
	public static <T> Integer NumEtiquetas(Tree<T> t) {
		Integer res = 1;
		switch(t.getType()) {
		case Empty:
			break;
		case Leaf:
			break;
		case Nary:
			for(int i=0; i<t.getNumOfChildren(); i++) {
				res = res + NumEtiquetas(t.getChild(i));
			}
		}
		return res;
	}
	//Calcular la altura de un árbol dado(t).Ejercicio 103
	public static <T> Integer Altura(Tree<T> t) {
		Integer r = 1;
		Integer a = 0;
		switch(t.getType()) {
		case Empty:
			r = 0;
			break;
		case Leaf:
			break;
		case Nary:
			for(int i=0; i<t.getNumOfChildren(); i++) {
				Integer s = r + Altura(t.getChild(i));
				if(a.compareTo(s)<0) {
					a = s;
				}
			}
			r = a;
		}
		return r;
	}
	
	
}
