package hairdresser;

import java.util.Arrays;

import hairdresser.FIFO;
public class HairdressView extends View{
	
	HairdressState state;
	
	public HairdressView(State state) {
		super(state);
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
	public void endPrint() {
		System.out.println("Number of customers cut: ......: " + FIFO.getCustomers());
		System.out.println("Average cutting time...........: ");
		System.out.println("Average queueing time: ........: ");
		System.out.println("Largest queue (max NumWaiting) : ");
		System.out.println("Customers not cut (NumLost) ...: ");
		System.out.println("Dissatisfied customers: .......: ");
		System.out.println("Time chairs were idle: ........: ");
	}
	
	

}
