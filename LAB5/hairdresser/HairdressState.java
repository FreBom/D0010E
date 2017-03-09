package hairdresser;

import random.ExponentialRandomStream;
import random.UniformRandomStream;
import generalSimulator.State;
/**
 * This class is the specified state for the simulation with all settings for the user 
 * including generation of random, and statistics.
 * 
 * @author arostr-5, Fanny, Dexmo
 *
 */
public class HairdressState extends State {

	public final static int queueLength = 4;
	public final static int numberOfChairs = 3;
	public final static double probDissatisfied = 0.25;
	public final static double simStopTime = 8.0;
	public final static double probDissatisfiedMin = 0.0;
	public final static double probDissatisfiedMax = 1.0;
	
	public final static double lambda = 3.0;	//  Entry rate per 1/lambda
	public final static long seed = 1116;

	
	public final static double hmin = 0.8;	//	hmin & hmax, time with specified interval it takes to cut the hair.
	public final static double hmax = 1.2;

	
	public final static double dmin = 2.0;	//	dmin & dmax, time it takes for dissatisfied customer to return.
	public final static double dmax = 3.0;

	private String eventName = "";
	private double stateTime, totalWaitingTime, totalIdleTime, averageCutTime;
	private boolean isClosed = false;
	private int customerReturns, customerCut, customerID;

	private ExponentialRandomStream entryRate;
	private UniformRandomStream cutTime;
	private UniformRandomStream returnTime;
	private UniformRandomStream disPro;
	private FIFO fifo;
	/*
	 * Constructor creates the dynamic objects of the classes given itself access
	 * 
	 */
	public HairdressState() {
		fifo = new FIFO();
		entryRate = new ExponentialRandomStream(lambda, seed);
		cutTime = new UniformRandomStream(hmin, hmax, seed);
		returnTime = new UniformRandomStream(dmin, dmax, seed);
		disPro = new UniformRandomStream(probDissatisfiedMin, probDissatisfiedMax, seed);
	}
	/**
	 * Generates if customer is satisfied or not
	 * 
	 * @return true or false 
	 */
	public boolean getDissatisfied() {
		if (disPro.next() < probDissatisfied) {
			return true;
		}
		return false;
	}
	
	/**
	 * Changes are being made in every event and observers notified to print new events
	 * 
	 */
	public void update() {
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Counts amount of customer gotten their haircut
	 * 
	 */
	public void setCutCustomer() {
		customerCut++;
	}
	
	/**
	 * 
	 * @return the amount of customers gotten their haircut
	 */
	public int getCutCustomer() {
		return customerCut;
	}
	
	/**
	 * Counts the amount of returning customer
	 * 
	 */
	public void setReturnCustomer() {
		customerReturns++;
	}
	
	/**
	 * 
	 * @return the amount of returning customer
	 */
	public int getReturnCustomer() {
		return customerReturns;
	}
	
	/**
	 * 
	 * @return the fifo object created in the constructor giving access to all it's functionality
	 * through state
	 * 
	 */
	public FIFO getFIFO() {
		return fifo;
	}
	
	/**
	 * 
	 * @return the max length of the queue (setting)
	 */
	public static int getQueueLength() {
		return queueLength;
	}
	
	/**
	 * 
	 * @return numbers of chairs for the salon (SETTING)
	 */
	public static int getNumberOfChairs() {
		return numberOfChairs;
	}
	
	/**
	 * 
	 * @return the random value generated based on arguments when created
	 */
	public double timeToArrival() {
		return entryRate.next();

	}
	
	/**
	 * 
	 * @return the random value generated based on arguments when created
	 */
	public double getCutTime() {
		return cutTime.next();
	}

	/**
	 * 
	 * @return the random value generated based on arguments when created
	 */
	public double getReturnTime() {
		return returnTime.next();
	}
	
	/**
	 * 
	 * @return the seed long (SETTING)
	 */
	public long getSeed() {
		return seed;
	}
	
	/**
	 * 
	 * @return when the closing event executes and salon closes (SETTING)
	 */
	public static double getSimStopTime() {
		return simStopTime;
	}
	
	/**
	 * 
	 * @return the lambda given by user (SETTING)
	 */
	public static double getLambda() {
		return lambda;
	}

	/**
	 * 
	 * @return an array with two values given by user (SETTING)
	 */
	public static double[] hArray() {
		return new double[] { hmin, hmax };
	}
	
	/**
	 * 
	 * @return an array with two values given by user (SETTING)
	 */
	public static double[] dArray() {
		return new double[] { dmin, dmax };
	}
	
	/**
	 * Making it possible to update the time data of state
	 * 
	 * @param time given when to update the stateTime (time)
	 */
	public void setTime(double time) {
		stateTime = time;
	}
	
	/**
	 * 
	 * @return the time of the state
	 */
	public double getTime() {
		return stateTime;
	}
	
	/**
	 * 
	 * @return the name of the event
	 */
	public String getEventName() {
		return eventName;
	}
	
	/**
	 * 
	 * @param eventName given by each occurring event with the toString method
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	/**
	 * 
	 * @return if the boolean is true/false. Salon is closed or not
	 */
	public boolean getIsClosed() {
		return isClosed;
	}
	
	/**
	 * 
	 * @param isClosed to set the boolean if salon is closed or not
	 */
	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}
	
	/**
	 * 
	 * @param waitingTime given by each event to update time hold in the state
	 */
	public void addWaitingTime(double waitingTime) {
		this.totalWaitingTime += waitingTime;

	}
	
	/**
	 * 
	 * @return the waiting time, will be total in the end of simulation
	 */
	public double getTotalWaitingTime() {
		return totalWaitingTime;
	}
	/**
	 * 
	 * @param idleTime given by each event to update time hold in the state
	 */
	public void addIdleTime(double idleTime) {
		this.totalIdleTime += idleTime;

	}
	/**
	 * 
	 * @return idleTime, will be total in the end of simulation
	 */
	public double getTotalIdleTime() {
		return totalIdleTime;
	}

	/**
	 * 
	 * @param averageCutTime to update the total average cut time
	 */
	public void setAverageCutTime(double averageCutTime) {
		this.averageCutTime += averageCutTime;
	}
	
	/**
	 * 
	 * @return the average cut time based on total average cut time and total cut customers
	 */
	public double getAverageCutTime() {
		return averageCutTime / customerCut;
	}
	
	/**
	 * 
	 * @return the average queue time based on total waiting time and total cut customers
	 */
	public double getAverageQueueTime() {
		return totalWaitingTime / customerCut;
	}
	
	/**
	 * 
	 * @param id of the customer assigned by the event holding the actual customer
	 */
	public void setCustomerID(int id) {
		customerID = id;

	}
	
	/**
	 * 
	 * @return the customer id created originally in newCustomer
	 */
	public int getCustomerID() {
		return customerID;
	}

}
