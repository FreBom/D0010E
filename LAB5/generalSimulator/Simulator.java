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
	private double time;

	public Simulator(State state, EventStore eventList, View view) {
		this.eventList = eventList;
		this.state = state;
		this.view = view;

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

		}
		view.stopPrint();

	}

}
