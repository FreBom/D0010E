package generalSimulator;

/**
 * 
 * @author arostr-5@student.ltu.se, fanny, dexmo
 *
 *
 */
public abstract class Event {

	public double time;

	
//	public Event(double time) {
//		this.time = time;
//	
//	}

	/**
	 * 
	 * @return the time of this object
	 */
	public double getTime() {
		return time;
	}

	public String toString() {
		return this.getClass().getSimpleName();
	}

	/**
	 * 
	 * @param y the event that we will compare with the current time.
	 * @return <B> true </B> if the current time is smaller than the time when the event will occur.   
	 */
	public boolean lessThan(Comparable y) {
		
		Event e = (Event) y;
		return this.time < e.time; 

	}
	/**
	 * 
	 * @param simulator the simulator that you want to run.
	 */
	public void execute(Simulator simulator) {
		// TODO Auto-generated method stub

	}
}
