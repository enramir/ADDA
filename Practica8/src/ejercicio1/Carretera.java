package ejercicio1;

public class Carretera {

	private static Integer num=0;
	private Ciudad source,target;
	private String nombre;
	private Double kms;
	private Integer id;


	public static Carretera create(Ciudad v1, Ciudad v2, String[] formato) { 
		return new Carretera(v1, v2, formato[2], Double.parseDouble(formato[3]));
	}

	public static Carretera create() { //factoría vacía, crea la carretera vacía
		return new Carretera(null,null,"",null);
	}

	private Carretera(Ciudad source, Ciudad target, String nombre, Double kms) {
		super();
		this.source = source;
		this.target = target;
		this.nombre = nombre;
		this.kms = kms;
		this.id = num++;
	}

	public String getNombre() {
		return nombre;
	}
	public Double getKms() {
		return kms;
	}
	public Ciudad getSource() {
		return source;
	}
	public Ciudad getTarget() {
		return target;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Carretera other = (Carretera) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public String toString() {
		return nombre;
	}



}
