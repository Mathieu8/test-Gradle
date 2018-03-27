package src.calculator5;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import src.calculator5.options.OptionsServer;
import javafx.application.Platform;
//import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

// TODO making the Menu bar more complete 

public class Menu {
	front cl;
	HelpServer help = new HelpServer();
	OptionsServer option = new OptionsServer();


	public HBox Menu(front clc) {
		this.cl = clc;
		HBox menu = new HBox();

		// MenuBar menuBar = new MenuBar();

		// Add the MenuBar to the top region

		final javafx.scene.control.Menu fileMenu = new javafx.scene.control.Menu("File");
		final javafx.scene.control.Menu optionsMenu = new javafx.scene.control.Menu("Options");
		final javafx.scene.control.Menu helpMenu = new javafx.scene.control.Menu("Help");

		MenuItem exitItem = new MenuItem("E_xit");
		exitItem.setOnAction(e -> Platform.exit());
		// Add menu items to the File menu
		fileMenu.getItems().addAll(exitItem);
		// menu1;

		//BF.setSelected(true);
		// testFront.setSelected(true);
		

		MenuItem help = new MenuItem("Help");
		help.setOnAction(e -> Help("Help"));
		MenuItem about = new MenuItem("About");
		about.setOnAction(e -> Help("About"));

		helpMenu.getItems().addAll(help, about);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, option.OptionsServer(clc), helpMenu);

		BorderPane root = new BorderPane(); // does this need to be here?
		root.setBottom(menuBar);
		// Let the MenuBar use system menu bar
		menuBar.setUseSystemMenuBar(true);

		// Add some menus to the MenuBar
		// Menu fileMenu = new Menu("File");
		// Menu editMenu = new Menu("Edit");
		// menuBar.getMenus().addAll(fileMenu, editMenu);
		menu.getChildren().addAll(menuBar);

		return menu;
	}

	public void Help(String help2) {
		String[] args = null;
		String option = help2.toString();
		switch (option) {
		case "Help":
			help.runHelp(args);
			break;
		case "About":
			help.runAbout(args);
			break;
		default:
			System.out.println("bug");
			break;
		}
	}

}
