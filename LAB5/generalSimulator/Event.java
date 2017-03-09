package generalSimulator;

/**
 * Every event is then unique and the abstract class makes sure the event extends this class
 * 
 * @author arostr-5@student.ltu.se, fanny, dexmo
 *
 */
public abstract class Event {

	private double time;
	private EventStore store;
	/**
	 * Event is specified with a time and a store
	 * 
	 * @param time
	 * @param store
	 */
	public Event(double time, EventStore store) {
		this.time = time;
		this.store = store;

	}

	/**
	 * Get the time of the this event
	 * 
	 * @return the time of this event
	 */
	public double getTime() {
		return time;
	}
	
	/**
	 * Get the store of were the event is stored
	 * 
	 * @return the given store 
	 */
	public EventStore getStore() {
		return store;
	}
	
	/**
	 * 
	 * @param the given state
	 */
	public abstract void execute(State state);
	// TODO Auto-generated method stub
	
	/**
	 *  
	 * @return the name of the class the event belongs to
	 */
	public String toString() {
		return this.getClass().getSimpleName();
	}

}
