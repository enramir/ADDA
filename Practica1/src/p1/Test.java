package p1;

import java.util.ArrayList;
import java.util.List;

import us.lsi.geometria.Punto2D;

public class Test {

	public static void main(String[] args) {
		
		Punto2D p1 = Punto2D.create(1.,2.);
		Punto2D p2 = Punto2D.create(-1.,2.);
		Punto2D p3 = Punto2D.create(1.,-2.);
		Punto2D p4 = Punto2D.create(-1.,-2.);
		Punto2D p5 = Punto2D.create(8.,2.);
		
		List<Punto2D> lista = new ArrayList<>();
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		lista.add(p4);
		lista.add(p5);
		
		var l = Ejercicio2.p2while(lista);
		
		System.out.println(l.toString());
		
		//l = Ejercicio2.p2Java10(lista);
		System.out.println(l.toString());
	}
}
