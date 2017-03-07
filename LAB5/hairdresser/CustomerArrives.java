package hairdresser;

import generalSimulator.Event;
import generalSimulator.State;
import generalSimulator.EventStore;
import generalSimulator.Simulator;
import hairdresser.FIFO;

public class CustomerArrives extends Event {
	// Simulator.getSimTime() + this.state.timeToArrival();
	private Customer customer;
	private HairdressState HSState;
	private FIFO store; //bytte från EventStore
	
	/**
	 * this method creates a new customer and sets the general simulators time
	 *  
	 */
	public CustomerArrives(double time, FIFO store) {//Byttefrån EventStore
		this.customer = NewCustomer.create();
		this.time = time;
		this.store = store;

	}

	public void execute(State state) {
		HSState = (HairdressState) state;
		HairdressState.eventName = "Arrived";
		
		
		if (!state.getEmergencyBreak()) {

			if (store.idle() > 0) {//FIFO
				store.addCustomer(customer);
				store.add(new CustomerLeaves(customer, Simulator.getSimTime() + HSState.getCutTime(), store));//FIFO

			} else {
				store.addNew(customer);
			} 
			store.add(new CustomerArrives(Simulator.getSimTime() + HSState.timeToArrival(), store));//FIFO
		}

	}

}
