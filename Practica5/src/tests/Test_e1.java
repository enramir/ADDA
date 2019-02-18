package tests;

import java.util.ArrayList;
import java.util.List;
import p5.Ejercicio1;
import us.lsi.tiposrecursivos.Tree;
import us.lsi.tiposrecursivos.*;
import us.lsi.regularexpressions.*;
import us.lsi.math.*;
import us.lsi.common.*;
import us.lsi.basictypes.*;

public class Test_e1 {

	public static void main(String[] args) {
		
		var arboles = trees();
		
		//Ejercicio 1
		arboles.forEach(a->{
			System.out.println("Dado el Árbol <"+a+">:");
			System.out.println("\t-> ¿Contiene 4? = "+Ejercicio1.contieneEtiqueta(a, 4));
			
		});

	}
	

    private static List<Tree<Integer>> trees(){
		var res = new ArrayList<Tree<Integer>>();
		
		Tree<Integer> t1 = Tree.empty();
		Tree<Integer> t2 = Tree.leaf(2);
		Tree<Integer> t3 = Tree.leaf(3);
		Tree<Integer> t4 = Tree.leaf(4);
		Tree<Integer> t5 = Tree.nary(27, t2,t3,t4);
		Tree<Integer> t6 = Tree.nary(39, t2,t5);
		return res;
	}

}
