package hairdresser;


import generalSimulator.Event;
import generalSimulator.EventStore;
import generalSimulator.Simulator;
import generalSimulator.State;
import hairdresser.CustomerDissatisfied;

public class CustomerLeaves extends Event{
	// Simulator.getSimTime() + this.state.getCutTime();
	private Customer customer;
	private HairdressState HSState;
	private FIFO store; //Bytte fr�n EVentstore till FIFO
	
	public CustomerLeaves(Customer customer, double time, FIFO store){  //Bytte fr�n EVentstore till FIFO
		this.customer = customer;
		this.time = time;
		this.store = store;
		
		
	}
	
	public void execute(State state) {
		HSState = (HairdressState) state;
		HairdressState.eventName = "Return";
		
		if(CustomerDissatisfied.getDissatisfied()){
			
			store.add(new CustomerReturns(customer, Simulator.getSimTime() + HSState.getReturnTime(), store));//FIFO
		}
		store.addGetHaircut(customer, HSState, store);  //FIFO
		
		
	}
}