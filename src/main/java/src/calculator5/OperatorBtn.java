package src.calculator5;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class OperatorBtn extends BorderPane {
	front cl;
	String operator;

	public OperatorBtn(String s, front clc) {
		operator = s;
		Button btn = new Button(operator);
		btn.setMinWidth(50.0);
		btn.setPrefWidth(50.0);
		btn.setMaxWidth(50.0);
		setCenter(btn);
		this.cl = clc;
		btn.setOnAction(buttonHandler);

	}

	EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			//System.out.println(operator);
			cl.text.addString(operator);
			cl.inputFld.setText(cl.text.string);
			
			event.consume();
		}
	};
}
