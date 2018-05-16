package application;

import java.net.URL;
import java.util.ResourceBundle;

import javax.print.attribute.standard.MediaSize.Other;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ItemScreen implements Initializable {
	@FXML
	Button rightButton;
	@FXML
	Button topButton;
	@FXML
	Button leftButton;
	@FXML
	Button bottomButton;

	@FXML
	ChoiceBox<String> colorChangeSelection;
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

		colorChangeSelection = new ChoiceBox<String>();
		itemSelection = new ChoiceBox<String>();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Image imageDecline = new
		// Image(getClass().getResourceAsStream("Images\\LeftArrow.jpg"));
		// leftButton.setGraphic(new ImageView(imageDecline));

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

		colorChangeSelection.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String selected = itemSelection.getItems().get(itemSelection.getSelectionModel().getSelectedIndex());

				if (selected.equals("Dot")) {
					System.out.println(selected);
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
