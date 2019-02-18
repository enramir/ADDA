package tests;

import ejercicios.Ejercicios;
import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.Tree;

public class Test {

	public static void main(String[] args) {
		/*BinaryTree<Integer> t = BinaryTree.binary(8, BinaryTree.leaf(4), BinaryTree.leaf(9));
		Tree<Integer> t6 = Tree.leaf(2);
		Tree<Integer> t7 = Tree.leaf(3);
		Tree<Integer> t8 = Tree.leaf(4);
		Tree<Integer> t9 = Tree.nary(20,t6,t7,t8);
		BinaryTree<String> t1 = BinaryTree.binary("A", BinaryTree.leaf("B"), BinaryTree.leaf("C"));
		int n = 9;
		
		System.out.println("Suma pares árbol binario = " + Ejercicios.sumaPares(t));
		System.out.println("Suma pares árbol n-ario = " + Ejercicios.sumaPares(t9));
		System.out.println("La lista del árbol binario con sus etiquetas en postOrden es = " 
		+ Ejercicios.recorridoPostOrden(t1));
		System.out.println("La raíz cuadrada de " + n + " es = " + Ejercicios.raizIterativo(n));
		System.out.println("La raíz cuadrada de " + n + " es = " + Ejercicios.raizRecursivo(n));
		System.out.println("La raíz cuadrada de " + n + " es = " + Ejercicios.raizStream(n));
		System.out.println("La raíz cuadrada de " + n + " es = " + Ejercicios.raizIterativoBinaria(n));*/
		Tree<Integer> a1 = Tree.leaf(2);
		Tree<Integer> a2 = Tree.leaf(2);
		Tree<Integer> a3 = Tree.leaf(3);
		Tree<Integer> a4 = Tree.leaf(2);
		Tree<Integer> a5 = Tree.nary(5, a3,a4);
		Tree<Integer> a = Tree.nary(20,a5,a2,a1);
		System.out.println(a);
		System.out.println(Ejercicios.cuentaX(a, 2));
		System.out.println(Ejercicios.NumEtiquetas(a));
		System.out.println(Ejercicios.Altura(a));
	}
}
