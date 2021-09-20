package clases_AL;

import java.util.Date;

public class vueloAL {
	String idvuelo;
	Date fecha;
	String hora;
	String tipovuelo;
	
	public vueloAL(String idvuelo, Date fecha, String hora, String tipovuelo) {
		this.idvuelo = idvuelo;
		this.fecha = fecha;
		this.hora = hora;
		this.tipovuelo = tipovuelo;
	}
	public String getIdvuelo() {
		return idvuelo;
	}
	public void setIdvuelo(String idvuelo) {
		this.idvuelo = idvuelo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getTipovuelo() {
		return tipovuelo;
	}
	public void setTipovuelo(String tipovuelo) {
		this.tipovuelo = tipovuelo;
	}
	
	
	
	
	
}
