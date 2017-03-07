package hairdresser;

import generalSimulator.EventStore;
import generalSimulator.Simulator;
import generalSimulator.State;
import generalSimulator.Event;

public class CustomerReturns extends Event {
	
	
	private Customer customer;
	private HairdressState state;
	
	
	
	public CustomerReturns(Customer customer){
		this.customer = customer;
		time =  Simulator.getSimTime() + this.state.getReturnTime();
		
	}
	
	public void execute(State state, Customer customer, EventStore store) {
		
		HairdressState.eventName = "Return";
		
		if (FIFO.idle() > 0) {
			FIFO.addCustomer(customer);
			store.add(new CustomerLeaves(customer));

		} else {
			FIFO.addOld(customer);
		} 
		
	}

}
