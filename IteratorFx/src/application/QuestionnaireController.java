package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;

public class QuestionnaireController implements Initializable {

	@FXML
	ScrollPane scrollPane;
	@FXML
	ChoiceBox<String> operationChoiceBox;

	@FXML
	Label questionnaireLabel;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		operationChoiceBox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String selectedOperation = operationChoiceBox.getItems().get(operationChoiceBox.getSelectionModel().getSelectedIndex());
				//System.out.println(selectedOperation);
				if(!(selectedOperation.trim().equals("Select Operation"))) { 					
					questionnaireLabel.setText(operationChoiceBox.getItems().get(operationChoiceBox.getSelectionModel().getSelectedIndex()));
				
					
				
				} else if(selectedOperation.trim().equals("Select Operation")) { 
					questionnaireLabel.setText("Questionnaire: Select / Make");
				}
			}
		});
	}

	public QuestionnaireController() {

	}

	public void resetControls() {
		scrollPane = new ScrollPane();
		((javafx.scene.control.ScrollPane) scrollPane).setHbarPolicy(ScrollBarPolicy.NEVER);
		((javafx.scene.control.ScrollPane) scrollPane).setVbarPolicy(ScrollBarPolicy.NEVER);
		operationChoiceBox = new ChoiceBox<String>();
		questionnaireLabel = new Label();
	}
}
