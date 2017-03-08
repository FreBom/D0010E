package hairdresser;

import random.ExponentialRandomStream;
import random.UniformRandomStream;
import generalSimulator.EventStore;
import generalSimulator.Simulator;
import generalSimulator.State;

public class HairdressState extends State {
	
	public final static int queueLength = 5;
	public final static int numberOfChairs = 2;
	public final static double probDissatisfied = 0.5;
	public final static double simStopTime = 7.0; 
	// Entry rate per 1/lambda
	public final static double lambda = 4.0;
	public final static long seed = 1116;
	
	// hmin & hmax, time with specified interval it takes to cut the hair.
	public final static double hmin = 0.5;
	public final static double hmax = 1.0;
	
	// dmin & dmax, time it takes for dissatisfied customer to return.
	public final static double dmin = 1.0;
	public final static double dmax = 2.0;
	
	private String eventName = "";
	private double stateTime;
	private int customerReturns;
	private int customerCut;
	int customerID;
	private int totalCut;
	private boolean isClosed = false;
	
	private FIFO fifo;
	
	private double timeWaitingTotal;
		
	
	private ExponentialRandomStream entryRate = new ExponentialRandomStream(lambda, seed);
	private UniformRandomStream cutTime = new UniformRandomStream(hmin, hmax, seed);
	private UniformRandomStream returnTime = new UniformRandomStream(dmin, dmax, seed);
	
	public HairdressState(){
		fifo = new FIFO();
	}
	
	public FIFO getFIFO() {
		return fifo;
	}
	public void update() {
		setChanged();
		notifyObservers();
	}
	
	public static int getQueueLength() {
		return queueLength;
	}
	public static int getNumberOfChairs() {
		return numberOfChairs;
	}
	public double timeToArrival() {
		return entryRate.next();
		
	}
	
	public double getCutTime() {
		return cutTime.next();
	}
	
	public double getReturnTime() {
		return returnTime.next();
	}
	
	public double timeWaitingTotal(){ //total tid någon har stått i kö
		if (fifo.getQueueSize() > 0){
			
		}
		return 0;
	}
	
	public int timeIdle(){ // total tid en klippstol är ledig
		return 0;
	}
	
	public long getSeed() {
		return seed;
	}
	
	public static double getSimStopTime(){
		return simStopTime;
	}
	
	public static double getLambda() {
		return lambda;
	}
	
	public static double[] hArray() {
		return new double[] {hmin, hmax};
	}
	
	public static double[] dArray() {
		return new double[] {dmin, dmax};
	}
	
	public void setTime(double time) {
		stateTime = time;
		
	}
	
	public double getTime() {
		return stateTime;
	}
	
	public int getCustomerReturns() {
		return customerReturns;
	}
	
	public void setCustomerReturns(int customerReturns) {
		this.customerReturns = customerReturns;
	}
	
	public int getTotalCut() {
		return totalCut;
	}
	
	public void setTotalCut(int totalCut) {
		this.totalCut = totalCut;
	}
	
	public int getCustomerCut() {
		customerCut = totalCut - customerReturns;
		return customerCut;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public boolean getIsClosed() {
		return isClosed;
	}

	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	

	
	

}
