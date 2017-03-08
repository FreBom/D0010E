package hairdresser;


import generalSimulator.State;
import generalSimulator.Event;
import generalSimulator.EventStore;

public class Return extends Event {
	
	private Customer customer;
	private double tempCutTime;
	HairdressState HSState;

	
	public Return(Customer customer, double time, EventStore store){
		super(time, store);
		this.customer = customer;
	}
	
	public void execute(State state) {
		
		HSState = (HairdressState) state;
		HSState.setEventName(toString());
		HSState.customerID = customer.getID(customer);
		
		
		updateWaitTime(HSState);
		updateIdleTime(HSState);	
		HSState.setTime(time);
		HSState.update();
		
		if(customer.getHasReturn() == false) {
			HSState.setReturnCustomer();
			customer.getHasReturn();
		}
		
		if (HSState.getFIFO().idle() > 0) {
			HSState.getFIFO().addCustomer(customer);
			tempCutTime = HSState.getCutTime();
			store.add(new Done(customer, time + tempCutTime, store));
			HSState.setAverageCutTime(tempCutTime);
		
		
		} else {
			HSState.getFIFO().addOld(customer);
		} 
		
	}
	
	public void updateWaitTime(HairdressState HSState) {
		HSState.addWaitingTime((HSState.getFIFO().numWaiting()) * (time - HSState.getTime()));
	
	}
	
	public void updateIdleTime(HairdressState HSState) {
		HSState.addIdleTime((HSState.getFIFO().idle()) * (time - HSState.getTime()));
		
		
	}


}
