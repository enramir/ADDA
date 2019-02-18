package tests;

import p5.Ejercicio2;
import us.lsi.tiposrecursivos.Tree;

public class Test_e2 {

	public static void main(String[] args) {
		
		Tree<Integer> t1 = Tree.leaf(20);
		Tree<Integer> t2 = Tree.leaf(32);
		Tree<Integer> t3 = Tree.leaf(45);
		Tree<Integer> t4 = Tree.nary(20,t1,t2,t3);
		Tree<Integer> t5 = Tree.nary(39,t2,t3);
		
		//System.out.println("¿Son iguales? "+Ejercicio2.sonIguales(t4, t5));
		System.out.println("¿Son iguales? "+Ejercicio2.sonIguales2(t4, t5));
		
		Tree<Integer> t6 = Tree.leaf(2);
		Tree<Integer> t7 = Tree.leaf(3);
		Tree<Integer> t8 = Tree.leaf(4);
		Tree<Integer> t9 = Tree.nary(20,t6,t7,t8);
		Tree<Integer> t10 = Tree.nary(7,t6,t7,t8);
		
		//System.out.println("¿Son iguales? "+Ejercicio2.sonIguales(t9, t10));
		System.out.println("¿Son iguales? "+Ejercicio2.sonIguales2(t9, t10));
	}

}
