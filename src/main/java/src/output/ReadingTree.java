package src.output;

//import input.Tree;
import src.input.Node;
import java.util.InputMismatchException;

public class ReadingTree {

	static double readingTree(Node localRoot) {
		double c = 0;
		System.out.println(localRoot.iData);
		// while (!Error.error) {
		if (localRoot != null) {
			double a, b;

			if (!localRoot.numberOrOperator) {
				return localRoot.iData;
			} // checks if this node is an operator or not.
			else {
				if (singleNumberOperation(localRoot)) {
					a = readingTree(localRoot.rightChild);
					if (localRoot.operator == "sin") {
						c = Sinus.Sine(a);
					} // end if sine
					if (localRoot.operator == "cos") {
						c = Sinus.cosine(a);
					} // end if cos
					if (localRoot.operator == "tan") {
						c = Sinus.tangent(a);
					} // end if tan
					if (localRoot.operator == "!") {
						c = SimpleOperations.factorial(a);
					} // end if factorial

					if (localRoot.operator == "(") {
						c = SimpleOperations.parentheses(a);
					} // end if parentheses

					if (localRoot.operator == "0-") {
						c = SimpleOperations.minus(0, a);
					} // end if minus
				} // end if singleNumberOperation is true
				else {
					a = readingTree(localRoot.leftChild);
					b = readingTree(localRoot.rightChild);

					if (localRoot.operator == "+") {
						c = SimpleOperations.plus(a, b);
					} // end if plus

					if (localRoot.operator == "-") {
						c = SimpleOperations.minus(a, b);
					} // end if minus

					if (localRoot.operator == "*") {
						c = SimpleOperations.multiplcation(a, b);
					} // end if multiplication

					if (localRoot.operator == "/") {
							c = SimpleOperations.division(a, b);
					} // end if division

					if (localRoot.operator == "mod") {

						c = SimpleOperations.modulus(a, b);
						// end else if devider != 0
					} // end if division

					if (localRoot.operator == "^") {
						c = SimpleOperations.power(a, b);
					} // end if power

				} // closing else singleNumberOperation is true
				localRoot.iData = c;
				// System.out.print(localRoot.iData + " ");
			} // end else
		} // end if localRoot!=null
			// }

		System.out.println(c);
		return c;

	} // closing readingTree

	static boolean singleNumberOperation(Node localRoot) {
		if (localRoot.operator.equals("sin")) {
			return true;
		} // end if sin
		if (localRoot.operator.equals("cos")) {
			return true;
		} // end if cos
		if (localRoot.operator.equals("tan")) {
			return true;
		} // end if tan
		if (localRoot.operator.equals("!")) {
			return true;
		} // end if factorial
		if (localRoot.operator.equals("(")) {
			return true;
		} // end if parentheses
		if (localRoot.operator.equals("0-")) {
			return true;
		} // end if negative numbers
		return false;
	} // end singleNumberOperation()

}
