package hairdresser;

import generalSimulator.Event;
import generalSimulator.EventStore;
import generalSimulator.State;

public class StopHSS  extends Event {
	
	HairdressState HSState;
	
	public StopHSS(double time, EventStore store) {
		
		super(time, store);
		
		
	}
	
	public void execute(State state) {
		
		
		HSState = (HairdressState) state;
		HSState.setEventName(toString());
		HSState.setTime(time);		
		state.setEmergencyBreak(true);
		HSState.update();
		
		
	}
	
	
	
}
