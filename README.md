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
