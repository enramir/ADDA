package ejercicio4;

public class ArticuloContenedor {
	private Integer volumen;
	
	public static ArticuloContenedor create(Integer volumen, Integer beneficio) {
		return new ArticuloContenedor(volumen);
	}
	
	public static ArticuloContenedor create(String s) {
		return new ArticuloContenedor(s);
	}
	
	private ArticuloContenedor(Integer volumen) {
		super();
		this.volumen = volumen;
	}

	private ArticuloContenedor(String s) {
		volumen = Integer.parseInt(s);
	}

	public Integer getVolumen() {
		return volumen;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((volumen == null) ? 0 : volumen.hashCode());
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
		ArticuloContenedor other = (ArticuloContenedor) obj;
		if (volumen == null) {
			if (other.volumen != null)
				return false;
		} else if (!volumen.equals(other.volumen))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Articulo con vulimen =" + volumen;
	}
	
}
