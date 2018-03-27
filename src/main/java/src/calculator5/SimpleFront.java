package src.calculator5;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SimpleFront {

	Label empty = new Label("   ");
		front cl;
		//boolean visiblity = true;
		VBox SimpleFront = new VBox();

		public VBox SimpleFront(front clc) {
			this.cl = clc;
			
			/*VBox outputFLd = new VBox();
			OutputFld of = new OutputFld();
			outputFLd.getChildren().addAll(of.OutputFld(cl));*/

			
			HBox d789 = new HBox();
			HBox d456 = new HBox();
			HBox d123 = new HBox();
			HBox d0dot = new HBox();
			d789.getChildren().addAll(new DigitButtons("7", cl), new DigitButtons("8", cl), new DigitButtons("9", cl));
			d456.getChildren().addAll(new DigitButtons("4", cl), new DigitButtons("5", cl), new DigitButtons("6", cl));
			d123.getChildren().addAll(new DigitButtons("1", cl), new DigitButtons("2", cl), new DigitButtons("3", cl));
			d0dot.getChildren().addAll(new DigitButtons("0", cl), new DigitButtons(".", cl));

			HBox odms = new HBox();
			HBox omfc = new HBox();
			HBox ompt = new HBox();
			HBox opbobc = new HBox();
			odms.getChildren().addAll(new DigitButtons("/", cl));
			omfc.getChildren().addAll(new DigitButtons("*", cl));
			ompt.getChildren().addAll(new DigitButtons("-", cl));
			opbobc.getChildren().addAll(new DigitButtons("+", cl));
//			EnterButton enter = new EnterButton(cl);

			VBox digid = new VBox();
			digid.getChildren().addAll(d789, d456, d123, d0dot);
			VBox operator = new VBox();
			operator.getChildren().addAll(odms, omfc, ompt, opbobc);
			HBox btn = new HBox();
			btn.getChildren().addAll(digid, empty, operator/*, enter*/);
			
			SimpleFront.getChildren().addAll(/*outputFLd,*/ btn);
			
			return SimpleFront;
			// root.addRow(4, test);

		}
		
		public void setVisible(boolean b) {
			//visiblity = b;
			//basicFront.setManaged(visiblity);
			SimpleFront.setVisible(b);
			SimpleFront.managedProperty().bind(SimpleFront.visibleProperty());
		}
	}

	/*
	root.addRow(0, messageLbl);
	root.addRow(2, inputFld);
	root.addRow(3, answerLine); */