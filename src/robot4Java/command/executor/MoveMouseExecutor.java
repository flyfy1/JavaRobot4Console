package robot4Java.command.executor;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.io.Writer;

import robot4Java.command.Command;
import robot4Java.command.UnknownCommandException;

enum MouseClickType{
	noClick, leftClick, rightClick;
	
	public static MouseClickType getMouseClick(String clickParams) throws UnknownCommandException{
		if(clickParams == null) return noClick;
		else if(clickParams.equals("-l"))	return leftClick;
		else if(clickParams.equals("-r"))	return rightClick;
		else throw new UnknownCommandException();
	}
}

public class MoveMouseExecutor implements Command {

	private int x;
	private int y;
	private MouseClickType clickType;

	public MoveMouseExecutor(int x, int y, String clickTypeParam) throws UnknownCommandException {
		this.x = x;
		this.y = y;
		
		clickType = MouseClickType.getMouseClick(clickTypeParam);
	}

	@Override
	public void exec(Robot robot, Writer out) throws IOException {
		robot.mouseMove(x, y);
		
		switch(clickType){
		case leftClick: robot.mousePress(InputEvent.BUTTON1_MASK);
		case rightClick: robot.mousePress(InputEvent.BUTTON2_MASK);
		}
	}
}
