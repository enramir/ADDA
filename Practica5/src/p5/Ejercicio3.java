package p5;

import java.util.Comparator;
import us.lsi.tiposrecursivos.BinaryTree;


public class Ejercicio3 {

	//P3 – (EJ102): Obtener la menor etiqueta de un árbol binario respecto a un orden.
	
	public static <E> E etiquetaMenor(BinaryTree<E> arbol, Comparator<E> cmp){
		E res = null;
		switch(arbol.getType()) {
		case Empty:
			break;
		case Leaf:
			res = arbol.getLabel();
			break;
		case Binary:
			E e1 = etiquetaMenor(arbol.getLeft(), cmp);
			E e2 = etiquetaMenor(arbol.getRight(), cmp);
			res = menor(arbol.getLabel(), menor(e1,e2,cmp),cmp);
		}
		return res;
	}
	

	private static <E> E menor(E e1, E e2, Comparator<E> cmp) {
		if(e1==null) {
			return e2;
		}else if(e2==null) {
			return e1;
		}else {
			return cmp.compare(e1,e2)<=0? e1: e2;
			
		}
	}
}
