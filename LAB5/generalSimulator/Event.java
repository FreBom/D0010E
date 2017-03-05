package generalSimulator;

/**
 * 
 * @author arostr-5@student.ltu.se, fanny, dexmo
 *
 *
 */
public abstract class Event {
		
	
	private double time;
	
	
	public Event(double time) {
		this.time = time;
		//this.settime(time);
	}
	
//	public void settime(double time) {
//		this.time = time;
//		
//	}
	
	public double gettime() {
		return time;
	}
	
	public abstract void execute(State state);
	
	public String toString() {
		return this.getClass().getSimpleName();
	}

}
