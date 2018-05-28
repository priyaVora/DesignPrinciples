package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/QuestionnaireFxml.fxml"));
		Parent root = loader.load();
		QuestionnaireController controller = loader.getController();

		Scene scene = new Scene(root);
		scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());

		primaryStage.setScene(scene);

		primaryStage.setTitle("Survey-Questionnaire");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);

	}
}
