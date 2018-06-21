package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.w3c.dom.ls.LSInput;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import vora.priya.IteratorFx.Category;
import vora.priya.IteratorFx.Question;
import vora.priya.IteratorFx.QuizComponent;

public class SurveyController implements Initializable {

	@FXML
	GridPane topGrid;
	@FXML
	GridPane bottomGrid;
	@FXML
	Label titleLabel;
	@FXML
	ChoiceBox<String> operationChoiceBox;

	Map<String, Category> categoryMap;

	private int currentRow = 2;
	private int quizEntriesCounter = 0;

	List<String> formStringList = new ArrayList<String>();

	// private Category currentCategory = null;
	// private Category currentSection = null;
	// private Category currentQuestion = null;
	//
	ArrayList<QuizComponent> listOfQuizEntries = new ArrayList<QuizComponent>();
	ArrayList<QuizComponent> listOfQuestions = new ArrayList<QuizComponent>();

	// List<Category> currentListOfSections_ForCategory = null;
	//
	// ArrayList<Category> totalListOfCategories = new ArrayList<>();
	// int categoriesCount = 0;

	public SurveyController() {
		resetControls();
		formStringList = new ArrayList<String>();
	}

	public void resetControls() {
		topGrid = new GridPane();
		topGrid.setVisible(true);
		bottomGrid = new GridPane();
		bottomGrid.setVisible(true);
		titleLabel = new Label();
		operationChoiceBox = new ChoiceBox<String>();
		categoryMap = new HashMap<String, Category>();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		start();
	}

	private void start() {
		System.out.println("Controller is ready!");
		setActionListener_ChoiceBox();

	}

	public void addSubSectionToSection(Category categoryToAdd) {
		currentRow++;
	}

	public void addNewCategoryField(TextField caTextField) {
		// listOfQuizEntries = new ArrayList<QuizComponent>();
		// listOfQuestions = new ArrayList<QuizComponent>();
		// currentListOfSections_ForCategory = null;
		Category newCategory = null;
		List<Question> currentListOfQuestion_ForSection = new ArrayList<>();
		if (caTextField != null) {
			if ((caTextField.getText().trim()).isEmpty() == false) {
				Label addCatField = new Label();
				addCatField.setText(caTextField.getText().trim());
				topGrid.add(addCatField, 1, currentRow);
				currentRow++;
				newCategory = new Category();
				newCategory.name = caTextField.getText().trim();
				// currentCategory = newCategory;
			}
		}

		formStringList.add(quizEntriesCounter, "Category:" + newCategory.name);
		quizEntriesCounter++;
	}

	public void addSubSectionField(TextField subSecTextField) {
		// List<Question> currentListOfQuestion_ForSection = new ArrayList<>();
		Category subSection;
		if (subSecTextField != null) {
			if ((subSecTextField.getText().trim()).isEmpty() == false) {
				Label addSubField = new Label();
				addSubField.setText(subSecTextField.getText().trim());
				topGrid.add(addSubField, 1, currentRow);
				currentRow++;
				subSection = new Category();
				subSection.name = subSecTextField.getText().trim();
				// currentSection = subSection;
				// if (currentListOfSections_ForCategory == null) {
				// currentListOfSections_ForCategory = new ArrayList<Category>();
				// }
				// currentListOfSections_ForCategory.add(currentSection);
				formStringList.add(quizEntriesCounter, "Sub-Section:" + subSection.name);
				quizEntriesCounter++;
			}
		}
	}

	public void addQuestionField(TextField questionTextField) {
		if (questionTextField != null) {
			if ((questionTextField).getText().trim().isEmpty() == false) {
				Label addQField = new Label();
				addQField.setText(questionTextField.getText().trim());
				topGrid.add(addQField, 1, currentRow);
				currentRow++;
				Question newQuestion = new Question();
				newQuestion.setQuestion(questionTextField.getText().trim());
				newQuestion.name = questionTextField.getText().trim();
				// listOfQuestions.add(newQuestion);
				// currentSection.setQuizEntrikes(listOfQuestions);
				formStringList.add(quizEntriesCounter, "Question:" + newQuestion.getQuestion());
				quizEntriesCounter++;
			}
		}
	}

	public void addQuestionToSub_Section(Category subSectionToAdd) {
		currentRow++;
	}

	public void addQuestionToSection(Question questionToAdd) {
		currentRow++;
	}

	public void setBasicSurveyLayout() {
		Button addCategory = new Button("Add Category");
		Button addSubSection = new Button("Add Sub Section");
		Button addQuestion = new Button("Add Question");

		addCategory.getStyleClass().add("Button");
		addSubSection.getStyleClass().add("Button");
		addQuestion.getStyleClass().add("Button");

		TextField categoryField = new TextField();
		TextField subSectionField = new TextField();
		TextField questionField = new TextField();

		addCategory.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				addNewCategoryField(categoryField);
			}
		});

		addSubSection.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				addSubSectionField(subSectionField);
			}
		});

		addQuestion.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				addQuestionField(questionField);

			}
		});

		categoryField.setPromptText("Enter category name");
		subSectionField.setPromptText("Enter sub-section name");
		questionField.setPromptText("Enter question name");

		topGrid.add(categoryField, 1, 1);
		topGrid.add(addCategory, 2, 1);
		topGrid.add(subSectionField, 3, 1);
		topGrid.add(addSubSection, 4, 1);
		topGrid.add(questionField, 5, 1);
		topGrid.add(addQuestion, 6, 1);
	}

	public void setActionListener_ChoiceBox() {
		operationChoiceBox.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				categoryMap = new HashMap<String, Category>();
				operationChoiceBox.getSelectionModel().selectFirst();
				String selectedOption = operationChoiceBox.getItems()
						.get(operationChoiceBox.getSelectionModel().getSelectedIndex());
				titleLabel.setText(selectedOption.trim());

				if (selectedOption.equals("Create a Survey")) {
					Button save = new Button("Save Category");
					save.getStyleClass().add("Button");

					save.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {

							bottomGrid.getChildren().clear();
							System.out.println("\nForm: ");
							Category currentCategory = null;
							Category previousCategory = null;

							Category newSection = null;
							int countCat = 0;

							List<Category> categoryList = new ArrayList<Category>();

							for (int i = 0; i < formStringList.size(); i++) {
								String formatStr = formStringList.get(i);
								String[] dataArray = formatStr.split(":");
								String type = dataArray[0];
								String data = dataArray[1];
								boolean endLoop = false;
								if (type.equals("Category")) {
									currentCategory = new Category();
									currentCategory.name = data;
									newSection = null;
									listOfQuestions = new ArrayList<>();
									listOfQuizEntries = new ArrayList<>();

									while (endLoop != true) {

										if ((i + 1) < formStringList.size()) {
											String nextStr = formStringList.get(i + 1);
											String[] nextDataArray = nextStr.split(":");
											String nextType = nextDataArray[0];
											String nextData = nextDataArray[1];

											if (nextType.equals("Sub-Section")) {
												newSection = new Category();
												newSection.name = nextData;
												i++;

											} else if (nextType.equals("Question")) {

												Question question = new Question();
												question.name = nextData;
												question.question = nextData;

												if (newSection != null) {
													// add question to the listOfQuestions for section
													listOfQuestions.add(question);
												} else {
													// add question to the listOfQuizEntries
													listOfQuizEntries.add(question);

												}
												i++;
											} else if (nextType.equals("Category")) {
												if (currentCategory != null) {
													// set the category by adding the section to the
													if (newSection != null) {
														newSection.setQuizEntrikes(listOfQuestions);
														listOfQuizEntries.add(newSection);
													}

													currentCategory.setQuizEntrikes(listOfQuizEntries);
													categoryList.add(currentCategory);
													previousCategory = currentCategory;
													currentCategory = new Category();
													currentCategory.name = nextData;
													newSection = null;
													listOfQuestions = new ArrayList<>();
													listOfQuizEntries = new ArrayList<>();
												}
												i++;
											}
										} else {
											if (!(categoryList.contains(currentCategory))) {
												if (currentCategory != null) {
													// set the category by adding the section to the
													if (newSection != null) {
														newSection.setQuizEntrikes(listOfQuestions);
														listOfQuizEntries.add(newSection);
													}

													currentCategory.setQuizEntrikes(listOfQuizEntries);
													categoryList.add(currentCategory);

												}
											}

											endLoop = true;
										}

									}
								}

								for (Category each_Cat : categoryList) {
									Iterator<QuizComponent> iterator = each_Cat.getQuizEntries().iterator();

									List<QuizComponent> catList = each_Cat.getQuizEntries();
									System.out.println("Each Category: " + each_Cat.name);

									while (iterator.hasNext()) {
										iterator.next().print();
									}
								}

								int rowCounterSecondGrid = 0;

								// call the method that makes the form
								for (Category each_Cat : categoryList) {
									Iterator<QuizComponent> iterator = each_Cat.getQuizEntries().iterator();

									List<QuizComponent> catList = each_Cat.getQuizEntries();
									System.out.println("Each Category: " + each_Cat.name);

									Label catLabel = new Label();
									catLabel.setText("Category:" + each_Cat.name);

									bottomGrid.add(catLabel, 1, rowCounterSecondGrid);
									rowCounterSecondGrid++;
									System.out.println(" ");
									while (iterator.hasNext()) {
										Category comp = (Category) iterator.next();
										String textValue = comp.name;
										System.out.println("Component: " + textValue);
										Label label = new Label();
										label.setText("Sub-Category:" + textValue.trim());
										// add label to the grid
										bottomGrid.add(label, 1, rowCounterSecondGrid);
										rowCounterSecondGrid++;

										Iterator<QuizComponent> questionIterator = comp.getQuizEntries().iterator();
										String textValueQ = questionIterator.next().name;
										System.out.println("Question: " + textValueQ);
										Label quesitonLabel = new Label();
										quesitonLabel.setText("Question: " + textValueQ.trim());
										// add label to the grid
										bottomGrid.add(quesitonLabel, 1, rowCounterSecondGrid);
										rowCounterSecondGrid++;

										TextField field = new TextField();
										field.setPromptText("Answer Here.");
										bottomGrid.add(field, 1, rowCounterSecondGrid);
										rowCounterSecondGrid++;
									}
								}

							}
						}
					});

					setBasicSurveyLayout();
					topGrid.add(save, 7, 400);

					// reste List<Question> currentListOfQuestion_ForSection = new ArrayList<>();
					// when save is hit
				}
			}
		});
	}

}
