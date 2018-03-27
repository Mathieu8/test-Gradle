package src.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	public static void main(String[] args) throws IOException {
		/*Number number = new Number();
		number.string = "1234.56789";
		number.stringToNumber();
		System.out.println(number.number);*/
		
		System.out.print("insert: ");
		String a = getString();
		Tree theTree = new Tree();
		theTree.createTree(a, 0);
		
		System.out.println();
		/*String a = "sin(7)";
		
		// for some reason split doesn't handle 3^5*7 not well, need to check it
		String a1 = "(1+3)";
		Tree theTree1 = new Tree();
		theTree1.createTree(a1, 0);
		System.out.println();

		String a2 = "1+3^5*7";
		Tree theTree2 = new Tree();
		theTree2.createTree(a2, 0);
		System.out.println();

		String a3 = "1*3+5^7";
		Tree theTree3 = new Tree();
		theTree3.createTree(a3, 0);
		System.out.println();

		String a4 = "1*3^5+7";
		Tree theTree4 = new Tree();
		theTree4.createTree(a4, 0);
		System.out.println();

		String a5 = "1^3*5+7";
		Tree theTree5 = new Tree();
		theTree5.createTree(a5, 0);
		System.out.println();

		String a6 = "1^3+5*7";
		Tree theTree6 = new Tree();
		theTree6.createTree(a6, 0);
		*/
		
		//test
	}
	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
}
