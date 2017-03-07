package hairdresser;

import generalSimulator.State;
import generalSimulator.StopEvent;

public class StopHSS  extends StopEvent {
	
	public StopHSS(double time) {
		// samla ihop tid
		
	}
	
	public void execute(State state) {
		activateEmergencyBreak(state);
		
	}
	
	
	
	
}
