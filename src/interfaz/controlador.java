package interfaz;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;

import clases_AL.aerolineaAL;
import clases_AL.avionAL;
import clases_AL.pilotoAL;
import clases_AL.usuario_aeropuertoAL;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import javafx.scene.control.TableColumn;

//Importacion de clases complementarias

public class controlador {

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
	private TextField txfIdaerolinea;

	@FXML
	private TextField txfidaerolineaeste;
	@FXML
	private TextField txfAdministrarUsuariosCedula;

	@FXML
	private Button btnAdministrarUsuarioModificar;

	@FXML
	private Button btnAdministrarUsuarioEliminar;

	@FXML
	private Hyperlink hiperlinkAeropuertoMenuRegistrosRegresar;
	
	@FXML
    private CheckBox chkboxCopiloto1,cbxcopiloto2;
	

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
	private ComboBox<String> cmbxLogin;
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
	private ComboBox<?> cbxTipodevueloModificarVuelo;

	@FXML
	private TextField txfIdavionagendarvuelo1;

	@FXML
	private TextField txfIdpilotaagendavuelos1;

	@FXML
	private TextField txfIdcopilotoAgendavuelo1;

	@FXML
	private DatePicker datepickFechaAgenda1;

	@FXML
	private Spinner<?> spinnerHoraagendavuelo1;
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
	private DatePicker datepickerModificarVuelo;

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
	private TableView<?> tbleviewGestionarhangares1;

	@FXML
	private TextField idAvionHangar1;

	@FXML
	private TextField idHangarLlegada1;

	@FXML
	private DatePicker datepickRegistroHangar1;

	@FXML
	private Spinner<?> spinnerHoraHangares1;

	@FXML
	private Button idRegistrarAvionHangar;

	@FXML
	private Hyperlink hiperlinkAeropuertoMenuRegistrosRegresar1;

	// REGISTRAR FACTURA HANGAR
	@FXML
	private Pane paneRegistrarFacturaHangar;
	@FXML
	private TableView<?> tbleViewFacturaHangares;
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
	private TableView<?> tbleViewVisualizarFacturasHangar;

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
		if (cmbxLogin.getValue() != null) {
			String tipousuario = cmbxLogin.getValue();
			if (tipousuario == "Aerolinea") {

				conexionbd conexion = new conexionbd();
				if (conexion.validarusuarioaerolinea(txfNomusuario.getText(), psfContras.getText())) {
					anpLogin.setVisible(false);
					anpMenuAerolinea.setVisible(true);
					idaerolinealogin = txfNomusuario.getText();
				} else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Error ");
					alert.setHeaderText("Usuario invalido");
					alert.setContentText("Por favor ingresa un usuario y contraseña validos");
					alert.showAndWait();
				}

			}
			if (tipousuario == "Administrador de aeropuerto") {

				conexionbd conexion = new conexionbd();
				if (conexion.validarusuarioaeropuerto(txfNomusuario.getText(), psfContras.getText())) {
					anpLogin.setVisible(false);
					anpMenuAeropuerto.setVisible(true);
					idaeropuertologin = txfNomusuario.getText();
				} else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Error ");
					alert.setHeaderText("Usuario invalido");
					alert.setContentText("Por favor ingresa un usuario y contraseña validos");
					alert.showAndWait();
				}

			}

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error ");
			alert.setHeaderText("Debe elegir un tipo de usuario");
			alert.setContentText("Selecciona un usuario");
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

	/* Comentario
	@FXML
	void btnAerolineaConsultas(ActionEvent event) {
		pneProgramarVuelo.setVisible(false);
		pneConsultas.setVisible(true);
		pneRegistros.setVisible(false);
		anpMenusVuelos.setVisible(false);
		anpMenuRegistros.setVisible(false);
	}
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
		
		String idvuelo=txfvueloSolicitudesAprobadas.getText();
		conexionbd conexion= new conexionbd();
		
		if(idvuelo!=null) {
			conexion.eliminarvuelo(idvuelo);
			limpiarvuelos();
			cargarvuelos();
			txfvueloSolicitudesAprobadas.clear();
		}else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error ");
			alert.setHeaderText("Debe escribir el id del vuelo");
			alert.setContentText("Ingrese un Id");
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
		
		//Cargar los datos
		cargarvuelos();
		
	}

	@FXML
	void modificarsolicitudesaprobadas(ActionEvent event) {
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
		
		//Metodos
		String idvuelo=txfvueloSolicitudesAprobadas.getText();
		
		
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
				;
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
		
		String idavion=txfIdpilotorlistaaviones.getText();
		if(idavion!=null) {
			conexionbd conexion=new conexionbd();
				conexion.eliminaravion(idavion);
				tbleviewListaaviones.getItems().clear();
				cargaraviones();
				
				txfIdpilotorlistaaviones.clear();
	
			
		}else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error ");
			alert.setHeaderText("Campo vacio");
			alert.setContentText("Digite un id para poder eliminar al avion");
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
			alert.setTitle("Error ");
			alert.setHeaderText("Campo vacio");
			alert.setContentText("Digite un id para poder eliminar al piloto");
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
					alert.setTitle("Error ");
					alert.setHeaderText("Registro no guardado");
					alert.setContentText("Los campos no deben estar vacios");
					alert.showAndWait();
				}

			} else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error ");
				alert.setHeaderText("Debe seleccionar un tipó de avion");
				alert.setContentText("Elija una opcion correcta en tipo de avion");
				alert.showAndWait();
			}

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error ");
			alert.setHeaderText("No se encontro a la aerolinea");
			alert.setContentText("Debe estar logeado con el id valido de una aerolinea");
			alert.showAndWait();
		}
	}

	@FXML
	void guardar_modificaravion(ActionEvent event) {
		String tipoavion=cbxTipoavionmodificar.getValue();
		String idavion=txfIdavionmodificar.getText();
		String capacidad=txfCpacidadcargapuestos.getText();
		String modelo=txfModeloavion129.getText();
		String propulsion=txfTipopropulsion116.getText();
		String motores=txfNumeromotoresmodifcaarvion.getText();
		String peso=txfPesonominalavion1128.getText();
		
		conexionbd conexion= new conexionbd();
		if(tipoavion!=null) {
			conexion.guardarmodificaravion(tipoavion,idavion,capacidad,modelo,propulsion,motores,peso);
			
			//limpiar pantalla
			
			cbxTipoavionmodificar.setPromptText("Tipo de avion");
			txfIdavionmodificar.clear();
			txfCpacidadcargapuestos.clear();
			txfModeloavion129.clear();
			txfTipopropulsion116.clear();
			txfNumeromotoresmodifcaarvion.clear();
			txfPesonominalavion1128.clear();

			//
			txfIdpilotorlistaaviones.clear();
			
			
		}else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Error ");
			alert.setHeaderText("Debe seleccionar el tipo de avion");
			alert.setContentText("Debe llenar toda la informacion y no dejar campos vacios");
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
		
		//cargar losd datos
		
		tbleviewListaaviones.getItems().clear();
		cargaraviones();
	}

	@FXML
	void modificaravion(ActionEvent event) {
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
		
		//MODIFICAR DATOS
		conexionbd conexion=new conexionbd();
		if(idaerolinealogin!=null && txfIdpilotorlistaaviones.getText()!=null) {
			avionAL avion=conexion.retornaavionamodificar(idaerolinealogin,txfIdpilotorlistaaviones.getText());
			
			
			txfIdavionmodificar.setText(avion.getIdavion());
			txfCpacidadcargapuestos.setText(avion.getCapacidad());
			txfModeloavion129.setText(avion.getModelo());
			txfTipopropulsion116.setText(avion.getTipopropulsion());
			txfNumeromotoresmodifcaarvion.setText(avion.getNumeromotores());
			txfPesonominalavion1128.setText(avion.getPesonominal());
			

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
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Error ");
			alert.setHeaderText("Registro invalido");
			alert.setContentText("Debe llenar toda la informacion y no dejar campos vacios");
			alert.showAndWait();
		}

	}

// *************************************************************************************************************
// *************************************************AEROPUERTO**************************************************
// *************************************************************************************************************

	@FXML
	private Button btnCerrrarSesionAeropuerto;
	@FXML
	private Button btnSalirAeropuerto;
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
		
				

	}

	@FXML
	void AgendaAeropuerto(ActionEvent event) {
		/*pneAgenda.setVisible(true);
		pneHangar.setVisible(false);
		pneAeropuertoRegistros.setVisible(false);
		anpMenusAgenda.setVisible(false);
		anpMenusHangar.setVisible(false);
		anprMenusRegistros.setVisible(false);
		*/
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
	void btnModificarAgendaVuelos(ActionEvent event) {
		paneAgendaVuelos.setVisible(false);
		paneModificarAgenda.setVisible(true);
		paneSolicitudesCambio.setVisible(false);
	}

	@FXML
	void btnEliminarAgendaVuelos(ActionEvent event) {

	}

	@FXML
	void btnAeropuertoModificarVuelos(ActionEvent event) {

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

	}

	@FXML
	void btnRegistrarHangar1(ActionEvent event) {

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

	}

	@FXML
	void btnFacturarVueloEnHangares(ActionEvent event) {

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
			conexionbd conexion = new conexionbd();
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
		conexionbd conexion = new conexionbd();
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
		conexionbd conexion = new conexionbd();
		String cedula = txfAdministrarUsuariosCedula.getText();
		if (cedula != null) {
			conexion.eliminarusuarioaeropuerto(cedula);
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
			conexionbd conexion = new conexionbd();
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
			conexionbd conexion = new conexionbd();
			conexion.eliminar_aerolinea(idaerolinea);

			limpiar_tabla_aerolineas();
			cargar_aerolineas_aeropuerto();
			txfAdministraraerolinea1.clear();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error ");
			alert.setHeaderText("Campo vacio");
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

		conexionbd conexion = new conexionbd();
		if (idaerolinea != "" && nombre != "" && usuario != "" && password != "" && correo != "") {
			conexion.guardaraerolinea(idaerolinea, nombre, correo, usuario, password);

			txfIdaerolinea.clear();
			txfRegistrarAerolineaNombreAerolinea.clear();
			txfRegistrarUsuarioRegistrarAerolinea.clear();
			txfRegistrarAerolineaContrasena.clear();
			txfCorreoRegistrarAerolinea.clear();

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error ");
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
		conexionbd conexion = new conexionbd();
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
			alert.setTitle("Error ");
			alert.setHeaderText("No se encontraron los datos del usuario");
			alert.setContentText("Verifique la informacion");
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
			conexionbd conexion = new conexionbd();
			conexion.guardar_modificaraerolinea(usuario_aerolinea, stridaerolineas, strnombres_aerolinea, strpassword,
					correo);

			// LImpieza de pantalla
			txfModificarUsuarioAerolinea.clear();
			txfidaerolineaeste.clear();
			txfModificarNombreAerolineaeste.clear();
			passwfieldModificarUsuarioAerolinea.clear();
			txfModificaraeroCorreo.clear();

			txfAdministraraerolinea1.clear();
		} else {
			System.out.println("campos vacios");
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
			conexionbd conexion = new conexionbd();
			conexion.guardarhangar(idhangar, ubicaciobnhangar, capacidadhangar);

			txfidhangar.clear();
			txfUbicacionHangar.clear();
			txfCpacidadMetrosHangar.clear();

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error ");
			alert.setHeaderText("Registro no guardado");
			alert.setContentText("Los campos deben estar llenos");
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
			conexionbd conexion = new conexionbd();
			conexion.eliminar_hangar(idhangar);

			limpiar_tabla_hangares();
			cargar_hangares();
			idhangarAdministrarhangar.clear();

		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error ");
			alert.setHeaderText("No ha digitado ningun campo");
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
			conexionbd conexion = new conexionbd();
			conexion.guardarmodificarpiloto(nombre, apellido, cedula, licencia, horas, fecha);

			// limpiar pantalla
			txfNombrePilotoModificar.clear();
			txfApellidoModificarpiloto.clear();
			txfCedulaModificarPiloto.clear();
			txfLicenciaModificarPiloto.clear();
			txfHoravuelosacumuladosModificar.clear();
			datepickerModificarVuelo.setValue(null);

			txfIdpiloto.clear();
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
	void solicitaragendaaerolinea(ActionEvent event) {
		String tipovuelo=cbxRipodevuelo.getValue();
		String idavion=txfIdavionagendarvuelo.getText();
		String idpiloto=txfIdpilotaagendavuelos.getText();
		String idcopiloto=txfIdcopilotoAgendavuelo.getText();
		LocalDate fecha=datepickFechaAgenda.getValue();
		int hora=spinnerHoraagendavuelo.getValue();
		int minutos=spinnerHoraagendavuelo2.getValue();
		
		if(tipovuelo!="" && idavion!="" && idpiloto!="" && fecha!=null) {
			conexionbd conexion=new conexionbd();
			conexion.programarvueloaerolinea(tipovuelo, idavion, idpiloto, idcopiloto, fecha, hora, minutos);
			

		}else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error ");
			alert.setHeaderText("no se pudo programar el vuelo");
			alert.setContentText("Debe digitar la informacion correspondiente");
			alert.showAndWait();
		}
		
		
	}
	
	//TIME SPINNER
	@FXML
	private Spinner<Integer> spinnerHoraagendavuelo,spinnerHoraagendavuelo2;
	
	
	@FXML
	private TableView<vuelo> tblevieSolicitudesaprobados,tbleviewAgendaVuelos;
	
	
	
		
	@FXML
	private TableColumn numsolicitudes,idvuelosoli,fechasoli,horasoli,tipovuelosoli;

	@FXML
	private TableColumn nroIdvuelo,colidvuelo,colfechavuelo,colhoravuelo,coltipovuelo;
	
	
	@FXML
	void initialize() {	
		

		
		
		
		
		
		//area de trabajo
		SpinnerValueFactory<Integer> value=new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23);
		spinnerHoraagendavuelo.setValueFactory(value);
		
		SpinnerValueFactory<Integer> value2=new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59);
		spinnerHoraagendavuelo2.setValueFactory(value2);
		

		
		
		
		//combobox aerolinea
		cmbxLogin.getItems().add("Aerolinea");
		cmbxLogin.getItems().add("Administrador de aeropuerto");

		// COMOBOBOX REGISTRO DE AVION
		cbxTipoavionRegistroAvion.getItems().add("Avion comercial");
		cbxTipoavionRegistroAvion.getItems().add("Avion de carga");
		
		//Combo box modificar avion
		cbxTipoavionmodificar.getItems().add("Avion comercial");
		cbxTipoavionmodificar.getItems().add("Avion de carga");
		
		//combo box programar vuelo
		cbxRipodevuelo.getItems().add("LLegada");
		cbxRipodevuelo.getItems().add("Salida");


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
		
		//TABLEVIEW MENU AEROLINEAS
		
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

	}

	// METODOS COMPLEMENTARIOS MENU AEROPUERTO
	// METODOS PARA CARGAR DATOS AEROPUERTO
	
	
	public void cargarvueloscomoaeropuerto() {
		conexionbd conexion= new conexionbd();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for (int i = 0; i < conexion.cargarsolicitudesvuelos().size(); i++) {
			tbleviewAgendaVuelos.getItems().add(new vuelo(
					(i+1),
					conexion.cargarsolicitudesvuelos().get(i).getIdvuelo(),
					sdf.format(conexion.cargarsolicitudesvuelos().get(i).getFecha()),
					conexion.cargarsolicitudesvuelos().get(i).getHora(),
					conexion.cargarsolicitudesvuelos().get(i).getTipovuelo()));
			
		}
		
	}
	
	
	
	public void cargarvuelos() {
		conexionbd conexion= new conexionbd();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for (int i = 0; i < conexion.cargarsolicitudesvuelos().size(); i++) {
			tblevieSolicitudesaprobados.getItems().add(new vuelo(
					(i+1),
					conexion.cargarsolicitudesvuelos().get(i).getIdvuelo(),
					sdf.format(conexion.cargarsolicitudesvuelos().get(i).getFecha()),
					conexion.cargarsolicitudesvuelos().get(i).getHora(),
					conexion.cargarsolicitudesvuelos().get(i).getTipovuelo()));
			
		}
	}
	
	public void cargar_pilotos() {
		conexionbd conexion = new conexionbd();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for (int i = 0; i < conexion.cargarpilotoaerolinea().size(); i++) {
			tblecolumListapilotos.getItems()
					.add(new piloto((i + 1), conexion.cargarpilotoaerolinea().get(i).getCedula(),
							conexion.cargarpilotoaerolinea().get(i).getNombre(),
							conexion.cargarpilotoaerolinea().get(i).getApellido(),
							sdf.format(conexion.cargarpilotoaerolinea().get(i).getFecharevmed())));

		}
	}
	
	

	public void cargaraviones() {
		conexionbd conexion = new conexionbd();
		for (int i = 0; i < conexion.cargaraviones(idaerolinealogin).size(); i++) {
			tbleviewListaaviones.getItems().add(new avion(
							(i+1),conexion.cargaraviones(idaerolinealogin).get(i).getIdavion(),
							conexion.cargaraviones(idaerolinealogin).get(i).getTopoavion(),
							conexion.cargaraviones(idaerolinealogin).get(i).getModelo(),
							conexion.cargaraviones(idaerolinealogin).get(i).getTipopropulsion()));
		}
	}



	public void cargar_usuario_aeropuerto() {
		conexionbd conexion = new conexionbd();
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
		conexionbd conexion = new conexionbd();
		for (int i = 0; i < conexion.cargaraerolineas().size(); i++) {
			tblevModificaraero.getItems()
					.add(new aerolineas((i + 1), conexion.cargaraerolineas().get(i).getid_aerolinea(),
							conexion.cargaraerolineas().get(i).getUsuario(),
							conexion.cargaraerolineas().get(i).getNombre(),
							conexion.cargaraerolineas().get(i).getCorreo()));

		}

	}

	public void cargar_hangares() {
		conexionbd conexion = new conexionbd();
		for (int i = 0; i < conexion.cargarhangares().size(); i++) {
			tbleviewAdministrarHangar.getItems()
					.add(new hangares((i + 1), conexion.cargarhangares().get(i).getIdhangar(),
							conexion.cargarhangares().get(i).getUbicacion(),
							conexion.cargarhangares().get(i).getCapacidad()));

		}

	}
	
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

	// CLASES SIMPLE STRING PARA MENU AEROPUERTO
	
	public class vuelo{
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

	// METODOS COMPLEMENTARIOS LOGIN

	public void limpiarlogin() {
		txfNomusuario.clear();
		psfContras.clear();
		cmbxLogin.setPromptText("Elige un tipo de usuario");

	}
}
