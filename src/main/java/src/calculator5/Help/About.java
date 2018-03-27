package src.calculator5.Help;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class About {
	src.calculator5.front cl;

	public void runAbout(String[] args) {
		Stage stage = new Stage();

		Text titleAbout = new Text("About:");
		titleAbout.setFont(new Font(24));
		Text firstAbout = new Text(
				"This is program is made by M. at wij3.0. This is made as part of learning to program in Java, there might some bugs or not optimized code in this program. I am doing the best that I can do to fix them");
		firstAbout.setWrappingWidth(375);
		firstAbout.setFont(new Font(12));

		GridPane root = new GridPane();
		root.setHgap(10);
		root.setVgap(5);

		VBox Front = new VBox();
		Front.getChildren().addAll(titleAbout, firstAbout);
		root.addRow(4, Front);

		root.setMinSize(400, 250);
		root.setMaxSize(400, 250);
		root.setPrefSize(400, 250);
		root.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: Grey;");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("A TextField Example");
		stage.show();
	}

}
