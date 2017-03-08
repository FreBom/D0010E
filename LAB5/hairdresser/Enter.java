package hairdresser;

import generalSimulator.Event;
import generalSimulator.State;
import generalSimulator.EventStore;
import generalSimulator.Simulator;
import hairdresser.FIFO;

public class Enter extends Event {

	private Customer customer;
	HairdressState HSState;

	/**
	 * this method creates a new customer and sets the general simulators time
	 *  
	 */
	public Enter(double time, EventStore store) {
		
		super(time, store);
		Customer customer = NewCustomer.create();
		this.customer = customer;
		
	}

	public void execute(State state) {
		
		HSState = (HairdressState) state;
		
		if (!HSState.getIsClosed()) {
			
			HSState.setEventName(toString());
			HSState.setTime(time);
			HSState.customerID = customer.getID(customer);
			
			if (HSState.getFIFO().idle() > 0) { 
				HSState.getFIFO().addCustomer(customer);
				store.add(new Done(customer, time + HSState.getCutTime(), store));

			} else {
				HSState.getFIFO().addNew(customer);
			} 
			store.add(new Enter(time + HSState.timeToArrival(), store));
		}
		HSState.update();
		

	}

}
