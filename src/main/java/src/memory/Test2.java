package src.memory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {
	Connection connection = new Connection();

	public void test() throws IOException {

		while (true) {
			System.out.println("type \"save\", \"load\", \"show\", \"up\" or \"down\": ");
			String string = getString();
			saveOrRead(string);
		}
	}
	
	public void saveOrRead(String s) throws IOException {
		switch (s) {
		case "save":
			save();
			break;
		case "test":
			read();
			break;
		case "load":
			read();
			break;
		case "up":
			up();
			break;
		case "down":
			down();
			break;
		case "show":
			show();
			break;
		case "add":
			//add():
			break;
		default:
			break;

		}
	}

	public void save() throws IOException {
		System.out.println("write here what to save");
		String string = getString();
		System.out.println("saving " + string + " on position: " + connection.writePosition );

		connection.save(string);

	}

	public void read() {
		//Connection test = new Connection();
		connection.read();
		String temp[] = connection.history;
		
		System.out.println( temp[1]);
		for(int i =0; i < temp.length;i++) {
		System.out.println("temp[" + i + "]: " + temp[i]);
		
		}

	}

	public String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	public void show(){
		String temp = connection.readPosition();
		System.out.println("on position " + connection.readPosition + " is "+ temp);
	}
	
	public void up() {
		connection.increseReadPosition();
		System.out.println("increasing position to " + connection.readPosition);
	}
	
	public void down() {
		connection.decreasePosition();
		System.out.println("decreasing position to " + connection.readPosition);
	}
}
