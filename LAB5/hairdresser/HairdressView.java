package hairdresser;

import java.util.Arrays;

import hairdresser.FIFO;
public class HairdressView extends HairdressState{
	
	public void startPrint(){ // Se Simulator start():
		
		System.out.println("Closing time of the day ..............: " + getSimStopTime());
		System.out.println("Total number of chairs ...............: " + getNumberOfChairs());
		System.out.println("Maximum queue size ...................: " + getQueueLength());
		System.out.println("Lambda (customers/timeunit entering)..: " + getLambda());
		System.out.println("hmin and hmax (cutting time interval) : " + Arrays.toString(hArray()));
		System.out.println("dmin and dmax (return time interval) .: " + Arrays.toString(dArray()));
		System.out.println("Risk dissatisfied returns: ...........: " + probDissatisfied);
		System.out.println("Seed used in pseudo random generator .: " + seed);
		
		
		
		
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
