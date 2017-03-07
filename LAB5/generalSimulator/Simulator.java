package generalSimulator;

import java.util.Observable;

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
	private double time;

	public Simulator(State state) {
		eventList = new EventStore();
		view = new View(state);
		
		this.state = state;
		
	    store.add(new StartHSS(0.00, store, fifo));
	    store.add(new StopHSS(999));

	}

	public double getSimTime() {
		return time;
	}

	public void start() {
		view.startPrint();
		Event e;
		while (!state.getEmergencyBreak()) { // Alt. !isEmpty()
			
			e = eventList.getFirstAndRemove();
			e.execute(state, this);
			time = e.getTime();
			state.notifyObservers();
			
			

		}
		view.stopPrint();

	}

}
