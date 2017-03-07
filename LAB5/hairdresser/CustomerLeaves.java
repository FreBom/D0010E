package hairdresser;


import generalSimulator.Event;
import generalSimulator.EventStore;
import generalSimulator.Simulator;
import generalSimulator.State;
import hairdresser.CustomerDissatisfied;

public class CustomerLeaves extends Event{

	private Customer customer;
	HairdressState HSState;
	
	public CustomerLeaves(Customer customer, double time, EventStore store){  
		super(time, store);
		this.customer = customer;
		
	}
	
	public void execute(State state) {
		
		HSState = (HairdressState) state;
		HSState.eventName = "Done";
		HSState.setTime(time);
		
		if(CustomerDissatisfied.getDissatisfied()){
			
			store.add(new CustomerReturns(customer, time + HSState.getReturnTime(), store, fifo));
		}
		fifo.addGetHaircut(customer, HSState, store);  
		
		
	}
}