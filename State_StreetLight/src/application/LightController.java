package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import vora.priya.trafficLight.GreenLight;
import vora.priya.trafficLight.RedLight;
import vora.priya.trafficLight.TrafficLight;
import vora.priya.trafficLight.YellowLight;

public class LightController implements Initializable {
	@FXML
	ImageView imageView;

	@FXML
	Button changeLightButton;

	public LightController() {
		resetControls();
	}

	public void resetControls() {
		imageView = new ImageView();
		changeLightButton = new Button();
	}

	String redLightUrl = "C:\\Users\\Priya\\Documents\\Personal Workspaces\\DesignPrinciples\\State_StreetLight\\src\\images\\redLight.png";
	String greenLightUrl = "C:\\Users\\Priya\\Documents\\Personal Workspaces\\DesignPrinciples\\State_StreetLight\\src\\images\\greenLight.png";
	String yellowLightUrl = "C:\\Users\\Priya\\Documents\\Personal Workspaces\\DesignPrinciples\\State_StreetLight\\src\\images\\yellowLight.png";

	File fRed = new File(redLightUrl);
	File fGreen = new File(greenLightUrl);
	File fYellow = new File(yellowLightUrl);

	final Image redImage = new Image("file:///" + fRed.getPath());
	final Image greenImage = new Image("file:///" + fGreen.getPath());
	final Image yellowImage = new Image("file:///" + fYellow.getPath());
	Timer timer;

	public void timer(TrafficLight light) {
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				light.getState().TransitionNextLight();
				changeLight(light);
			}
		}, 1000, 1000);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TrafficLight light = new TrafficLight();
		light.setState(light.getRedlightState());

		timer(light);

		imageView.setImage(redImage);
		imageView.setImage(greenImage);
		imageView.setImage(yellowImage);

		changeLightButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Change Lights!");
				timer.cancel();
				light.getState().TransitionNextLight();
				timer(light);
				changeLight(light);
				
			}
		});
	}

	protected void changeLight(TrafficLight light) {
		if (light.getState() instanceof RedLight) {
			imageView.setImage(redImage);
		} else if (light.getState() instanceof GreenLight) {
			imageView.setImage(greenImage);
		} else if (light.getState() instanceof YellowLight) {
			imageView.setImage(yellowImage);
		}

	}

}
