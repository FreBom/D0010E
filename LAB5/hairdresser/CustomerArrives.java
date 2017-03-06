package hairdresser;

import generalSimulator.Event;
import generalSimulator.State;
import generalSimulator.EventStore;

public class CustomerArrives extends Event {
	
	
	HairdressState state;
	EventStore store;
	
	private double time;
	
	
	public CustomerArrives(State state, EventStore store, Customer customer) {
		this.state = (HairdressState) state;
		this.store = store;
		time = this.state.newEventTime();		
		
	}
	
	
	public void execute(State state, EventStore store, Customer customer) {
		hairdresser.FIFO.addNew(state , store, customer);
		customerEnters();
		
		
		
	}
	
	public String customerEnters() {
		return "Arrived";
	}
	
	

}
