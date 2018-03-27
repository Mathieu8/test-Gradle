package src.calculator5;

import src.calculator5.Help.About;
import src.calculator5.Help.Help;

public class HelpServer {

	src.calculator5.Help.Help help = new Help();
	src.calculator5.Help.About about = new About();

	public void runHelp(String[] args) {
		help.runHelp(args);
	}
	
	public void runAbout(String[] args) {
		about.runAbout(args);
	}
}
