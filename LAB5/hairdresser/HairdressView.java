package hairdresser;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Observable;
import generalSimulator.State;
import generalSimulator.View;
public class HairdressView extends View{
	

	HairdressState HSState;
	DecimalFormat numberFormat = new DecimalFormat("#.00");
	
	public HairdressView(State state) {
		super(state);
		HSState = (HairdressState) state;
		HSState.addObserver(this);
	}
	
	public void update(Observable o, Object arg) { 
		
		if(HSState.getEventName() == "Enter" || HSState.getEventName() == "Done " || HSState.getEventName() == "Return") {
		
		System.out.format("%s %2s %6s %6s %6s %7s %6s %6s %6s %6s %n", 
			numberFormat.format(HSState.getTime()), 
			HSState.getEventName(), 
			HSState.getCustomerID(),
			HSState.getFIFO().idle(),
			"TIDLE",
			"TWAIT",
			HSState.getFIFO().numWaiting(),
			HSState.getCustomerCut(),
			HSState.getFIFO().getNumLost(),
			HSState.getCustomerReturns()
			);				
		}
		else if(HSState.getEventName() == "StopHSS") {
		System.out.format("%s %2s %3s %6s %6s %7s %6s %6s %6s %6s %n", 
			HSState.getTime(), 
			HSState.getEventName(), 
			"",
			HSState.getFIFO().idle(),
			"TIDLE",
			"TWAIT",
			HSState.getFIFO().numWaiting(),
			HSState.getCustomerCut(),
			HSState.getFIFO().getNumLost(),
			HSState.getCustomerReturns()
			);
		} else {
			System.out.format("%s %2s %n", 
					HSState.getTime(), 
					HSState.getEventName());
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
		System.out.format("%s %2s %6s %6s %6s %7s %6s %6s %6s %6s %n", "- Time" , "Event", "Id", "Idle", "TIdle", "TWait", "InQ", "Cut", "Lost", "Ret -");
		
		
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
