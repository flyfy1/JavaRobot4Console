package robot4Java.command;

import java.awt.Robot;
import java.io.IOException;
import java.io.Writer;

public interface Command {
	void exec(Robot robot, Writer out) throws IOException;
}
