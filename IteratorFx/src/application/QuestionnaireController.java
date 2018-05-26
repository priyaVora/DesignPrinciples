package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class QuestionnaireController implements Initializable {

	@FXML
	ScrollPane scrollPane;
	@FXML
	AnchorPane bottomPane;
	@FXML
	ChoiceBox<String> operationChoiceBox;
	@FXML
	Label questionnaireLabel;
	@FXML
	GridPane mainGrid;

	TextField sectionField = new TextField();
	TextField subSectionField = new TextField();

	
	GridPane bottomGrid;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		operationChoiceBox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String selectedOperation = operationChoiceBox.getItems()
						.get(operationChoiceBox.getSelectionModel().getSelectedIndex());
				// System.out.println(selectedOperation);
				if (!(selectedOperation.trim().equals("Select Operation"))) {
					questionnaireLabel.setText(operationChoiceBox.getItems()
							.get(operationChoiceBox.getSelectionModel().getSelectedIndex()));

					if (selectedOperation.equals("Make A Questionnaire")) {
						setGridView();
					}

				} else if (selectedOperation.trim().equals("Select Operation")) {
					questionnaireLabel.setText("Questionnaire: Select / Make");
					mainGrid.getChildren().clear();
				}
			}
		});
	}

	public QuestionnaireController() {

	}

	public void resetControls() {
		scrollPane = new ScrollPane();
		bottomPane = new AnchorPane();
		((javafx.scene.control.ScrollPane) scrollPane).setHbarPolicy(ScrollBarPolicy.NEVER);
		((javafx.scene.control.ScrollPane) scrollPane).setVbarPolicy(ScrollBarPolicy.NEVER);
		operationChoiceBox = new ChoiceBox<String>();
		questionnaireLabel = new Label();
		mainGrid = new GridPane();
		mainGrid.setGridLinesVisible(true);
		bottomGrid = new GridPane();
		bottomGrid.getStyleClass().add("bottomGrid");
	}

	public void setGridView() {
		mainGrid.getChildren().clear();
		List<String> controlsList = new ArrayList<String>();
		controlsList.add("TextField");
		controlsList.add("Label");
		controlsList.add("TextField");
		controlsList.add("Label");
		controlsList.add("Button");

		List<String> controlTexts = new ArrayList<String>();
		controlTexts.add("---");
		controlTexts.add("Section");
		controlTexts.add("---");
		controlTexts.add("Sub-Section");
		controlTexts.add("Button");

		int index = 0;
		int counter = 1;

		for (int i = 0; i < 1; i++) {
			for (int k = 0; k < controlsList.size(); k++) {
				if (controlsList.get(index).equals("Label")) {

					Label field = new Label();
					field.setText(controlTexts.get(index));
					field.setPrefWidth(field.getText().length() * 14);
					field.getStyleClass().add("Label");
					mainGrid.add(field, k, i);
					System.out.println("X: " + i);
					System.out.println("Y:" + k);
					index++;

				} else if (controlsList.get(index).equals("TextField")) {
					TextField field = new TextField();
					field.setPromptText("---");
					field.setPrefWidth(10);
					// field.getStyleClass().add("TextField");
					mainGrid.add(field, k, i);
					System.out.println("X: " + i);
					System.out.println("Y:" + k);
					index++;
					if (counter <= 1) {
						sectionField = field;
						System.out.println("Sub Section Field: Added");
						counter++;
					} else {
						subSectionField = field;
						System.out.println("Section Field: Added");
						counter++;
					}
				} else if (controlsList.get(index).equals("Button")) {
					Button field = new Button();
					field.setText(controlTexts.get(index));
					field.setPrefWidth(field.getText().length() * 14);
					field.getStyleClass().add("Button");
					mainGrid.add(field, k, i);

					field.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							
							try {
								bottomGrid = new GridPane();
								bottomGrid.setGridLinesVisible(true);
								bottomGrid.getChildren().clear();
								System.out.println("Button was clicked!");
								String sectionCount = sectionField.getText().trim();
								String subSectionCount = subSectionField.getText().trim();
								Integer.parseInt(sectionCount);
								Integer.parseInt(subSectionCount);

								System.out.println("Section Count: " + sectionCount);
								System.out.println("Sub-Section Count: " + subSectionCount);

								int gridRows = ((Integer.parseInt(sectionCount) * Integer.parseInt(subSectionCount))
										+ Integer.parseInt(sectionCount));

								System.out.println("grid Row: " + gridRows);
								int sectionIndex = 1 + Integer.parseInt(subSectionCount);
								System.out.println("Section Index is : " + sectionIndex);
								int subIndex = 1;
								for (int j = 0; j < gridRows; j++) {
									
									if(subIndex == 1) { 
										System.out.println("\nSection is here!");
										subIndex++;
										HBox box = new HBox();
										box.getStyleClass().add("hBox");
										Label label = new Label("  Category:      ");
										label.getStyleClass().add("hBoxLabel");
										TextField field = new TextField();
										field.setPromptText("Enter Category Here");
										field.setPrefWidth(field.getPromptText().length() * 14);
										field.getStyleClass().add("hBoxTextField");
										
										box.getChildren().add(label);
										box.getChildren().add(field);
										
										bottomGrid.add(box, 1, j);
										
									} else { 
										System.out.println("   Sub Section is here!");
										subIndex++;
										HBox sectionHBox = new HBox();
										TextField field = new TextField();
										field.getStyleClass().add("hBoxTextField");
										sectionHBox.getStyleClass().add("hBox");
										sectionHBox.getChildren().add(field);
										bottomGrid.add(sectionHBox, 1, j);
									}
									if(subIndex > sectionIndex) { 
										subIndex = 1;
									}
								
								}
								bottomPane.getChildren().clear();
								bottomPane.getChildren().add(bottomGrid);
							} catch (NumberFormatException e) {
								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("Invalid Section and Sub Section Count!");
								alert.setHeaderText("Enter valid numerical values.");
								alert.setContentText("Try Again!");
								alert.showAndWait();
								bottomGrid.getChildren().clear();
								bottomPane.getChildren().clear();
							}
						}
					});

					index++;
				} else {
					index--;
				}
			}
		}
		int row = 1;
		int col = 0;

		button_RowFiller(row, col, 5);

		Label questionaireLabel = new Label();
		questionaireLabel.setText("Questionairee: ");
		questionaireLabel.setPrefWidth(questionaireLabel.getText().length() * 14);
		questionaireLabel.getStyleClass().add("QuestionaireeLabel");
		mainGrid.add(questionaireLabel, 1, 3);

		// TextField questionaireLabel2 = new TextField();
		// questionaireLabel2.setText(" ");
		// questionaireLabel2.setPromptText("Enter your title here.");
		// questionaireLabel2.setPrefWidth(22* 14);
		//
		// mainGrid.add(questionaireLabel2, 2, 3);
	}

	public void button_RowFiller(int row, int col, int num) {
		for (int j = col; j < num; j++) {
			Button spaceFillerButton = new Button();
			spaceFillerButton.setText("  ");
			spaceFillerButton.setPrefWidth(spaceFillerButton.getText().length() * 14);
			spaceFillerButton.getStyleClass().add("ButtonFiller");
			mainGrid.add(spaceFillerButton, j, row);
		}
	}
}
