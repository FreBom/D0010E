package generalSimulator;

import java.util.Observable;

import hairdresser.HairdressState;
import hairdresser.StartHSS;
import hairdresser.StopHSS;

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
	private Event e;
	
	public Simulator(State state, View view) {
		
		this.state = state;
		this.view = view;
		eventList = new EventStore();
		
		eventList.add(new StartHSS(0.00, eventList));
	    eventList.add(new StopHSS(999, eventList));

	}

	public void start() {
		view.startPrint();
		
		while (!eventList.isEmpty()) { 
			
			e = eventList.getFirstAndRemove();
			setChanged();
			state.notifyObservers();
			state.update(state, e);
			e.execute(state);	
			

		}
		view.stopPrint();

	}

}
