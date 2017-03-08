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
		
		if(HSState.getEventName().equals("Enter")) {
		
		System.out.format("%s %2s %6s %6s %6s %7s %6s %6s %6s %6s %n", 
			numberFormat.format(HSState.getTime()), 
			HSState.getEventName(), 
			HSState.getCustomerID(),
			HSState.getFIFO().idle(),
			"TIDLE",
			"TWAIT",
			HSState.getFIFO().numWaiting(),
			HSState.getCutCustomer(),
			HSState.getFIFO().getNumLost(),
			HSState.getReturnCustomer()
			);				
		}
		else if (HSState.getEventName().equals("Done")) {
			System.out.format("%s %5s %6s %6s %6s %7s %6s %6s %6s %6s %n",
					numberFormat.format(HSState.getTime()), 
					HSState.getEventName(), 
					HSState.getCustomerID(),
					HSState.getFIFO().idle(),
					"TIDLE",
					"TWAIT",
					HSState.getFIFO().numWaiting(),
					HSState.getCutCustomer(),
					HSState.getFIFO().getNumLost(),
					HSState.getReturnCustomer()
					);	
		}
		else if(HSState.getEventName().equals("Return")) {
			System.out.format("%s %2s %5s %6s %6s %7s %6s %6s %6s %6s %n",
					numberFormat.format(HSState.getTime()), 
					HSState.getEventName(), 
					HSState.getCustomerID(),
					HSState.getFIFO().idle(),
					"TIDLE",
					"TWAIT",
					HSState.getFIFO().numWaiting(),
					HSState.getCutCustomer(),
					HSState.getFIFO().getNumLost(),
					HSState.getReturnCustomer()
					);
		}
		else if(HSState.getEventName().equals("StopHSS")){
		System.out.format("%s %2s %3s %5s %6s %7s %6s %6s %6s %6s %n", 
			numberFormat.format(HSState.getTime()), 
			HSState.getEventName(), 
			"",
			HSState.getFIFO().idle(),
			"TIDLE",
			"TWAIT",
			HSState.getFIFO().numWaiting(),
			HSState.getCutCustomer(),
			HSState.getFIFO().getNumLost(),
			HSState.getReturnCustomer()
			);
		} else {
			System.out.format("%s %2s %n", 
					numberFormat.format(HSState.getTime()), 
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
		System.out.println("Number of customers cut: ......: " + HSState.getCutCustomer());
		System.out.println("Average cutting time...........: ");
		System.out.println("Average queueing time: ........: ");
		System.out.println("Largest queue (max NumWaiting) : " + HSState.getFIFO().getMax());
		System.out.println("Customers not cut (NumLost) ...: " + HSState.getFIFO().getNumLost());
		System.out.println("Dissatisfied customers: .......: " + HSState.getReturnCustomer());
		System.out.println("Time chairs were idle: ........: ");
	}

	
	

}
