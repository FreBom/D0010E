package hairdresser;

import random.ExponentialRandomStream;
import random.UniformRandomStream;
import generalSimulator.EventStore;
import generalSimulator.Simulator;
import generalSimulator.State;

public class HairdressState extends State {
	
	public final static int queueLength = 4;
	public final static int numberOfChairs = 3;
	public final static double probDissatisfied = 0.25;
	public final static double simStopTime = 8.0; 
	// Entry rate per 1/lambda
	public final static double lambda = 3.0;
	public final static long seed = 1116;
	
	// hmin & hmax, time with specified interval it takes to cut the hair.
	public final static double hmin = 0.8;
	public final static double hmax = 1.2;
	
	// dmin & dmax, time it takes for dissatisfied customer to return.
	public final static double dmin = 2.0;
	public final static double dmax = 3.0;
	
	private String eventName = "";
	private double stateTime;
	private int customerReturns = 0;
	private int customerCut = 0;
	int customerID;
	private int totalCutCustomers;
	private boolean isClosed = false;
	
	public final static double probDissatisfiedMin = 0.0;
	public final static double probDissatisfiedMax = 1.0;
	
	private FIFO fifo;
	
	private double timeWaitingTotal;
		
	
	private ExponentialRandomStream entryRate = new ExponentialRandomStream(lambda, seed);
	private UniformRandomStream cutTime = new UniformRandomStream(hmin, hmax, seed);
	private UniformRandomStream returnTime = new UniformRandomStream(dmin, dmax, seed);
	private UniformRandomStream disPro = new UniformRandomStream(probDissatisfiedMin, probDissatisfiedMax, seed);
	
	public void setCutCustomer() {
		customerCut++;
		
	}

	public int getCutCustomer() {
		return customerCut;
	}
	
	public void setReturnCustomer() {
		customerReturns++;
	}
	
	public int getReturnCustomer() {
		return customerReturns;
	}
	
	public boolean getDissatisfied() {
		 if(disPro.next() < HairdressState.probDissatisfied)  {
			 return true;
		 }
		return false;
	}
	
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
