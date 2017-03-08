package generalSimulator;

/**
 * 
 * @author arostr-5@student.ltu.se, fanny, dexmo
 *
 *
 */
public abstract class Event {

	public double time;
	public EventStore store;
	
	public Event(double time, EventStore store) {
		this.time = time;
		this.store = store;	
		
	}
	
	/**
	 * 
	 * @return the time of this object
	 */
	public double getTime() {
		return time;
	}
	
	public abstract void execute(State state);
		// TODO Auto-generated method stub

	
	public String toString() {
		return this.getClass().getSimpleName();
	}



}
