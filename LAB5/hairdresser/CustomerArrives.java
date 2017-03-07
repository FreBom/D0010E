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
	private EventStore store; //bytte från EventStore
	private FIFO fifo;
	
	/**
	 * this method creates a new customer and sets the general simulators time
	 *  
	 */
	public CustomerArrives(double time, EventStore store, FIFO fifo) {//Byttefrån EventStore
		this.customer = NewCustomer.create();
		this.time = time;
		this.store = store;
		this.fifo = fifo;

	}

	public void execute(State state, Simulator sim) {
		HSState = (HairdressState) state;
		HairdressState.eventName = "Arrived";
		
		
		if (!state.getEmergencyBreak()) {

			if (fifo.idle() > 0) { 
				fifo.addCustomer(customer);
				store.add(new CustomerLeaves(customer, sim.getSimTime() + HSState.getCutTime(), store, fifo));//FIFO

			} else {
				fifo.addNew(customer);
			} 
			store.add(new CustomerArrives(sim.getSimTime() + HSState.timeToArrival(), store, fifo));//FIFO
		}

	}

}
