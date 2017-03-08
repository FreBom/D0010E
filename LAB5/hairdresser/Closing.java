package hairdresser;


import generalSimulator.State;
import generalSimulator.Event;
import generalSimulator.EventStore;

public class Closing extends Event{

	HairdressState HSState;
	
	public Closing(double time, EventStore store) {
		
		super(time, store);
		
		
		
		
	}
	public void execute(State state) {
	
		HSState = (HairdressState) state;
		HSState.setEventName(toString());
		HSState.setTime(time);
		
		HSState.update();
		
		HSState.setClosed(true);
		store.add(new StopHSS(999.0, store));
		
		
	}
	
	
	
	
	
}
