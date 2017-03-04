package hairdresser;

import generalSimulator.State;
import generalSimulator.Time;

public class HSState extends State implements Time{
//	private int queueLength = 6;  //antal platser i v�ntek�n
//	private int numberOfChairs = 3;   //antal stolar som man kan klippa sig i
//	private int simStartTime;  //d� fris�rsalongen �ppnar
//	private int simStopTime;  //d� fris�rsalongen st�nger
	
	private static int queueLength, numberOfChairs, simStartTime, simStopTime;

	public HSState(int queueLength, int numberOfChairs, int simStartTime, int simStopTime) {
		this.queueLength = queueLength;       
		this.numberOfChairs = numberOfChairs;  
		this.simStartTime = simStartTime;  
		this.simStopTime = simStopTime;    
	}

	public static int getQueueLength() {// kanske b�ttre med protected
		return queueLength;
	}

	public static int getNumberOfChairs() {
		return numberOfChairs;
	}
	
	public static int getSimStartTime(){
		return simStartTime;
	}
	
	public static int getSimStopTime(){
		return simStopTime;
	}
	

	@Override
	public void setStartingTime() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStopTime() {
		// TODO Auto-generated method stub

	}
}
