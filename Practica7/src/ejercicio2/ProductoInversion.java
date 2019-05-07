package ejercicio2;

public class ProductoInversion {
	private Integer capital, beneficio;
	
	public static ProductoInversion create(Integer capital, Integer beneficio) {
		return new ProductoInversion(capital, beneficio);
	}
	
	public static ProductoInversion create(String s) {
		return new ProductoInversion(s);
	}
	
	private ProductoInversion(Integer capital, Integer beneficio) {
		super();
		this.capital = capital;
		this.beneficio = beneficio;
	}

	private ProductoInversion(String s) { //capital,beneficio
		String[] partes = s.split(",");
		capital = Integer.parseInt(partes[0]);
		beneficio = Integer.parseInt(partes[1]);
	}

	public Integer getCapital() {
		return capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	public Integer getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Integer beneficio) {
		this.beneficio = beneficio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beneficio == null) ? 0 : beneficio.hashCode());
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
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
		ProductoInversion other = (ProductoInversion) obj;
		if (beneficio == null) {
			if (other.beneficio != null)
				return false;
		} else if (!beneficio.equals(other.beneficio))
			return false;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ObjetoInversion [capital=" + capital + ", beneficio=" + beneficio + "]";
	}
	
}
