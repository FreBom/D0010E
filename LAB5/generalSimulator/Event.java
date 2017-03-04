package generalSimulator;

import java.util.Observable;

public abstract class Event extends Observable {
	
	private Simulator state;
	
	
	private double time;
	
	
	public abstract void execute(State state);
	
	
	public Event(Simulator state, Time time) {
		this.state = state;
		this.time = time;
	}
	
	
	

}
