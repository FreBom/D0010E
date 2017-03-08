package hairdresser;


import generalSimulator.Event;
import generalSimulator.EventStore;
import generalSimulator.State;

public class Done extends Event{

	private Customer customer;
	HairdressState HSState;
	
	public Done(Customer customer, double time, EventStore store){  
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
		
		if(customer.getHasCut() == false){
			
			HSState.setCutCustomer();
			customer.setHasCut();
			
		}
				
		if(HSState.getDissatisfied()){
			
			store.add(new Return(customer, time + HSState.getReturnTime(), store));
		
		}
		HSState.getFIFO().addGetHaircut(customer, HSState, store);  
		
	}
	
	public void updateWaitTime(HairdressState HSState) {
		HSState.addWaitingTime((HSState.getFIFO().numWaiting()) * (time - HSState.getTime()));
	
	}
	
	public void updateIdleTime(HairdressState HSState) {
		HSState.addIdleTime((HSState.getFIFO().idle()) * (time - HSState.getTime()));
		
		
	}
	

}