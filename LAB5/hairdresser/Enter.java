package hairdresser;

import generalSimulator.Event;
import generalSimulator.State;
import generalSimulator.EventStore;
import generalSimulator.Simulator;
import hairdresser.FIFO;

public class Enter extends Event {

	private Customer customer;
	private double tempCutTime;
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
			HSState.customerID = customer.getID(customer);
			
			
			updateWaitTime(HSState);
			updateIdleTime(HSState);
			HSState.setTime(time);
			HSState.update();
	
			
			if (HSState.getFIFO().idle() > 0) { 
				HSState.getFIFO().addCustomer(customer);
				tempCutTime = HSState.getCutTime();
				store.add(new Done(customer, time + tempCutTime, store));
				HSState.setAverageCutTime(tempCutTime);
			} else {
				HSState.getFIFO().addNew(customer);
			} 
			store.add(new Enter(time + HSState.timeToArrival(), store));
		}
		
		

	}
	public void updateWaitTime(HairdressState HSState) {
		HSState.addWaitingTime((HSState.getFIFO().numWaiting()) * (time - HSState.getTime()));
	
	}
	
	public void updateIdleTime(HairdressState HSState) {
		HSState.addIdleTime((HSState.getFIFO().idle()) * (time - HSState.getTime()));
		
		
	}

}
