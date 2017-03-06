package generalSimulator;

/**
 * 
 * @author arostr-5@student.ltu.se, fanny, dexmo
 *
 *
 */
public abstract class Event {
		
	
	double time;
	
	
	public Event(double time) {
		this.time = time;
		//this.settime(time);
	}
	
//	public void settime(double time) {
//		this.time = time;
//		
//	}
	
	public double getTime() {
		return time;
	}
	
	public abstract void execute(State state, EventStore store);
	
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
    public boolean lessThan(Comparable y) {
        Event e = (Event) y; 
        return this.time < e.time;  //kollar om tiden nu är mindre en tiden för eventet

}

	public void execute(Simulator simulator) {
		// TODO Auto-generated method stub
		
	}
