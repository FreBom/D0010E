package hairdresser;

import java.util.Arrays;
import java.util.Observable;

import generalSimulator.Event;
import generalSimulator.State;
import generalSimulator.View;
import hairdresser.FIFO;
public class HairdressView extends View{
	
	Event event;
	Customer customer;
	HairdressState HSState;
	
	public HairdressView(State state, Event event, Customer customer) {
		super(state);
		this.event = event;
		this.customer = customer;
		state.addObserver(this);
		HSState = (HairdressState) state;
	}
	
	public void update(Observable o, Object arg) { 
		
		
		System.out.format("%s %2s %6s %6s %6s %7s %6s %6s %6s %6s %n", "- Time" , "Event", "Id", "Idle", "TIdle", "TWait", "InQ", "Cut", "Lost", "Ret -");
		System.out.format("%s %2 %6 %6s %6s %7s %6s %6s %6s %6s %n", 
			event.getTime(), 
			HSState.getEventName(), 
			customer.getID(),
			HSState.getFIFO().idle(),
			//TIDLE,
			//TWAIT
			HSState.getFIFO().numWaiting(),
			//Cut
			HSState.getFIFO().getNumLost()
			//RET
			);		
		
		
		
	}
	public void startPrint(){ // Se Simulator start():
		
		System.out.println("Closing time of the day ..............: " + HairdressState.getSimStopTime());
		System.out.println("Total number of chairs ...............: " + HairdressState.getNumberOfChairs());
		System.out.println("Maximum queue size ...................: " + HairdressState.getQueueLength());
		System.out.println("Lambda (customers/timeunit entering)..: " + HairdressState.getLambda());
		System.out.println("hmin and hmax (cutting time interval) : " + Arrays.toString(HairdressState.hArray()));
		System.out.println("dmin and dmax (return time interval) .: " + Arrays.toString(HairdressState.dArray()));
		System.out.println("Risk dissatisfied returns: ...........: " + HairdressState.probDissatisfied);
		System.out.println("Seed used in pseudo random generator .: " + HairdressState.seed);
		
		
	}
	
	public void stopPrint() {
		System.out.println("Number of customers cut: ......: " + HSState.getCustomerCut());
		System.out.println("Average cutting time...........: ");
		System.out.println("Average queueing time: ........: ");
		System.out.println("Largest queue (max NumWaiting) : ");
		System.out.println("Customers not cut (NumLost) ...: ");
		System.out.println("Dissatisfied customers: .......: ");
		System.out.println("Time chairs were idle: ........: ");
	}

	
	

}
