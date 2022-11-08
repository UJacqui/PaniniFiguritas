package ar.edu.unlam.pb2;

public class Figurita implements Comparable<Figurita>{
	
	private Integer codFigu;
	private Character letra;
	private String seleccion;
	private String jugadorName;
	private Double precio;
	private Estado estadoFigurita;
	
	Figurita(Integer codFigu, Character letra, String seleccion, String jugadorName, Double precio,Estado estadoFigurita) {
		super();
		this.codFigu = codFigu;
		this.letra = letra;
		this.seleccion = seleccion;
		this.jugadorName = jugadorName;
		this.precio = precio;
		this.estadoFigurita = estadoFigurita;
		
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codFigu == null) ? 0 : codFigu.hashCode());
		result = prime * result + ((seleccion == null) ? 0 : seleccion.hashCode());
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
		Figurita other = (Figurita) obj;
		if (codFigu == null) {
			if (other.codFigu != null)
				return false;
		} else if (!codFigu.equals(other.codFigu))
			return false;
		if (seleccion == null) {
			if (other.seleccion != null)
				return false;
		} else if (!seleccion.equals(other.seleccion))
			return false;
		return true;
	}

	public Integer getCodFigu() {
		return codFigu;
	}

	public void setCodFigu(Integer codFigu) {
		this.codFigu = codFigu;
	}

	public Character getLetra() {
		return letra;
	}

	public void setLetra(Character letra) {
		this.letra = letra;
	}

	public String getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}

	public String getJugadorName() {
		return jugadorName;
	}

	public void setJugadorName(String jugadorName) {
		this.jugadorName = jugadorName;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public Estado getEstadoFigurita() {
		return estadoFigurita;
	}

	public void setEstadoFigurita(Estado estadoFigurita) {
		this.estadoFigurita = estadoFigurita;
	}


	@Override
	public int compareTo(Figurita o) {
		return this.codFigu - o.getCodFigu();
	}
	
	
	
	

}
