package clases;

public class aerolineaAL {
	String usuario;
	String id_aerolinea;
	String nombre;
	String password;
	String correo;
	
	public aerolineaAL(String usuario, String id_aerolinea, String nombre, String password, String correo) {
		this.usuario = usuario;
		this.id_aerolinea = id_aerolinea;
		this.nombre = nombre;
		this.password = password;
		this.correo = correo;
	}
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getid_aerolinea() {
		return id_aerolinea;
	}
	public void setId_aerolinea(String id_aerolinea) {
		this.id_aerolinea = id_aerolinea;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	
	
	
	
}
