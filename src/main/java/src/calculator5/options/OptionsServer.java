package src.calculator5.options;

import javafx.scene.control.Menu;
import src.calculator5.front;

public class OptionsServer {
	front cl;
	final javafx.scene.control.Menu optionsMenu = new javafx.scene.control.Menu("Options");
	Fronts front = new Fronts();
	History history = new History();
	
	public Menu OptionsServer(front clc) {
		optionsMenu.getItems().addAll(front.fronts(clc),history.HistoryMenu(clc));
		
		return optionsMenu;
		
	}

}
