package robot4Java.command;

public class CommandParser {

	public static Command getCommand(String msg) {
		
		return new UnknownCommand();
	}

}
