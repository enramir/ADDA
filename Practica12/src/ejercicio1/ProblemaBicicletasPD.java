package ejercicio1;

import java.util.Arrays;
import java.util.List;

import us.lsi.graphs.GraphView;
import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPD;

public class ProblemaBicicletasPD<V, E> implements 
     ProblemaPD<String, ProblemaBicicletasPD.Alternativa, ProblemaBicicletasPD<V, E>> {
	
	public enum Alternativa{Yes, No};
	
	private int i;
	private int j;
	private int k;
	private GraphView<V,E> grafo;
	
	private ProblemaBicicletasPD(int i, int j, int k, GraphView<V, E> grafo) {
		super();
		this.i = i;
		this.j = j;
		this.k = k;
		this.grafo = grafo;
	}
	
	public static <V, E> ProblemaBicicletasPD<V, E> create(int i, int j, GraphView<V, E> grafo){
		return new ProblemaBicicletasPD<V, E>(i, j, 0, grafo);
	}
	
	public static <V, E> ProblemaBicicletasPD<V, E> create(int i, int j, int k, GraphView<V, E> grafo){
		return new ProblemaBicicletasPD<V, E>(i, j, k, grafo);
		
	}
	
	public boolean esCasoBase() {
		return i == j || k == grafo.getNumVertices();
	}
	
	public Sp<Alternativa> getSolucionParcialCasoBase(){
		Sp<Alternativa> r = null;
		if(i == j) {
			r = Sp.create(Alternativa.No,0.0);
		}else if(grafo.isEdge(i, j)) {
			Double w = grafo.getWeight(i, j);
			r = Sp.create(Alternativa.No,w);
			
		}else {
			r = null;
		}
		return r;
	}
	
	public List<Alternativa> getAlternativas(){
		if(i == k || k == j) {
			return Arrays.asList(Alternativa.No);
		}else {
			return Arrays.asList(Alternativa.values());
		}
	}
	
	public int getNumeroSubProblemas(Alternativa a) {
		return a.equals(Alternativa.No)?1:2;
	}
	
	public ProblemaBicicletasPD<V, E> getSubProblema(Alternativa a, int np){
		ProblemaBicicletasPD<V, E> r = null;
		switch(a) {
		case No : r = ProblemaBicicletasPD.create(i, j, k+1, grafo); break;
		case Yes : 
			switch(np) {
			case 0 : r = ProblemaBicicletasPD.create(i, k, k+1, grafo); break;
			case 1 : r = ProblemaBicicletasPD.create(k, j, k+1, grafo); break;
			default : throw new IllegalArgumentException("El número del subproblema no existe");
			}
		}
		return r;
	}
	
	public Sp<Alternativa> getSolucionParcialPorAlternativa
	                        (Alternativa a, List<Sp<Alternativa>> ls){
		Sp<Alternativa> r = Sp.create(a, ls.get(0).propiedad);
		switch(a) {
		case No : break;
		case Yes : r.propiedad += ls.get(1).propiedad;
		}
		return r;
	}
	
	public String getSolucionReconstruidaCasoBase(Sp<Alternativa> sp) {
		return grafo.getVertice(i) + "<" + sp.propiedad + ">" + grafo.getVertice(j);
	}
	
	public String getSolucionReconstruidaCasoRecursivo(Sp<Alternativa> sp, List<String> ls) {
		
		String r = null;
		switch(sp.alternativa) {
		case No: r = ls.get(0); break;
		case Yes: r = ls.get(0) + ", " + ls.get(1); break;
		}
		return r;
	}
	
	public int size() {
		return grafo.getNumVertices()-k;
	}

	public Tipo getTipo() {
		return Tipo.Min;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		result = prime * result + k;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProblemaBicicletasPD<?, ?> other = (ProblemaBicicletasPD<?, ?>) obj;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		if (k != other.k)
			return false;
		return true;
	}

	public String toString() {
		return "(" + i + "," + j + "," + k + ")";
	}
}
