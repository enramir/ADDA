package p1;

import java.util.Iterator;
import java.util.List;

import us.lsi.common.ListMultimap;
import us.lsi.geometria.Punto2D;
import us.lsi.geometria.Punto2D.Cuadrante;

public class Ejercicio2 {

	public static ListMultimap<Cuadrante,Punto2D> p2while(List<Punto2D> lista){
		
		//variable de salida
		ListMultimap<Cuadrante,Punto2D> res = new ListMultimap<Cuadrante,Punto2D>();
		
		// utilizar iterator
		Iterator<Punto2D> it1 = lista.iterator();
		
		//variable aux
		Punto2D paux = null;
		
		//bucle while
		while(it1.hasNext()) {
			paux=it1.next();
			
			res.put(paux.getCuadrante(), paux);
			
		}
		
		return res;
	}
	
	/*public static ListMultimap<Cuadrante,Punto2D> p2Java10(List<Punto2D> lista){
		//variable de salida
		ListMultimap<Cuadrante,Punto2D> res =new ListMultimap<Cuadrante,Punto2D>(){
			
		}
	}*/
	
}
