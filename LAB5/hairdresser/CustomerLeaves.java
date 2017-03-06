package hairdresser;


import generalSimulator.Event;
import generalSimulator.EventStore;
import generalSimulator.State;
import hairdresserState.Customer;
import hairdresser.CustomerDissatisfied;

public class CustomerLeaves extends Event{
	
	HairdressState state;
	EventStore store;
	double time;
	
	public CustomerLeaves(State state, EventStore store, Customer readyCustomer){  
		this.state = (HairdressState) state;
		this.store = store;
		time = this.state.newEventTime();
		
		
	}
	
	public void execute(State state, EventStore store, Customer readyCustomer) {
		boolean diss = CustomerDissatisfied.getDissatisfied();
		if(diss){
			store.add(CustomerReturns.CustomerReturns())
		}
		FIFO.addGetHaircut(readyCustomer);  
		
		
	}
}