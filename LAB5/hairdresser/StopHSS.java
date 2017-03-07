package hairdresser;

import generalSimulator.EventStore;
import generalSimulator.StartEvent;
import generalSimulator.State;
import generalSimulator.StopEvent;

public class StopHSS  extends StartEvent {
	
	public StopHSS() {
		time = HairdressState.getSimStopTime();
		// TODO Auto-generated constructor stub
	}
	
	public void execute(State state) {
		
	}
	
	
	
	
}
