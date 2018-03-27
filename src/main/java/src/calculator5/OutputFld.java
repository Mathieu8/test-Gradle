package src.calculator5;

import javafx.scene.layout.VBox;

public class OutputFld {
	front cl;
	
	public VBox OutputFld(front clc) {
		this.cl = clc;/*
		cl.messageLbl;
		cl.inputFld;
		cl.answerLine;*/
		VBox outputFld = new VBox();
		outputFld.getChildren().addAll(cl.inputFld, cl.answerLine);
		return outputFld;
	}

}
