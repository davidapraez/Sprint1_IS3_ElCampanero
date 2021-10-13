package interfaz;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;

//Import complementarios
import clases_AL.aerolineaAL;
import clases_AL.avionAL;
import clases_AL.hangarAL;
import clases_AL.pilotoAL;
import clases_AL.usuario_aeropuertoAL;
import clases_AL.vueloAL;

public class conexionbd {

	public Statement conexionbasededatos() {
		Statement st = null;
		Connection conexion = null;

		try {
			String BD = "jdbc:postgresql://localhost:5432/Aeropuerto";
			String usuario = "postgres";
			String contrasena = "postgres1";
			Class.forName("org.postgresql.Driver");
			conexion = DriverManager.getConnection(BD, usuario, contrasena);
			st = conexion.createStatement();
		} catch (Exception e) {
			e.getMessage();
		}
		return st;
	}

	public void mostrardatos() {
		try {
			java.sql.Statement st = conexionbasededatos();
			String sql = "SELECT * FROM usuario";
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				String usuario = resultSet.getString("usuario");
				String password = resultSet.getString("password");
				
			}
		} catch (Exception e) {

		}

	}

	// MENU AEROPUERTO

	public boolean validarusuarioaeropuerto(String usu, String pssword) {
		boolean validado = false;
		java.sql.Statement st = conexionbasededatos();
		String sql = "SELECT * FROM usuario_sistema_aeropuerto ";
		try {
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				String usuario = resultSet.getString("id_usuario_sistema_aeropuerto");
				String password = resultSet.getString("password");
				if (usuario.equals(usu) && (password.equals(pssword))) {
					validado = true;

				}

			}
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		return validado;
	}

	public void guardarusuarioaeropuerto(String nombre, String apellido, String cedula, String usuario, String password,
			String correo) {
		java.sql.Statement st = conexionbasededatos();
		String sql = "insert into usuario_aeropuerto (cedula, primer_nombre, primer_apellido,correo)";
		sql += "values ('" + cedula + "','" + nombre + "','" + apellido + "','" + correo + "' );";

		try {
			if (!buscarusuarioaeropuerto(usuario)) {
				st.execute(sql);
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Guardado");
				alert.setHeaderText("Registro exitoso");
				alert.setContentText("Se registró satisfactoriamente el usuario.");
				alert.showAndWait();

			} else {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error ");
				alert.setHeaderText("Registro no guardado");
				alert.setContentText("El usuario ya se encuentra registrado");
				alert.showAndWait();
			}
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

	}

	public void modificar_usuario_aeropuerto(String nombre, String apellido, String cedula, String usuario,
			String password, String correo) {
		java.sql.Statement st = conexionbasededatos();
		String sql = "alter table usuario_sistema_aeropuerto drop constraint fk_usuarios_aeropuerto_usuario_aeropuerto1";
		String sql2 = "update usuario_aeropuerto set primer_nombre='" + nombre + "',primer_apellido='" + apellido
				+ "',correo='" + correo + "' where (cedula='" + cedula + "');";
		String sql3 = "update usuario_sistema_aeropuerto set id_usuario_sistema_aeropuerto='" + usuario + "',password='"
				+ password + "'" + "where (usuario_aeropuerto_cedula='" + cedula + "')";
		String sql4 = "ALTER TABLE usuario_sistema_aeropuerto"
				+ "  ADD CONSTRAINT fk_usuarios_aeropuerto_usuario_aeropuerto1"
				+ "  FOREIGN KEY (usuario_aeropuerto_cedula)" + "  REFERENCES usuario_aeropuerto(cedula)"
				+ "  ON DELETE CASCADE;";

		try {
			st.execute(sql);
			st.execute(sql2);
			st.execute(sql3);
			st.execute(sql4);
			st.close();
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Guardado ");
			alert.setHeaderText("Registro Exitoso");
			alert.setContentText("Se modifico satisfactoriamente el usuario");
			alert.showAndWait();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void eliminarusuarioaeropuerto(String cedula) {
		java.sql.Statement st = conexionbasededatos();
		String sql = "delete from usuario_aeropuerto where cedula='" + cedula + "';";
		try {
			if (buscarusuarioaeropuerto_cedula(cedula)) {
				st.execute(sql);
				st.close();
			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("No se encuentra registrado un usuario con la cedula digitada");
				alert.setContentText("Verifique la informacion ");
				alert.showAndWait();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean buscarusuarioaeropuerto_cedula(String idcedula) {
		boolean encontrado = false;
		java.sql.Statement st = conexionbasededatos();
		String sql = "SELECT * FROM usuario_aeropuerto ";
		try {
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				String cedula = resultSet.getString("cedula");
				if (cedula.equals(idcedula)) {
					encontrado = true;
				}
			}
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			
		}

		return encontrado;
	}

	public void guardarusuarioaeropuertosistema(String usuario, String cedula, String password) {
		java.sql.Statement st = conexionbasededatos();
		String sql2 = "insert into usuario_sistema_aeropuerto (id_usuario_sistema_aeropuerto,usuario_aeropuerto_cedula,password) "
				+ "values ( '" + usuario + "','" + cedula + "','" + password + "');";
		try {
			if (!buscarusuarioaeropuerto(usuario)) {
				st.execute(sql2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<usuario_aeropuertoAL> cargarusuariosaeropuerto() {
		java.sql.Statement st = conexionbasededatos();
		ArrayList<usuario_aeropuertoAL> arrayUsuariosSistema = new ArrayList<>();
		String sql = "select *" + "from (usuario_sistema_aeropuerto cross join usuario_aeropuerto)"
				+ "where (usuario_sistema_aeropuerto.usuario_aeropuerto_cedula=usuario_aeropuerto.cedula) ;";
		try {
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				String usuario = resultSet.getString("id_usuario_sistema_aeropuerto");
				String cedula = resultSet.getString("cedula");
				String nombre = resultSet.getString("primer_nombre");
				String apellido = resultSet.getString("primer_apellido");
				String correo = resultSet.getString("correo");
				String password = resultSet.getString("password");

				arrayUsuariosSistema.add(new usuario_aeropuertoAL(usuario, cedula, nombre, apellido, correo, password));
			}

		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

		return arrayUsuariosSistema;
	}

	public pilotoAL cargarpilotoamodificar(String idpiloto) {
		java.sql.Statement st = conexionbasededatos();
		String sql = "SELECT * FROM piloto WHERE cedula ='" + idpiloto + "';";

		pilotoAL piloto = null;
		if (buscarpiloto(idpiloto)) {
			try {
				ResultSet resulset = st.executeQuery(sql);
				while (resulset.next()) {
					String cedula = resulset.getString("cedula");
					String nombre = resulset.getString("nombre");
					String apellido = resulset.getString("apellido");
					String licencia = resulset.getString("licencia");
					String horas = resulset.getString("horas_experiencia_acumuladas");
					Date fecha = resulset.getDate("fecha_revision_medica");

					piloto = new pilotoAL(cedula, nombre, apellido, fecha, licencia, horas);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return piloto;

	}

	public ArrayList<pilotoAL> cargarpilotoaerolinea() {
		java.sql.Statement st = conexionbasededatos();
		ArrayList<pilotoAL> cargarpilotoaerolinea = new ArrayList<>();
		String sql = "SELECT * FROM piloto;";
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String cedula = rs.getString("cedula");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				Date fecharevmed = rs.getDate("fecha_revision_medica");

				cargarpilotoaerolinea.add(new pilotoAL(cedula, nombre, apellido, fecharevmed));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cargarpilotoaerolinea;
	}

	public ArrayList<aerolineaAL> cargaraerolineas() {
		java.sql.Statement st = conexionbasededatos();
		ArrayList<aerolineaAL> arrayaerolineas = new ArrayList<>();
		String sql = "select *" + "from (aerolineas cross join usuario_sistema_aerolinea)"
				+ "where (aerolineas.idaerolinea=usuario_sistema_aerolinea.idaerolinea) ;";
		try {
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				String usuario = resultSet.getString("usuario");
				String id_aerolinea = resultSet.getString("idaerolinea");
				String password = resultSet.getString("password");
				String nombre = resultSet.getString("nombre_aerolinea");
				String correo = resultSet.getString("correo");

				arrayaerolineas.add(new aerolineaAL(usuario, id_aerolinea, nombre, password, correo));
			}

		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

		return arrayaerolineas;

	}

	public ArrayList<hangarAL> cargarhangares() {
		java.sql.Statement st = conexionbasededatos();
		ArrayList<hangarAL> arrayhangares = new ArrayList<>();
		String sql = "select *" + "from hangares;";
		try {
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				String idhangar = resultSet.getString("id_hangar");
				String ubicacion = resultSet.getString("ubicacion");
				String password = resultSet.getString("capacidad");

				arrayhangares.add(new hangarAL(idhangar, ubicacion, password));
			}

		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

		return arrayhangares;

	}

	public boolean buscarusuarioaeropuerto(String idusuario) {
		boolean encontrado = false;
		java.sql.Statement st = conexionbasededatos();
		String sql = "SELECT * FROM usuario_sistema_aeropuerto ";
		try {
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				String usuario = resultSet.getString("id_usuario_sistema_aeropuerto");
				if (usuario.equals(idusuario)) {
					encontrado = true;
					
				}
			}
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			
		}

		return encontrado;
	}

	public usuario_aeropuertoAL cargar_usuarioaeropuerto(String id_cedula) {
		java.sql.Statement st = conexionbasededatos();
		String sql = "select *" + "from (usuario_sistema_aeropuerto cross join usuario_aeropuerto)"
				+ "where (usuario_sistema_aeropuerto.usuario_aeropuerto_cedula=" + "'" + id_cedula + "'" + " and "
				+ "usuario_sistema_aeropuerto.usuario_aeropuerto_cedula=usuario_aeropuerto.cedula);";
		usuario_aeropuertoAL persona = null;

		try {
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				String usuario = resultSet.getString("id_usuario_sistema_aeropuerto");
				String cedula = resultSet.getString("cedula");
				String nombre = resultSet.getString("primer_nombre");
				String apellido = resultSet.getString("primer_apellido");
				String correo = resultSet.getString("correo");
				String password = resultSet.getString("password");

				persona = new usuario_aeropuertoAL(usuario, cedula, nombre, apellido, correo, password);
			}
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();

		}
		return persona;

	}

	public aerolineaAL cargar_aerolineas(String id_cedula) {
		java.sql.Statement st = conexionbasededatos();
		String sql = "select *" + "from (aerolineas cross join usuario_sistema_aerolinea)"
				+ "where (aerolineas.idaerolinea='" + id_cedula + "' and "
				+ "aerolineas.idaerolinea=usuario_sistema_aerolinea.idaerolinea);";
		aerolineaAL aerolinea = null;

		try {
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				String idaerolinea = resultSet.getString("idaerolinea");
				String usuario = resultSet.getString("usuario");
				String password = resultSet.getString("password");
				String nombre = resultSet.getString("nombre_aerolinea");
				String correo = resultSet.getString("correo");

				aerolinea = new aerolineaAL(usuario, idaerolinea, nombre, password, correo);
			}
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			
		}
		return aerolinea;

	}

	public aerolineaAL guardar_modificaraerolinea(String usuario, String idaerolinea, String nombre, String password,
			String correo) {
		aerolineaAL aerolinea = null;

		java.sql.Statement st = conexionbasededatos();

		String sql = "alter table usuario_sistema_aerolinea drop constraint fk_usuario_sistema_aerolinea_aerolineas1;";
		String sql2 = "update aerolineas set idaerolinea='" + idaerolinea + "',nombre_aerolinea='" + nombre
				+ "',correo='" + correo + "' " + "where (idaerolinea='" + idaerolinea + "');";
		String sql3 = "update usuario_sistema_aerolinea set idaerolinea ='" + idaerolinea + "',usuario='" + usuario
				+ "', password='" + password + "'" + " where (idaerolinea='" + idaerolinea + "')";
		String sql4 = "ALTER TABLE usuario_sistema_aerolinea"
				+ "  ADD CONSTRAINT fk_usuario_sistema_aerolinea_aerolineas1" + "  FOREIGN KEY (idaerolinea) "
				+ "  REFERENCES aerolineas (idaerolinea)" + "  ON DELETE CASCADE;";

		try {
			st.execute(sql);
			st.execute(sql2);
			st.execute(sql3);
			st.execute(sql4);
			st.close();
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Guardado ");
			alert.setHeaderText("Registro Exitoso");
			alert.setContentText("Se modifico satisfactoriamente el usuario");
			alert.showAndWait();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aerolinea;

	}

	public void guardarhangar(String idhangar, String ubicacion, String capacidad) {

		java.sql.Statement st = conexionbasededatos();
		String sql2 = "insert into hangares(id_hangar,ubicacion,capacidad) " + "values ( '" + idhangar + "','"
				+ ubicacion + "','" + capacidad + "');";

		try {
			if (!buscaridhangar(idhangar)) {
				st.execute(sql2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public boolean buscaridhangar(String idhangar) {
		boolean encontrado = false;
		java.sql.Statement st = conexionbasededatos();
		String sql = "SELECT * FROM hangares ";
		try {
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				String usuario = resultSet.getString("id_hangar");
				if (usuario.equals(idhangar)) {
					encontrado = true;
				}
			}
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		return encontrado;

	}

	public void eliminar_hangar(String idhangar) {
		java.sql.Statement st = conexionbasededatos();
		String sql = "delete from hangares where id_hangar='" + idhangar + "';";
		try {
			if (buscaridhangar(idhangar)) {
				st.execute(sql);
				st.close();
			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("El hangar digitado no se encuentra registrado.");
				alert.setContentText("Verifique la información.");
				alert.showAndWait();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// MENU AEROLINEA

	public void guardaraerolinea(String idaerolinea, String nombre, String correo, String usuario, String password) {
		java.sql.Statement st = conexionbasededatos();
		String sql = "insert into aerolineas (idaerolinea, nombre_aerolinea,correo)";
		sql += "values ('" + idaerolinea + "','" + nombre + "','" + correo + "' );";

		String sql2 = "insert into usuario_sistema_aerolinea (idaerolinea,usuario,password) " + "values ( '"
				+ idaerolinea + "','" + usuario + "','" + password + "');";

		try {
			if (!buscarIDaerolinea(idaerolinea) && (!buscarusuarioaerolinea(usuario))) {
				st.execute(sql);
				st.execute(sql2);
				st.close();
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Guardado ");
				alert.setHeaderText("Registro Exitoso");
				alert.setContentText("Se registro satisfactoriamente el usuario");
				alert.showAndWait();

			} else {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error ");
				alert.setHeaderText("Registro no guardado.");
				alert.setContentText("El ID aerolinea o el usuario ya se encuentran registrados");
				alert.showAndWait();
			}
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

	}

	public boolean buscarIDaerolinea(String id_aerolinea) {
		boolean encontrado = false;
		java.sql.Statement st = conexionbasededatos();
		String sql = "SELECT * FROM aerolineas ";
		try {
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				String usuario = resultSet.getString("idaerolinea");
				if (usuario.equals(id_aerolinea)) {
					encontrado = true;
				}
			}
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

		return encontrado;
	}

	public boolean buscarusuarioaerolinea(String usuarioaerolinea) {
		boolean encontrado = false;
		java.sql.Statement st = conexionbasededatos();
		String sql = "SELECT * FROM usuario_sistema_aerolinea ";
		try {
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				String usuario = resultSet.getString("usuario");
				if (usuario.equalsIgnoreCase(usuarioaerolinea)) {
					encontrado = true;
				}
			}
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

		return encontrado;
	}

	public void eliminar_aerolinea(String idaerolinea) {
		java.sql.Statement st = conexionbasededatos();
		String sql = "delete from aerolineas where idaerolinea='" + idaerolinea + "';";
		try {
			if (buscarIDaerolinea(idaerolinea)) {
				st.execute(sql);
				st.close();
			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("La aerolínea no se encuentra registrada.");
				alert.setContentText("Verifique la información.");
				alert.showAndWait();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean validarusuarioaerolinea(String usu, String pssword) {
		boolean validado = false;
		java.sql.Statement st = conexionbasededatos();
		String sql = "SELECT * FROM usuario_sistema_aerolinea ";
		try {
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				String usuario = resultSet.getString("usuario");
				String password = resultSet.getString("password");
				if (usuario.equals(usu) && (password.equals(pssword))) {
					validado = true;
				}

			}
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		return validado;
	}

	// Registrar aviones
	public void guardaraviones(String idavion, String tipodeavion, String capacidadcarga, String modelo,
			String tipopropulsion, String numeromotores, String pesonominal, String usuarioaerolinea) {
		String idaerolinea = getIdaerolinea(usuarioaerolinea);
		if (buscarIDaerolinea(idaerolinea)) {
			java.sql.Statement st = conexionbasededatos();
			String sql = "insert into avion (id_avion, tipo_avion,capacidad,modelo,tipo_propulsion,numero_motores"
					+ ",peso_nominal, idaerolinea)";
			sql += "values ('" + idavion + "','" + tipodeavion + "','" + capacidadcarga + "','" + modelo + "','"
					+ tipopropulsion + "','" + numeromotores + "','" + pesonominal + "','" + idaerolinea + "');";

			try {
				if (!buscaravion(idavion)) {
					st.execute(sql);
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Guardado");
					alert.setHeaderText("Registro exitoso");
					alert.setContentText("El avión se registró satisfactoriamente.");
					alert.showAndWait();

				} else {

					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Registro no guardado.");
					alert.setContentText("El ID del avion ya se encuentra registrado.");
					alert.showAndWait();
				}
			} catch (SQLException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No se pudo registrar el avion");
			alert.setContentText("No se encontró a la aerolínea del avión");
			alert.showAndWait();
		}

	}

	public boolean verificarvuelo(String id) {
		boolean validado = false;
		java.sql.Statement st = conexionbasededatos();
		String sql = "SELECT * from vuelo ;";

		ResultSet resultSet;
		try {
			resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				String idavion_bd = resultSet.getString("idvuelo");

				if (idavion_bd.equals(id)) {
					validado = true;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return validado;

	}

	public vueloAL retornarvuelo(String id) {

		java.sql.Statement st = conexionbasededatos();
		String sql = "SELECT * from vuelo ;";
		ResultSet resultSet;

		vueloAL vuelo = null;
		try {
			resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				String idvuelo = resultSet.getString("idvuelo");
				if (idvuelo.equals(id)) {
					Date fecha = resultSet.getDate("fecha");
					String hora = resultSet.getString("hora");
					String minutos = resultSet.getString("minutos");
					String tipovuelo = resultSet.getString("tipo_de_vuelo");
					String piloto = resultSet.getString("piloto_cedula");
					String copiloto = resultSet.getString("copiloto");
					String avion = resultSet.getString("id_avion");

					vuelo = new vueloAL(idvuelo, fecha, hora, tipovuelo, minutos, avion, piloto, copiloto);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vuelo;

	}

	public boolean modificarvuelo(String id, LocalDate fecha, int hora, int minutos) {
		boolean validar = false;
		java.sql.Statement st = conexionbasededatos();
		String sql = "update vuelo set fecha='" + fecha + "',hora='" + hora + "',minutos='" + minutos + "' where "
				+ "idvuelo='" + id + "';";
		// update vuelo set fecha='20-05-2021',hora='5',minutos='55'
		// where idvuelo='20';
		try {
			st.execute(sql);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return validar;

	}

	public boolean modificarvueloaerolinea(String id, LocalDate fecha, int hora, int minutos, String tipodevuelo,
			String idavion, String piloto, String copiloto) {
		boolean validar = false;
		java.sql.Statement st = conexionbasededatos();
		
		String sql = "update vuelo set fecha='"+fecha+ "',hora='" + hora + "',minutos='" + minutos
				+ "',tipo_de_vuelo='" + tipodevuelo + "',id_avion='" + idavion + "',piloto_cedula='" + piloto
				+ "',copiloto='" + copiloto + "' where" + " idvuelo='" + id + "';";


		try {
			st.execute(sql);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return validar;

	}

	public String getIdaerolinea(String usuarioaerolinea) {
		String idaerolinea = "";
		java.sql.Statement st = conexionbasededatos();
		String sql = "SELECT * from usuario_sistema_aerolinea where usuario='" + usuarioaerolinea + "';";

		try {
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				idaerolinea = resultSet.getString("idaerolinea");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return idaerolinea;
	}

	public boolean buscaravion(String idavion) {
		boolean encontrado = false;
		java.sql.Statement st = conexionbasededatos();
		String sql = "SELECT * FROM avion ";
		try {
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				String idavion_bd = resultSet.getString("id_avion");
				if (idavion_bd.equals(idavion)) {
					encontrado = true;
				}
			}
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

		return encontrado;
	}

	public avionAL retornaavionamodificar(String usuarioaerolinea, String idavion) {
		avionAL avion = null;
		java.sql.Statement st = conexionbasededatos();
		String idaerolinea = getIdaerolinea(usuarioaerolinea);

		String sql = "select *" + "  from avion" + "  where idaerolinea='" + idaerolinea + "' and id_avion='" + idavion
				+ "';";

		try {
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				String idavionacargar = resultSet.getString("id_avion");
				String tipodeavion = resultSet.getString("tipo_avion");
				String capacidadavion = resultSet.getString("capacidad");
				String modelo = resultSet.getString("modelo");
				String propulsion = resultSet.getString("tipo_propulsion");
				String motores = resultSet.getString("numero_motores");
				String peso = resultSet.getString("peso_nominal");
				String idaerolineas = resultSet.getString("idaerolinea");

				avion = new avionAL(idavionacargar, tipodeavion, capacidadavion, modelo, propulsion, motores, peso,
						idaerolineas);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return avion;

	}

	public void eliminarvuelo(String idvuelo) {
		java.sql.Statement st = conexionbasededatos();
		String sql = "delete from vuelo where idvuelo='" + idvuelo + "';";
		
		if(buscaridvuelo(idvuelo)) {
			try {
				st.execute(sql);
				st.close();
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Eliminado");
				alert.setHeaderText("Registro eliminado");
				alert.setContentText("El vuelo se eliminó satisfactoriamente.");
				alert.showAndWait();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Registro no encontrado");
			alert.setHeaderText("No se encontro el ID del vuelo");
			alert.setContentText("Haga clic en Aceptar e inténtelo nuevamente");
			alert.showAndWait();
		}
		

	}

	public ArrayList<vueloAL> cargarsolicitudesvuelos() {
		ArrayList<vueloAL> solicitudes = new ArrayList<>();
		java.sql.Statement st = conexionbasededatos();
		String sql = "SELECT * FROM vuelo ;";

		try {
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				String idvuelo = resultSet.getString("idvuelo");
				String tipovuelo = resultSet.getString("tipo_de_vuelo");
				Date fecha = resultSet.getDate("fecha");
				String hora = resultSet.getString("hora");
				String minutos = resultSet.getString("minutos");

				String horas = hora + ":" + minutos;
				solicitudes.add(new vueloAL(idvuelo, fecha, horas, tipovuelo));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return solicitudes;

	}

	public ArrayList<avionAL> cargaraviones(String usuarioaerolinea) {
		ArrayList<avionAL> aviones = new ArrayList<>();
		java.sql.Statement st = conexionbasededatos();
		String idaerolineacomprar = getIdaerolinea(usuarioaerolinea);
		String sql = "SELECT * FROM avion where idaerolinea='" + idaerolineacomprar + "';";
		try {
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				String idavion = resultSet.getString("id_avion");
				String tipoavion = resultSet.getString("tipo_avion");
				String capacidad = resultSet.getString("capacidad");
				String modelo = resultSet.getString("modelo");
				String propulsion = resultSet.getString("tipo_propulsion");
				String numero_motores = resultSet.getString("numero_motores");
				String peso = resultSet.getString("peso_nominal");
				String idaerolinea = resultSet.getString("idaerolinea");
				aviones.add(new avionAL(idavion, tipoavion, capacidad, modelo, propulsion, numero_motores, peso,
						idaerolinea));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aviones;

	}

	// PILOTO

	public boolean buscarpiloto(String cedula) {
		boolean encontrado = false;
		java.sql.Statement st = conexionbasededatos();
		String sql = "SELECT * FROM piloto ";
		try {
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				String cedula_bd = resultSet.getString("cedula");
				if (cedula_bd.equals(cedula)) {
					encontrado = true;
				}
			}
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

		return encontrado;
	}

	public void guardarmodificarpiloto(String nombre, String apellido, String cedula, String licencia,
			String horasvueloacumuladas, LocalDate fecha) {
		java.sql.Statement st = conexionbasededatos();
		String sql = "update piloto set nombre='" + nombre + "',apellido='" + apellido + "',licencia='" + licencia
				+ "',horas_experiencia_acumuladas='" + horasvueloacumuladas + "',fecha_revision_medica='" + fecha + "'"
				+ "where cedula='" + cedula + "';";
		try {
			if (buscarpiloto(cedula)) {
				st.execute(sql);
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Guardado");
				alert.setHeaderText("Registro exitoso.");
				alert.setContentText("Se registro satisfactoriamente al piloto.");
				alert.showAndWait();

			} else {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Registro no guardado.");
				alert.setContentText("No se encontro el piloto.");
				alert.showAndWait();
			}
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

	}

	public void guardarmodificaravion(String tipoavion, String idavion, String capacidad, String modelo,
			String propulsion, String motores, String peso) {
		java.sql.Statement st = conexionbasededatos();
		String sql = "update avion set tipo_avion='" + tipoavion + "',capacidad='" + capacidad + "',modelo='" + modelo
				+ "'," + "tipo_propulsion='" + propulsion + "',numero_motores='" + motores + "',peso_nominal='" + peso
				+ "'" + "where id_avion='" + idavion + "';";

		try {
			st.execute(sql);
			st.close();

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Información");
			alert.setHeaderText("Se guardó el registro");
			alert.setContentText("Los datos del avión se ha actualizado satisfactoriamente.");
			alert.showAndWait();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void eliminaravion(String idavion) {
		java.sql.Statement st = conexionbasededatos();

		String sql = "delete from avion where id_avion='" + idavion + "';";
		if (buscaravion(idavion)) {
			try {
				st.execute(sql);
				st.close();

				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Información");
				alert.setHeaderText("Registro eliminado");
				alert.setContentText("El avión se ha eliminado satisfactoriamente.");
				alert.showAndWait();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Información");
			alert.setHeaderText("Registro no encontrado");
			alert.setContentText("No se encontro el id del avion a eliminar");
			alert.showAndWait();
		}

	}

	public boolean buscaridvuelo(String idvuelo) {
		boolean encontrado=false;
		java.sql.Statement st = conexionbasededatos();
		String sql = "select * from vuelo";
		
		ResultSet resultSet;
		try {
			resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				String id=resultSet.getString("idvuelo");
				if(id.equalsIgnoreCase(idvuelo)) {
					encontrado=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return encontrado;
	}
	
	
	public int buscaridvuelo() {
		int numeromayor = 0;
		java.sql.Statement st = conexionbasededatos();
		String sql = "select * from vuelo";
		try {
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				int numero = Integer.parseInt(resultSet.getString("idvuelo"));
				if (numero > numeromayor) {
					numeromayor = numero;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return numeromayor;
	}

	public boolean validarhoravuelo(String fecha1, int hora, int minutos) {
		boolean disponible = false;
		// LocalDate fecha = LocalDate.parse(new
		// SimpleDateFormat("yyyy-MM-dd").format(fecha1));
		try {
			java.sql.Statement st = conexionbasededatos();
			String sql = "SELECT * FROM vuelo WHERE hora =" + "'" + hora + "'" + " AND fecha =" + "'" + fecha1 + "'";
			ResultSet result = st.executeQuery(sql);
			while (result.next()) {
				disponible = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return disponible;
	}

	public boolean programarvueloaerolinea(String tipovuelo, String idavion, String idpiloo, String copiloto,
			LocalDate fecha, int hora, int minutos) {
		boolean programado = false;
		java.sql.Statement st = conexionbasededatos();
		if (!validarhoravuelo(fecha.toString(), hora, minutos)) {
			int idvuelo = buscaridvuelo() + 1;
			String sql = "insert into vuelo (idvuelo,tipo_de_vuelo,fecha,hora,minutos,piloto_cedula,copiloto,id_avion)"
					+ "values ('" + idvuelo + "','" + tipovuelo + "','" + fecha + "'," + hora + "," + minutos + ",'"
					+ idpiloo + "','" + copiloto + "','" + idavion + "');";

			try {
				st.execute(sql);
				st.close();
				programado = true;
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Información");
				alert.setHeaderText("Vuelo programado exitosamente");
				alert.setContentText("El vuelo se ha registrado satisfactoriamente.");
				alert.showAndWait();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Informacion");
			alert.setHeaderText("No se pudo programar el vuelo.");
			alert.setContentText("Otro vuelo ya se encuentra registrado a la misma hora. Por favor seleccione otra fecha u hora.");
			alert.showAndWait();
		}

		return programado;
	}

	public void eliminarpiloto(String cedula) {
		java.sql.Statement st = conexionbasededatos();
		String sql = "delete from piloto where cedula='" + cedula + "';";
		if (buscarpiloto(cedula)) {
			try {
				st.execute(sql);
				st.close();
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Información");
				alert.setHeaderText("Registro eliminado.");
				alert.setContentText("El piloto se ha eliminado satisfactoriamente.");
				alert.showAndWait();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No se encontró al piloto");
			alert.setContentText("Digite una cédula válida para eliminar el registro");
			alert.showAndWait();
		}

	}

	public void guardarpiloto(String nombre, String apellido, String cedula, String licencia,
			String horasvueloacumuladas, LocalDate fecha) {

		java.sql.Statement st = conexionbasededatos();
		String sql = "insert into piloto (cedula, nombre,apellido,licencia,horas_experiencia_acumuladas,"
				+ "fecha_revision_medica)";
		sql += "values ('" + cedula + "','" + nombre + "','" + apellido + "','" + licencia + "','"
				+ horasvueloacumuladas + "','" + fecha + "');";

		try {
			if (!buscarpiloto(cedula)) {
				st.execute(sql);
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Guardado ");
				alert.setHeaderText("Registro Exitoso");
				alert.setContentText("El usuario se ha registrado satisfactoriamente.");
				alert.showAndWait();

			} else {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error ");
				alert.setHeaderText("Registro no guardado");
				alert.setContentText("El id del piloto ya se encuentra registrado");
				alert.showAndWait();
			}
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

	}

}
