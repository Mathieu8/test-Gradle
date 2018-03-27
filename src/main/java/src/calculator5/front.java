package src.calculator5;
/* 
 TODO add memory function
 TODO tidy up front
 TODO Junit
 TODO add safety mode, first make an approximation before getting the answer
 TODO add significant digits
 TODO 42 easter egg
*/

//import java.util.Collection;
import java.util.HashMap;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class front extends Application {
	
	HashMap<String, Boolean> currentlyActiveKeys = new HashMap<>();
	// Create the Message Label
	Text messageLbl = new Text("Enter your Calculation into the Text Fields.");

	MakingText text = new MakingText();
	CalculationServer cal = new CalculationServer();

	TextField inputFld = new TextField();
	Text answerLine = new Text();
	
	public BasicFront bf = new BasicFront();
	public SimpleFront sf = new SimpleFront();

	EnterButton enter = new EnterButton(this);
	
	public MemoryServer memory = new MemoryServer();
	
	Menu menu = new Menu(); 
	

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		VBox outputFLd = new VBox();
		OutputFld of = new OutputFld();
		outputFLd.getChildren().addAll(of.OutputFld(this));

		Button oneBtn = new Button("1");
		// Add EventHandler to the Button
		oneBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				printMessage("Calulation ");
			}
		});

		// Create the TextFields

		// Both fields should be wide enough to display 15 chars
		inputFld.setPrefColumnCount(15);
		// Set ActionEvent handlers for both fields
		inputFld.setOnKeyReleased(e -> handle(e, inputFld));
		answerLine.setText(" ");

		GridPane root = new GridPane();
		// Set the horizontal spacing to 10px
		root.setHgap(10);
		// Set the vertical spacing to 5px
		root.setVgap(5);
		// Add Labels and Fields to the GridPane
		
		
		
		
		VBox menuBar = new VBox();
		menuBar.getChildren().addAll(menu.Menu(this));
		root.addRow(0, menuBar);
		root.addRow(1, memory.Memory(this));
		root.addRow(2, outputFLd);

		HBox Front = new HBox();
		Front.getChildren().addAll(bf.basicFront(this),sf.SimpleFront(this), enter);
		root.addRow(4, Front);
		sf.setVisible(false);

		// Set the Size of the GridPane
		root.setMinSize(350, 250);
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
		
		scene.setOnKeyPressed(event -> {
			String codeString = event.getCode().toString();
			if (!currentlyActiveKeys.containsKey(codeString)) {
				currentlyActiveKeys.put(codeString, true);
			}
		});
		
		inputFld.setOnKeyPressed(event -> {
			String codeString = event.getCode().toString();
			if (!currentlyActiveKeys.containsKey(codeString)) {
				currentlyActiveKeys.put(codeString, true);
			}
		});
		
		scene.setOnKeyReleased(event -> 
		currentlyActiveKeys.remove(event.getCode().toString())
				);
		
		new AnimationTimer() {
			@Override
			public void handle(long now) {
				/*if (removeActiveKey("LEFT")) {
					System.out.println("left");
				}
				
				if (removeActiveKey("RIGHT")) {
					System.out.println("right");
				}*/
				
				if (removeActiveKey("UP")) {
					System.out.println("up");
				}
				
				if (removeActiveKey("DOWN")) {
					System.out.println("down");
				}
			}
		}.start();
		
		// Add the scene to the Stage
		stage.setScene(scene);
		// stage.setScene(scene1);
		// Set the title of the Stage
		stage.setTitle("A TextField Example");
		// Display the Stage
		stage.show();
	}

	Label messageLbl2 = new Label("E-------------------");

	// Helper Method
	public void printMessage(String message) {
		// Set the Text of the Label
		messageLbl.setText(message);
	}

	// @Override
	public void handle(KeyEvent e, TextField tf) {
		String input = String.valueOf(tf.getText());
		text.newString(input);
		printMessage(text.string);
		e.consume();
	}
	
	 private boolean removeActiveKey(String codeString) {
	        Boolean isActive = currentlyActiveKeys.get(codeString);

	        if (isActive != null && isActive) {
	            currentlyActiveKeys.put(codeString, false);
	            return true;
	        } else {
	            return false;
	        }
	    }
}