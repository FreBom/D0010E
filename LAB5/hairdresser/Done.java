package hairdresser;


import generalSimulator.Event;
import generalSimulator.EventStore;
import generalSimulator.State;

public class Done extends Event{

	private Customer customer;
	HairdressState HSState;
	private int customerCut;
	
	public Done(Customer customer, double time, EventStore store){  
		super(time, store);
		this.customer = customer;
		
	}
	
	public void execute(State state) {
		
		HSState = (HairdressState) state;
		HSState.setEventName(toString());
		HSState.customerID = customer.getID(customer);
		HSState.setTime(time);
		
		if(customer.getHasCut() == false){
			
			HSState.setCutCustomer();
			customer.setHasCut();
			
		}
				
		
		if(HSState.getDissatisfied()){
			
			store.add(new Return(customer, time + HSState.getReturnTime(), store));
			
		}
		HSState.getFIFO().addGetHaircut(customer, HSState, store);  
//		HSState.setTotalCut(HSState.getTotalCutCustomers() + 1);
		HSState.update();
	}
	

}