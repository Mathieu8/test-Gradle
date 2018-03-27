package src.input;

public class Number {
	String string;
	double number;
	int dot = 0;

	void stringToNumber() {
		double a = 0;
		int i = 0;
		int order = -1;
		boolean smallNumbers = false;
		while (stillANumber(string.charAt(i)) == true) {
			if (smallNumbers == true) {
				if (string.charAt(i) == '.') {
					break;
				}
				a = a + charToNumber(string.charAt(i)) * Math.pow(10, order);
				order--;

			}
			if (string.charAt(i) == '.') {
				dot = +1;
				smallNumbers = true;
				if (dot == 2)
					break;
			}
			if (smallNumbers == false) {
				a = a * 10 + charToNumber(string.charAt(i));
			}
			i++;
			if (i == string.length()) {
				break;
			}
		}
		number = a;
	}

	boolean stillANumber(char a) { // checks if the char is still within the
									// same number
		if ((a < '9' + 1) & (a > '0' - 1)) {
			return true;
		} else if (a == '.') {
			return true;
		} else
			return false;
	}

	int charToNumber(char a) {
		/*
		 * returns a int from a char, it should not return 42. As a should pass the
		 * stillANumber() method and the '.' should be all ready accounted for.
		 */
		switch (a) {
		case '0': {
			return 0;
		}
		case '1': {
			return 1;
		}
		case '2': {
			return 2;
		}
		case '3': {
			return 3;
		}
		case '4': {
			return 4;
		}
		case '5': {
			return 5;
		}
		case '6': {
			return 6;
		}
		case '7': {
			return 7;
		}
		case '8': {
			return 8;
		}
		case '9': {
			return 9;
		}
		}
		return 42;
	}
}
