package ejercicio1;

import java.util.ArrayList;
import java.util.List;

import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPDR;

public class Ejercicio1 implements ProblemaPDR<List<Integer>, Integer, Ejercicio1> {
	
	private Integer posActual;
	private List<Integer> numeros;
	
	public static Ejercicio1 create(List<Integer> numeros) {
		return new Ejercicio1(numeros);
	}

	private Ejercicio1(List<Integer> numeros) {
		super();
		this.posActual = 0;
		this.numeros = numeros;
	}
	
	public Ejercicio1 clone() {
		Ejercicio1 newProblem = new Ejercicio1(this.numeros);
		return newProblem;
	}


	@Override
	public Tipo getTipo() {
		return Tipo.Min;
	}

	@Override
	public int size() {
		return numeros.size() - posActual - 1;
	}

	@Override
	public boolean esCasoBase() {
		return ((this.numeros.size() - 1) == this.posActual);
	}

	@Override
	public Sp<Integer> getSolucionParcialCasoBase() {
		return Sp.create(0, 0.);
	}

	@Override
	public Ejercicio1 getSubProblema(Integer a) { //Las alterntivas son los saltos que puede dar
		Ejercicio1 newProblem = this.clone();
		newProblem.posActual = this.posActual + a;
		return newProblem;
	}

	@Override
	public Sp<Integer> getSolucionParcialPorAlternativa(Integer a, Sp<Integer> s) {
		return Sp.create(a, s.propiedad + 1);
	}

	@Override
	public List<Integer> getAlternativas() {
		List<Integer> alternativas = new ArrayList<Integer>();
		if(this.numeros.get(this.posActual) != 0) {
			for (int i = 1; i <= this.numeros.get(this.posActual); i++) {
				if(this.posActual + i == this.numeros.size()) {
					break;
				}
				alternativas.add(i);
			}
		}
		return alternativas;
	}

	@Override
	public List<Integer> getSolucionReconstruidaCasoBase(Sp<Integer> sp) {
		return new ArrayList<>();
	}

	@Override
	public List<Integer> getSolucionReconstruidaCasoRecursivo(Sp<Integer> sp, List<Integer> s) {
		s.add(0, sp.alternativa); //Le pasa la alternativa que este usando 
		return s;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeros == null) ? 0 : numeros.hashCode());
		result = prime * result + ((posActual == null) ? 0 : posActual.hashCode());
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
		Ejercicio1 other = (Ejercicio1) obj;
		if (numeros == null) {
			if (other.numeros != null)
				return false;
		} else if (!numeros.equals(other.numeros))
			return false;
		if (posActual == null) {
			if (other.posActual != null)
				return false;
		} else if (!posActual.equals(other.posActual))
			return false;
		return true;
	}

}
