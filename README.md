JavaRobot4Console
=================

A wrapper to control mouse/keyboard from console. Using java so that it's cross
platform.

After it runs, it listens to the predefined local port for new commands; the
default port number is 9000. Programs who want to use this wrapper needs to
connect to this port number.

Note about the following:
- Because it's controller the mouse, only one connection is allowed at one time
- Only local connection is accetped due to security reasons.

Commands:

    screen_shot [file_path] ([sx] [sy] [ex] [ey]):
      take screenshot of rectangle [(sx,sy),(ex,ey)], and save the image to the
      [file_path] given. If [(sx,sy),(ex,ey)] is not given, then the screenshot
      of the whole screen would be taken.

    move_mouse [x] [y] [-l]:
      move mouse to the (x, y) location. If the [-l] is given, then a left-click
      would be performed.

