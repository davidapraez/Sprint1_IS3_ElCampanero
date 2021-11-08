package interfaz;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;

import clases.aerolineaAL;
import clases.avionAL;
import clases.pilotoAL;
import clases.usuario_aeropuertoAL;
import clases.vueloAL;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Labeled;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import javafx.scene.control.TableColumn;

//Importacion de clases complementarias

public class controlador {

	// Variables constantes
	conexionbd conexion = new conexionbd();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	@FXML
	private AnchorPane anpMenuAerolinea;
	@FXML
	private Button buttonAerolinea1;

	@FXML
	private Button buttonAerolinea2;

	@FXML
	private Button buttonAerolineaRegistros1;

	@FXML
	private Button btnCerrarSesionAerolinea;
	@FXML
	private Button btnSalirAerolinea;

	@FXML
	private TextField txfIdaerolinea, txfIdhangar, txfidaerolineaeste, txfAdministrarUsuariosCedula;

	@FXML
	private Button btnAdministrarUsuarioModificar;

	@FXML
	private Button btnAdministrarUsuarioEliminar;

	@FXML
	private Hyperlink hiperlinkAeropuertoMenuRegistrosRegresar;

	@FXML
	private CheckBox chkboxCopiloto1, cbxcopiloto2;

	// 2 VISTA MODIFICAR EMPLEADO

	@FXML
	private VBox vbxMenus_aeropuerto_ModificarEmpleado;

	@FXML
	private TextField txfModificarEmpleadoNombre;

	@FXML
	private TextField txfModificarEmpleadoApellido;

	@FXML
	private TextField txfModificarEmpleadoCedula;

	@FXML
	private TextField txfUsuarioModificarEmpleado;

	@FXML
	private PasswordField txfModificarEmpleadoContrasena;

	@FXML
	private Button btnModificarEmpleadoMostrarContrasena;

	@FXML
	private TextField txfModificarEmpleadoCorreo;

	@FXML
	private Button btnGuardarModificarEmpleado;

	@FXML
	private Hyperlink hiperlinkModificarEmpleadoRegresar;

	// REGISTRAR AEROLINEA
	@FXML
	private Pane paneRegistrarAerolinea;

	@FXML
	private TextField txfRegistrarAerolineaNombreAerolinea;

	@FXML
	private TextField txfRegistrarUsuarioRegistrarAerolinea;

	@FXML
	private PasswordField txfRegistrarAerolineaContrasena;

	@FXML
	private TextField txfCorreoRegistrarAerolinea;

	@FXML
	private Button btnRegistrarAerolineaGuardar;

	@FXML
	private Hyperlink hiperlinkAeropuertoMenuRegistrosRegresar22;

	// ************************MODIFICAR AEROLINEA*********
	@FXML
	private Pane paneModificarAerolinea;

	// MODIFICAR AEROLINEA 1 VISTA
	@FXML
	private VBox vbxModificarUsuarioTableView1;

	@FXML
	private TextField txfAdministraraerolinea1;

	@FXML
	private Button btnModificarAerolinea;

	@FXML
	private Button btnEliminarAerolinea;

	@FXML
	private Hyperlink hiperlinkAeropuertoMenuRegistrosRegresar3;

	// MODIFICAR AEROLINEA 2 VISTA
	@FXML
	private VBox vbxMenus_aeropuerto_ModificarEmpleado1;

	@FXML
	private TextField txfModificarNombreAerolinea;

	@FXML
	private TextField txfModificarUsuarioAerolinea;

	@FXML
	private PasswordField passwfieldModificarUsuarioAerolinea;

	@FXML
	private Button btnMostrarContraseñaModificar;

	@FXML
	private ImageView btnModificarAerolineamostrar;

	@FXML
	private TextField txfModificaraeroCorreo;

	@FXML
	private Button btnGuardarMofdificaraerolinea;

	@FXML
	private Hyperlink hiperlinkAeropuertoMenuRegistrosRegresar211;

	// REGISTRAR HANGAR
	@FXML
	private Pane paneRegistrarHangar;

	@FXML
	private TextField txfUbicacionHangar;

	@FXML
	private TextField txfCpacidadMetrosHangar;

	@FXML
	private Button btnGuardarRegistroHangar;

	@FXML
	private Hyperlink hiperlinkAeropuertoMenuRegistrosRegresar221;

	// ***********************MODIFICAR HANGARES***********

	@FXML
	private Pane paneModificarHangar;

	@FXML
	private VBox vbxModificarUsuarioTableView11;

	@FXML
	private TextField idhangarAdministrarhangar;

	@FXML
	private Button btnEliminarHangar;

	@FXML
	private Hyperlink hiperlinkAeropuertoMenuRegistrosRegresar31;

	// MENU AEROPUERTO
	@FXML
	private AnchorPane anpMenuAeropuerto;
	@FXML
	private Button btnAgendaAeropuerto;
	@FXML
	private Button btnHangarAeropuerto;

	@FXML
	private Button btnRegistrosAeropuerto;

	@FXML
	private AnchorPane anpLogin;
	@FXML
	private ComboBox<String> cmbxLogin, cmbIdavionHangar;

	@FXML
	private TextField txfNomusuario;
	@FXML
	private PasswordField psfContras;
	@FXML
	private Button btnIniciarsesion;
	@FXML
	private Hyperlink hiperOlvidoSucontrase;
	@FXML
	private Pane paneModificarEmpleado;

	@FXML
	private VBox vbxModificarUsuarioTableView;
	@FXML
	private Button btnProgramarVueloAerolinea;

	@FXML
	private Button btnAerolineaSolicitudesAprobadas;
	@FXML
	private Button btnEliminarsolicitudesaprobadas;
	@FXML
	private Pane paneSolicitudesAerolinea;
	@FXML
	private Hyperlink hiperlinkAeropuertoMenuRegistrosRegresar81;
	@FXML
	private Hyperlink hiperlinkRegresar1;
	@FXML
	private Button btnModificarSolicitudesAprobadas;
	@FXML
	private ComboBox<String> cbxRipodevuelo;

	@FXML
	private TextField txfIdavionagendarvuelo;

	@FXML
	private TextField txfIdpilotaagendavuelos;

	@FXML
	private TextField txfIdcopilotoAgendavuelo;

	@FXML
	private DatePicker datepickFechaAgenda;

	@FXML
	private Button btnSolicitaragendamientoAgendavuelo;

	@FXML
	private VBox vbxModificaravion;
	@FXML
	private AnchorPane root;
	@FXML
	private Pane paneModificarVueloAerolinea;
	@FXML
	private ComboBox<String> cbxTipodevueloModificarVuelo;

	@FXML
	private TextField txfIdavionagendarvuelo1;

	@FXML
	private TextField txfIdpilotaagendavuelos1;

	@FXML
	private TextField txfIdcopilotoAgendavuelo1;

	@FXML
	private DatePicker datepickFechaAgenda1;

	@FXML
	private Spinner<Integer> spinnerHoraagendavuelo1;
	@FXML
	private Button btnRegistrarAvion;

	@FXML
	private Button btnModificarpiloto;

	@FXML
	private Button btnEliminaravion;

	@FXML
	private Button btnRegistrarpiloto;
	@FXML
	private Button btnEliminarpiloto;
	@FXML
	private Hyperlink hiperlinkRegresarListapilotos;
	@FXML
	private Hyperlink hiperlinkRegresarRegistroavion;
	@FXML
	private Pane paneRegistrarAvion;

	@FXML
	private VBox vbxModificarPiloto1;

	@FXML
	private ComboBox<String> cbxTipoavionRegistroAvion;

	@FXML
	private TextField txfIdavionregistroavion;

	@FXML
	private TextField txfCapacidadCargaNumeroPuestos;

	@FXML
	private TextField txfModeloavion121;

	@FXML
	private TextField txfTipopropulsion121;
	@FXML
	private TextField txfNumeromotores1222;

	@FXML
	private TextField txfPesonominalavion1222;
	@FXML
	private AnchorPane anpMenusAgenda;
	@FXML
	private Pane paneAgendaVuelos;

	@FXML
	private TextField txfAgendaVuelos1;

	@FXML
	private Button btnModificarAgendaVuelos1;

	@FXML
	private Button btnEliminarAgendaVuelos1;

	@FXML
	private Hyperlink hiperlinkAeropuertoMenuRegistrosRegresar8;

	// MODIFICAR AGENDA VUELOS
	@FXML
	private Pane paneModificarAgenda;

	@FXML
	private TableView<?> tbleviewModificarVuelos;

	@FXML
	private TextField txfVueloSeleccionadoModificar;

	@FXML
	private DatePicker datepickFechaModificarVuelos;

	@FXML
	private Spinner<?> spinnerHoraModificaVuelo;

	@FXML
	private Button btnModificarVuelos1;

	@FXML
	private Hyperlink hiperlinkAeropuertoMenuRegistrosRegresar7;

	// SOLICITUDES DE CAMBIO

	@FXML
	private Pane paneSolicitudesCambio;
	@FXML
	private TableView<?> tbleviewSolicitudesvuelo;
	@FXML
	private TextField idVueloMenusAgenda;

	@FXML
	private Button idButtonModificarSolicitudesVuelos;
	@FXML
	private Button btnModificarSolicitudesVuelos1;
	@FXML
	private Hyperlink hiperlinkAeropuertoMenuRegistrosRegresar6;
	@FXML
	private Pane pneProgramarVuelo;

	@FXML
	private Pane pneConsultas;

	@FXML
	private Button btnConsultarDisponibilidadVuelos;

	@FXML
	private Button btnConsultarAgenda;

	@FXML
	private Pane pneRegistros;

	@FXML
	private AnchorPane anpMenusVuelos;

	@FXML
	private Pane paneAerolineaAgendarVuelo;

	@FXML
	private TextField txfvueloSolicitudesAprobadas;

	@FXML
	private TableView<?> tbleviewSolicitudesrechazadas;

	@FXML
	private TextField txfIdvuelorechazadas;

	@FXML
	private Button btnModificarsolicitudesrechazadas;

	@FXML
	private Button btnConsultaHorariodisponible;

	@FXML
	private Hyperlink hiperlinkAeropuertoMenuRegistrosRegresar71;

	@FXML
	private AnchorPane anpMenuRegistros;

	@FXML
	private Pane paneAerolineaRegistrarPiloto;

	@FXML
	private TextField txfNombrepiloto;

	@FXML
	private TextField txfApellidoPiloto;

	@FXML
	private TextField txfCedulaPiloto;

	@FXML
	private TextField txfLicenciaPiloto;

	@FXML
	private TextField txfHorasVueloAcum;

	@FXML
	private TextField txfCorreo3;

	@FXML
	private DatePicker dtepickRevisionmedica;

	@FXML
	private Button btnguardarpiloto;

	@FXML
	private Hyperlink hiperlinkAeropuertoMenuRegistrosRegresar23;

	@FXML
	private Pane paneAerolineaModificarPiloto;

	@FXML
	private VBox vbxListaPilotos;

	@FXML
	private TextField txfIdpiloto;

	@FXML
	private VBox vbxModificarPiloto;

	@FXML
	private TextField txfNombrePilotoModificar;

	@FXML
	private TextField txfApellidoModificarpiloto;

	@FXML
	private TextField txfCedulaModificarPiloto;

	@FXML
	private TextField txfLicenciaModificarPiloto;

	@FXML
	private TextField txfHoravuelosacumuladosModificar;

	@FXML
	private TextField txfUltimarevisionmedica;

	@FXML
	private DatePicker datepickerModificarVuelo, datepickmodific;

	@FXML
	private Button btnGuardarModificarPiloto;

	@FXML
	private Hyperlink hiperlinkRegresarModificarPiloto;

	@FXML
	private Pane paneModificaravion;

	@FXML
	private VBox vbxAdministrarAviones;

	@FXML
	private TextField txfIdpilotorlistaaviones;

	@FXML
	private Button bntmodificaraviones;

	@FXML
	private Hyperlink hiperlinkAeropuertoMenuRegistrosRegresar8111;

	@FXML
	private ComboBox<String> cbxTipoavionmodificar;

	@FXML
	private TextField txfIdavionmodificar;

	@FXML
	private TextField txfCpacidadcargapuestos;

	@FXML
	private TextField txfModeloavion129;

	@FXML
	private TextField txfTipopropulsion116;

	@FXML
	private TextField txfNumeromotoresmodifcaarvion;

	@FXML
	private TextField txfPesonominalavion1128;

	@FXML
	private Button btnGuardarModificaravion1;

	@FXML
	private Hyperlink hiperlinkRegresarModificaravion;

	// ****************MENUS HANGAR************

	@FXML
	private Pane pneAeropuertoRegistros;

	@FXML
	private Button button2211;

	@FXML
	private Button button22111;

	@FXML
	private Button button22113;

	@FXML
	private Button button22114;

	@FXML
	private Button button221131;

	@FXML
	private Button button2211311;

	@FXML
	private AnchorPane anpMenusHangar;

	// REGISTRAR LLEGADA

	@FXML
	private Pane paneRegistrarLlegada;

	@FXML
	private Spinner<Integer> spinnerHoraagendavuelo21;

	@FXML
	private Hyperlink hiperlinkAeropuertoMenuRegistrosRegresar1;

	// REGISTRAR FACTURA HANGAR
	@FXML
	private Pane paneRegistrarFacturaHangar;

	@FXML
	private TextField txfHangarFacturar;

	@FXML
	private Button btnFacturarHangar1;

	@FXML
	private Hyperlink hiperlinkAeropuertoMenuRegistrosRegresar4;

	// FACTURAS REALZIADAS HANGAR

	@FXML
	private Pane paneFacturasRealizadasHnagar;

	@FXML
	private Hyperlink hiperlinkAeropuertoMenuRegistrosRegresar5;

	// *****************MENUS REGISTROS***********
	@FXML
	private AnchorPane anprMenusRegistros;

	// REGISTRAR EMPLEADO

	@FXML
	private Pane paneRegistrarEmpleado;

	@FXML
	private TextField txfRegistrarEmpleadoNombres;

	@FXML
	private TextField txfRegistrarEmpleadoApellido;

	@FXML
	private TextField txfidhangar;

	@FXML
	private TextField txfRegistrarEmpleadoCedula;

	@FXML
	private TextField txfRegistrarEmpleadoUsuario;

	@FXML
	private PasswordField passwordfRegistrarEmpleadoContrasena;

	@FXML
	private TextField txfRegistrarEmpleadoCorreo;

	@FXML
	private Button btnRegistrarEmpleadoGuardar;

	@FXML
	private Hyperlink hiperlinkAeropuertoMenuRegistrosRegresar2;

	@FXML
	private Pane pneHangar;

	@FXML
	private Button buttonAeropuertoRegistrarEntrada;

	@FXML
	private Button button2212;

	@FXML
	private Button button223111;

	@FXML
	private Pane pneAgenda;

	@FXML
	private Button button221;

	@FXML
	private Button buttonSolicitudesAeropuerto;

//**************************************************************************************************************
//**********************************************LOGIN************************************************************
//**************************************************************************************************************

	public String idaerolinealogin = "";
	public String idaeropuertologin = "";

	@FXML
	void cbxElegirTipoUsuario(ActionEvent event) {
	}

	@FXML
	void iniciarsesion(ActionEvent event) {
		if (cmbxLogin.getValue() != null && txfNomusuario.getText() != "" && psfContras.getText() != "") {
			String tipousuario = cmbxLogin.getValue();
			if (tipousuario == "Aerolinea") {

				if (conexion.validarusuarioaerolinea(txfNomusuario.getText(), psfContras.getText())) {
					anpLogin.setVisible(false);
					anpMenuAerolinea.setVisible(true);
					idaerolinealogin = txfNomusuario.getText();
				} else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Usuario o Contraseña incorrectos");
					alert.setContentText("Click en aceptar para continuar");
					alert.showAndWait();
				}

			}
			if (tipousuario == "Administrador de aeropuerto") {

				if (conexion.validarusuarioaeropuerto(txfNomusuario.getText(), psfContras.getText())) {
					anpLogin.setVisible(false);
					anpMenuAeropuerto.setVisible(true);
					idaeropuertologin = txfNomusuario.getText();

				} else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Error ");
					alert.setHeaderText("Usuario o Contraseña incorrectos\"");
					alert.setContentText("Click en aceptar para continuar");
					alert.showAndWait();
				}

			}

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Campos vacios");
			alert.setContentText("Selecciona un usuario e ingresa un usuario y contraseña validos");
			alert.showAndWait();
		}

	}

//**************************************************************************************************************
//*******************************************AEROLINEA**********************************************************
//**************************************************************************************************************

	@FXML
	void cerrarsesionaerolinea(ActionEvent event) {
		pneProgramarVuelo.setVisible(false);
		pneConsultas.setVisible(false);
		pneRegistros.setVisible(false);
		anpMenusVuelos.setVisible(false);
		anpMenuRegistros.setVisible(false);
		anpMenuAerolinea.setVisible(false);
		anpLogin.setVisible(true);
		limpiarlogin();
	}

	@FXML
	void saliraerolinea(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void btnVuelo(ActionEvent event) {
		pneProgramarVuelo.setVisible(true);
		pneConsultas.setVisible(false);
		pneRegistros.setVisible(false);
		anpMenusVuelos.setVisible(false);
		anpMenuRegistros.setVisible(false);
	}

	/*
	 * Comentario
	 * 
	 * @FXML void btnAerolineaConsultas(ActionEvent event) {
	 * pneProgramarVuelo.setVisible(false); pneConsultas.setVisible(true);
	 * pneRegistros.setVisible(false); anpMenusVuelos.setVisible(false);
	 * anpMenuRegistros.setVisible(false); }
	 */
	@FXML
	void btnAerolineaRegistros(ActionEvent event) {
		pneProgramarVuelo.setVisible(false);
		pneConsultas.setVisible(false);
		pneRegistros.setVisible(true);
		anpMenusVuelos.setVisible(false);
		anpMenuRegistros.setVisible(false);
	}

	@FXML
	void btnAerolineaVueloProgramarVuelo(ActionEvent event) {
		// 1 capa
		pneProgramarVuelo.setVisible(false);
		pneConsultas.setVisible(false);
		pneRegistros.setVisible(false);
		anpMenusVuelos.setVisible(true);
		anpMenuRegistros.setVisible(false);
		// 2 capa
		paneAerolineaAgendarVuelo.setVisible(true);
		paneSolicitudesAerolinea.setVisible(false);

		//
		spinnerFecha1.setDisable(false);
		spinnerHoravuelo1.setDisable(false);
		spinnerMinutos.setDisable(false);
		btnDisponibilidad.setDisable(false);

		hbxTipovuelo1.setDisable(true);
		hbxIdavion1.setDisable(true);
		hbxIdpiloto1.setDisable(true);
		hbxIdcopiloto1.setDisable(true);
		btnSolicitaragendamientoAgendavuelo.setDisable(true);

		// limpiar antes
		limpiarprogramarvuelos();

	}

	public void limpiarprogramarvuelos() {

		txfIdavionagendarvuelo.clear();
		txfIdpilotaagendavuelos.clear();
		txfIdcopilotoAgendavuelo.clear();
	}

	@FXML
	void hiperlinkAgendarVueloAerolinea(ActionEvent event) {
		pneProgramarVuelo.setVisible(true);
		pneConsultas.setVisible(false);
		pneRegistros.setVisible(false);
		anpMenusVuelos.setVisible(false);
		anpMenuRegistros.setVisible(false);
		// 2 capa
		paneAerolineaAgendarVuelo.setVisible(false);
		paneSolicitudesAerolinea.setVisible(false);
	}

	@FXML
	void Regresar1(ActionEvent event) {
		pneProgramarVuelo.setVisible(false);
		pneConsultas.setVisible(false);
		pneRegistros.setVisible(false);
		anpMenusVuelos.setVisible(true);
		anpMenuRegistros.setVisible(false);
		// 2 capa
		paneAerolineaAgendarVuelo.setVisible(false);
		paneSolicitudesAerolinea.setVisible(true);
		paneModificarVueloAerolinea.setVisible(false);

		// metodos
		txfvueloSolicitudesAprobadas.clear();
		limpiar_agenda_vuelos_aerolinea();
		cargarvuelos();

	}

	@FXML
	void Regresar2(ActionEvent event) {
		pneProgramarVuelo.setVisible(false);
		pneConsultas.setVisible(false);
		pneRegistros.setVisible(false);
		anpMenusVuelos.setVisible(false);
		anpMenuRegistros.setVisible(true);
		// 2 capa
		paneAerolineaRegistrarPiloto.setVisible(false);
		paneAerolineaModificarPiloto.setVisible(true);
		paneRegistrarAvion.setVisible(false);
		paneModificaravion.setVisible(false);
		// 3 capa
		vbxModificarPiloto.setVisible(false);
		vbxListaPilotos.setVisible(true);

		// Limpieza del table view
		limpiar_pantalla_pilotos();
		cargar_pilotos();

	}

	@FXML
	void eliminarvuelosaprobadas(ActionEvent event) {

		String idvuelo = txfvueloSolicitudesAprobadas.getText();
		conexionbd conexion = new conexionbd();

		if (idvuelo != "") {
			conexion.eliminarvuelo(idvuelo);
			limpiarvuelos();
			cargarvuelos();
			txfvueloSolicitudesAprobadas.clear();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error ");
			alert.setHeaderText("No digito ningun ID de vuelo");
			alert.setContentText("Haga clic en Aceptar para volver a la agenda de vuelos.");
			alert.showAndWait();
		}

	}

	@FXML
	private HBox spinnerFecha1, spinnerHoravuelo1, spinnerMinutos, btnDisponibilidad, hbxTipovuelo1, hbxIdavion1,
			hbxIdpiloto1, hbxIdcopiloto1;

	@FXML
	void solicitaragendaaerolinea(ActionEvent event) {
		String tipovuelo = cbxRipodevuelo.getValue();
		String idavion = txfIdavionagendarvuelo.getText();
		String idpiloto = txfIdpilotaagendavuelos.getText();
		String idcopiloto = txfIdcopilotoAgendavuelo.getText();
		LocalDate fecha = datepickFechaAgenda.getValue();
		int hora = spinnerHoraagendavuelo.getValue();
		int minutos = spinnerHoraagendavuelo2.getValue();
		if (tipovuelo != "" && idavion != "" && idpiloto != "" && fecha != null) {
			conexionbd conexion = new conexionbd();
			if (conexion.programarvueloaerolinea(tipovuelo, idavion, idpiloto, idcopiloto, fecha, hora, minutos)) {
				limpiarprogramarvuelos();

			}

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No se pudo programar el vuelo.");
			alert.setContentText("Debe diligenciar todos los campos correspondientes.");
			alert.showAndWait();
		}
	}

	@FXML
	void btnComprobardisponib(ActionEvent event) {
		// boton a programar

		LocalDate fechadatepicker = datepickFechaAgenda.getValue();
		String fecha = fechadatepicker.toString();
		int hora = spinnerHoraagendavuelo.getValue();
		int minutos = spinnerHoraagendavuelo2.getValue();

		conexionbd conexion = new conexionbd();
		if (!conexion.validarhoravuelo(fecha, hora, minutos)) {
			spinnerFecha1.setDisable(true);
			spinnerHoravuelo1.setDisable(true);
			spinnerMinutos.setDisable(true);
			btnDisponibilidad.setDisable(true);

			hbxTipovuelo1.setDisable(false);
			hbxIdavion1.setDisable(false);
			hbxIdpiloto1.setDisable(false);
			hbxIdcopiloto1.setDisable(false);
			btnSolicitaragendamientoAgendavuelo.setDisable(false);

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error ");
			alert.setHeaderText("Fecha no disponible");
			alert.setContentText("Debe escoger otra fecha");
			alert.showAndWait();
		}

	}

	@FXML
	void btnAerolineaVueloAgendarVuelo(ActionEvent event) {
		// 1 capa
		pneProgramarVuelo.setVisible(false);
		pneConsultas.setVisible(false);
		pneRegistros.setVisible(false);
		anpMenusVuelos.setVisible(true);
		anpMenuRegistros.setVisible(false);
		// 2 capa
		paneAerolineaAgendarVuelo.setVisible(false);
		paneSolicitudesAerolinea.setVisible(true);

		paneModificarVueloAerolinea.setVisible(false);

		// Cargar los datos

		limpiar_agenda_vuelos_aerolinea();
		cargarvuelos();

	}

	@FXML
	void hiperlinkSolicitudesRegresar(ActionEvent event) {
		// 1 capa
		pneProgramarVuelo.setVisible(true);
		pneConsultas.setVisible(false);
		pneRegistros.setVisible(false);
		anpMenusVuelos.setVisible(false);
		anpMenuRegistros.setVisible(false);
		// 2 capa
		paneAerolineaAgendarVuelo.setVisible(false);
		paneSolicitudesAerolinea.setVisible(false);
		paneModificarVueloAerolinea.setVisible(false);

	}

//REGISTROS AEROLINEA

	@FXML
	void registrarpiloto(ActionEvent event) {
		pneProgramarVuelo.setVisible(false);
		pneConsultas.setVisible(false);
		pneRegistros.setVisible(false);
		anpMenusVuelos.setVisible(false);
		anpMenuRegistros.setVisible(true);
		// 2 capa
		paneAerolineaRegistrarPiloto.setVisible(true);
		paneAerolineaModificarPiloto.setVisible(false);
		paneRegistrarAvion.setVisible(false);
		paneModificaravion.setVisible(false);
	}

	@FXML
	void modificarpilota(ActionEvent event) {
		pneProgramarVuelo.setVisible(false);
		pneConsultas.setVisible(false);
		pneRegistros.setVisible(false);
		anpMenusVuelos.setVisible(false);
		anpMenuRegistros.setVisible(true);
		// 2 capa
		paneAerolineaRegistrarPiloto.setVisible(false);
		paneAerolineaModificarPiloto.setVisible(true);
		paneRegistrarAvion.setVisible(false);
		paneModificaravion.setVisible(false);
		// 3 capa
		vbxListaPilotos.setVisible(true);
		vbxModificarPiloto.setVisible(false);

		// cargar datos piloto
		limpiar_pantalla_pilotos();
		cargar_pilotos();

	}

	@FXML
	void modificarpilotolista(ActionEvent event) {
		// 1 capa
		pneProgramarVuelo.setVisible(false);
		pneConsultas.setVisible(false);
		pneRegistros.setVisible(false);
		anpMenusVuelos.setVisible(false);
		anpMenuRegistros.setVisible(true);

		// 2 capa
		paneAerolineaRegistrarPiloto.setVisible(false);
		paneAerolineaModificarPiloto.setVisible(true);
		paneRegistrarAvion.setVisible(false);
		paneModificaravion.setVisible(false);
		// 3 capa
		vbxListaPilotos.setVisible(false);
		vbxModificarPiloto.setVisible(true);

		// Modificar lista

		String idPiloto = txfIdpiloto.getText();

		if (idPiloto != null) {
			conexionbd conexion = new conexionbd();

			pilotoAL piloto = conexion.cargarpilotoamodificar(idPiloto);

			// limpiar text fields

			if (piloto != null) {
				String cedula = conexion.cargarpilotoamodificar(idPiloto).getCedula();
				String nombre = conexion.cargarpilotoamodificar(idPiloto).getNombre();
				String apellido = conexion.cargarpilotoamodificar(idPiloto).getApellido();
				String horas = conexion.cargarpilotoamodificar(idPiloto).getHorasvueloacum();
				Date fecharevmed = conexion.cargarpilotoamodificar(idPiloto).getFecharevmed();
				LocalDate date = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(fecharevmed));
				String licencia = conexion.cargarpilotoamodificar(idPiloto).getLicencia();

				txfNombrePilotoModificar.clear();
				txfApellidoModificarpiloto.clear();
				txfCedulaModificarPiloto.clear();
				txfLicenciaModificarPiloto.clear();
				txfHoravuelosacumuladosModificar.clear();
				datepickerModificarVuelo.setValue(null);

				// cargar los datos en el menu

				txfNombrePilotoModificar.setText(nombre);
				txfApellidoModificarpiloto.setText(apellido);
				txfCedulaModificarPiloto.setText(cedula);
				txfLicenciaModificarPiloto.setText(licencia);
				txfHoravuelosacumuladosModificar.setText(horas);
				datepickerModificarVuelo.setValue(date);
			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error ");
				alert.setHeaderText("No se encontro el piloto");
				alert.setContentText("Debe digitar una cedula valida para el piloto");
				alert.showAndWait();
			}

		}
	}

	@FXML
	void registraravionaerolinea(ActionEvent event) {

		pneProgramarVuelo.setVisible(false);
		pneConsultas.setVisible(false);
		pneRegistros.setVisible(false);
		anpMenusVuelos.setVisible(false);
		anpMenuRegistros.setVisible(true);
		// 2 capa
		paneAerolineaRegistrarPiloto.setVisible(false);
		paneAerolineaModificarPiloto.setVisible(false);
		paneRegistrarAvion.setVisible(true);
		paneModificaravion.setVisible(false);

	}

	@FXML
	void regresarRegistropiloto(ActionEvent event) {
		pneProgramarVuelo.setVisible(false);
		pneConsultas.setVisible(false);
		pneRegistros.setVisible(true);
		anpMenusVuelos.setVisible(false);
		anpMenuRegistros.setVisible(false);
		// 2 capa
		paneAerolineaRegistrarPiloto.setVisible(false);
		paneAerolineaModificarPiloto.setVisible(false);
		paneRegistrarAvion.setVisible(false);
		paneModificaravion.setVisible(false);

	}

	@FXML
	void eliminaravion(ActionEvent event) {
		pneProgramarVuelo.setVisible(false);
		pneConsultas.setVisible(false);
		pneRegistros.setVisible(false);
		anpMenusVuelos.setVisible(false);
		anpMenuRegistros.setVisible(true);
		// 2 capa
		paneAerolineaRegistrarPiloto.setVisible(false);
		paneAerolineaModificarPiloto.setVisible(false);
		paneRegistrarAvion.setVisible(false);
		paneModificaravion.setVisible(true);
		// 3 capa
		vbxAdministrarAviones.setVisible(true);
		vbxModificaravion.setVisible(false);

		// cargar aviones
		tbleviewListaaviones.getItems().clear();
		cargaraviones();

	}

	@FXML
	void eliminaravion2(ActionEvent event) {

		String idavion = txfIdpilotorlistaaviones.getText();
		if (idavion != null) {
			conexionbd conexion = new conexionbd();
			conexion.eliminaravion(idavion);
			tbleviewListaaviones.getItems().clear();
			cargaraviones();

			txfIdpilotorlistaaviones.clear();

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Campo vacío");
			alert.setContentText("Digite un id para eliminar al avion.");
			alert.showAndWait();
		}
	}

	@FXML
	void eliminarpiloto(ActionEvent event) {

		String idpiloto = txfIdpiloto.getText();
		if (idpiloto != "") {
			conexionbd conexion = new conexionbd();
			conexion.eliminarpiloto(idpiloto);
			limpiar_pantalla_pilotos();
			cargar_pilotos();
			txfIdpiloto.clear();

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Campo vacío");
			alert.setContentText("Digite un ID para poder eliminar al piloto.");
			alert.showAndWait();
		}

	}

	@FXML
	void regresarlistapilotos(ActionEvent event) {
		pneProgramarVuelo.setVisible(false);
		pneConsultas.setVisible(false);
		pneRegistros.setVisible(true);
		anpMenusVuelos.setVisible(false);
		anpMenuRegistros.setVisible(false);
		// 2 capa
		paneAerolineaRegistrarPiloto.setVisible(false);
		paneAerolineaModificarPiloto.setVisible(false);
		paneRegistrarAvion.setVisible(false);
		paneModificaravion.setVisible(false);
		// 3 capa
		vbxListaPilotos.setVisible(false);
		vbxModificarPiloto.setVisible(false);

	}

	@FXML
	void guardaravion(ActionEvent event) {
		String idavion = txfIdavionregistroavion.getText();
		String tipodeavion = cbxTipoavionRegistroAvion.getValue();
		String capacidadcarga = txfCapacidadCargaNumeroPuestos.getText();
		String modelo = txfModeloavion121.getText();
		String tipopropulsion = txfTipopropulsion121.getText();
		String numerodemotores = txfNumeromotores1222.getText();
		String pesonominal = txfPesonominalavion1222.getText();

		conexionbd conexion = new conexionbd();
		if (idaerolinealogin != "") {
			if (cbxTipoavionRegistroAvion.getValue() != null) {
				if (tipodeavion != "" && idavion != "" && capacidadcarga != "" && modelo != "" && tipopropulsion != ""
						&& numerodemotores != "" && pesonominal != "") {
					conexion.guardaraviones(idavion, tipodeavion, capacidadcarga, modelo, tipopropulsion,
							numerodemotores, pesonominal, idaerolinealogin);

					// Limpiar pantalla
					cbxTipoavionRegistroAvion.setValue(null);
					txfIdavionregistroavion.clear();
					txfCapacidadCargaNumeroPuestos.clear();
					txfModeloavion121.clear();
					txfTipopropulsion121.clear();
					txfNumeromotores1222.clear();
					txfPesonominalavion1222.clear();
					cbxTipoavionRegistroAvion.setPromptText("tipo de avion");
					txfIdpilotorlistaaviones.clear();

				} else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Registro no guardado");
					alert.setContentText("Los campos no deben estar vacíos");
					alert.showAndWait();
				}

			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Debe seleccionar un tipo de avión.");
				alert.setContentText("Elija una opcion correcta en Tipo de avión.");
				alert.showAndWait();
			}

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No se encontro a la aerolinea");
			alert.setContentText("Debe estar logeado con el id valido de una aerolinea");
			alert.showAndWait();
		}
	}

	@FXML
	void guardar_modificaravion(ActionEvent event) {
		String tipoavion = cbxTipoavionmodificar.getValue();
		String idavion = txfIdavionmodificar.getText();
		String capacidad = txfCpacidadcargapuestos.getText();
		String modelo = txfModeloavion129.getText();
		String propulsion = txfTipopropulsion116.getText();
		String motores = txfNumeromotoresmodifcaarvion.getText();
		String peso = txfPesonominalavion1128.getText();

		conexionbd conexion = new conexionbd();
		if (tipoavion != "") {
			if (idavion != "" && capacidad != "" && modelo != "" && propulsion != "" && motores != "" && peso != "") {
				// limpiar pantalla

				cbxTipoavionmodificar.setPromptText("Tipo de avion");
				txfIdavionmodificar.clear();
				txfCpacidadcargapuestos.clear();
				txfModeloavion129.clear();
				txfTipopropulsion116.clear();
				txfNumeromotoresmodifcaarvion.clear();
				txfPesonominalavion1128.clear();
				//
				txfIdpilotorlistaaviones.clear();

				// cambiar a la vista anterior
				pneProgramarVuelo.setVisible(false);
				pneConsultas.setVisible(false);
				pneRegistros.setVisible(false);
				anpMenusVuelos.setVisible(false);
				anpMenuRegistros.setVisible(true);
				// 2 capa
				paneAerolineaRegistrarPiloto.setVisible(false);
				paneAerolineaModificarPiloto.setVisible(false);
				paneRegistrarAvion.setVisible(false);
				paneModificaravion.setVisible(true);
				// 3 capa
				vbxAdministrarAviones.setVisible(true);
				vbxModificaravion.setVisible(false);

				// cargar losd datos

				tbleviewListaaviones.getItems().clear();
				cargaraviones();

				conexion.guardarmodificaravion(tipoavion, idavion, capacidad, modelo, propulsion, motores, peso);
			} else {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Error.");
				alert.setHeaderText("Campos vacios");
				alert.setContentText("Verifique los datos e intentelo de nuevo");
				alert.showAndWait();
			}

		} else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Error.");
			alert.setHeaderText("Debe seleccionar el tipo de avion");
			alert.setContentText("Debe diligenciar toda la informacion sin dejar campos vacios");
			alert.showAndWait();
		}

	}

	@FXML
	void hiperlinkModificaravionregresar(ActionEvent event) {
		pneProgramarVuelo.setVisible(false);
		pneConsultas.setVisible(false);
		pneRegistros.setVisible(false);
		anpMenusVuelos.setVisible(false);
		anpMenuRegistros.setVisible(true);
		// 2 capa
		paneAerolineaRegistrarPiloto.setVisible(false);
		paneAerolineaModificarPiloto.setVisible(false);
		paneRegistrarAvion.setVisible(false);
		paneModificaravion.setVisible(true);
		// 3 capa
		vbxAdministrarAviones.setVisible(true);
		vbxModificaravion.setVisible(false);

		// cargar losd datos

		tbleviewListaaviones.getItems().clear();
		cargaraviones();

	}

	@FXML
	void modificaravion(ActionEvent event) {

		// MODIFICAR DATOS
		conexionbd conexion = new conexionbd();

		if (idaerolinealogin != "" && txfIdpilotorlistaaviones.getText() != "") {
			avionAL avion = conexion.retornaavionamodificar(idaerolinealogin, txfIdpilotorlistaaviones.getText());

			// ***********************************
			pneProgramarVuelo.setVisible(false);
			pneConsultas.setVisible(false);
			pneRegistros.setVisible(false);
			anpMenusVuelos.setVisible(false);
			anpMenuRegistros.setVisible(true);
			// 2 capa
			paneAerolineaRegistrarPiloto.setVisible(false);
			paneAerolineaModificarPiloto.setVisible(false);
			paneRegistrarAvion.setVisible(false);
			paneModificaravion.setVisible(true);
			// 3 capa
			vbxAdministrarAviones.setVisible(false);
			vbxModificaravion.setVisible(true);

			// **************************************

			txfIdavionmodificar.setText(avion.getIdavion());
			txfCpacidadcargapuestos.setText(avion.getCapacidad());
			txfModeloavion129.setText(avion.getModelo());
			txfTipopropulsion116.setText(avion.getTipopropulsion());
			txfNumeromotoresmodifcaarvion.setText(avion.getNumeromotores());
			txfPesonominalavion1128.setText(avion.getPesonominal());

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error ");
			alert.setHeaderText("Campo vacio ");
			alert.setContentText("Debe digitar un id de avion valido");
			alert.showAndWait();
		}

	}

	@FXML
	void hiperlinkRegresarlistaaviones(ActionEvent event) {
		pneProgramarVuelo.setVisible(false);
		pneConsultas.setVisible(false);
		pneRegistros.setVisible(true);
		anpMenusVuelos.setVisible(false);
		anpMenuRegistros.setVisible(false);
		// 2 capa
		paneAerolineaRegistrarPiloto.setVisible(false);
		paneAerolineaModificarPiloto.setVisible(false);
		paneRegistrarAvion.setVisible(false);
		paneModificaravion.setVisible(false);
		// 3 capa
		vbxAdministrarAviones.setVisible(false);
		vbxModificaravion.setVisible(false);
	}

	@FXML
	void regresarRegistroavion(ActionEvent event) {

		pneProgramarVuelo.setVisible(false);
		pneConsultas.setVisible(false);
		pneRegistros.setVisible(true);
		anpMenusVuelos.setVisible(false);
		anpMenuRegistros.setVisible(false);
		// 2 capa
		paneAerolineaRegistrarPiloto.setVisible(false);
		paneAerolineaModificarPiloto.setVisible(false);
		paneRegistrarAvion.setVisible(false);
		paneModificaravion.setVisible(false);

	}

	@FXML
	void requierecopiloto1(ActionEvent event) {

	}

	@FXML
	void requierecopiloto2(ActionEvent event) {

	}

	@FXML
	void guardarpiloto(ActionEvent event) {
		String nombre = txfNombrepiloto.getText();
		String apellido = txfApellidoPiloto.getText();
		String cedula = txfCedulaPiloto.getText();
		String licencia = txfLicenciaPiloto.getText();
		String horasvueloacumuladas = txfHorasVueloAcum.getText();
		LocalDate fecha = dtepickRevisionmedica.getValue();

		conexionbd conexion = new conexionbd();
		if (nombre != "" && apellido != "" && cedula != "" && licencia != "" && horasvueloacumuladas != ""
				&& fecha != null) {
			conexion.guardarpiloto(nombre, apellido, cedula, licencia, horasvueloacumuladas, fecha);

			// Limpiar los registros
			txfNombrepiloto.clear();
			txfApellidoPiloto.clear();
			txfCedulaPiloto.clear();
			txfLicenciaPiloto.clear();
			txfHorasVueloAcum.clear();

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Registro invalido.");
			alert.setContentText("Debe ingresar toda la informacion sin dejar campos vacios.");
			alert.showAndWait();
		}

	}

// *************************************************************************************************************
// *************************************************AEROPUERTO**************************************************
// *************************************************************************************************************

	@FXML
	private Button btnSalirAeropuerto, btnCerrrarSesionAeropuerto;
	@FXML
	private TextField txfModificarNombreAerolineaeste;

	@FXML
	void cerrarSesionAeropuerto(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(false);
		anpMenuAeropuerto.setVisible(false);
		anpLogin.setVisible(true);
		limpiarlogin();
	}

	@FXML
	void salirAeropuerto(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void btnModificarVueloGuardarEmpleado(ActionEvent event) {

	}

	@FXML
	void btnRegistrarAvionEnHangar(ActionEvent event) {

		String idhangar = txfIdhangar.getText();
		String idavion = cmbIdavionHangar.getValue();

		Date date = new Date();
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		String horaentrada = hourFormat.format(date);

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String fechaentrada = dateFormat.format(date);
		if (idhangar != "" && idavion != null) {
			if (conexion.comprobardisponibilidadhangar(idhangar)) {
				conexion.asignaravionahangar(idhangar, idavion, horaentrada, fechaentrada);
				txfIdhangar.clear();
				cmbIdavionHangar.getSelectionModel().clearSelection();
				// *****
				limpiarhangaresvacios();
				limpiar_avionescombohangar();
				cargaraviones_comboboxhangar();
				cargarhangaresaeropuerto();
			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("El id del hangar no esta disponible o no esta registrado");
				alert.setContentText("Dele clic en aceptar para continuar");
				alert.showAndWait();
			}

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Debe digitar el id del hangar y seleccionar el id del avion");
			alert.setContentText("Dele clic en aceptar para continuar");
			alert.showAndWait();
		}

	}

	@FXML
	void btnModificarEmpleadobtnAeropuertoRegistrosModificarEmpleadoAeropuerto(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(true);
		// secundario
		paneRegistrarEmpleado.setVisible(false);
		paneModificarEmpleado.setVisible(true);
		paneRegistrarAerolinea.setVisible(false);
		paneModificarAerolinea.setVisible(false);
		paneRegistrarHangar.setVisible(false);
		paneModificarHangar.setVisible(false);
		// terciario
		vbxModificarUsuarioTableView.setVisible(true);

		vbxMenus_aeropuerto_ModificarEmpleado.setVisible(false);

		// Limpiar datos antes
		limpiar_tabla_usuario_aeropuerto();

		// cargar datos

		cargar_usuario_aeropuerto();

	}

	@FXML
	void btnAeropuertoAgendaAgendarVuelos(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(true);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(false);

		// SECUNDARIO
		paneAgendaVuelos.setVisible(true);
		paneModificarAgenda.setVisible(false);
		paneSolicitudesCambio.setVisible(false);

		// metodos
		limpiarvueloaeropuerto();
		cargarvueloscomoaeropuerto();

	}

	@FXML
	void AgendaAeropuerto(ActionEvent event) {

		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(true);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(false);

		// SECUNDARIO
		paneAgendaVuelos.setVisible(true);
		paneModificarAgenda.setVisible(false);
		paneSolicitudesCambio.setVisible(false);

		limpiarvueloaeropuerto();
		cargarvueloscomoaeropuerto();

	}

	@FXML
	void HangarAeropuerto(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(true);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(false);

	}

	@FXML
	void RegistroAeropuerto(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(true);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(false);

	}

	// AGENDA AEROPUERTO

	@FXML
	void modificarsolicitudesaprobadas(ActionEvent event) {
		// Metodos
		String idvuelo = txfvueloSolicitudesAprobadas.getText();
		if (idvuelo != "") {
			if (conexion.verificarvuelo(idvuelo)) {
				// Cambiar de vista
				// 1 capa
				pneProgramarVuelo.setVisible(false);
				pneConsultas.setVisible(false);
				pneRegistros.setVisible(false);
				anpMenusVuelos.setVisible(true);
				anpMenuRegistros.setVisible(false);
				// 2 capa
				paneAerolineaAgendarVuelo.setVisible(false);
				paneSolicitudesAerolinea.setVisible(false);
				paneModificarVueloAerolinea.setVisible(true);
				paneSolicitudesAerolinea.setVisible(false);

				//
				// darle valor al combo box
				vueloAL vuelo = conexion.retornarvuelo(idvuelo);
				cbxTipodevueloModificarVuelo.setValue(vuelo.getTipovuelo());
				txfIdavionagendarvuelo1.setText(vuelo.getId_avion());
				txfIdpilotaagendavuelos1.setText(vuelo.getPiloto());
				txfIdcopilotoAgendavuelo1.setText(vuelo.getCopiloto());
				LocalDate date = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(vuelo.getFecha()));
				datepickFechaAgenda1.setValue(date);

				//
				SpinnerValueFactory<Integer> value3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23);
				spinnerHoraagendavuelo1.setValueFactory(value3);
				SpinnerValueFactory<Integer> value4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59);
				spinnerHoraagendavuelo21.setValueFactory(value4);

				value3.setValue(Integer.parseInt(vuelo.getHora()));
				value4.setValue(Integer.parseInt(vuelo.getMinutos()));

			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("No se encontro informacion del vuelo digitado");
				alert.setContentText("Ingrese la informacion correspondiente y luego pulse modificar");
				alert.showAndWait();
			}

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No debe dejar el campo idvuelo vacio");
			alert.setContentText("Digite un Id de vuelo valido");
			alert.showAndWait();
		}

	}

	@FXML
	void btnModificarAgendaVuelos(ActionEvent event) {

		if (txfAgendaVuelos1.getText() != "") {
			if (conexion.verificarvuelo(txfAgendaVuelos1.getText())) {
				paneAgendaVuelos.setVisible(false);
				paneModificarAgenda.setVisible(true);
				paneSolicitudesCambio.setVisible(false);
				txfVueloSeleccionadoModificar.setText(txfAgendaVuelos1.getText());
				vueloAL vuelo = conexion.retornarvuelo(txfAgendaVuelos1.getText());
				Date fecha = vuelo.getFecha();
				txfVueloSeleccionadoModificar.setText(txfAgendaVuelos1.getText());
				// pasar la fecha a localdate
				LocalDate date = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(fecha));
				datepickFechaModificarVuelos.setValue(date);
				int hora = Integer.parseInt(vuelo.getHora());
				int minutos = Integer.parseInt(vuelo.getMinutos());

				SpinnerValueFactory<Integer> value = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23);
				spinnerHoraModificaVuelo1.setValueFactory(value);
				value.setValue(hora);

				SpinnerValueFactory<Integer> value2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59);
				spinnerHoraModificaVuelo11.setValueFactory(value2);
				value2.setValue(minutos);

				limpiarmodificarvueloaero();
				cargarvuelomodificarvueloaero();

			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("No se encontro informacion del vuelo digitado");
				alert.setContentText("Ingrese la informacion correspondiente y luego pulse modificar");
				alert.showAndWait();
			}

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Campos vacios");
			alert.setHeaderText("Debe digitar el ID del vuelo");
			alert.setContentText("Ingrese la información correspondiente y luego pulse en Modificar");
			alert.showAndWait();
		}

	}

	@FXML
	void solicitaragendaaerolinea2(ActionEvent event) {
		String idvuelo = txfvueloSolicitudesAprobadas.getText();

		String tipodevuelo = cbxTipodevueloModificarVuelo.getValue();
		String idavion = txfIdavionagendarvuelo1.getText();
		String piloto = txfIdpilotaagendavuelos1.getText();
		String copiloto = txfIdcopilotoAgendavuelo1.getText();
		LocalDate fecha = datepickFechaAgenda1.getValue();
		int horas = spinnerHoraagendavuelo1.getValue();
		int minutos = spinnerHoraagendavuelo21.getValue();

		if (idavion != "" && piloto != "" && fecha != null) {

			if (!conexion.validarhoravuelo(fecha.toString(), horas, minutos)) {

				conexion.modificarvueloaerolinea(idvuelo, fecha, horas, minutos, tipodevuelo, idavion, piloto,
						copiloto);

				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Registro guardado");
				alert.setHeaderText("La solicitud de agendamiento se ha guardado con exito.");
				alert.setContentText("Haga clic en aceptar para regresar al menu de modificar vuelos");
				alert.showAndWait();

				// Cambiar vista
				pneProgramarVuelo.setVisible(false);
				pneConsultas.setVisible(false);
				pneRegistros.setVisible(false);
				anpMenusVuelos.setVisible(true);
				anpMenuRegistros.setVisible(false);
				// 2 capa
				paneAerolineaAgendarVuelo.setVisible(false);
				paneSolicitudesAerolinea.setVisible(true);
				paneModificarVueloAerolinea.setVisible(false);

				// metodos
				txfvueloSolicitudesAprobadas.clear();
				limpiar_agenda_vuelos_aerolinea();
				cargarvuelos();

			} else {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Registro no modificado");
				alert.setHeaderText("La solicitud de agendamiento no se modifico");
				alert.setContentText("Haga clic en aceptar para regresar al menu de modificar vuelos");
				alert.showAndWait();

			}
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Campos vacios");
			alert.setHeaderText("Solicitud no completada");
			alert.setContentText("Revise los datos ingresados e intentelo de nuevo");
			alert.showAndWait();
		}

	}

	@FXML
	void btnAeropuertoModificarVuelos(ActionEvent event) {

		if (spinnerHoraModificaVuelo1.getValue() != null && spinnerHoraModificaVuelo11.getValue() != null
				&& datepickFechaModificarVuelos.getValue() != null) {
			LocalDate fechadatepicker = datepickFechaModificarVuelos.getValue();
			String fecha = fechadatepicker.toString();
			int hora = spinnerHoraModificaVuelo1.getValue();
			int minutos = spinnerHoraModificaVuelo11.getValue();
			String tipovuelo = txfVueloSeleccionadoModificar.getText();

			if (tipovuelo != "" && datepickFechaModificarVuelos.getValue() != null
					&& spinnerHoraModificaVuelo1.getValue() != null && spinnerHoraModificaVuelo11.getValue() != null) {

				if (!conexion.validarhoravuelo(fecha, hora, minutos)) {

					conexion.modificarvuelo(tipovuelo, datepickFechaModificarVuelos.getValue(),
							spinnerHoraModificaVuelo1.getValue(), spinnerHoraModificaVuelo11.getValue());

					limpiarmodificarvueloaero();
					cargarvuelomodificarvueloaero();

					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Guardado");
					alert.setHeaderText("Registro modificado");
					alert.setContentText("Se guardaron los cambios correctamente");
					alert.showAndWait();

					// }
				} else {

					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Fecha y hora no disponible");
					alert.setContentText("Debe escoger otra fecha u otra hora");
					alert.showAndWait();
				}

			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error ");
				alert.setHeaderText("Campos vacios");
				alert.setContentText("Debe digitar toda la informacion");
				alert.showAndWait();

			}
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error ");
			alert.setHeaderText("Campos vacios");
			alert.setContentText("Debe digitar toda la informacion");
			alert.showAndWait();
		}

	}

	public controlador() {
		// TODO Auto-generated constructor stub
	}

	@FXML
	void btnEliminarAgendaVuelos(ActionEvent event) {
		String idvuelo = txfAgendaVuelos1.getText();
		if (idvuelo != "") {
			conexion.eliminarvuelo(idvuelo);
			limpiarvueloaeropuerto();
			cargarvueloscomoaeropuerto();
			txfAgendaVuelos1.clear();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error ");
			alert.setHeaderText("No digito ningun ID de vuelo");
			alert.setContentText("Haga clic en Aceptar para volver a la agenda de vuelos.");
			alert.showAndWait();
		}

	}

	@FXML
	void hiperlinkRegresarAgendaVuelos(ActionEvent event) {
		pneAgenda.setVisible(true);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(false);

		// SECUNDARIO
		paneAgendaVuelos.setVisible(false);
		paneModificarAgenda.setVisible(false);
		paneSolicitudesCambio.setVisible(false);
	}

	@FXML
	void hiperLinkRegresarModificarVuelo(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(true);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(false);

		// SECUNDARIO
		paneAgendaVuelos.setVisible(true);
		paneModificarAgenda.setVisible(false);
		paneSolicitudesCambio.setVisible(false);

		limpiarvueloaeropuerto();
		cargarvueloscomoaeropuerto();

	}

	@FXML
	void btnAeropuertoAgendaSolicitudesCambio(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(true);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(false);

		// secundario
		paneSolicitudesCambio.setVisible(true);

	}

	@FXML
	void btnAgregarSolicitudesdeVuelos(ActionEvent event) {

	}

	@FXML
	void modificarSolicitudesVuelos(ActionEvent event) {

	}

	@FXML
	void btnRegresarSolicitudesVuelos(ActionEvent event) {
		pneAgenda.setVisible(true);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(false);

		// secundario
		paneSolicitudesCambio.setVisible(false);
	}

	@FXML
	void btnAeropuertoHangarRegistrarLlegada(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(true);
		anprMenusRegistros.setVisible(false);
		// secundario
		paneRegistrarLlegada.setVisible(true);
		paneRegistrarFacturaHangar.setVisible(false);
		paneFacturasRealizadasHnagar.setVisible(false);

		// -----------------------------------------------------------------

		limpiarhangaresvacios();
		limpiar_avionescombohangar();
		cargaraviones_comboboxhangar();
		cargarhangaresaeropuerto();

		// conexio.cargarHangaresDesocupados(tbleviewGestionarhangares1);

	}

	@FXML
	void hiperlinkRegresarHangar(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(true);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(false);
		// secundario
		paneRegistrarLlegada.setVisible(false);
		paneRegistrarFacturaHangar.setVisible(false);
		paneFacturasRealizadasHnagar.setVisible(false);
	}

	@FXML
	void btnAeropuertoHangarFacturarSalida(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(true);
		anprMenusRegistros.setVisible(false);
		// secundario
		paneRegistrarLlegada.setVisible(false);
		paneRegistrarFacturaHangar.setVisible(true);
		paneFacturasRealizadasHnagar.setVisible(false);

		// AA
		limpiarhangaresocupados();
		cargarhangaresocupadoss();

	}

	@FXML
	void btnFacturarVueloEnHangares(ActionEvent event) {

		String idhangar = txfHangarFacturar.getText();
		// conexion.cambiarestadohangar(idhangar);
		if (idhangar != "") {
			conexion.facturahangar_yregistrar(idhangar);
			txfHangarFacturar.clear();
			limpiarhangaresocupados();
			cargarhangaresocupadoss();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Campos vacios");
			alert.setHeaderText("Debe digitar el Id del hangar");
			alert.setContentText("Delec click en aceptar para continuar");
			alert.showAndWait();
		}

	}

	@FXML
	void hiperlinkRegresarFacturarHangar(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(true);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(false);
		// secundario
		paneRegistrarLlegada.setVisible(false);
		paneRegistrarFacturaHangar.setVisible(false);
		paneFacturasRealizadasHnagar.setVisible(false);
	}

	@FXML
	void btnAeropuertoHangarRegistrosDeHangar(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(true);
		anprMenusRegistros.setVisible(false);
		// secundario
		paneRegistrarLlegada.setVisible(false);
		paneRegistrarFacturaHangar.setVisible(false);
		paneFacturasRealizadasHnagar.setVisible(true);

		// metodos
		limpiar_registroshangar();
		cargar_registros();

	}

	@FXML
	void hiperlinkRegresarVisualizarFacturasHangares(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(true);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(false);
		// secundario
		paneRegistrarLlegada.setVisible(false);
		paneRegistrarFacturaHangar.setVisible(false);
		paneFacturasRealizadasHnagar.setVisible(false);
	}

	@FXML
	void btnAeropuertoRegistrosRegistrarEmpleado(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(true);
		// secundario
		paneRegistrarEmpleado.setVisible(true);
		paneModificarEmpleado.setVisible(false);
		paneRegistrarAerolinea.setVisible(false);
		paneModificarAerolinea.setVisible(false);
		paneRegistrarHangar.setVisible(false);
		paneModificarHangar.setVisible(false);

	}

	@FXML
	void guardarEmpleado(ActionEvent event) {

		String nombre = txfRegistrarEmpleadoNombres.getText();
		String apellido = txfRegistrarEmpleadoApellido.getText();
		String cedula = txfRegistrarEmpleadoCedula.getText();
		String usuario = txfRegistrarEmpleadoUsuario.getText();
		String correo = txfRegistrarEmpleadoCorreo.getText();
		String password = passwordfRegistrarEmpleadoContrasena.getText();

		if (nombre != "" && apellido != "" && usuario != "" && correo != "" && password != "" && cedula != "") {
			conexion.guardarusuarioaeropuerto(nombre, apellido, cedula, usuario, password, correo);
			conexion.guardarusuarioaeropuertosistema(usuario, cedula, password);

			// Limpiar pantalla
			txfRegistrarEmpleadoNombres.clear();
			txfRegistrarEmpleadoApellido.clear();
			txfRegistrarEmpleadoCedula.clear();
			txfRegistrarEmpleadoUsuario.clear();
			txfRegistrarEmpleadoCorreo.clear();
			passwordfRegistrarEmpleadoContrasena.clear();

			//

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Campos vacios");
			alert.setHeaderText("Debe digitar todos los campos");
			alert.setContentText("Verifique si toda la informacion esta completa");
			alert.showAndWait();
		}

	}

	@FXML
	void hiperlinkRegistrarEmpleadoRegresar(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(true);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(false);
		// secundario
		paneRegistrarEmpleado.setVisible(false);
		paneModificarEmpleado.setVisible(false);
		paneRegistrarAerolinea.setVisible(false);
		paneModificarAerolinea.setVisible(false);
		paneRegistrarHangar.setVisible(false);
		paneModificarHangar.setVisible(false);
	}

	@FXML
	void btnModificarUsuarioAeropuerto(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(true);
		// secundario
		paneRegistrarEmpleado.setVisible(false);
		paneModificarEmpleado.setVisible(true);
		paneRegistrarAerolinea.setVisible(false);
		paneModificarAerolinea.setVisible(false);
		paneRegistrarHangar.setVisible(false);
		paneModificarHangar.setVisible(false);
		// terciario
		vbxModificarUsuarioTableView.setVisible(false);
		vbxMenus_aeropuerto_ModificarEmpleado.setVisible(true);

		// MODIFICAR AL USUARIO
		String cedula = txfAdministrarUsuariosCedula.getText();
		// Limpiar pantalla
		txfModificarEmpleadoNombre.clear();
		txfModificarEmpleadoApellido.clear();
		txfModificarEmpleadoCedula.clear();
		txfUsuarioModificarEmpleado.clear();
		txfModificarEmpleadoContrasena.clear();
		txfModificarEmpleadoCorreo.clear();

		// cargar datos
		usuario_aeropuertoAL persona = conexion.cargar_usuarioaeropuerto(cedula);
		if (persona != null) {
			txfModificarEmpleadoNombre.setText(persona.getNombre());
			txfModificarEmpleadoApellido.setText(persona.getApellido());
			txfModificarEmpleadoCedula.setText(persona.getCedula());
			txfUsuarioModificarEmpleado.setText(persona.getUsuario());
			txfModificarEmpleadoContrasena.setText(persona.getPassword());
			txfModificarEmpleadoCorreo.setText(persona.getCorreo());
		}

	}

	@FXML
	void btnEliminarUsuarioAeropuerto(ActionEvent event) {
		String cedula = txfAdministrarUsuariosCedula.getText();
		if (cedula != null) {
			if (conexion.eliminarusuarioaeropuerto(cedula)) {
				// mensaje
				conexion.eliminarusuarioaeropuerto(cedula);
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Registro eliminado");
				alert.setHeaderText("Se elimino al empleado");
				alert.setContentText("Clic en aceptar para continuar ");
				alert.showAndWait();
			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("No se pudo eliminar el empleado");
				alert.setContentText("Clic en aceptar para continuar ");
				alert.showAndWait();
			}
			limpiar_tabla_usuario_aeropuerto();
			cargar_usuario_aeropuerto();
			txfAdministrarUsuariosCedula.clear();

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Campos vacio");
			alert.setHeaderText("Debe digitar una cedula en el campo correspondiente");
			alert.setContentText("Verifique la informacion ");
			alert.showAndWait();
		}

	}

	@FXML
	void mostrarcontrasena1(ActionEvent event) {

	}

	@FXML
	void hiperlinkregresarAdministrarUsuario(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(true);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(false);
		// secundario
		paneRegistrarEmpleado.setVisible(false);
		paneModificarEmpleado.setVisible(false);
		paneRegistrarAerolinea.setVisible(false);
		paneModificarAerolinea.setVisible(false);
		paneRegistrarHangar.setVisible(false);
		paneModificarHangar.setVisible(false);
		// terciario
		vbxModificarUsuarioTableView.setVisible(false);
		vbxMenus_aeropuerto_ModificarEmpleado.setVisible(false);

	}

	@FXML
	void btnModificarVueloGuardarEmpleado1(ActionEvent event) {
		String nombre = txfModificarEmpleadoNombre.getText();
		String apellido = txfModificarEmpleadoApellido.getText();
		String cedula = txfModificarEmpleadoCedula.getText();
		String usuario = txfUsuarioModificarEmpleado.getText();
		String password = txfModificarEmpleadoContrasena.getText();
		String correo = txfModificarEmpleadoCorreo.getText();
		if (nombre != "" && apellido != "" && usuario != "" && correo != "" && password != "" && cedula != "") {
			conexion.modificar_usuario_aeropuerto(nombre, apellido, cedula, usuario, password, correo);
			// Limpiar pantalla

			txfRegistrarEmpleadoNombres.clear();
			txfRegistrarEmpleadoApellido.clear();
			txfRegistrarEmpleadoCedula.clear();
			txfRegistrarEmpleadoUsuario.clear();
			txfRegistrarEmpleadoCorreo.clear();
			passwordfRegistrarEmpleadoContrasena.clear();
			// Limpiar pantalla modificar empleados
			txfModificarEmpleadoNombre.clear();
			txfModificarEmpleadoApellido.clear();
			txfModificarEmpleadoCedula.clear();
			txfUsuarioModificarEmpleado.clear();
			txfModificarEmpleadoContrasena.clear();
			txfModificarEmpleadoCorreo.clear();
			// Limpia textfield
			txfAdministrarUsuariosCedula.clear();

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Campos vacios");
			alert.setHeaderText("Debe digitar todos los campos");
			alert.setContentText("Verifique si toda la informacion esta completa");
			alert.showAndWait();
		}
	}

	@FXML
	void EliminarAerolineas(ActionEvent event) {
		String idaerolinea = txfAdministraraerolinea1.getText();

		if (idaerolinea != "") {
			conexion.eliminar_aerolinea(idaerolinea);

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Eliminado ");
			alert.setHeaderText("Registro eliminado");
			alert.setContentText("Se elimino satisfactoriamente la aerolinea");
			alert.showAndWait();

			limpiar_tabla_aerolineas();
			cargar_aerolineas_aeropuerto();
			txfAdministraraerolinea1.clear();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error ");
			alert.setHeaderText("Campo vacío");
			alert.setContentText("Debe escribir el id de la aerolinea para eliminar la aerolinea");
			alert.showAndWait();
		}

	}

	@FXML
	void hiperlinkRegresarModificarempleado(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(true);
		// secundario
		paneRegistrarEmpleado.setVisible(false);
		paneModificarEmpleado.setVisible(true);
		paneRegistrarAerolinea.setVisible(false);
		paneModificarAerolinea.setVisible(false);
		paneRegistrarHangar.setVisible(false);
		paneModificarHangar.setVisible(false);
		// terciario
		vbxModificarUsuarioTableView.setVisible(true);
		vbxMenus_aeropuerto_ModificarEmpleado.setVisible(false);

		// CARGAR DATOS
		limpiar_tabla_usuario_aeropuerto();
		cargar_usuario_aeropuerto();
	}

	@FXML
	void btnAeropuertoRegistrosRegistrarAerolinea(ActionEvent event) {

		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(true);
		// secundario
		paneRegistrarEmpleado.setVisible(false);
		paneModificarEmpleado.setVisible(false);
		paneRegistrarAerolinea.setVisible(true);
		paneModificarAerolinea.setVisible(false);
		paneRegistrarHangar.setVisible(false);
		paneModificarHangar.setVisible(false);

	}

	@FXML
	void btnGuardarRegistrodeAerolinea(ActionEvent event) {
		String idaerolinea = txfIdaerolinea.getText();
		String nombre = txfRegistrarAerolineaNombreAerolinea.getText();
		String usuario = txfRegistrarUsuarioRegistrarAerolinea.getText();
		String password = txfRegistrarAerolineaContrasena.getText();
		String correo = txfCorreoRegistrarAerolinea.getText();

		if (idaerolinea != "" && nombre != "" && usuario != "" && password != "" && correo != "") {
			conexion.guardaraerolinea(idaerolinea, nombre, correo, usuario, password);

			txfIdaerolinea.clear();
			txfRegistrarAerolineaNombreAerolinea.clear();
			txfRegistrarUsuarioRegistrarAerolinea.clear();
			txfRegistrarAerolineaContrasena.clear();
			txfCorreoRegistrarAerolinea.clear();

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Registro no guardado");
			alert.setContentText("Debe completar los campos vacios");
			alert.showAndWait();
		}

	}

	@FXML
	void hiperlinkRegistrarAerolineaRegresar(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(true);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(false);
		// secundario
		paneRegistrarEmpleado.setVisible(false);
		paneModificarEmpleado.setVisible(false);
		paneRegistrarAerolinea.setVisible(false);
		paneModificarAerolinea.setVisible(false);
		paneRegistrarHangar.setVisible(false);
		paneModificarHangar.setVisible(false);
	}

	@FXML
	void btnAeropuertoRegistrosModificarAerolinea(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(true);
		// secundario
		paneRegistrarEmpleado.setVisible(false);
		paneModificarEmpleado.setVisible(false);
		paneRegistrarAerolinea.setVisible(false);
		paneModificarAerolinea.setVisible(true);
		paneRegistrarHangar.setVisible(false);
		paneModificarHangar.setVisible(false);
		// terciario
		vbxModificarUsuarioTableView1.setVisible(true);
		vbxMenus_aeropuerto_ModificarEmpleado1.setVisible(false);

		// cargar datos
		limpiar_tabla_aerolineas();
		cargar_aerolineas_aeropuerto();

	}

	@FXML
	void ModificarAerolinea(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(true);
		// secundario
		paneRegistrarEmpleado.setVisible(false);
		paneModificarEmpleado.setVisible(false);
		paneRegistrarAerolinea.setVisible(false);
		paneModificarAerolinea.setVisible(true);
		paneRegistrarHangar.setVisible(false);
		paneModificarHangar.setVisible(false);
		// terciario
		vbxModificarUsuarioTableView1.setVisible(false);
		vbxMenus_aeropuerto_ModificarEmpleado1.setVisible(true);

		// Metodo para modificar datos de aerolinea
		String idaerolinea = txfAdministraraerolinea1.getText();
		// limpiar pantalla antes
		txfidaerolineaeste.clear();
		txfModificarNombreAerolineaeste.clear();
		txfModificarUsuarioAerolinea.clear();
		passwfieldModificarUsuarioAerolinea.clear();
		txfModificaraeroCorreo.clear();

		// cargar datos
		aerolineaAL aerolinea = conexion.cargar_aerolineas(idaerolinea);
		if (aerolinea.getid_aerolinea() != null && aerolinea.getNombre() != null && aerolinea.getUsuario() != null
				&& aerolinea.getPassword() != null && aerolinea.getCorreo() != null) {

			txfidaerolineaeste.setText(aerolinea.getid_aerolinea());
			txfModificarNombreAerolineaeste.setText(aerolinea.getNombre());
			txfModificarUsuarioAerolinea.setText(aerolinea.getUsuario());
			passwfieldModificarUsuarioAerolinea.setText(aerolinea.getPassword());
			txfModificaraeroCorreo.setText(aerolinea.getCorreo());

			// LIMPIAR PANTALLA

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error.");
			alert.setHeaderText("No se encontraron los datos del usuario.");
			alert.setContentText("Verifique la informacion e inténtelo de nuevo.");
			alert.showAndWait();
		}

	}

	@FXML
	void regresarAdministrarAerolineas(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(true);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(false);
		// secundario
		paneRegistrarEmpleado.setVisible(false);
		paneModificarEmpleado.setVisible(false);
		paneRegistrarAerolinea.setVisible(false);
		paneModificarAerolinea.setVisible(false);
		paneRegistrarHangar.setVisible(false);
		paneModificarHangar.setVisible(false);
		// terciario
		vbxModificarUsuarioTableView1.setVisible(false);
		vbxMenus_aeropuerto_ModificarEmpleado1.setVisible(false);
	}

	@FXML
	void guardarModificarAerolinea(ActionEvent event) {
		String usuario_aerolinea = txfModificarUsuarioAerolinea.getText();
		String stridaerolineas = txfidaerolineaeste.getText();
		String strnombres_aerolinea = txfModificarNombreAerolineaeste.getText();
		String strpassword = passwfieldModificarUsuarioAerolinea.getText();
		String correo = txfModificaraeroCorreo.getText();
		if (stridaerolineas != "" && strnombres_aerolinea != "" && usuario_aerolinea != "" && strpassword != ""
				&& correo != "") {
			conexion.guardar_modificaraerolinea(usuario_aerolinea, stridaerolineas, strnombres_aerolinea, strpassword,
					correo);

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Guardado");
			alert.setHeaderText("Registro guardado");
			alert.setContentText("Se actualizaron satisfactoriamente los datos");
			alert.showAndWait();

			// LImpieza de pantalla
			txfModificarUsuarioAerolinea.clear();
			txfidaerolineaeste.clear();
			txfModificarNombreAerolineaeste.clear();
			passwfieldModificarUsuarioAerolinea.clear();
			txfModificaraeroCorreo.clear();

			txfAdministraraerolinea1.clear();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Campos vacíos");
			alert.setContentText("Verifique que todos los campos estén diligenciados y vuelva a intentarlo.");
			alert.showAndWait();
		}
	}

	@FXML
	void regresarModificarAerolinea(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(true);
		// secundario
		paneRegistrarEmpleado.setVisible(false);
		paneModificarEmpleado.setVisible(false);
		paneRegistrarAerolinea.setVisible(false);
		paneModificarAerolinea.setVisible(true);
		paneRegistrarHangar.setVisible(false);
		paneModificarHangar.setVisible(false);
		// terciario
		vbxModificarUsuarioTableView1.setVisible(true);
		vbxMenus_aeropuerto_ModificarEmpleado1.setVisible(false);

		// cargar los datos
		limpiar_tabla_aerolineas();
		cargar_aerolineas_aeropuerto();

	}

	@FXML
	void btnAeropuertoRegistrosRegistrarHangar(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(true);
		// secundario
		paneRegistrarEmpleado.setVisible(false);
		paneModificarEmpleado.setVisible(false);
		paneRegistrarAerolinea.setVisible(false);
		paneModificarAerolinea.setVisible(false);
		paneRegistrarHangar.setVisible(true);
		paneModificarHangar.setVisible(false);

	}

	@FXML
	void guardarHangar(ActionEvent event) {

		String idhangar = txfidhangar.getText();
		String ubicaciobnhangar = txfUbicacionHangar.getText();
		String capacidadhangar = txfCpacidadMetrosHangar.getText();

		if (idhangar != "" && ubicaciobnhangar != "" && capacidadhangar != "") {
			conexion.guardarhangar(idhangar, ubicaciobnhangar, capacidadhangar);

			txfidhangar.clear();
			txfUbicacionHangar.clear();
			txfCpacidadMetrosHangar.clear();

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Registro no guardado");
			alert.setContentText("Uno o mas campos estan vacios");
			alert.showAndWait();
		}

	}

	@FXML
	void registroHangarregresar(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(true);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(false);
		// secundario
		paneRegistrarEmpleado.setVisible(false);
		paneModificarEmpleado.setVisible(false);
		paneRegistrarAerolinea.setVisible(false);
		paneModificarAerolinea.setVisible(false);
		paneRegistrarHangar.setVisible(false);
		paneModificarHangar.setVisible(false);
	}

	@FXML
	void btnAeropuertoRegistrosModificarHangar(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(true);
		// secundario
		paneRegistrarEmpleado.setVisible(false);
		paneModificarEmpleado.setVisible(false);
		paneRegistrarAerolinea.setVisible(false);
		paneModificarAerolinea.setVisible(false);
		paneRegistrarHangar.setVisible(false);
		paneModificarHangar.setVisible(true);

		// cargar hangar
		limpiar_tabla_hangares();
		cargar_hangares();

	}

	@FXML
	void eliminarhangar(ActionEvent event) {
		String idhangar = idhangarAdministrarhangar.getText();
		if (idhangar != "") {
			conexion.eliminar_hangar(idhangar);

			limpiar_tabla_hangares();
			cargar_hangares();
			idhangarAdministrarhangar.clear();

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("No ha digitado ningun 	id de hangar");
			alert.setContentText("Por favor ingresa un idhangar valido");
			alert.showAndWait();
		}

	}

	@FXML
	void hiperlinkEliminarhangar(ActionEvent event) {
		pneAgenda.setVisible(false);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(true);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(false);
		// secundario
		paneRegistrarEmpleado.setVisible(false);
		paneModificarEmpleado.setVisible(false);
		paneRegistrarAerolinea.setVisible(false);
		paneModificarAerolinea.setVisible(false);
		paneRegistrarHangar.setVisible(false);
		paneModificarHangar.setVisible(false);
	}

	// **********************MENU AEROLINEA*****************

	@FXML
	void ConsultaAerolineaVuelos(ActionEvent event) {

	}

	@FXML
	void consultaragendaaerolinea(ActionEvent event) {

	}

	@FXML
	void consultarhorariodisponible(ActionEvent event) {

	}

	@FXML
	void guardarmodificarpiloto(ActionEvent event) {

		String nombre = txfNombrePilotoModificar.getText();
		String apellido = txfApellidoModificarpiloto.getText();
		String cedula = txfCedulaModificarPiloto.getText();
		String licencia = txfLicenciaModificarPiloto.getText();
		String horas = txfHoravuelosacumuladosModificar.getText();
		LocalDate fecha = datepickerModificarVuelo.getValue();

		if (nombre != "" && apellido != "" && cedula != "" && licencia != "" && horas != "" && fecha != null) {
			conexion.guardarmodificarpiloto(nombre, apellido, cedula, licencia, horas, fecha);

			// limpiar pantalla
			txfNombrePilotoModificar.clear();
			txfApellidoModificarpiloto.clear();
			txfCedulaModificarPiloto.clear();
			txfLicenciaModificarPiloto.clear();
			txfHoravuelosacumuladosModificar.clear();
			datepickerModificarVuelo.setValue(null);

			txfIdpiloto.clear();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Campos vacíos");
			alert.setContentText("Por favor ingrese toda la información.");
			alert.showAndWait();
		}

	}

	@FXML
	void hiperlinkregresarsolicitudrechazadas(ActionEvent event) {

	}

	@FXML
	void modificarsolicitudesrechazadas(ActionEvent event) {

	}

	@FXML
	void tipodevueloaerolinea(ActionEvent event) {

	}

	// table views menu aeropuerto
	@FXML
	private TableView<usuario_aeropuerto> tableviewModificarEmpleadosAeropuerto;
	@FXML
	private TableColumn numero_usuarios_aeropuerto, cedula_usuarios_aeropuerto, nombre_usuarios_aeropuerto,
			apellido_usuarios_aeropuerto, correo_usuarios_aeropuerto, usuario_usuarios_aeropuerto;

	@FXML
	private TableView<aerolineas> tblevModificaraero;
	@FXML
	private TableColumn numero_aerolinea, column_id_aerolinea, column_usuario_aerolinea, column_nombre_aerolinea,
			column_correo_aerolinea;

	@FXML
	private TableView<hangares> tbleviewAdministrarHangar;
	@FXML
	private TableColumn numeroHangar, idhangar, ubicacionhangar, capacidadhangar;

	// Table view menus aerolinea
	@FXML
	private TableView<piloto> tblecolumListapilotos;

	@FXML
	private TableColumn idnumeropiloto, idcedulapiloto, idnombrepiloto, idapellidopiloto, idrevisionmedica;

	@FXML
	private TableView<avion> tbleviewListaaviones;

	@FXML
	private TableColumn numeroavion, columidavion, columntipoavion, columnmodeloavion, columnpropulsion;

	@FXML
	private TableView<vuelo> tbleviewModificarVuelos1;
	@FXML
	private TableColumn numero_vueloma, columdvuelo, columfecha, columhoraaero, columtipodevuelo;

	@FXML
	private Spinner<Integer> spinnerHoraagendavuelo, spinnerHoraagendavuelo2, spinnerHoraModificaVuelo1,
			spinnerHoraModificaVuelo11;

	@FXML
	private TableView<vuelo> tblevieSolicitudesaprobados, tbleviewAgendaVuelos;

	@FXML
	private TableColumn numsolicitudes, idvuelosoli, fechasoli, horasoli, tipovuelosoli;

	@FXML
	private TableColumn nroIdvuelo, colidvuelo, colfechavuelo, colhoravuelo, coltipovuelo;

	@FXML
	private TableView<hangaresasignaravion> tbleviewGestionarhangares1;
	@FXML
	private TableColumn nroHangarreservar, idHangarReservar, costoHoraHangar;

	// Hangares ocupados
	@FXML
	private TableView<hangaresocupados> tbleViewFacturaHangares;

	@FXML
	private TableColumn nroHangarFactura, idhangarfacturar, idavionfacturar, horaentradahangar, fechaentradahangar,
			valoractualhangar;

	@FXML
	private TableView<facturas> tbleViewVisualizarFacturasHangar;

	@FXML
	private TableColumn id_factura, tablecolum_idhangar, tablecolum_idavion, tablecolum_aerolinea, tablecolum_facturado;

	@FXML
	void initialize() throws Exception {
		cmbIdavionHangar.setPromptText("Selecciona Id Avion");

		// Spinner modificar vuelo
		SpinnerValueFactory<Integer> value3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23);
		spinnerHoraagendavuelo1.setValueFactory(value3);
		SpinnerValueFactory<Integer> value4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59);
		spinnerHoraagendavuelo21.setValueFactory(value4);

		SpinnerValueFactory<Integer> value = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23);
		spinnerHoraagendavuelo.setValueFactory(value);

		SpinnerValueFactory<Integer> value2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59);

		spinnerHoraagendavuelo2.setValueFactory(value2);

		// Menu aerolinea modificar vuelo

		// combobox aerolinea
		cmbxLogin.getItems().add("Aerolinea");
		cmbxLogin.getItems().add("Administrador de aeropuerto");

		// COMOBOBOX REGISTRO DE AVION
		cbxTipoavionRegistroAvion.getItems().add("Avion comercial");
		cbxTipoavionRegistroAvion.getItems().add("Avion de carga");

		// Combo box modificar avion
		cbxTipoavionmodificar.getItems().add("Avion comercial");
		cbxTipoavionmodificar.getItems().add("Avion de carga");

		// combo box programar vuelo
		cbxRipodevuelo.getItems().add("LLegada");
		cbxRipodevuelo.getItems().add("Salida");

		// Combo box modificar vuelo
		cbxTipodevueloModificarVuelo.getItems().add("llegada");
		cbxTipodevueloModificarVuelo.getItems().add("Salida");

		// ******************TABLEVIEW MENU
		// AEROPUERTO**************************************
		// TABLEVIE USUARIOS AEROPUERTO
		tableviewModificarEmpleadosAeropuerto.setEditable(true);
		numero_usuarios_aeropuerto.setCellValueFactory(new PropertyValueFactory<>("numero"));
		usuario_usuarios_aeropuerto.setCellValueFactory(new PropertyValueFactory<>("usuario"));
		cedula_usuarios_aeropuerto.setCellValueFactory(new PropertyValueFactory<>("cedula"));
		nombre_usuarios_aeropuerto.setCellValueFactory(new PropertyValueFactory<>("primerNombre"));
		apellido_usuarios_aeropuerto.setCellValueFactory(new PropertyValueFactory<>("primerApellido"));
		correo_usuarios_aeropuerto.setCellValueFactory(new PropertyValueFactory<>("correo"));

		//

		// TABLEVIEW AEROLINEAS
		tblevModificaraero.setEditable(true);
		numero_aerolinea.setCellValueFactory(new PropertyValueFactory<>("numero"));
		column_id_aerolinea.setCellValueFactory(new PropertyValueFactory<>("idaerolinea"));
		column_usuario_aerolinea.setCellValueFactory(new PropertyValueFactory<>("usuario"));
		column_nombre_aerolinea.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		column_correo_aerolinea.setCellValueFactory(new PropertyValueFactory<>("correo"));

		// Table view hangares

		tbleviewAdministrarHangar.setEditable(true);
		numeroHangar.setCellValueFactory(new PropertyValueFactory<>("numero"));
		idhangar.setCellValueFactory(new PropertyValueFactory<>("idhangares"));
		ubicacionhangar.setCellValueFactory(new PropertyValueFactory<>("ubicaciones"));
		capacidadhangar.setCellValueFactory(new PropertyValueFactory<>("capacidades"));

		// AEROLINEAS
		tblecolumListapilotos.setEditable(true);
		idnumeropiloto.setCellValueFactory(new PropertyValueFactory<>("numero"));
		idcedulapiloto.setCellValueFactory(new PropertyValueFactory<>("cedula"));
		idnombrepiloto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		idapellidopiloto.setCellValueFactory(new PropertyValueFactory<>("apellido"));
		idrevisionmedica.setCellValueFactory(new PropertyValueFactory<>("fecharevision"));

		// AVIONES
		tbleviewListaaviones.setEditable(true);
		numeroavion.setCellValueFactory(new PropertyValueFactory<>("numero"));
		columidavion.setCellValueFactory(new PropertyValueFactory<>("idavion"));
		columntipoavion.setCellValueFactory(new PropertyValueFactory<>("tipoavion"));
		columnmodeloavion.setCellValueFactory(new PropertyValueFactory<>("modelo"));
		columnpropulsion.setCellValueFactory(new PropertyValueFactory<>("tipopropulsion"));

		// TABLEVIEW MENU AEROLINEAS

		tblevieSolicitudesaprobados.setEditable(true);
		numsolicitudes.setCellValueFactory(new PropertyValueFactory<>("numero"));
		idvuelosoli.setCellValueFactory(new PropertyValueFactory<>("idvuelo"));
		fechasoli.setCellValueFactory(new PropertyValueFactory<>("fecha"));
		horasoli.setCellValueFactory(new PropertyValueFactory<>("hora"));
		tipovuelosoli.setCellValueFactory(new PropertyValueFactory<>("tipovuelo"));

		tbleviewAgendaVuelos.setEditable(true);
		nroIdvuelo.setCellValueFactory(new PropertyValueFactory<>("numero"));
		colidvuelo.setCellValueFactory(new PropertyValueFactory<>("idvuelo"));
		colfechavuelo.setCellValueFactory(new PropertyValueFactory<>("fecha"));
		colhoravuelo.setCellValueFactory(new PropertyValueFactory<>("hora"));
		coltipovuelo.setCellValueFactory(new PropertyValueFactory<>("tipovuelo"));

		// modificar vuelos
		// construccion
		tbleviewModificarVuelos1.setEditable(true);
		numero_vueloma.setCellValueFactory(new PropertyValueFactory<>("numero"));
		columdvuelo.setCellValueFactory(new PropertyValueFactory<>("idvuelo"));
		columfecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
		columhoraaero.setCellValueFactory(new PropertyValueFactory<>("hora"));
		columtipodevuelo.setCellValueFactory(new PropertyValueFactory<>("tipovuelo"));

		// Tabla gestionar hangares
		tbleviewGestionarhangares1.setEditable(true);
		nroHangarreservar.setCellValueFactory(new PropertyValueFactory<>("numero"));
		idHangarReservar.setCellValueFactory(new PropertyValueFactory<>("idhangar"));
		costoHoraHangar.setCellValueFactory(new PropertyValueFactory<>("costos"));

		// tabla gesstionar hangares ocupados
		tbleViewFacturaHangares.setEditable(true);
		nroHangarFactura.setCellValueFactory(new PropertyValueFactory<>("numero"));
		idhangarfacturar.setCellValueFactory(new PropertyValueFactory<>("idhangar"));
		idavionfacturar.setCellValueFactory(new PropertyValueFactory<>("idavion"));
		horaentradahangar.setCellValueFactory(new PropertyValueFactory<>("horaentrada"));
		fechaentradahangar.setCellValueFactory(new PropertyValueFactory<>("fechaentrada"));
		valoractualhangar.setCellValueFactory(new PropertyValueFactory<>("valoractual"));

		// espacio de trabajo

		tbleViewVisualizarFacturasHangar.setEditable(true);
		id_factura.setCellValueFactory(new PropertyValueFactory<>("idfacturas"));
		tablecolum_idhangar.setCellValueFactory(new PropertyValueFactory<>("idhangars"));
		tablecolum_idavion.setCellValueFactory(new PropertyValueFactory<>("idavions"));
		tablecolum_aerolinea.setCellValueFactory(new PropertyValueFactory<>("aerolineas"));
		tablecolum_facturado.setCellValueFactory(new PropertyValueFactory<>("facturados"));

	}

	// METODOS COMPLEMENTARIOS MENU AEROPUERTO
	// METODOS PARA CARGAR DATOS AEROPUERTO

	public void cargar_registros() {
		for (int i = 0; i < conexion.cargarfacturas().size(); i++) {
			tbleViewVisualizarFacturasHangar.getItems().add(new facturas(
					conexion.cargarfacturas().get(i).getIdfactura(), conexion.cargarfacturas().get(i).getIdhangar(),
					conexion.cargarfacturas().get(i).getIdavion(), conexion.cargarfacturas().get(i).getAerolinea(),
					conexion.cargarfacturas().get(i).getFacturado()));

		}

	}

	public void limpiar_registroshangar() {
		tbleViewVisualizarFacturasHangar.getItems().clear();
	}

	public void cargarhangaresaeropuerto() {
		for (int i = 0; i < conexion.cargarhangares_desocupados().size(); i++) {
			tbleviewGestionarhangares1.getItems()
					.add(new hangaresasignaravion((i + 1), conexion.cargarhangares_desocupados().get(i).getIdhangar(),
							conexion.cargarhangares_desocupados().get(i).getCosto()));

		}
	}

	public void cargarhangaresocupadoss() {
		for (int i = 0; i < conexion.cargarhangares_ocupados().size(); i++) {
			tbleViewFacturaHangares.getItems()
					.add(new hangaresocupados((i + 1), conexion.cargarhangares_ocupados().get(i).getIdhangar(),
							conexion.cargarhangares_ocupados().get(i).getIdavion(),
							conexion.cargarhangares_ocupados().get(i).getHoraentrada(),
							conexion.cargarhangares_ocupados().get(i).getFechaentrada(),
							conexion.cargarhangares_ocupados().get(i).getValoractual()));

		}
	}

	public void limpiarhangaresocupados() {
		tbleViewFacturaHangares.getItems().clear();
	}

	public void cargarvueloscomoaeropuerto() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for (int i = 0; i < conexion.cargarsolicitudesvuelos().size(); i++) {
			tbleviewAgendaVuelos.getItems()
					.add(new vuelo((i + 1), conexion.cargarsolicitudesvuelos().get(i).getIdvuelo(),
							sdf.format(conexion.cargarsolicitudesvuelos().get(i).getFecha()),
							conexion.cargarsolicitudesvuelos().get(i).getHora(),
							conexion.cargarsolicitudesvuelos().get(i).getTipovuelo()));

		}

	}

	public void cargarvuelomodificarvueloaero() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for (int i = 0; i < conexion.cargarsolicitudesvuelos().size(); i++) {
			tbleviewModificarVuelos1.getItems()
					.add(new vuelo((i + 1), conexion.cargarsolicitudesvuelos().get(i).getIdvuelo(),
							sdf.format(conexion.cargarsolicitudesvuelos().get(i).getFecha()),
							conexion.cargarsolicitudesvuelos().get(i).getHora(),
							conexion.cargarsolicitudesvuelos().get(i).getTipovuelo()));

		}
	}

	public void limpiarmodificarvueloaero() {
		tbleviewModificarVuelos1.getItems().clear();

	}

	public void cargarvuelos() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for (int i = 0; i < conexion.cargarsolicitudesvuelos().size(); i++) {
			tblevieSolicitudesaprobados.getItems()
					.add(new vuelo((i + 1), conexion.cargarsolicitudesvuelos().get(i).getIdvuelo(),
							sdf.format(conexion.cargarsolicitudesvuelos().get(i).getFecha()),
							conexion.cargarsolicitudesvuelos().get(i).getHora(),
							conexion.cargarsolicitudesvuelos().get(i).getTipovuelo()));

		}
	}

	public void cargar_pilotos() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for (int i = 0; i < conexion.cargarpilotoaerolinea().size(); i++) {
			tblecolumListapilotos.getItems()
					.add(new piloto((i + 1), conexion.cargarpilotoaerolinea().get(i).getCedula(),
							conexion.cargarpilotoaerolinea().get(i).getNombre(),
							conexion.cargarpilotoaerolinea().get(i).getApellido(),
							sdf.format(conexion.cargarpilotoaerolinea().get(i).getFecharevmed())));

		}
	}

	public void cargaraviones_comboboxhangar() {
		for (int i = 0; i < conexion.cargaraviones_hangar().size(); i++) {
			cmbIdavionHangar.getItems().add(conexion.cargaraviones_hangar().get(i).getIdavion());

		}

	}

	public void limpiar_avionescombohangar() {
		cmbIdavionHangar.getItems().clear();
	}

	public void cargaraviones() {
		for (int i = 0; i < conexion.cargaraviones(idaerolinealogin).size(); i++) {
			tbleviewListaaviones.getItems()
					.add(new avion((i + 1), conexion.cargaraviones(idaerolinealogin).get(i).getIdavion(),
							conexion.cargaraviones(idaerolinealogin).get(i).getTopoavion(),
							conexion.cargaraviones(idaerolinealogin).get(i).getModelo(),
							conexion.cargaraviones(idaerolinealogin).get(i).getTipopropulsion()));
		}
	}

	public void cargar_usuario_aeropuerto() {
		for (int i = 0; i < conexion.cargarusuariosaeropuerto().size(); i++) {
			tableviewModificarEmpleadosAeropuerto.getItems()
					.add(new usuario_aeropuerto((i + 1), conexion.cargarusuariosaeropuerto().get(i).getUsuario(),
							conexion.cargarusuariosaeropuerto().get(i).getCedula(),
							conexion.cargarusuariosaeropuerto().get(i).getNombre(),
							conexion.cargarusuariosaeropuerto().get(i).getApellido(),
							conexion.cargarusuariosaeropuerto().get(i).getCorreo()));
		}
	}

	public void cargar_aerolineas_aeropuerto() {
		for (int i = 0; i < conexion.cargaraerolineas().size(); i++) {
			tblevModificaraero.getItems()
					.add(new aerolineas((i + 1), conexion.cargaraerolineas().get(i).getid_aerolinea(),
							conexion.cargaraerolineas().get(i).getUsuario(),
							conexion.cargaraerolineas().get(i).getNombre(),
							conexion.cargaraerolineas().get(i).getCorreo()));

		}

	}

	public void cargar_hangares() {
		for (int i = 0; i < conexion.cargarhangares().size(); i++) {
			tbleviewAdministrarHangar.getItems()
					.add(new hangares((i + 1), conexion.cargarhangares().get(i).getIdhangar(),
							conexion.cargarhangares().get(i).getUbicacion(),
							conexion.cargarhangares().get(i).getCapacidad()));

		}

	}

	// CLASES SIMPLE STRING PARA MENU AEROPUERTO

	public class vuelo {
		private final SimpleIntegerProperty numero;
		private final SimpleStringProperty idvuelo;
		private final SimpleStringProperty fecha;
		private final SimpleStringProperty hora;
		private final SimpleStringProperty tipovuelo;

		private vuelo(int numero, String idvuelo, String fecha, String hora, String tipovuelo) {
			this.numero = new SimpleIntegerProperty(numero);
			this.idvuelo = new SimpleStringProperty(idvuelo);
			this.fecha = new SimpleStringProperty(fecha);
			this.hora = new SimpleStringProperty(hora);
			this.tipovuelo = new SimpleStringProperty(tipovuelo);

		}

		public int getNumero() {
			return numero.get();
		}

		public String getIdvuelo() {
			return idvuelo.get();
		}

		public String getFecha() {
			return fecha.get();
		}

		public String getHora() {
			return hora.get();
		}

		public String getTipovuelo() {
			return tipovuelo.get();
		}

	}

	public class avion {
		private final SimpleIntegerProperty numero;
		private final SimpleStringProperty idavion;
		private final SimpleStringProperty tipoavion;
		private final SimpleStringProperty modelo;
		private final SimpleStringProperty tipopropulsion;

		private avion(int numero, String idavion, String tipoavion, String modelo, String tipopropulsion) {
			this.numero = new SimpleIntegerProperty(numero);
			this.idavion = new SimpleStringProperty(idavion);
			this.tipoavion = new SimpleStringProperty(tipoavion);
			this.modelo = new SimpleStringProperty(modelo);
			this.tipopropulsion = new SimpleStringProperty(tipopropulsion);
		}

		public int getNumero() {
			return numero.get();
		}

		public String getIdavion() {
			return idavion.get();
		}

		public String getTipoavion() {
			return tipoavion.get();
		}

		public String getModelo() {
			return modelo.get();
		}

		public String getTipopropulsion() {
			return tipopropulsion.get();
		}

	}

	public class piloto {
		private final SimpleIntegerProperty numero;
		private final SimpleStringProperty cedula;
		private final SimpleStringProperty nombre;
		private final SimpleStringProperty apellido;
		private final SimpleStringProperty fecharevision;

		private piloto(int numero, String cedula, String nombre, String apellido, String fecharevision) {
			this.numero = new SimpleIntegerProperty(numero);
			this.cedula = new SimpleStringProperty(cedula);
			this.nombre = new SimpleStringProperty(nombre);
			this.apellido = new SimpleStringProperty(apellido);
			this.fecharevision = new SimpleStringProperty(fecharevision);

		}

		public int getNumero() {
			return numero.get();
		}

		public String getCedula() {
			return cedula.get();
		}

		public String getNombre() {
			return nombre.get();
		}

		public String getApellido() {
			return apellido.get();
		}

		public String getFecharevision() {
			return fecharevision.get();
		}

	}

	public class usuario_aeropuerto {
		private final SimpleIntegerProperty numero;
		private final SimpleStringProperty usuario;
		private final SimpleStringProperty cedula;
		private final SimpleStringProperty primerNombre;
		private final SimpleStringProperty primerApellido;
		private final SimpleStringProperty correo;

		private usuario_aeropuerto(int numero, String usuario, String cedula, String primerNombre,
				String primerApellido, String correo) {

			this.numero = new SimpleIntegerProperty(numero);
			this.usuario = new SimpleStringProperty(usuario);
			this.cedula = new SimpleStringProperty(cedula);
			this.primerNombre = new SimpleStringProperty(primerNombre);
			this.primerApellido = new SimpleStringProperty(primerApellido);
			this.correo = new SimpleStringProperty(correo);
		}

		public int getNumero() {
			return numero.get();
		}

		public String getCedula() {
			return cedula.get();
		}

		public String getUsuario() {
			return usuario.get();
		}

		public String getPrimerNombre() {
			return primerNombre.get();
		}

		public String getPrimerApellido() {
			return primerApellido.get();
		}

		public String getCorreo() {
			return correo.get();
		}

	}

	public class hangaresasignaravion {
		private final SimpleIntegerProperty numero;
		private final SimpleStringProperty idhangar;
		private final SimpleStringProperty costos;

		private hangaresasignaravion(int numero, String idhangar, String costos) {
			this.numero = new SimpleIntegerProperty(numero);
			this.idhangar = new SimpleStringProperty(idhangar);
			this.costos = new SimpleStringProperty(costos);

		}

		public int getNumero() {
			return numero.get();
		}

		public String getIdhangar() {
			return idhangar.get();
		}

		public String getCostos() {
			return costos.get();
		}

	}

	public class hangaresocupados {
		private final SimpleIntegerProperty numero;
		private final SimpleStringProperty idhangar;
		private final SimpleStringProperty idavion;
		private final SimpleStringProperty horaentrada;
		private final SimpleStringProperty fechaentrada;
		private final SimpleStringProperty valoractual;

		private hangaresocupados(int numero, String idhangar, String idavion, String horaentrada, String fechaentrada,
				String valoractual) {
			this.numero = new SimpleIntegerProperty(numero);
			this.idhangar = new SimpleStringProperty(idhangar);
			this.idavion = new SimpleStringProperty(idavion);
			this.horaentrada = new SimpleStringProperty(horaentrada);
			this.fechaentrada = new SimpleStringProperty(fechaentrada);
			this.valoractual = new SimpleStringProperty(valoractual);

		}

		public int getNumero() {
			return numero.get();
		}

		public String getIdhangar() {
			return idhangar.get();
		}

		public String getIdavion() {
			return idavion.get();
		}

		public String getHoraentrada() {
			return horaentrada.get();
		}

		public String getFechaentrada() {
			return fechaentrada.get();
		}

		public String getValoractual() {
			return valoractual.get();
		}

	}

	public class aerolineas {
		private final SimpleIntegerProperty numero;
		private final SimpleStringProperty idaerolinea;
		private final SimpleStringProperty usuario;
		private final SimpleStringProperty nombre;
		private final SimpleStringProperty correo;

		private aerolineas(int numero, String idaerolinea, String usuario, String nombre, String correo) {

			this.numero = new SimpleIntegerProperty(numero);
			this.idaerolinea = new SimpleStringProperty(idaerolinea);
			this.usuario = new SimpleStringProperty(usuario);
			this.nombre = new SimpleStringProperty(nombre);
			this.correo = new SimpleStringProperty(correo);
		}

		public int getNumero() {
			return numero.get();
		}

		public String getIdaerolinea() {
			return idaerolinea.get();
		}

		public String getUsuario() {
			return usuario.get();
		}

		public String getNombre() {
			return nombre.get();
		}

		public String getCorreo() {
			return correo.get();
		}

	}

	public class hangares {
		private final SimpleIntegerProperty numero;
		private final SimpleStringProperty idhangares;
		private final SimpleStringProperty ubicaciones;
		private final SimpleStringProperty capacidades;

		private hangares(int numero, String idhangares, String ubicaciones, String capacidades) {
			this.numero = new SimpleIntegerProperty(numero);
			this.idhangares = new SimpleStringProperty(idhangares);
			this.ubicaciones = new SimpleStringProperty(ubicaciones);
			this.capacidades = new SimpleStringProperty(capacidades);
		}

		public int getNumero() {
			return numero.get();
		}

		public String getIdhangares() {
			return idhangares.get();
		}

		public String getUbicaciones() {
			return ubicaciones.get();
		}

		public String getCapacidades() {
			return capacidades.get();
		}

	}

	public class facturas {
		private final SimpleStringProperty idfacturas;
		private final SimpleStringProperty idhangars;
		private final SimpleStringProperty idavions;
		private final SimpleStringProperty aerolineas;
		private final SimpleStringProperty facturados;

		private facturas(String idfacturas, String idhangars, String idavions, String aerolineas, String facturados) {
			this.idfacturas = new SimpleStringProperty(idfacturas);
			this.idhangars = new SimpleStringProperty(idhangars);
			this.idavions = new SimpleStringProperty(idavions);
			this.aerolineas = new SimpleStringProperty(aerolineas);
			this.facturados = new SimpleStringProperty(facturados);
		}

		public String getIdfacturas() {
			return idfacturas.get();
		}

		public String getIdhangars() {
			return idhangars.get();
		}

		public String getIdavions() {
			return idavions.get();
		}

		public String getAerolineas() {
			return aerolineas.get();
		}

		public String getFacturados() {
			return facturados.get();
		}
	}

	// METODOS DE LIMPIEZA

	public void limpiarvuelos() {
		tblevieSolicitudesaprobados.getItems().clear();
	}

	public void limpiarvueloaeropuerto() {
		tbleviewAgendaVuelos.getItems().clear();

	}

	public void limpiar_tabla_hangares() {
		tbleviewAdministrarHangar.getItems().clear();
	}

	public void limpiar_tabla_aerolineas() {
		tblevModificaraero.getItems().clear();
	}

	public void limpiar_tabla_usuario_aeropuerto() {
		tableviewModificarEmpleadosAeropuerto.getItems().clear();
	}

	public void limpiar_pantalla_pilotos() {
		tblecolumListapilotos.getItems().clear();
	}

	public void limpiar_agenda_vuelos_aerolinea() {
		tblevieSolicitudesaprobados.getItems().clear();
	}

	public void limpiarlogin() {
		txfNomusuario.clear();
		psfContras.clear();
		cmbxLogin.setPromptText("Elige un tipo de usuario");

	}

	public void limpiarhangaresvacios() {
		tbleviewGestionarhangares1.getItems().clear();
	}

}
