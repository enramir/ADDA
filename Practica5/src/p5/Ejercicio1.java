package p5;

import us.lsi.tiposrecursivos.Tree;

public class Ejercicio1 {

	
	//P1 – (EJ104): Determinar si un árbol n-ario contiene una etiqueta dada.
	public static <E> Boolean contieneEtiqueta(Tree<E> arbol, E etiq) {
		Boolean res = null;
		switch(arbol.getType()) {
		case Empty:
			res = false;
			break;
		case Leaf:
			res = arbol.getLabel().equals(etiq);
			break;
		case Nary:
			res = arbol.getLabel().equals(etiq) || 
			arbol.getChildren().stream().anyMatch(a->contieneEtiqueta(a,etiq));
	    }
		return res;
	}
	
	

}
   