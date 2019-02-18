package p5;

import us.lsi.common.Streams2;
import us.lsi.tiposrecursivos.Tree;
import java.util.stream.IntStream;

public class Ejercicio2 {

	//P2 – (EJ106): Comprobar si dos árboles n-arios son iguales.
	
/*	public static <E> Boolean sonIguales(Tree<E> a1, Tree<E> a2) {
		Boolean res = true;
		switch(a1.getType()) {
		case Empty:
			res = a2.isEmpty();
			break;
		case Leaf:
			res = a2.isLeaf()&& a1.getLabel().equals(a2.getLabel());
			break;
		case Nary:
			res = a2.isNary()&&
			a1.getLabel().equals(a2.getLabel())&&
			Streams2.zip(a1.getChildren().stream(), 
					a2.getChildren().stream(),
					(ab1,ab2)->sonIguales(ab1,ab2).allMatch(x->x==true));
		}
		return res;
	}*/
	
	public static <E> Boolean sonIguales2(Tree<E> a1, Tree<E> a2) {
		Boolean res = null;
		switch(a1.getType()) {
		case Empty:
			res = a2.isEmpty();
			break;
		case Leaf:
			res = a2.isLeaf()&& a1.getLabel().equals(a2.getLabel());
			break;
		case Nary:
			res = a1.getLabel().equals(a2.getLabel())&&
			a1.getNumOfChildren()==a2.getNumOfChildren()&&
			IntStream.iterate(0, x->x<a1.getNumOfChildren(), x->x+1)
			.boxed()
			.map(x->sonIguales2(a1.getChild(x), a2.getChild(x)))
			.reduce(true, Boolean::logicalAnd);
		}
		
		return res;
		
	}
	
}
