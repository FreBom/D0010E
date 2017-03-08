package hairdresser;


import generalSimulator.Event;
import generalSimulator.EventStore;
import generalSimulator.Simulator;
import generalSimulator.State;
import hairdresser.DissatisfiedGenerator;

public class CustomerLeaves extends Event{

	private Customer customer;
	HairdressState HSState;
	DissatisfiedGenerator isDissatisfied;
	
	public CustomerLeaves(Customer customer, double time, EventStore store){  
		super(time, store);
		this.customer = customer;
		
	}
	
	public void execute(State state) {
		
		HSState = (HairdressState) state;
		HSState.setEventName("Done");
		HSState.setTime(time);
		isDissatisfied = new DissatisfiedGenerator();
		
		if(isDissatisfied.getDissatisfied()){
			
			store.add(new CustomerReturns(customer, time + HSState.getReturnTime(), store));
			HSState.setCustomerReturns(HSState.getCustomerReturns() + 1);
		}
		HSState.getFIFO().addGetHaircut(customer, HSState, store, this);  
		HSState.setTotalCut(HSState.getTotalCut() + 1);
		
	}
}