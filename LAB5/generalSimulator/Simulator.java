package generalSimulator;

import java.awt.Event;
import java.util.Observable;


/**
 * 
 * @author Dexmo
 *
 *
 */
public class Simulator {
	
	private EventStore eventList;
	private State state;
	
	public Simulator(State state, EventStore eventList) {
		this.eventList = eventList;
		this.state = state;
		this.addObserver(View);
		
		
	}	
	
	public void start(){
		
		while(state.getEmergencyBreak() && !eventList.isEmpty()) {
			
			Event event = eventList.first();
			eventList.removeFirst();
			eventList.first();
			
		}
		
		
	}

}
