package p5;

import java.util.Comparator;
import java.util.stream.IntStream;
import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.Tree;

public class Prac5 {

	public static void main(String[] args) {
		Tree<Integer> t1 = Tree.nary(4, Tree.nary(2, Tree.leaf(6)));
		Tree<Integer> t6 = Tree.nary(4, Tree.nary(2, Tree.leaf(4)));
		Tree<Integer> t2 = Tree.empty();
		Tree<Integer> t3 = Tree.nary(1);
		Tree<Integer> t4 = Tree.nary(9, t1,t2,t3);
		//Tree<Integer> t5 = Tree.nary(9, t1,t2,t3);
		BinaryTree<Integer> t = BinaryTree.binary(4, BinaryTree.leaf(1),BinaryTree.binary(6, BinaryTree.leaf(1),BinaryTree.empty()));
		System.out.println(t);
		System.out.println(minEtiq(t, Comparator.naturalOrder()));

		System.out.println(t1);
		System.out.println(contieneEtiq(t4, 1));
		System.out.println(soniguales(t1, t6));
	}
	//P1 – (EJ104): Determinar si un árbol n-ario contiene una etiqueta dada.
	public static <T> boolean contieneEtiq(Tree<T> t,T s) {
		Boolean res = null;
		switch(t.getType()) {
		case Empty:
			res = false;
			break;
		case Leaf:
			res = t.getLabel().equals(s);
			break;
		case Nary:
			res = t.getLabel().equals(s);
			if(!res) {
				res = t.getChildren().stream().anyMatch(x->contieneEtiq(x, s));
			}
			break;
		}

		return res;
	}
	//P2 – (EJ106): Comprobar si dos árboles n-arios son iguales.
	public static <T> boolean soniguales(Tree<T> t1, Tree<T> t2) {
		Boolean res = null;
		switch(t1.getType()) {
		case Empty:
			res = t2.isEmpty();
			break;
		case Leaf:
			res = t2.isLeaf();
			if(res) {
				res = t2.getLabel().equals(t1.getLabel());
			}
			break;
		case Nary:
			res = t2.isNary();
			if(res) {
				res = t2.getLabel().equals(t1.getLabel());
			}
			if(res) {
				res = t1.getNumOfChildren() == t2.getNumOfChildren();

			}
			if(res) {
				res = IntStream.range(0, t1.getNumOfChildren()).allMatch(i->soniguales(t1.getChild(i),t2.getChild(i)));
			}
			break;
		}

		return res;
	}

	//P3 – (EJ102): Obtener la menor etiqueta de un árbol binario respecto a un orden.
	public static <T> T minEtiq(BinaryTree<T> t,Comparator<T> ord){
		T res = null;

		switch(t.getType()) {
		case Empty:
			res = null;
			break;
		case Leaf:
			res = t.getLabel();
			break;
		case Binary:
			res = t.getLabel();
			res = min(res,minEtiq(t.getLeft(),ord),ord);
			res = min(res,minEtiq(t.getRight(),ord),ord);

			break;

		}
		return res;
	}
	private static <T> T min(T a, T b, Comparator<T>ord){
		if(a == null) return b;
		if(b == null) return a;
		if(ord.compare(a, b) < 0) {
			return a ;
		}
		return b;

	}
}
