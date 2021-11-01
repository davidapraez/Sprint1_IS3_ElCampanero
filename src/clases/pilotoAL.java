package clases;

import java.util.Date;

public class pilotoAL {
	String cedula, nombre, apellido,licencia,horasvueloacum;
	Date fecharevmed;

	public pilotoAL(String cedula, String nombre, String apellido, Date fecharevmed) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecharevmed = fecharevmed;
	}
	
	
	

	public pilotoAL(String cedula, String nombre, String apellido, Date fecharevmed, String licencia,
			String horasvueloacum) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecharevmed = fecharevmed;
		this.licencia = licencia;
		this.horasvueloacum = horasvueloacum;
	}




	public String getLicencia() {
		return licencia;
	}




	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}




	public String getHorasvueloacum() {
		return horasvueloacum;
	}




	public void setHorasvueloacum(String horasvueloacum) {
		this.horasvueloacum = horasvueloacum;
	}




	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFecharevmed() {
		return fecharevmed;
	}

	public void setFecharevmed(Date fecharevmed) {
		this.fecharevmed = fecharevmed;
	}
		
	
}
