package p4;

import java.util.stream.Stream;

public class Problema1 {

	public static void main(String[] args) {
		Integer[] v = {-1,0,2,5,7,8,10};
		System.out.println("El v[k]=k: " +busquedaI(v));
		System.out.println("El v[k]=k: " +busquedaR(v));
		System.out.println("El v[k]=k: " +busquedaF(v));

	}
	/*La complejidad logaritmica se caracteriza porque no pasa por todos los elementos
	 * Por ejemplo multiplicar o dividir
	 * 
	 * suponer {-1,0,1,3,7,10,15}
	 * 
	 * DEVUELVE SI EL VALOR ES IGUAL A LA POSICION
	 * 
	 */
	
	//Buscar una solución iterativa (usando while) 
	public static Integer busquedaI(Integer[] v) {  
		int i = 0;
		int j = v.length;
		int k = (i+j)/2;
		while(v[k]!=k && i!=j) {
			if(k<v[k]) {
				j = k;
			}else {
				i = k+1;
			}
			k = (i+j)/2; 
		}
		if(v[k]!=k) {
			k=-1;

		}
		return k;

	}
	
	//Buscar una solución funcional (usando streams de Java) 
	private static class Tupla {
		public int i, j, k;
		public Tupla(int a, int b, int c) {
			this.i = a; this.j = b; this.k = c;
		}
	}
	public static Integer busquedaF(Integer[] v) {
		Tupla semilla = new Tupla(0, v.length,  v.length/2);
		return Stream.iterate(semilla,t->siguiente(t,v))
				.limit((long) (1 + (Math.log(v.length)/Math.log(2))))
				.dropWhile(t->v[t.k]!=t.k)
				.findFirst().orElse(new Tupla(0,0,-1)).k;
	}
	
	private static Tupla siguiente(Tupla t, Integer[] v) {
		if(v[t.k]>t.k)
			return new Tupla(t.i,t.k,(t.i+t.k)/2);
		else
			return new Tupla(t.k+1,t.j,(t.k+1+t.j)/2);
		
	}
	
	//Buscar una solución recursiva lineal 
	public static Integer busquedaR(Integer[] v) {
		return busquedaR(v, 0, v.length, v.length/2);
	}
	private static Integer busquedaR(Integer[] v , int i , int j, int k) {
		int res;
		if(v[k] == k) {
			res = k;
		}
		else if(i==j) {
			res = -1;
		}
		else if(k < v[k]) {
			res = busquedaR(v, i, k, (i+k)/2);
		}
		else {
			res = busquedaR(v, k+1, j, (k+1+j)/2);
		}
	

	return res;

}

}


