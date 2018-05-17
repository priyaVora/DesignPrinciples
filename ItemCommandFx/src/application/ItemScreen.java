package application;

import java.net.URL;
import java.util.ResourceBundle;

import command.models.Item;
import command.solutions.ItemChangeColorsCommandRed;
import command.solutions.ItemChangedColorsCommandBlack;
import command.solutions.ItemControl;
import command.solutions.ItemMoveCommandBottom;
import command.solutions.ItemMoveCommandLeft;
import command.solutions.ItemMoveCommandRight;
import command.solutions.ItemMoveCommandTop;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;

public class ItemScreen implements Initializable {
	@FXML
	GridPane mainGrid;
	@FXML
	Button rightButton;
	@FXML
	Button topButton;
	@FXML
	Button leftButton;
	@FXML
	Button bottomButton;
	@FXML
	Button undoButton;

	@FXML
	ChoiceBox<String> ColorChangeSelection;
	@FXML
	ChoiceBox<String> itemSelection;

	int currentRow = 0;
	int currentCol = 0;

	public ItemScreen() {
		resetControls();
	}

	public void resetControls() {
		leftButton = new Button();
		rightButton = new Button();
		topButton = new Button();
		bottomButton = new Button();
		undoButton = new Button();

		ColorChangeSelection = new ChoiceBox<String>();
		itemSelection = new ChoiceBox<String>();
		mainGrid = new GridPane();

	}

	public void setGridView() {
		mainGrid.getChildren().clear();
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 29; j++) {
				Button newButton = new Button("");

				if (ColorChangeSelection.getItems().get(ColorChangeSelection.getSelectionModel().getSelectedIndex())
						.equals("Red")) {
					if (i == currentCol && j == currentRow) {
						newButton.getStyleClass().add("currentButtonRed");
					} else {
						newButton.getStyleClass().add("gridButtonsRed");
					}
				} else if (ColorChangeSelection.getItems()
						.get(ColorChangeSelection.getSelectionModel().getSelectedIndex()).equals("Black")) {
					if (i == currentCol && j == currentRow) {
						newButton.getStyleClass().add("currentButtonBlack");
					} else {

						newButton.getStyleClass().add("gridButtonsBlack");
					}
				}

				mainGrid.add(newButton, j, i);
			}

		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Image imageDecline = new
		// Image(getClass().getResourceAsStream("Images\\LeftArrow.jpg"));
		// leftButton.setGraphic(new ImageView(imageDecline));
		itemSelection.setValue(itemSelection.getItems().get(0));
		ColorChangeSelection.setValue(ColorChangeSelection.getItems().get(1));
		mainGrid.setGridLinesVisible(false);
		setGridView();

		ItemControl rc = new ItemControl();
		Item item = new Item();
		rc.program(0, 0,
				new ItemChangeColorsCommandRed(item, item.getColorChange() != null ? item.getColorChange() : "Red"));
		rc.program(1, 0, new ItemChangedColorsCommandBlack(item,
				item.getColorChange() != null ? item.getColorChange() : "Black"));
		rc.program(2, 0, new ItemMoveCommandTop(item, item.getMovement() != null ? item.getMovement() : "Top"));

		rc.program(3, 0, new ItemMoveCommandRight(item, item.getMovement() != null ? item.getMovement() : "Right"));

		rc.program(4, 0, new ItemMoveCommandBottom(item, item.getMovement() != null ? item.getMovement() : "Bottom"));

		rc.program(5, 0, new ItemMoveCommandLeft(item, item.getMovement() != null ? item.getMovement() : "Left"));

		leftButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Left Arrow is Clicked!");
				if (currentRow != 0) {
					rc.pressButton(2, 0);
					currentCol = currentCol;
					currentRow = currentRow - 1;
				}
				System.out.println("Current Row: " + currentRow);
				System.out.println("Current Col: " + currentCol);
				setGridView();
			}
		});
		rightButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Right Arrow is Clicked!");
				if (currentRow < 14) {
					rc.pressButton(4, 0);
					currentCol = currentCol;
					currentRow = currentRow + 1;
				}
				System.out.println("Current Row: " + currentRow);
				System.out.println("Current Col: " + currentCol);
				setGridView();
			}
		});
		topButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Top Arrow is Clicked!");

				if (currentCol != 0) {
					rc.pressButton(5, 0);
					currentCol = currentCol - 1;
					currentRow = currentRow;
				}
				System.out.println("Current Row: " + currentRow);
				System.out.println("Current Col: " + currentCol);
				setGridView();
			}

		});
		bottomButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Bottom Arrow is Clicked!");

				if (currentCol < 28) {
					rc.pressButton(3, 0);
					currentCol = currentCol + 1;
					currentRow = currentRow;
				}
				System.out.println("Current Row: " + currentRow);
				System.out.println("Current Col: " + currentCol);
				setGridView();
			}
		});

		undoButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Undo!");
				rc.pressUndoButton();
				
			}
		});
		
		
		
		
		
		ColorChangeSelection.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String selected = ColorChangeSelection.getItems()
						.get(ColorChangeSelection.getSelectionModel().getSelectedIndex());

				if (selected.equals("Red")) {
					System.out.println(selected);
				} else if (selected.equals("Black")) {
					System.out.println("Black");
				}
				setGridView();
			}
		});

		itemSelection.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String selected = itemSelection.getItems().get(itemSelection.getSelectionModel().getSelectedIndex());

				if (selected.equals("Button")) {
					System.out.println(selected);
				}

			}
		});

	}

}
