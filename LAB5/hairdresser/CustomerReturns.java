package hairdresser;


import generalSimulator.State;
import generalSimulator.Event;
import generalSimulator.EventStore;

public class CustomerReturns extends Event {
	
	private Customer customer;

	
	
	public CustomerReturns(Customer customer, double time, EventStore store){
		super(time, store);
		this.customer = customer;
	}
	
	public void execute(State state) {
		
		HairdressState HSState = (HairdressState) state;
		HSState.setEventName("Return");
		HSState.customerID = customer.getID(customer);
		HSState.setTime(time);
		
		HSState.setCustomerReturns(HSState.getCustomerReturns() + 1);
		
		if (HSState.getFIFO().idle() > 0) {
			HSState.getFIFO().addCustomer(customer);
			store.add(new CustomerLeaves(customer, time + HSState.getCutTime(), store));

		} else {
			HSState.getFIFO().addOld(customer);
		} 
		HSState.update();
	}


}
