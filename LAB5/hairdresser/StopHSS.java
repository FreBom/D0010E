package hairdresser;

import generalSimulator.State;
import generalSimulator.StopEvent;

public class StopHSS  extends StopEvent {
	
	public StopHSS(double time) {
		
		
	}
	
	public void execute(State state) {
		
		// samla ihop tid
		activateEmergencyBreak(state);
	}
	
	
	
	
	
}
