package Aeropuerto;

import javafx.beans.property.SimpleStringProperty;

public class usuario {

	private final SimpleStringProperty nombre;
	private final SimpleStringProperty apellido;
	public usuario(String pnombre, String papellido) {
		this.nombre = new SimpleStringProperty(pnombre);
		this.apellido =new SimpleStringProperty(papellido);
	}
	public String getNombre() {
		return nombre.get();
	}
	public void setNombre(String pnombre) {
		this.nombre.set(pnombre);
	}
	public String getApellido() {
		return apellido.get();
	}
	public void setApellido(String papellido) {
		this.apellido.set(papellido);;
	}
	
	
}
