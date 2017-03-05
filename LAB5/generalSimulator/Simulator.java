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
	
	public Simulator(State state, EventStore eventList, View view) {
		this.eventList = eventList;
		this.state = state;
		this.view = view;
		
		
	}	
	
	public void start(){
		view.startPrint();
		while(state.getEmergencyBreak() && !eventList.isEmpty()) {
			
			Event event = eventList.first();
			eventList.removeFirst();
			eventList.first();
			
		}
		view.stopPrint();
		
		
	}

}
