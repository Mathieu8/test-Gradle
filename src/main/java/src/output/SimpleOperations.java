package src.output;

public strictfp class SimpleOperations {
	static Calculation cl;

	static double plus(double leftChild, double rightChild) {
		double sum = leftChild + rightChild;
		return sum;
	}

	static double minus(double leftChild, double rightChild) {
		double sup = leftChild - rightChild;
		return sup;
	}

	static double multiplcation(double leftChild, double rightChild) {
		double mul = leftChild * rightChild;
		return mul;
	}

	static double division(double leftChild, double rightChild) {
		double div = leftChild / rightChild;
		if (rightChild == 0) {
			cl.error.DivedeByZerroError();
		}

		return div;

	}

	static double modulus(double leftChild, double rightChild) {
		double mod = leftChild % rightChild;
		if (rightChild == 0) {
			cl.error.DivedeByZerroError();
		}
		return mod;
	}

	static double power(double leftChild, double rightChild) {
		if ((rightChild != 0) && (leftChild != 0)) {
			double pow = 1;
			for (double i = rightChild; rightChild > 0; rightChild--) {
				pow *= leftChild;
				return pow;
			}
		}
		if (rightChild == 0) {
			return 1;
		}
		if (leftChild == 0) {
			return 0;
		}
		if ((rightChild == 0) && (leftChild == 0)) {

		}
		return 0;
	}

	static double parentheses(double rightChild) {
		return rightChild;
	}

	static double factorial(double rightChild) {
		double fact = 1;
		for (double i = rightChild; rightChild > 0; rightChild--) {
			fact *= rightChild;
		}
		return fact;
	}

}
