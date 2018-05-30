package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/TrafficLightScreen.fxml"));
		Parent root = loader.load();
		LightController controller = loader.getController();

		Scene scene = new Scene(root);
		scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());

		primaryStage.setScene(scene);

		primaryStage.setTitle("Traffic Light");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}
}