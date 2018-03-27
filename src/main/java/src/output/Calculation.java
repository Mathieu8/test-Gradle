package src.output;

import src.input.Tree;

public class Calculation {
	// public static void main(String[] args) {
	Error error = new Error();
	String question; // getString();
	Double answer = 0.5 / 0;
	String ErrorNote;

	public void makeTree() {
		Tree theTree = new Tree();
		theTree.createTree(question, 0);
		try {
			// System.out.println("inside calculation");
			ReadingTree.readingTree(theTree.root);
			System.out.println("test line");
		} catch (Exception exc) {
			error.DivedeByZerroError();
		}
		ErrorNote = error.ErrorCheck();
		System.out.println(ErrorNote);
		answer = theTree.root.iData;
		error.errorReset();

	}

	public void setQuestion(String temp) {
		question = temp;
	}

	public double returnAnswer() {
		return answer;
	}

	public String returnError() {
		return ErrorNote;
	}

	public void reset() {
		question = ""; // getString();
		answer = 0.5 / 0;
		ErrorNote = "";
	}
}
