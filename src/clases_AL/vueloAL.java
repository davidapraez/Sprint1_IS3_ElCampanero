package clases_AL;

import java.util.Date;

public class vueloAL {
	String idvuelo;
	Date fecha;
	String hora;
	String tipovuelo;
	String minutos;
	String id_avion;
	String piloto;
	String copiloto;
	
	public vueloAL(String idvuelo, Date fecha, String hora, String tipovuelo) {
		this.idvuelo = idvuelo;
		this.fecha = fecha;
		this.hora = hora;
		this.tipovuelo = tipovuelo;
	}
	
	
	public vueloAL(String idvuelo, Date fecha, String hora, String tipovuelo, String minutos, String id_avion,
			String piloto, String copiloto) {
		this.idvuelo = idvuelo;
		this.fecha = fecha;
		this.hora = hora;
		this.tipovuelo = tipovuelo;
		this.minutos = minutos;
		this.id_avion = id_avion;
		this.piloto = piloto;
		this.copiloto = copiloto;
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
	public String getMinutos() {
		return minutos;
	}
	public void setMinutos(String minutos) {
		this.minutos = minutos;
	}
	public String getId_avion() {
		return id_avion;
	}
	public void setId_avion(String id_avion) {
		this.id_avion = id_avion;
	}
	public String getPiloto() {
		return piloto;
	}
	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}
	public String getCopiloto() {
		return copiloto;
	}
	public void setCopiloto(String copiloto) {
		this.copiloto = copiloto;
	}
	
	
	
	
	
	
	
}
