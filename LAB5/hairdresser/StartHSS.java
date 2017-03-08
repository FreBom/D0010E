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
		HSState.setEventName("StartHSS");
		HSState.setTime(time);
	
		store.add(new CustomerArrives(time + HSState.timeToArrival(), store));
		HSState.update();
		
	}
	
	
	
}
