package Aeropuerto;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class usuario_aeropuerto {
		public final SimpleIntegerProperty numero;
		public final SimpleStringProperty cedula;
		public final SimpleStringProperty primerNombre;
		public final SimpleStringProperty primerApellido;
		public final SimpleStringProperty correo;

		public usuario_aeropuerto(int numero, String cedula, String primerNombre,String primerApellido,String correo) {
			this.numero = new SimpleIntegerProperty(numero);
			this.cedula = new SimpleStringProperty(cedula);
			this.primerNombre = new SimpleStringProperty(primerNombre);
			this.primerApellido = new SimpleStringProperty(primerApellido);
			this.correo = new SimpleStringProperty(correo);
		}

		public SimpleIntegerProperty getNumero() {
			return numero;
		}

		public SimpleStringProperty getCedula() {
			return cedula;
		}

		public SimpleStringProperty getPrimerNombre() {
			return primerNombre;
		}

		public SimpleStringProperty getPrimerApellido() {
			return primerApellido;
		}

		public SimpleStringProperty getCorreo() {
			return correo;
		}


		
	}
	
	

