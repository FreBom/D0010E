package generalSimulator;


import hairdresser.ClosingHSS;
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
	    eventList.add(new ClosingHSS(7.0, eventList));

	}

	public void start() {
		view.startPrint();
		while (!eventList.isEmpty() && !state.getEmergencyBreak()) { 
			e = eventList.getFirstAndRemove();
			e.execute(state);	
			state.notifyObservers();
			

		}
		view.stopPrint();

	}

}
