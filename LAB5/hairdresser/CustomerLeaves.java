package hairdresser;


import generalSimulator.Event;
import generalSimulator.EventStore;
import generalSimulator.Simulator;
import generalSimulator.State;
import hairdresser.CustomerDissatisfied;

public class CustomerLeaves extends Event{
	
	private Customer customer;
	private HairdressState state;
	
	public CustomerLeaves(Customer customer){  
		this.customer = customer;
		time = Simulator.getSimTime() + this.state.getCutTime();
		
		
	}
	
	public void execute(State state, Customer customer, EventStore store) {
		HairdressState.eventName = "Return";
		
		if(CustomerDissatisfied.getDissatisfied()){
			
			store.add(new CustomerReturns(customer));
		}
		FIFO.addGetHaircut(customer);  
		
		
	}
}