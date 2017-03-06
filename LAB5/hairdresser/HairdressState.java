package hairdresser;

import random.ExponentialRandomStream;
import random.UniformRandomStream;
import generalSimulator.State;
import generalSimulator.Time;

public class HairdressState extends State {
	
	protected final static int queueLength = 5;
	protected final static int numberOfChairs = 2;
	protected static final double probDissatisfied = 0.5;
	protected static final double simStopTime = 7.0; 
	// Entry rate per 1/lambda
	protected final double lambda = 4.0;
	protected final static long seed = 1116;
	
	// hmin & hmax, time with specified interval it takes to cut the hair.
	protected final double hmin = 0.5, hmax = 1.0;
	
	// dmin & dmax, time it takes for dissatisfied customer to return.
	protected final double dmin = 1.0, dmax = 2.0;
	protected static String eventName = "";
	//protected double currentTime = 0;
		
	
	private ExponentialRandomStream entryRate = new ExponentialRandomStream(lambda, seed);
	private UniformRandomStream cutTime = new UniformRandomStream(hmin, hmax, seed);
	private UniformRandomStream returnTime = new UniformRandomStream(dmin, dmax, seed);
	
	
	public double timeToArrival() {
		return entryRate.next();
		
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
	
	public long getSeed() {
		return seed;
	}

	public static int getQueueLength() {
		return queueLength;
	}

	public static int getNumberOfChairs() {
		return numberOfChairs;
	}
	
	public static double getSimStopTime(){
		return simStopTime;
	}
	
	public double getLambda() {
		return lambda;
	}
	
	public double[] hArray() {
		return new double[] {hmin, hmax};
	}
	
	public double[] dArray() {
		return new double[] {dmin, dmax};
	}
	


}
