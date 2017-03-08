package hairdresser;

import random.ExponentialRandomStream;
import random.UniformRandomStream;
import generalSimulator.EventStore;
import generalSimulator.Simulator;
import generalSimulator.State;

public class HairdressState extends State {
	
	protected final static int queueLength = 5;
	protected final static int numberOfChairs = 2;
	protected static final double probDissatisfied = 0.5;
	protected static final double simStopTime = 7.0; 
	// Entry rate per 1/lambda
	protected final static double lambda = 4.0;
	protected final static long seed = 1116;
	
	// hmin & hmax, time with specified interval it takes to cut the hair.
	protected final static double hmin = 0.5;
	protected final static double hmax = 1.0;
	
	// dmin & dmax, time it takes for dissatisfied customer to return.
	protected final static double dmin = 1.0;
	protected final static double dmax = 2.0;
	protected static String eventName = "";

	private double stateTime;
	private int customerReturns;
	private int customerCut;
	private int totalCut;
	
	private FIFO fifo;
	
	private int numLost = 0;
	private int numCustomers = 0;
	
	
	
	private ExponentialRandomStream entryRate = new ExponentialRandomStream(lambda, seed);
	private UniformRandomStream cutTime = new UniformRandomStream(hmin, hmax, seed);
	private UniformRandomStream returnTime = new UniformRandomStream(dmin, dmax, seed);
	
	public HairdressState(FIFO fifo){
		this.fifo = fifo;
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
	
	public int timeWaiting(){
		return 0;
	}
	
	public int timeIdle(){
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
	
	
	public void addGetHaircut(Customer customer, HairdressState state, EventStore store, Simulator sim) {
		fifo.removeGettingHaircut(customer);
		
		int i = 1;
		Customer customerInQueue;
		if (fifo.oldCustomerQueue.size() >= i) {
			customerInQueue = fifo.oldCustomerQueue.get(0);
			fifo.customerGettingHaircut.add(customerInQueue);
			store.add(new CustomerLeaves(customerInQueue, sim.getSimTime() + state.getCutTime(), store, this));
			fifo.oldCustomerQueue.remove(0);
		} else if (fifo.newCustomerQueue.size() >= i) {
			customerInQueue= fifo.newCustomerQueue.get(0);
			fifo.customerGettingHaircut.add(customerInQueue);
			store.add(new CustomerLeaves(customerInQueue, sim.getSimTime() + state.getCutTime(), store, this));
			fifo.newCustomerQueue.remove(0);
		}
	
	}
	
	public void addNew(Customer customer) {
		if ((fifo.oldCustomerQueue.size() + fifo.newCustomerQueue.size()) == queueLength ) {
			numLost++;
		} else {

			fifo.newCustomerQueue.add(customer);
		}
		numCustomers++;
	}
	
	public void addOld(Customer customer) {
		if ((fifo.oldCustomerQueue.size() + fifo.newCustomerQueue.size()) == queueLength) {
			
			if(fifo.newCustomerQueue.size() > 0){
				fifo.removeLast(fifo.newCustomerQueue);//removeLast();
				fifo.oldCustomerQueue.add(customer);
			
			}
			numLost++;
			
		} else {
		fifo.oldCustomerQueue.add(customer);}
	}

	public void addCustomer(Customer customer) {
		fifo.customerGettingHaircut.add(customer);
		numCustomers++;
	}

}
