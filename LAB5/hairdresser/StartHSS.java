package hairdresser;
import generalSimulator.Event;
import generalSimulator.EventStore;
import generalSimulator.Simulator;
import generalSimulator.State;

public class StartHSS extends Event {

	EventStore store;
	HairdressState HSState;
	FIFO fifo;
	
	public StartHSS(double time, EventStore store, FIFO fifo) {
		this.time = time;
		this.store = store;
		this.fifo = fifo;
		
	}
	
	public void execute(State state, Simulator sim) {
		HSState = (HairdressState) state;
		HairdressState.eventName = "StartHSS";
		store.add(new CustomerArrives(sim.getSimTime() + HSState.timeToArrival(), store, fifo));
	}
	
	
	
}
