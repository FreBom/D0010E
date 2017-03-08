package hairdresser;


import generalSimulator.State;
import generalSimulator.Event;
import generalSimulator.EventStore;

public class Return extends Event {
	
	private Customer customer;
	HairdressState HSState;
	private int returns;

	
	public Return(Customer customer, double time, EventStore store){
		super(time, store);
		this.customer = customer;
	}
	
	public void execute(State state) {
		
		HSState = (HairdressState) state;
		HSState.setEventName(toString());
		HSState.customerID = customer.getID(customer);
		HSState.setTime(time);
		if(customer.getHasReturn() == false) {
			HSState.setReturnCustomer();
			customer.getHasReturn();
		}
		
		if (HSState.getFIFO().idle() > 0) {
			HSState.getFIFO().addCustomer(customer);
			store.add(new Done(customer, time + HSState.getCutTime(), store));

		} else {
			HSState.getFIFO().addOld(customer);
		} 
		HSState.update();
	}


}
