package generalSimulator;

import java.util.Observable;

public abstract class Event {
		
	
	private double time;
	
	
	public Event(Simulator state, Time time) {
		this.state = state;
		this.time = time;
	}
	
	public abstract void effect();
	
	
	

}
