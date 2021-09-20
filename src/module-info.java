module SoftwareAeropuertoElCampaneros {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires java.sql;
	
	opens interfaz to javafx.graphics, javafx.fxml, javafx.controls, javafx.base, java.sql;
}
