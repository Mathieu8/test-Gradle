package src.calculator5;

import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;

public class MemoryServer {
	front cl;
	public src.memory.Connection con = new src.memory.Connection();
	String toSave;
	String fromLoad;
	public int maxPosition;
	String[] history = new String[50];
	ComboBox<String> historyChoiceBox = new ComboBox<>();
	HBox historyHBox = new HBox();
	// Node historyChoiceNode;

	public void increasePosition() {
		con.increseReadPosition();
	}

	public void decreasePosition() {
		con.decreasePosition();
	}

	public String readFromLoad() {
		return fromLoad;
	}

	public void setToSave(String temp) {
		toSave = temp;
		save();
	}

	public void save() {
		con.save(toSave);
	}

	public void show() {
		fromLoad = con.readPosition();
	}

	public void setMaxPosition(int temp) {
		System.out.println("in MemoryServer, max position is " + temp);
		maxPosition = temp;
		con.setMaxPosition(temp);
	}

	public void setHistory() {

		con.read();
		maxPosition = con.returnMaxPosition();
		history = con.returnHistory();
	}

	public HBox Memory(front clc) {
		setHistory();
		// cl.text.addString(tempHistory); // something here doesn't work
		// cl.inputFld.setText(cl.text.string); // something here doesn't work
		/*
		 * historyChoiceBox.getSelectionModel().selectedItemProperty().addListener(new
		 * ChangeListener<String>() {
		 * 
		 * public void changed(ObservableValue<? extends String> ov, final String
		 * oldValue, final String newValue) { tempHistory = newValue;
		 * System.out.println("test " + tempHistory); } });
		 */

		// historyHBox.getChildren().addAll(historyChoiceBox(clc),historyButtons(clc));
		historyChoiceBoxReset(clc);
		return historyHBox;
	}

	public HBox historyChoiceBox(front clc) {

		HBox temp = new HBox();
		historyChoiceBoxReset(clc);
		// temp.getChildren().add(historyChoiceBox);

		return temp;
	}

	public void historyChoiceBoxReset(front clc) {
		historyChoiceBox.getItems().clear();
		historyChoiceBox.setValue(null);
		historyHBox.getChildren().removeAll();
		historyHBox.getChildren().clear();
		historyHBox.getChildren().remove(historyButtons(clc));
		historyHBox.getChildren().remove(historyChoiceBox);

		historyChoiceBox = new ComboBox();// do whatever else you need to format your ComboBox
		historyHBox.getChildren().addAll(historyChoiceBox, historyButtons(clc));
		setHistory();

		int i = 0;
		int j = maxPosition;// -1;
		while (i < maxPosition) {
			if (j == maxPosition) {
				j = 0;
			}
			System.out.println("history[" + j + "]: " +history[j]);
			if ((history[j] != null)&&!history[j].equals("null")) {
				historyChoiceBox.getItems().add(history[j]);
				System.out.println("added " + history[j] + " als " + j + " optie" );
			} //TODO make sure it only displays validate options
			i++;
			j++;
		}
		historyChoiceBox.getSelectionModel().selectFirst();

	}

	public HBox historyButtons(front clc) {
		HBox temp = new HBox();
		Button btn = new Button("History");
		btn.setMinWidth(80.0);
		btn.setPrefWidth(80.0);
		btn.setMaxWidth(80.0);
		// setCenter(btn);
		this.cl = clc;
		btn.setOnAction(buttonHandler);
		temp.getChildren().add(btn);
		return temp;

	}

	EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			// System.out.println(digit);
			String tempHistory;
			tempHistory = historyChoiceBox.getSelectionModel().getSelectedItem();
			cl.text.deleteString();
			cl.text.addString(tempHistory);
			cl.inputFld.setText(cl.text.string);

			event.consume();
		}
	};
}
