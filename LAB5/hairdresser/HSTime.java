package hairdresser;

import java.awt.Event;

import com.sun.java.accessibility.util.EventID;

public class HSTime implements generalSimulator.Time {
	private int hmin;
	private int hmax;
	private int dmin;
	private int dmax;

	public HSTime() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setStartingTime() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStopTime() {
		// TODO Auto-generated method stub

	}

	private int timeBetweenTwoEvents(Event e1, Event e2) {
		// TODO should return the time that minimum time between end of e1 and
		// start of e2
		return 0;
	}

	private int CuttingTime(Customer c) {
		// TODO after creating the customer class coem back here and return the
		// actual cutting time
		return 0;
	}

}
