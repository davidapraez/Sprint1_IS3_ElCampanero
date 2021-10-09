package interfaz;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("vista.fxml"));
			Scene scene = new Scene(root, 800, 500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			System.out.println("holaa");
			System.out.println("holaa");
			System.out.println("holaa");
			System.out.println("holaa");
			System.out.println("holaa");
			
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void main(String[] args) {
		
		launch(args);
	}

}
