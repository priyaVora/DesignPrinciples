package application;

import java.awt.image.TileObserver;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class SurveyController implements Initializable {

	@FXML
	GridPane topGrid;
	@FXML
	GridPane bottomGrid;
	@FXML
	Label titleLabel;
	@FXML
	ChoiceBox<String> operationChoiceBox;

	public SurveyController() {
		resetControls();
	}

	public void resetControls() {
		topGrid = new GridPane();
		topGrid.setVisible(true);
		bottomGrid = new GridPane();
		bottomGrid.setVisible(true);
		titleLabel = new Label();
		operationChoiceBox = new ChoiceBox<String>();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		start();
	}

	private void start() {
		System.out.println("Controller is ready!");
		setActionListener_ChoiceBox();
	}

	public void setActionListener_ChoiceBox() {
		operationChoiceBox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String selectedOption = operationChoiceBox.getItems()
						.get(operationChoiceBox.getSelectionModel().getSelectedIndex());
				titleLabel.setText(selectedOption.trim());
			}
		});
	}

}
