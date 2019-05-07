package ejercicio2;

public class Ciudad  {

	public static Ciudad create(String[] formato) {
		return new Ciudad(formato);
	}

	public static Ciudad create(String nombre) {
		return new Ciudad(nombre);
	}

	public static Ciudad create() {
		return new Ciudad("");
	}
	
	private String nombre;

	private Ciudad(String nombre) {
		super();
		this.nombre = nombre;
	
	}

	private Ciudad(String[] formato){
		super();
		this.nombre = formato[0];
		
	}
	
	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Ciudad other = (Ciudad) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.nombre;
	}
}
