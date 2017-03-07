package generalSimulator;

/**
 * 
 * @author arostr-5@student.ltu.se, fanny, dexmo
 *
 *
 */
public abstract class Event {

	public double time;
	
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

	/**
	 * 
	 * @param simulator the simulator that you want to run.
	 */

}
