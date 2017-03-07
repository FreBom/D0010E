package hairdresser;
import generalSimulator.Event;
import generalSimulator.EventStore;
import generalSimulator.Simulator;
import generalSimulator.State;

public class StartHSS extends Event {

	EventStore store;
	HairdressState HSState;
	
	public StartHSS(double time, EventStore store) {
		this.time = time;
		this.store = store;
		
	}
	
	public void execute(State state) {
		HSState = (HairdressState) state;
		store.add(new CustomerArrives(Simulator.getSimTime() + HSState.timeToArrival(), store));
	}
	
	
	
}
