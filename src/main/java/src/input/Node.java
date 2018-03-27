package src.input;

public class Node {
	public Double iData = 0.0; // data item (key)
	//public double dData;// data item
	public String string = "";
	public boolean numberOrOperator = false; // if a operator than it's set to
												// true
	public String before = "", after = "";
	public String operator = "";
	public int splitsLocatie = 0;

	public Node leftChild; // this node’s left child
	public Node rightChild; // this node’s right child

	public void displayNode() // display ourself
	{
		System.out.print('{');
		System.out.print(iData);
		System.out.print(", ");
		//System.out.print(dData);
		System.out.print("} ");
	}

	void split() {
		// int splitsLocatie =0;
		if ((string != "") && (string != null)) {
			noOperations();
			if (numberOrOperator) {
				SplitsLocation();
				// SplitsChar(splitsLocatie);
				if (splitsLocatie == 0) {
					if (singleNumberOperations(0)) {
						afterSplits(splitsLocatie);
					} else {
						numberOrOperator = false;
						splitsLocatie = string.length();
					}
				}
				beforeSplits(splitsLocatie);
				afterSplits(splitsLocatie);
			} else {
				Number number = new Number();
				number.string = string;
				number.stringToNumber();
				iData = number.number;

			}
		}
	}
	
	void noOperations() { /*
							 * checks if there is a char that isn't part of a
							 * number
							 */
		String numbers = "1234567890.";
		for (int i = 0; i < string.length(); i++) {
			if (numbers.indexOf(string.charAt(i)) == -1) {
				numberOrOperator = true;
				break;
			} // end if

		} // end for
	}// noOperations

	void SplitsLocation() {
		/*
		 * first it checks parentheses it will only checks operators when we are
		 * outside of parentheses secondly it takes the first + or -, afterwards it
		 * will break out of the for loop. works than it will checks *, / or %,
		 * it will take the first one in the string. works after that ^ will be
		 * checked, if there is no *, / or % before than. works lastly it will
		 * only take check if there is a single number operation at the start, it will than checks for sine, parentheses and factorial.
		 */
		int i = 0;
		int sum = 0;
		int parentheses = 0;
		for (i = 0; i < string.length(); i++) {
			if (string.charAt(i) == ' ') {

			} // if
			if (string.charAt(i) == '(') {
				parentheses++;
				if (i == 0) {
					sum = +1;
				} // end if
			} // end if
			if (string.charAt(i) == ')') {
				if ((parentheses == 1) && (i != string.length() - 1)) {
					sum = -1;
					parentheses--;
				} else {
					parentheses--;
				}
			}
			if (parentheses == 0) {
				if (string.charAt(i) == '+') {
					operator = "+";
					splitsLocatie = i;
					break;
				}
				if ((string.charAt(i) == '-') && (i > 0)) {
					splitsLocatie = i;
					operator = "-";
					break;
				}
				if (((operator == "^") | (operator == "")) && ((string.charAt(i) == '*') ^ (string.charAt(i) == 'x'))) {
					splitsLocatie = i;
					operator = "*";
				}
				if (((operator == "^") | (operator == "")) && (string.charAt(i) == '/')) {
					splitsLocatie = i;
					operator = "/";
				}
				if (((operator == "^") | (operator == "")) && (string.indexOf("mod(")) == i) {
					splitsLocatie = i;
					operator = "mod";
				}
				if ((operator == "") && (string.charAt(i) == '^')) {
					splitsLocatie = i;
					operator = "^";
				}
				if ((operator == "" ) &&(string.charAt(string.length() - 1) == '!')) {
					operator = "!";
				}
				if (i == 0) {
					if ((operator != "*") && (operator != "/") && (operator != "%") && (operator != "^")) {
						splitsLocatie = 0;
						if (string.indexOf("sin(") == i) {
							operator = "sin(";
						}
						if (string.indexOf("cos(") == i) {
							operator = "cos(";
						}
						if (string.indexOf("tan(") == i) {
							operator = "tan(";
						}
						if (string.charAt(i) == '-') {
							operator = "0-";
						}
					}

				}
			}
		}
	}

	boolean singleNumberOperations(int i) {
		//if ((operator != "+") &&(operator != "*") && (operator != "/") && (operator != "%")  && (operator != "^")) {
		if (string.indexOf("sin(") == i) {
			operator = "sin";
			return true;
		} // end if sin
		if (string.indexOf("cos(") == i) {
			operator = "cos";
			return true;
		} // end if cos
		if (string.indexOf("tan(") == i) {
			operator = "tan";
			return true;
		} // end if tan
		if ((string.charAt(0) == '(') && (string.charAt(string.length() - 1) == ')')) {
			operator = "(";
			return true;
		} // end if parentheses
		if ((operator == "!" ) && (string.indexOf("!") == string.length() - 1)) {
			operator = "!";
			return true;
		}
		if ((string.indexOf("-") == i) && (i == 0)) {
			operator = "-";
			return true;
		}
		return false;
	}

	void beforeSplits(int splits) {
		before = "";
		if (splits != string.length()) {
			// int length = string.length();
			for (int j = 0; j < splitsLocatie; j++) {
				before = before + string.charAt(j);
			}
			if (singleNumberOperations(splits)) {
				splitsLocatie = splits + operator.length() - 1;
			}
		}
	}

	void afterSplits(int splits) {
		after = "";
		if (operator == "mod") {
			splitsLocatie +=2;
		}
		if (operator == "(") {
			for (int i = 1; i < string.length() - 1; i++) {
				after = after + string.charAt(i);
			}
		} else {
			int parentheses = 0;
			// int length = string.length();
			if (operator == "!") {
				for (int i = 0; i < string.length() - 1; i++) {
					after = after + string.charAt(i);
				}
			} else {
				for (int i = splitsLocatie + 1; i < string.length(); i++) {
					if ((operator.equals("sin(")) & (string.charAt(i) == ')') && (parentheses == 0)) {
						i++;
					} else {

						after = after + string.charAt(i);
						if (string.charAt(i) == '(') {
							parentheses++;
						}
						if (string.charAt(i) == ')') {
							parentheses--;
						}
					}
				}
			}
		}
	}

} // end class Node