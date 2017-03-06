package hairdresser;

public class HairdressView extends HairdressState{
	
	public void startPrint(){ // Se Simulator start():
		
		System.out.println("Closing time of the day ..............: " + getSimStopTime());
		System.out.println("Total number of chairs ...............: " + getNumberOfChairs());
		System.out.println("Maximum queue size ...................: " + getQueueLength());
		System.out.println("Lambda (customers/timeunit entering)..: " + getLambda());
		System.out.println("hmin and hmax (cutting time interval) : " + hArray());
		System.out.println("dmin and dmax (return time interval) .: " + dArray());
		System.out.println("Risk dissatisfied returns: ...........: " + probDissatisfied);
		System.out.println("Seed used in pseudo random generator .: " + seed);
		
		
		
		
	}
	public void endPrint() {
		
	}
	
	

}
