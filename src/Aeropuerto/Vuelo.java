package Aeropuerto;

import java.util.Calendar;

import Aerolinea.Avion;

public class Vuelo {
	Calendar fecha;
	Calendar hora;
	int numero_vuelo;
	Avion avion;
	
	//constructor
	public Vuelo(Calendar fecha, Calendar hora, int numero_vuelo, Avion avion) {
		this.numero_vuelo = numero_vuelo;
		this.fecha = fecha;
		this.hora = hora;		
		this.avion = avion;
	}

	public Vuelo() {
	}
	
	


	

}
