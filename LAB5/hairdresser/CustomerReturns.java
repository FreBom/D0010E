package hairdresser;

import generalSimulator.EventStore;
import generalSimulator.State;

public class CustomerReturns {
	HairdressState state;
	EventStore store;
	double time;
	
	public CustomerReturns(State state, EventStore store, Customer customer){
		this.state = (HairdressState) state;
		this.store = store;
		time = this.state.newEventTime();
	}

}
