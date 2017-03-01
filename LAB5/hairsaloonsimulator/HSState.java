package hairsaloonsimulator;

import generalsimulator.State;
import generalsimulator.Time;

public class HSState extends State implements Time {
	private int queueLength;// tyckte det var bättra namn än FIFOSIZE
	private int numberOfChairs;
	private int simStartTime;// starttime for simulation
	private int simStopTime;// simulation stoptime

	public HSState(int queueLength, int numberOfChairs, int simStartTime, int simStopTime) {
		this.queueLength = queueLength;
		this.numberOfChairs = numberOfChairs;
		this.simStartTime = simStartTime;
		this.simStopTime = simStopTime;
	}

	private int getQueueLength() {// kanske bättre med protected
		return this.queueLength;
	}

	private int getNumberOfchairs() {
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
