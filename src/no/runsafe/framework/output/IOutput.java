package no.runsafe.framework.output;

import java.util.logging.Level;

public interface IOutput {

	// Sends the supplied string to the console/log the output handler has
	public abstract void outputToConsole(String message);

	// Sends the supplied string with the supplied logging level to the console/log the output handler has
	public abstract void outputToConsole(String message, Level level);
	
	// Sends the supplied string to the console/log the output handler has if the debug level is high enough
	public abstract void outputDebugToConsole(String message, Level messageLevel);

	// Broadcasts the supplied string to all players on the event the output handler has
	public abstract void outputToServer(String message);

	// Gets the current debug output level
	public abstract Level getDebugLevel();
	
	// Sets the debug output level
	public abstract void setDebugLevel(Level level);
}