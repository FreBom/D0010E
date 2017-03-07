package hairdresser;

import java.util.Arrays;
import java.util.Observable;

import generalSimulator.Event;
import generalSimulator.State;
import generalSimulator.View;
import hairdresser.FIFO;
public class HairdressView extends View{
	
	HairdressState state;
	Event event;
	Customer customer;
	FIFO fifo;
	
	public HairdressView(State state, Event event, Customer customer, FIFO fifo) {
		super(state);
		this.event = event;
		this.customer = customer;
		this.fifo = fifo;
		state.addObserver(this);
	}
	
	public void update(Observable o, Object arg) { // MELLANHAND!
		
		switch(state.eventName) {
		
		case ("Start"): 
			System.out.format("%s %2s %6s %6s %6s %7s %6s %6s %6s %6s %n", "- Time" , "Event", "Id", "Idle", "TIdle", "TWait", "InQ", "Cut", "Lost", "Ret -");
			System.out.format("%s %2", event.getTime(), "Start");
			break;
		case ("Arrived"):
			System.out.format("%s %2 %6 %6s %6s %7s %6s %6s %6s %6s %n", 
					event.getTime(), 
					"Arrived", 
					customer.getID(),
					fifo.idle(),
					//TIDLE,
					//TWAIT
					fifo.numWaiting(),
					//Cut
					fifo.getNumLost()
					//RET
					);
		break;
		case("Return"):
			System.out.format("%s %2 %6 %6s %6s %7s %6s %6s %6s %6s %n", 
					event.getTime(), 
					"Return", 
					customer.getID(),
					fifo.idle(),
					//TIDLE,
					//TWAIT
					fifo.numWaiting(),
					//Cut
					fifo.getNumLost()
					//RET
					);
		break;
		case("Done"):			
			System.out.format("%s %2 %6 %6s %6s %7s %6s %6s %6s %6s %n", 
				event.getTime(), 
				"Return", 
				customer.getID(),
				fifo.idle(),
				//TIDLE,
				//TWAIT
				fifo.numWaiting(),
				//Cut
				fifo.getNumLost()
				//RET
				);
		break;
		case("Stop"):
			System.out.format("%s %2s %6s %6s %6s %7s %6s %6s %6s %6s %n", 		
					event.getTime(), 
					"Return", 
					customer.getID(),
					fifo.idle(),
					//TIDLE,
					//TWAIT
					fifo.numWaiting(),
					//Cut
					fifo.getNumLost()
					//RET
					); 

		break;
		
		case("Closing"):
			break;
		}
		
		
		
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
		System.out.println("Number of customers cut: ......: " + fifo.getCustomers());
		System.out.println("Average cutting time...........: ");
		System.out.println("Average queueing time: ........: ");
		System.out.println("Largest queue (max NumWaiting) : ");
		System.out.println("Customers not cut (NumLost) ...: ");
		System.out.println("Dissatisfied customers: .......: ");
		System.out.println("Time chairs were idle: ........: ");
	}

	
	

}
