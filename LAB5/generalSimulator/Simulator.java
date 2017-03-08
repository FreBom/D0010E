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

	public Simulator(State state) {
		
		this.state = state;
		view = new View(state);
		
		eventList = new EventStore();
		eventList.add(new StartHSS(0.00, eventList));
	    eventList.add(new StopHSS(999, eventList));

	}

	public void start() {
		view.startPrint();
		Event e;
		while (!eventList.isEmpty()) { 
			
			e = eventList.getFirstAndRemove();
//			setChanged();
//			notifyObservers(e);
			state.update(state, e);
			e.execute(state);
			
			
			

		}
		view.stopPrint();

	}

}
