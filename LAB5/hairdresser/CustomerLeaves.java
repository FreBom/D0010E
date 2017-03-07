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
	private EventStore store; //Bytte från EVentstore till FIFO
	private FIFO fifo;
	
	public CustomerLeaves(Customer customer, double time, EventStore store, FIFO fifo){  //Bytte från EVentstore till FIFO
		this.customer = customer;
		this.time = time;
		this.store = store;
		this.fifo = fifo;
		
		
	}
	
	public void execute(State state, Simulator sim) {
		HSState = (HairdressState) state;
		HairdressState.eventName = "Return";
		
		if(CustomerDissatisfied.getDissatisfied()){
			
			store.add(new CustomerReturns(customer, sim.getSimTime() + HSState.getReturnTime(), store, fifo));//FIFO
		}
		fifo.addGetHaircut(customer, HSState, store, sim);  //FIFO
		
		
	}
}