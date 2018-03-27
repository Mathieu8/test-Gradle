package src.calculator5.Help;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import src.calculator5.front;

public  class Help {
	src.calculator5.front cl;

	public void runHelp(String[] args) {
		 Stage stage = new Stage();
		
		Text firstHelp = new Text("This is a beginning of the helpdesk");

		Button oneBtn = new Button("1");
		oneBtn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {

				System.out.print("Calulation ");
			}
		});


		

		GridPane root = new GridPane();
		root.setHgap(10);
		root.setVgap(5);


		HBox Front = new HBox();
		Front.getChildren().addAll(firstHelp);
		root.addRow(4, Front);

		root.setMinSize(400, 250);
		root.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: BLACK;");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("A TextField Example");
		stage.show();
	}

}
