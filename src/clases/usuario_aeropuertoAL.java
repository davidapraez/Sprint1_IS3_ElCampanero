package clases;

public class usuario_aeropuertoAL {
	String usuario;
	String cedula;
	String nombre;
	String apellido;
	String correo;
	String password;
	
	public usuario_aeropuertoAL(String usuario,String cedula,String nombre,String apellido,String correo, String password) {
		this.usuario=usuario;
		this.cedula=cedula;
		this.nombre=nombre;
		this.apellido=apellido;
		this.correo=correo;
		this.password=password;
	}
	
	
	
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
