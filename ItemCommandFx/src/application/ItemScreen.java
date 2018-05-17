package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

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
	ChoiceBox<String> ColorChangeSelection;
	@FXML
	ChoiceBox<String> itemSelection;

	public ItemScreen() {
		resetControls();
	}

	public void resetControls() {
		leftButton = new Button();
		rightButton = new Button();
		topButton = new Button();
		bottomButton = new Button();

		ColorChangeSelection = new ChoiceBox<String>();
		itemSelection = new ChoiceBox<String>();
		mainGrid = new GridPane();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Image imageDecline = new
		// Image(getClass().getResourceAsStream("Images\\LeftArrow.jpg"));
		// leftButton.setGraphic(new ImageView(imageDecline));
		Button field = new Button();
		field.setText("Priya");
		field.setPrefWidth(field.getText().length() * 14);
		field.getStyleClass().add("gridResult");

		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 29; j++) {
				Button newButton = new Button("");
				if(i == 0 && j == 0) { 
					newButton.getStyleClass().add("currentButton");
				} else { 
					newButton.getStyleClass().add("gridButtons");
				}
				
				mainGrid.add(newButton, j, i);
			}

		}

		// mainGrid.getColumnConstraints().add(new ColumnConstraints(10)); // column 0
		// is 100 wide
		// mainGrid.getRowConstraints().add(new RowConstraints(10)); // column 1 is 200
		// wide
		mainGrid.setGridLinesVisible(true);
		leftButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Left Arrow is Clicked!");

			}
		});
		rightButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Right Arrow is Clicked!");

			}
		});
		topButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Top Arrow is Clicked!");

			}
		});
		bottomButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Bottom Arrow is Clicked!");

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

			}
		});

		itemSelection.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String selected = itemSelection.getItems().get(itemSelection.getSelectionModel().getSelectedIndex());

				if (selected.equals("Dot")) {
					System.out.println(selected);
				}

			}
		});

	}

}