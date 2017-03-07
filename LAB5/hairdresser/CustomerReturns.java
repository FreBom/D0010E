package hairdresser;

import generalSimulator.EventStore;
import generalSimulator.Simulator;
import generalSimulator.State;
import generalSimulator.Event;

public class CustomerReturns extends Event {
	
	// Simulator.getSimTime() + this.state.getReturnTime();
	private Customer customer;
	private HairdressState HSState;
	private FIFO store;
	
	
	public CustomerReturns(Customer customer, double time, FIFO store){
		this.customer = customer;
		this.time = time;
		this.store = store;
		
	}
	
	public void execute(State state) {
		
		HSState = (HairdressState) state;
		HairdressState.eventName = "Return";
		
		if (store.idle() > 0) {
			store.addCustomer(customer);
			store.add(new CustomerLeaves(customer, Simulator.getSimTime() + HSState.getCutTime(), store));

		} else {
			store.addOld(customer);
		} 
		
	}

}
