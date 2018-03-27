package src.calculator5.options;

import org.junit.Test;

import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import src.calculator5.front;
import src.memory.Connection;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.HBox;

public class History {
	front cl;
	Connection mem;
	Menu historyMenu = new Menu("History");
	HBox Test = new  HBox();
	Label lGeschiedenis = new Label();
	//Test.getChildren().addAll(lGeschiedenis);
	//lengteGeschiedenis.getChildren().addAll(lGeschiedenis);

	


	public Menu HistoryMenu(front clc) {
		this.cl = clc;
		MenuItem historyLine = new MenuItem("Zet de lengte van de geschiedenis:");
		//SeparatorMenuItem historyLine= new SeparatorMenuItem();
		CustomMenuItem hLine = new CustomMenuItem(); 
		hLine.setContent(Test); 
		hLine.setHideOnClick(false);
		MenuItem h5 = new MenuItem("5");
		h5.setOnAction(e -> MaxPosition(5,clc));
		MenuItem h10 = new MenuItem("10");
		h10.setOnAction(e -> MaxPosition(10,clc));
		MenuItem h20 = new MenuItem("20");
		h20.setOnAction(e -> MaxPosition(20,clc));
		MenuItem h50 = new MenuItem("50");
		h50.setOnAction(e -> MaxPosition(50,clc));
		
		
		
		Menu hAnders = new Menu("anders");
		//hAnders.getItems().add();
		
		
		SeparatorMenuItem separator= new SeparatorMenuItem();
		MenuItem reset = new MenuItem("reset geschiedenis");
		reset.setOnAction(e -> resetHistory(clc));
		
		historyMenu.getItems().addAll(historyLine,hLine,h5,h10,h20,h50, hAnders,separator,reset);
		return historyMenu;
	}
	
	public void MaxPosition(int temp, front clc) {
		System.out.println("in History menu, max position is " + temp);
		cl.memory.setMaxPosition(temp);
		cl.memory.historyChoiceBoxReset(clc);
		//cl.memory
	}
	
	public void resetHistory(front clc) {
		String temp = "0";
		int maxPosition =cl.memory.maxPosition;
		temp += ","+ maxPosition;
		
		for(int i =0; i<50; i++) {
			temp += ",";
		}
		
		cl.memory.con.saveFile.save(temp);
		cl.memory.historyChoiceBoxReset(clc);
		
	}
	
	
	
}
