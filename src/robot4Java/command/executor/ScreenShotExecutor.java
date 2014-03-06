package robot4Java.command.executor;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Writer;

import javax.imageio.ImageIO;

import robot4Java.command.Command;

public class ScreenShotExecutor implements Command {

	private String savePath;
	private Rectangle rect;
	
	private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static final Rectangle wholeScreen = new Rectangle(screenSize); 
	

	public ScreenShotExecutor(String savePath) {
		this.savePath = savePath;
		this.rect = wholeScreen;
	}

	public ScreenShotExecutor(String savePath, int recLocs[]) {
		this.savePath = savePath;
		rect = new Rectangle(recLocs[0],recLocs[1],recLocs[2],recLocs[3]);
	}

	@Override
	public void exec(Robot robot, Writer out) throws IOException {
		File f = new File(savePath);
		String extension = savePath.substring(savePath.lastIndexOf('.') + 1);
		
		if(!f.isAbsolute()){
			out.write("Err - the file path must be absolute.");
			return;
		}
		
		BufferedImage img = robot.createScreenCapture(rect);
		if(ImageIO.write(img, extension, f)){
			out.write("Done - file wrote to :" + savePath);
		} else{
			out.write("Err - error when saving file to path: " + savePath);
		}
		
	}
}
