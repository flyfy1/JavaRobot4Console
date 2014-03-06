package robot4Java.command.executor;

import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.Writer;
import java.text.DecimalFormat;

import robot4Java.command.Command;

public class GetScreenSpecsExecutor implements Command {
	private static DecimalFormat df = new DecimalFormat("# #");
	
	@Override
	public void exec(Robot robot, Writer out) throws IOException {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		out.write(df.format(width) + " " + df.format(height));
	}
}
