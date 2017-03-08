package hairdresser;


import generalSimulator.State;
import generalSimulator.Event;
import generalSimulator.EventStore;

public class ClosingHSS extends Event{

	HairdressState HSState;
	
	public ClosingHSS(double time, EventStore store) {
		
		super(time, store);
		
		
		
		
	}
	public void execute(State state) {
	
		HSState = (HairdressState) state;
		HSState.setEventName("(Closing)");
		HSState.setTime(time);
		HSState.setClosed(true);
		
		
		store.add(new StopHSS(999.0, store));
		
		HSState.update();
	}
	
	
	
	
	
}
