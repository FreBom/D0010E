package hairsaloonsimulator;

import generalsimulator.State;
import generalsimulator.Time;

public class HSState extends State implements Time {
	private int queueLength;// tyckte det var b�ttra namn �n FIFOSIZE
	private int numberOfChairs;
	private int startingTime;
	private int stopTime;
	
	public HSState(int queueLength,int numberOfChairs,int startingTime,int stopTime) {
		this.queueLength = queueLength;
		this.numberOfChairs = numberOfChairs;
		this.startingTime = startingTime;
		this.stopTime = stopTime;
	}
	
	private int getQueueLength(){//kanske b�ttre med protected
		return this.queueLength;
	}
	private int getNumberOfchairs(){
		return this.numberOfChairs;
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
