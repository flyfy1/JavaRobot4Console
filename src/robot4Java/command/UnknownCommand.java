package robot4Java.command;

import java.awt.Robot;
import java.io.IOException;
import java.io.Writer;

public class UnknownCommand implements Command {
	private static String helpMessage = 
		  "Commands:\n"
		+ "screen_shot [start_x start_y end_x end_y] [save_path]: \n"
		+ "\tTake screen schot, in the rectangle (start_x start_y end_x end_y), and save"
		+ " to the save_path\n"
		+ "move_mouse [x y] [-l|-r]:\n"
		+ "\tMove mouse to the (x,y) point; if -l is issued, perform left click; "
		+ "if -r is issued, perform right click\n";
	@Override
	public void exec(Robot robot, Writer out) throws IOException {
		out.write(helpMessage);
		out.flush();
	}
}
