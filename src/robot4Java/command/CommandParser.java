package robot4Java.command;

import java.util.Arrays;

import robot4Java.command.executor.GetScreenSpecsExecutor;
import robot4Java.command.executor.MoveMouseExecutor;
import robot4Java.command.executor.ScreenShotExecutor;
import robot4Java.command.executor.UnknownCommandExecutor;

public class CommandParser {

	public static Command getCommand(String msg) throws UnknownCommandException{
		String args[] = msg.split(" ");
		String cmd = args[0];
		
		if(cmd.equals("move_mouse")){
			int x,y;
			String mouseClickedType = args.length >= 4 ? args[3] : null;
			try{
				x = Integer.parseInt(args[1]);
				y = Integer.parseInt(args[2]);
			} catch(NumberFormatException e){
				throw new UnknownCommandException();
			}
			
			return new MoveMouseExecutor(x,y, mouseClickedType);
		} else if(cmd.equals("screen_shot")){
			if(args.length == 2) return new ScreenShotExecutor(args[1]);
			else if(args.length == 6){
				int locs[] = new int[4];
				for(int i = 0 ; i < 4; i++){
					locs[i] = Integer.parseInt(args[2+i]);
				}
				return new ScreenShotExecutor(args[1],locs);
			} else throw new UnknownCommandException();
		} else if(cmd.equals("get_screen_specs")){
			return new GetScreenSpecsExecutor();
		} else{
			throw new UnknownCommandException();
		}
	}
}
