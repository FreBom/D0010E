package hairdresser;

import generalSimulator.Event;
import generalSimulator.State;
import generalSimulator.EventStore;

public class CustomerArrives extends Event {
	
	
	HairdressState state;
	EventStore store;
	
	double time;
	
	
	public CustomerArrives(State state, EventStore store) {
		this.state = (HairdressState) state;
		this.store = store;
		time = this.state.newEventTime();
		
		
	}
	
	
	public void execute(State state, EventStore store) {
		
		customerEnters();
		store.add(new CustomerArrives(state, store));
		
		
		
	}


	
	public String customerEnters() {
		return "Enter";
	}
	
	

}
