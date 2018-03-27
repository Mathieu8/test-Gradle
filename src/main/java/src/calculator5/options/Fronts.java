package src.calculator5.options;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import src.calculator5.front;

public class Fronts {
	Menu Fronts = new Menu("Fronts");
	front cl;
	
	RadioMenuItem BF = new RadioMenuItem("Advance Calculator");
	RadioMenuItem SF = new RadioMenuItem("basic Calculator");
	RadioMenuItem testFront = new RadioMenuItem("testFront"); // TODO remove this line after making it
	MenuItem test = new MenuItem("test");
	
	public Menu fronts(front clc) {
		this.cl = clc;
		
		BF.setSelected(true);
		// testFront.setSelected(true);
		BF.setOnAction(e -> draw());
		SF.setOnAction(e -> draw());
		testFront.setOnAction(e -> draw());
		ToggleGroup shapeGroup = new ToggleGroup();
		shapeGroup.getToggles().addAll(BF, SF, testFront);

		Fronts.getItems().addAll(BF, SF, testFront, test);
		
		return Fronts;
	}
	
	public void draw() {
		String selectedFront = getSelectedFront();
		cl.bf.setVisible(false);
		cl.sf.setVisible(false);

		switch (selectedFront) {
		case "BF": {
			cl.bf.setVisible(true);
			System.out.println("inside case BF");
			break;
		}
		case "SF": {
			cl.sf.setVisible(true);
			System.out.println("inside case SF");
			break;
		}
		case "test": {
			cl.bf.setVisible(false);
			cl.sf.setVisible(false);
			System.out.println("inside case test");
			break;
		}
		default: {
			System.out.println("inside case default");
			break;
		}
		}

	}

	public String getSelectedFront() {
		if (BF.isSelected()) {
			return "BF";
		} else if (SF.isSelected()) {
			return "SF";
		} else if (testFront.isSelected()) {
			return "test";

		} else {
			return "";
		}
	}	

}
