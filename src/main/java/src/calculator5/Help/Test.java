package src.calculator5.Help;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import src.calculator5.OutputFld;

public class Test extends Application {
	Help help = new Help();

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		VBox outputFLd = new VBox();
		OutputFld of = new OutputFld();

		Button oneBtn = new Button("test");
		// Add EventHandler to the Button
		oneBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String[] args = null;
				System.out.println("help");
				
					 help.runHelp(args);
				
				        /*Stage stage = new Stage();
				        //Fill stage with content
				        stage.show();
				    */
				System.out.println("help");
			}
		});

		// Create the TextFields

		// Both fields should be wide enough to display 15 chars
		// Set ActionEvent handlers for both fields
		GridPane root = new GridPane();
		// Set the horizontal spacing to 10px
		root.setHgap(10);
		// Set the vertical spacing to 5px
		root.setVgap(5);
		// Add Labels and Fields to the GridPane

		VBox menuBar = new VBox();
		root.addRow(0, oneBtn);
		root.addRow(1, outputFLd);

		HBox Front = new HBox();
		root.addRow(4, Front);

		// Set the Size of the GridPane
		root.setMinSize(400, 250);
		/*
		 * Set the padding of the GridPane Set the border-style of the GridPane Set the
		 * border-width of the GridPane Set the border-insets of the GridPane Set the
		 * border-radius of the GridPane Set the border-color of the GridPane
		 */
		root.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: BLACK;");
		// Create the Scene
		Scene scene = new Scene(root);
		// Scene scene1 = new Scene(test1);
		// Add the scene to the Stage
		stage.setScene(scene);
		// stage.setScene(scene1);
		// Set the title of the Stage
		stage.setTitle("A TextField Example");
		// Display the Stage
		stage.show();
	}

	public void pressButton() throws Exception {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/A.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
