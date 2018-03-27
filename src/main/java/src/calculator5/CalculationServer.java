package src.calculator5;

import src.output.Calculation;

public class CalculationServer {
	front fr;
	Calculation cal = new Calculation();

	String question;// = cl.text.string;
	double answer;
	boolean logical;
	String ErrorNote;
	boolean EnterPressed = false;
	String finalAnswer;

	void runCalculation() {
		cal.reset();
		//logical = true;
		ErrorNote = "";
		System.out.println("logical in calServer: " + logical);
		if (logical) {
			cal.setQuestion(question);
			cal.makeTree();
			importData();
		} else {
			ErrorNote = "ERROR: Calculation doesn't make sense";
		}

		if (isThereAError()) {
			finalAnswer = ErrorNote;
		} else {
			finalAnswer = Double.toString(answer);
		}
		System.out.println("final Error " + ErrorNote);
		System.out.println("final Answer " + finalAnswer);

	}

	boolean isThereAError() {

		if (ErrorNote.indexOf("ERROR") == -1) {
			return false;
		} else {
			return true;
		}
	}

	void importData() {
		answer = cal.returnAnswer();
		ErrorNote = cal.returnError();

	}

}