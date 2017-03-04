package generalSimulator;

import java.util.Observable;

public abstract class Event {
		
	
	private double time;
	
	
	public Event(Simulator state, double time) {
		this.state = state;
		this.settime(time);
	}
	
	public abstract void effect();
	

	public void settime(double time) {
		this.time = time;
		
	}
	
	public double gettime() {
		return time;
	}
	
	

}
