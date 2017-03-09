package generalSimulator;

import hairdresser.StartHSS;

/**
 * The simulation of the specified events and the display
 * 
 * @author arostr-5@student.ltu.se, fanny, dexmo
 *
 */
public class Simulator {

	private EventStore eventList;
	private State state;
	private View view;
	private Event e;
	/**
	 * Constructor assigns what state to observe and view to display
	 * 
	 * @param state to run and observe
	 * @param view to display what you see in console
	 */
	public Simulator(State state, View view) {

		this.state = state;
		this.view = view;
		eventList = new EventStore();
		eventList.add(new StartHSS(0.00, eventList));

	}
	
	/**
	 *	When called simulation starts. Keeps going till stopped defined in specified
	 * @throws Exception is thrown if the EventStore wouldn't been emptied.
	 * 
	 */
	public void start() throws Exception {
		view.startPrint();
		while (!state.getEmergencyBreak()) {
			e = eventList.getFirstAndRemove();
			e.execute(state);
			state.notifyObservers();

		}
		if(!eventList.isEmpty()) {
			throw new Exception("EventsStore not empty!");
		}
		view.stopPrint();

	}

}
