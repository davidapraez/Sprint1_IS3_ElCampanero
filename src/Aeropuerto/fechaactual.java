package Aeropuerto;

import java.util.Calendar;

public class fechaactual {
	
	Calendar fecha=Calendar.getInstance();
	int anno;
	int mes ;
	int dia;
	int hora;
	String am_pm;
	
	//Constuctor
	
	public fechaactual() {
		this.anno = obtenerelanno();
		this.mes = obtenerelmes();
		this.dia = obtenereldia();
		this.hora = obtenerlahora();
		this.am_pm =obtenermeridiano();
	}
	//metodos
	public int obtenerelanno() {
		return fecha.get(Calendar.YEAR);
	}
	
	public int obtenerelmes() {
		return fecha.get(Calendar.MONTH)+1;
	}
	public int obtenereldia() {
		return fecha.get(Calendar.DAY_OF_MONTH);
	}
	public int obtenerlahora() {
		return fecha.get(Calendar.HOUR);
	}
	public String obtenermeridiano() {
		String cadena="";
		if (fecha.get(Calendar.AM_PM)==0) {
			cadena="Am";
		}else{
			cadena="Pm";
		}
		return cadena;
			
		
	}
	
	
		
	
	
}
