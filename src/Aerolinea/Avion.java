package Aerolinea;

public class Avion {
	String id;
	String aerolinea_pertenece;
	double capacidad;
	int numero_motores;
	String modelo;
	String tipo_propulsion;
	
			
	public Avion() {
	}
	public Avion(String id, String aerolinea_pertenece, double capacidad, int numero_motores, String modelo,
			String tipo_propulsion) {
		this.id = id;
		this.aerolinea_pertenece = aerolinea_pertenece;
		this.capacidad = capacidad;
		this.numero_motores = numero_motores;
		this.modelo = modelo;
		this.tipo_propulsion = tipo_propulsion;
		
	}
	
	
	
	public String getId() {
		return id;
	}
	public String getAerolinea_pertenece() {
		return aerolinea_pertenece;
	}
	public double getCapacidad() {
		return capacidad;
	}
	public int getNumero_motores() {
		return numero_motores;
	}
	public String getModelo() {
		return modelo;
	}
	public String getTipo_propulsion() {
		return tipo_propulsion;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setAerolinea_pertenece(String aerolinea_pertenece) {
		this.aerolinea_pertenece = aerolinea_pertenece;
	}
	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}
	public void setNumero_motores(int numero_motores) {
		this.numero_motores = numero_motores;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setTipo_propulsion(String tipo_propulsion) {
		this.tipo_propulsion = tipo_propulsion;
	}
	
	
	
	
	
}
