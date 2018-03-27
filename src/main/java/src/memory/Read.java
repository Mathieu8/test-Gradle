package src.memory;

import java.io.*;

public class Read {// 1
	int i;
	int maxPosition;
	FileInputStream fin = null;
	String LocationFile = "C:\\Users\\mathi\\eclipse-workspace\\test Gradle\\src\\main\\java\\src\\memory\\save.txt";
	String save[]= new String[50];

	public String readFile() {// 2
		String s = "";
		try {// 3
			fin = new FileInputStream(LocationFile);
			do {// 4
				i = fin.read();
				if (i != -1)
					s = s + ((char) i);
					//System.out.print((char) i);
			} while (i != -1);// 3
			//System.out.println();
		} catch (FileNotFoundException exc) {// 3
			System.out.println("File Not Found.");
		}

		catch (IOException exc) {// 2
			{// 3
				s = "0";
				for(int i =0; i < 50 ; i++) {
					s = s + ",";
				}
				System.out.println("An I/O Error Occurred");
			}
		} finally// 2
		{ // Close file in all cases. 3
			try { // 4
				if (fin != null)
					fin.close();
			} catch (IOException exc) { // 3 4
				System.out.println("Error Closing File");
			} // 3

		} // 2
		return s;
	}

	public String[] readArray() {
		String[] a = new String[52];
		String begin = readFile();
		int n = 0;
		String temp = "";
		for (int i = 0; i < begin.length(); i++) {
			if (begin.charAt(i) == ',') {
				a[n] = temp;
				n++;
				temp = "";
			} else {
				temp = temp + begin.charAt(i);
			}
		}
		return a;
	}
}