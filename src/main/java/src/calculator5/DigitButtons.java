package src.calculator5;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class DigitButtons extends BorderPane {
	front cl;
	String digit;

	public DigitButtons(String s, front clc) {
		digit = s;
		Button btn = new Button(digit);
		btn.setMinWidth(30.0);
		btn.setPrefWidth(30.0);
		btn.setMaxWidth(30.0);
		setCenter(btn);
		this.cl = clc;
		btn.setOnAction(buttonHandler);
		 	}

	EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			//System.out.println(digit);
			cl.text.addString(digit);
			cl.inputFld.setText(cl.text.string);
			
			event.consume();
		}
	};
}
