package src.memory;

public class Connection {
	String newSum;
	int maxPosition = 5; // TODO add a slider to increase the max of the history
	String[] rawHistory = new String[60];
	String[] history = new String[50];
	int readPosition;
	int writePosition;
	String returnString;
	public Save saveFile = new Save();
	Read readfile = new Read();

	public void setMaxPosition(int temp) {
		System.out.println("in Connection, max position is " + temp);
		maxPosition = temp;

		String tempString = "0"; // Integer.toString(writePosition);
		tempString = tempString + "," + maxPosition;
		int j = 0;
		for (int i = 0; j < maxPosition; j++, i++) {
			if (i == maxPosition) {
				i = 0;
			}
			tempString = tempString + "," + history[i];
			System.out.println("tempString " + tempString + " j " + j);
		}
		saveFile.save(tempString);

	}

	public int returnMaxPosition() {
		System.out.println("returning Connection, max position is " + maxPosition);
		return maxPosition;
	}

	public String[] returnHistory() {
		return history;
	}

	// method 1
	public void read() {
		rawHistory = readfile.readArray();
		readPosition = Integer.parseInt(rawHistory[0]);
		maxPosition = Integer.parseInt(rawHistory[1]);
		writePosition = readPosition;
		increseWritePosition();
		for (int i = 0; i < maxPosition; i++) {
			// System.out.println("read " + i);
			if (rawHistory[i + 2] == null) {
				history[i] = null;
			} else if (rawHistory[i + 2] == "") {
				history[i] = null;
			} else {
				history[i] = rawHistory[i + 2];
			}
		}
	}

	// method 2
	public void save(String tempInput) {
		read();
		history[writePosition] = tempInput;

		String temp = "0"; // Integer.toString(writePosition);
		temp = temp + "," + maxPosition;
		int j = 0;
		for (int i = writePosition; j < maxPosition; j++, i++) {
			if (i == maxPosition) {
				i = 0;
			}
			if (history[i] == null) {
				temp = temp + ",";
			} else {
				temp = temp + "," + history[i];
			}
		}
		System.out.println("to save : " + temp);
		saveFile.save(temp);

	}

	// method 3
	public String readPosition() {
		return history[readPosition];
	}

	// method 4
	public void increseReadPosition() {
		int temp = readPosition;
		temp = (temp + 1) % maxPosition;
		// System.out.println("readPosition: " + readPosition + " temp: " + temp + "
		// writePosition: " + writePosition);
		if (!(temp == writePosition - 1)) {
			readPosition = temp;
		}
	}

	public void decreasePosition() {
		int temp = readPosition - 1;
		// System.out.println("readPosition: " + readPosition + " temp: " + temp + "
		// writePosition: " + writePosition);
		if (temp < 0) {
			temp = maxPosition;
		}
		// System.out.println("readPosition: " + readPosition + " temp: " + temp + "
		// writePosition: " + writePosition);
		if (!((temp + 1) == writePosition)) {
			readPosition = temp;
		}

	}

	// method 5
	public void increseWritePosition() {
		int temp = writePosition - 1;
		// System.out.println("writePosition: " + writePosition + " temp: " + temp + "
		// writePosition: " + writePosition);
		if (temp < 0) {
			temp = maxPosition - 1;
		}
		/*
		 * System.out.println("readPosition: "+ readPosition + " temp: " + temp +
		 * " writePosition: " + writePosition ); if (!((temp+1) == writePosition)) {
		 * writePosition = temp; }
		 */
		writePosition = temp;

		// writePosition = (writePosition + 1) % maxPosition;
	}

}