package src.memory;

import java.io.*;

public class Save {
	String saveString="";
	String LocationFile = "C:\\Users\\mathi\\eclipse-workspace\\test Gradle\\src\\main\\java\\src\\memory\\save.txt";
	int i=0;
	char c;
	FileOutputStream fout = null;

	public void save(String temp) {
		saveString = temp;
		// Copy a File.
		try {
			// Attempt to open the files.
			fout = new FileOutputStream(LocationFile);//, true );
			do {
				 c = saveString.charAt(i);
				i++;
				if (c != -1)
					fout.write(c);
			} while (i<saveString.length());
			fout.write(',');
		} catch (IOException exc) {
			System.out.println("I/O Error: " + exc);
		} finally {
			try {
				if (fout != null)
					fout.close();
			} catch (IOException exc) {
				System.out.println("Error Closing Output File");
			}
		}
		i=0;
		saveString="";
	}
}