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
	
	public Simulator(EventStore eventList) {
		this.eventList = eventList;
		
		
	}	
	
	public void start(){
		
		while(!eventList.isEmpty()) {
			
			Event event = eventList.first();
			eventList.removeFirst();
			//event.event
			
		}
		
		
	}

}
