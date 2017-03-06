package hairdresser;

import random.ExponentialRandomStream;
import random.UniformRandomStream;
import generalSimulator.State;
import generalSimulator.Time;

public class HairdressState extends State {
	
	private double currentTime;
	private final double simStopTime = 7.0; 
	
	private final int queueLength = 5;
	private final int numberOfChairs = 2;
	
	private final double probDissatisfied = 0.5;
	
	// Entry rate per 1/lambda
	private final double lambda = 4.0;
	private final long seed = 1116;
	
	// hmin & hmax, time with specified interval it takes to cut the hair.
	private final double hmin = 0.5, hmax = 1.0;
	
	// dmin & dmax, time it takes for dissatisfied customer to return.
	private final double dmin = 1.0, dmax = 2.0;
	
	
	
//	public HairdressState(int queueLength, int numberOfChairs, int simStopTime, double probDissatisfied) {
//		this.queueLength = queueLength;       
//		this.numberOfChairs = numberOfChairs;  
//		this.simStopTime = simStopTime;  
//		this.probDissatisfied = probDissatisfied;
//	}
	
	private ExponentialRandomStream entryRate = new ExponentialRandomStream(lambda, seed);
	private UniformRandomStream cutTime = new UniformRandomStream(hmin, hmax, seed);
	private UniformRandomStream returnTime = new UniformRandomStream(dmin, dmax, seed);
	
	
	public double newEventTime() {
		currentTime += entryRate.next();
		
		return currentTime;
	}
	
	public double getCutTime() {
		return cutTime.next();
	}
	
	public double getReturnTime() {
		return returnTime.next();
	}
	
	public int timeWaiting(){
		return 0;
	}
	
	public int timeIdle(){
		return 0;
	}
	
	

	public int getQueueLength() {// kanske b�ttre med protected
		return queueLength;
	}

	public int getNumberOfChairs() {
		return numberOfChairs;
	}
	
	public int getSimStopTime(){
		return simStopTime;
	}
	


}
