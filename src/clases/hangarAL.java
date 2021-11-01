package clases;


public class hangarAL {

	String idhangar, ubicacion, capacidad;
	
	String horaentrada;
    String fechaentrada;
    String estado;
    String costo;
    String idavion;
    String valoractual;

	public hangarAL(String idhangar, String ubicacion, String capacidad) {
		this.idhangar = idhangar;
		this.ubicacion = ubicacion;
		this.capacidad = capacidad;
	}
	
	public hangarAL(String idhangar, String costo) {
		this.idhangar = idhangar;
		this.costo = costo;
		
	}
	
	
	
	public hangarAL (String idhangar, String horaentrada,
			String fechaentrada,String idavion, String valoracrtual) {
		this.idhangar = idhangar;
		this.horaentrada = horaentrada;
		this.fechaentrada = fechaentrada;
		this.idavion=idavion;
		this.valoractual=valoracrtual;
		
	}
	
	
	
	
	public String getValoractual() {
		return valoractual;
	}

	public void setValoractual(String valoractual) {
		this.valoractual = valoractual;
	}

	public String getIdavion() {
		return idavion;
	}

	public void setIdavion(String idavion) {
		this.idavion = idavion;
	}

	public String getHoraentrada() {
		return horaentrada;
	}



	public void setHoraentrada(String horaentrada) {
		this.horaentrada = horaentrada;
	}



	public String getFechaentrada() {
		return fechaentrada;
	}



	public void setFechaentrada(String fechaentrada) {
		this.fechaentrada = fechaentrada;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}






	public String getCosto() {
		return costo;
	}



	public void setCosto(String costo) {
		this.costo = costo;
	}



	public String getIdhangar() {
		return idhangar;
	}

	public void setIdhangar(String idhangar) {
		this.idhangar = idhangar;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}
	
	
	
}
