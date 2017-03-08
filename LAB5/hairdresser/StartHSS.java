package hairdresser;
import generalSimulator.Event;
import generalSimulator.EventStore;
import generalSimulator.Simulator;
import generalSimulator.State;

public class StartHSS extends Event {

	HairdressState HSState;
	
	
	public StartHSS(double time, EventStore store) {
		super(time, store);
		
		
	}
	
	public void execute(State state) {
		
		HSState = (HairdressState) state;
		HSState.setEventName(toString());
		HSState.setTime(time);
		store.add(new Enter(time + HSState.timeToArrival(), store));
	    store.add(new Closing(8.00, store));
	    
	    HSState.update();
		
		
	}
	
	
	
}
