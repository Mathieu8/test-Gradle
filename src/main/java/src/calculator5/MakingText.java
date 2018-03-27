package src.calculator5;

public class MakingText {
	boolean logical = true;
	String numbers = "1234567890.";
	String operators = "+-*/^!()abcdefghijklmnopqrstuvwxyz";
	String string = "";
	boolean empty = true;
	String Error;
	double answer;
	
	String getText() { return string;}

	void addChar(char c) {
		empty = false;
		string += c;
	}

	void addInt(int i) {
		empty = false;
		string += i;
	}

	void addString(String s) {
		string += s;
		if (string.equals("")) {
			empty = false;
		}
	}

	void newString(String s) {
		string = s;
	}

	void removeChar() {
		String temp = "";
		for (int i = 0; i < string.length(); i++) {
			temp += string.charAt(i);
		}
		string = temp;
	}

	void deleteString() {
		string = "";
	}

	boolean setClear() {
		return empty;
	}

	void readable() {
		String temp = "";

		if (temp.equals(string)) {
			empty = true;
		}

		int b = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == ' ') {
			} else if (string.charAt(i) == 'x')
				temp += '*';
			else if (string.charAt(i) == 'X')
				temp += '*';
			else if (string.charAt(i) == '(') {
				b += 1;
				temp += '(';
			} else if (string.charAt(i) == ')') {
				if (b <= 0) {
				} else {
					temp += ')';
					b -= 1;
				}
			} else if(string.charAt(i)== ',') {
				temp = temp + '.';
			}

			else
				temp += string.charAt(i);
		}
		if (b != 0) {
			b--;
			for (b++; b > 0; b--) {
				temp += ')';
				System.out.println(temp);
			}
		}
		string = temp;
	}

	void logical() {
		logical = true;
		readable();
		if (empty) {
			logicalGemo();
			logicalDot();
		}
	}

	void logicalGemo() {
		System.out.println("Logical Gemo");
		String temp = "";
		int l = string.length();
		for (int i = 0; i < l; i++) {
			if (i < l - 4) {
				// sin
				if ((aNumber(i)) && ((string.charAt(i + 1) == 's') && (string.charAt(i + 2) == 'i')
						&& (string.charAt(i + 3) == 'n'))) {
					temp = temp + string.charAt(i) + "*";
				} else if ((aNumber(i)) && ((string.charAt(i + 1) == 'c') && (string.charAt(i + 2) == 'o')
						&& (string.charAt(i + 3) == 's'))) {
					temp = temp + string.charAt(i) + "*";
				} else if ((aNumber(i)) && ((string.charAt(i + 1) == 't') && (string.charAt(i + 2) == 'a')
						&& (string.charAt(i + 3) == 'n'))) {
					temp = temp + string.charAt(i) + "*";
				} else
					temp += string.charAt(i);

			} else
				temp += string.charAt(i);

		}
		string = temp;
	}

	void logicalDot() {
		String temp = "";
		String temp1 = string;
		logical = true;
		boolean dot = false;
		for (int i = 0; i < temp1.length() - 1; i++) {
			
			if (!logical) {
				break;
			}
			if ((temp1.charAt(i) == '.')&(dot)) {
				
					logical = false;
					System.out.println("set logical in making text: " + logical);
				
			} else {
				if (temp1.charAt(i)=='.') {
					dot = true;
				}
				if (anOperator(i)) {
					dot = false;
				}
				if ((anOperator(i))&((anOperator(i+1)&!(temp1.charAt(i+1)=='-')))) {
					logical = false;
				}
				
				
				temp += temp1.charAt(i);
			}

			// }
		}

		temp += temp1.charAt(temp1.length() - 1);
		
		temp1 = temp;

		string = temp;

	}

	boolean anOperator(int i) {
		char ch = string.charAt(i);
		String CH = "" + ch;
		return operators.contains(CH);
	}

	boolean aNumber(int i) {
		char ch = string.charAt(i);
		String CH = "" + ch;
		return numbers.contains(CH);

	}
}