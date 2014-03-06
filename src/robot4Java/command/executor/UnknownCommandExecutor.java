package robot4Java.command.executor;

import java.awt.Robot;
import java.io.IOException;
import java.io.Writer;

import robot4Java.command.Command;

public class UnknownCommandExecutor implements Command {
	private static String helpMessage = 
		  "Commands:\n"
		+ "screen_shot [save_path] [x y w h]: \n"
		+ "\tTake screen schot, in the rectangle (x y w h), and save"
		+ " to the save_path\n"
		+ "\tIf the coordinates are not given, the screenshot of the "
		+ "whole screen is taken\n\n"
		+ "move_mouse [x y] [-l|-r]:\n"
		+ "\tMove mouse to the (x,y) point; if -l is issued, perform left click; "
		+ "if -r is issued, perform right click\n\n"
		+ "get_screen_specs: get the screen specs, (width, height) pair";
	@Override
	public void exec(Robot robot, Writer out) throws IOException {
		out.write(helpMessage);
	}
}
