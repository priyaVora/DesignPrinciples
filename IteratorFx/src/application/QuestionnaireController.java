package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
import vora.priya.iteratorComposite.Category;
import vora.priya.iteratorComposite.Question;
import vora.priya.iteratorComposite.QuizComponent;

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
	// List<QuizComponent> listOfQuizEntries = new ArrayList<QuizComponent>();
	Map<Integer, Category> categoryMap = new HashMap<Integer, Category>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		operationChoiceBox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String selectedOperation = operationChoiceBox.getItems()
						.get(operationChoiceBox.getSelectionModel().getSelectedIndex());
				bottomPane.getChildren().clear();
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
		controlTexts.add("Create");

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
					field.getStyleClass().add("countField");
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
								categoryMap = new HashMap<Integer, Category>();
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

								System.out.println("///////////////////////////////////////////");
								System.out.println("Wanted: " + sectionCount + " Sections");
								System.out.println("Wanted: " + sectionCount + " Sub-Sections");
								System.out.println("Wanted: " + 1 + " Question(s)");

								List<String> operationList = new ArrayList<String>();

								int categoryCount = 0;
								for (int j = 0; j < Integer.parseInt(sectionCount); j++) {

									//////////////////////////////////////////////////
									Category currentCateogory = new Category();
									currentCateogory.name = "Category" + categoryCount;
									ArrayList<QuizComponent> listOfQuizEntries = new ArrayList<QuizComponent>();
									//////////////////////////////////////////////////

									operationList.add("Section");

									for (int l = 0; l < Integer.parseInt(subSectionCount); l++) {
										operationList.add("Sub-Section");

										for (int m = 0; m < 1; m++) {
											operationList.add("Question");

											Question q = new Question();
											q.setQuestion("Question is not set.");
											q.setAnswer("Answer is not set.");
											listOfQuizEntries.add(q);
										}
									}
									// set the listOfQuizEntries for current category
									currentCateogory.setQuizEntrikes(listOfQuizEntries);
									// create the iterator for that category
									Iterator<QuizComponent> iterator = currentCateogory.getQuizEntries().iterator();
									// add the category to the hashmap
									categoryMap.put(categoryCount, currentCateogory);
									// increase the count of category
									categoryCount++;
								}

								//////////////////////////////////////////////////////////////////

								setControlsOnForm(operationList);
								/////////////////////////////////////////////////////////////////
								System.out.println("///////////////////////////////////////////");

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
	}

	protected void setControlsOnForm(List<String> operationList) {
		int row = 0;
		for (String eachOperation : operationList) {

			int categoryCount = 0;

			Category currentCategory = null;
			if (eachOperation.equals("Section")) {
				currentCategory = categoryMap.get(categoryCount);
				categoryCount++;
				// add a section to the form
				System.out.println("Current Row for Section: " + row);
				String sectionText = "  Section:      ";
				String promptText = "Enter Category Here";
				addSectionToForm(row, 1, promptText, sectionText);
				row++;
				System.out.println("   Row: " + row);
			} else if (eachOperation.equals("Sub-Section")) {
				// add a subsection to the form
				System.out.println("Current Row for Sub Section: " + row);
				String sectionText = "Sub-Section:      ";
				String promptText = "Enter Sub-Section Here";
				addSectionToForm(row, 1, promptText, sectionText);
				row++;
			} else if (eachOperation.equals("Question")) {
				// add a question to the form
				System.out.println("Current Row for Question: " + row);
				String sectionText = "Question:      ";
				String promptText = "Enter Question Here";
				addSectionToForm(row, 1, promptText, sectionText);
				row++;
			}
		}
	}

	public void addSectionToForm(int row, int col, String promptText, String labelText) {
		System.out.println("\nSection is here!");

		HBox box = new HBox();
		Label label = new Label(labelText);
		TextField field = new TextField();

		field.setPromptText(promptText);
		field.setPrefWidth(field.getPromptText().length() * 14);

		box.getStyleClass().add("hBox");
		label.getStyleClass().add("hBoxLabel");
		field.getStyleClass().add("hBoxTextField");

		box.getChildren().add(label);
		box.getChildren().add(field);

		bottomGrid.add(box, col, row);
	}

	public void addSubSectionToForm(int row, int col) {
		HBox sectionHBox = new HBox();
		TextField field = new TextField();
		Label label = new Label("Sub-Section:      ");
		Button addButton = new Button("+");
		Button subButton = new Button("-");

		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Add Sub Section!");

			}
		});

		subButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Subtract Sub-Section!");

			}
		});

		sectionHBox.getStyleClass().add("hBox");
		label.getStyleClass().add("hBoxLabel");
		field.getStyleClass().add("hBoxTextField");
		addButton.getStyleClass().add("addButton");
		subButton.getStyleClass().add("subButton");

		sectionHBox.getChildren().add(label);
		sectionHBox.getChildren().add(field);
		sectionHBox.getChildren().add(addButton);
		sectionHBox.getChildren().add(subButton);
		bottomGrid.add(sectionHBox, row, col);
	}

	protected void setControlsOnBottomGrid(int gridRows, int sectionIndex) {
		int subIndex = 1;

		for (int j = 0; j < gridRows; j++) {
			System.out.println();
			if (subIndex == 1) {
				System.out.println("\nSection is here!");
				subIndex++;

				HBox box = new HBox();
				Label label = new Label("  Section:      ");
				TextField field = new TextField();

				field.setPromptText("Enter Category Here");
				field.setPrefWidth(field.getPromptText().length() * 14);

				box.getStyleClass().add("hBox");
				label.getStyleClass().add("hBoxLabel");
				field.getStyleClass().add("hBoxTextField");

				box.getChildren().add(label);
				box.getChildren().add(field);

				bottomGrid.add(box, 1, j);

			} else {
				System.out.println("   Sub Section is here!");
				subIndex++;

				HBox sectionHBox = new HBox();
				TextField field = new TextField();
				Label label = new Label("Sub-Section:      ");
				Button addButton = new Button("+");
				Button subButton = new Button("-");

				addButton.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						System.out.println("Add Sub Section!");

					}
				});

				subButton.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						System.out.println("Subtract Sub-Section!");

					}
				});

				sectionHBox.getStyleClass().add("hBox");
				label.getStyleClass().add("hBoxLabel");
				field.getStyleClass().add("hBoxTextField");
				addButton.getStyleClass().add("addButton");
				subButton.getStyleClass().add("subButton");

				sectionHBox.getChildren().add(label);
				sectionHBox.getChildren().add(field);
				sectionHBox.getChildren().add(addButton);
				sectionHBox.getChildren().add(subButton);
				bottomGrid.add(sectionHBox, 1, j);

			}
			if (subIndex > sectionIndex) {
				subIndex = 1;
			}

			if (j == gridRows - 1) {
				HBox box = new HBox();
				box.getStyleClass().add("hBox");
				box.getChildren().add(new Button("Save"));
				bottomGrid.add(box, 2, 400);
			}

		}

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
