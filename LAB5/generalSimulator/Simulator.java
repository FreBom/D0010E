package generalSimulator;

import java.util.Observable;



/**
 * 
 * @author arostr-5@student.ltu.se, fanny, dexmo
 *
 *
 */
public class Simulator {
	
	private EventStore eventList;
	private State state;
	private View view;
	static double time;
	
	public Simulator(State state, EventStore eventList, View view) {
		this.eventList = eventList;
		this.state = state;
		this.view = view;
		
		
	}	
	public static double getSimTime() {
		return time;
	}
	
	public void start(){
		view.startPrint();
		Event e;
		while(!(state.getEmergencyBreak()) && !(eventList.isEmpty())) {
		
			e = eventList.first();
			e.execute(this);
			time = e.getTime();
			eventList.removeFirst();
			eventList.first();
			
		}
		view.stopPrint();
		
		
	}  

}
