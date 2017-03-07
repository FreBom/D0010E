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

	public static double getSimTime() {
		return 0;
	}

	public void start() {
		view.startPrint();
		Event e;
		while (!state.getEmergencyBreak()) {
			e = eventList.first();
			e.execute(state);
//			time = e.getTime();

		}
		view.stopPrint();

	}

}
