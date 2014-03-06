package robot4Java;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.io.Writer;

import robot4Java.command.Command;
import robot4Java.command.CommandParser;
import robot4Java.command.UnknownCommandException;
import robot4Java.command.executor.UnknownCommandExecutor;

public class Main {
	private static final int DEFAULT_PORT_NUMBER = 9000;

	public static void main(String args[]) throws IOException, AWTException{
		final Robot robot = new Robot();
		
		int port_num = DEFAULT_PORT_NUMBER;
		try{
			if(args.length > 0){
				port_num = Integer.parseInt(args[0]);
			}
		} catch(NumberFormatException e){
			System.out.println("Using default port number: " + DEFAULT_PORT_NUMBER);
		}
		
		ServerService.LineListener messageHandler = new ServerService.LineListener() {
			@Override
			public void onMessage(String msg, Writer out) throws IOException {
				System.out.println("Got message: " + msg);
				Command cmd;
				try{
					cmd = CommandParser.getCommand(msg);
				} catch(UnknownCommandException e){
					cmd = new UnknownCommandExecutor();
				}
				
				cmd.exec(robot,out);
				out.write('\n');out.flush();
			}
		};
		
		ServerService server = new ServerService(messageHandler, port_num);
		server.serve();
	}
}
