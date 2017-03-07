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
	static double time;

	public Simulator(State state, EventStore eventList, View view) {
		this.eventList = eventList;
		this.state = state;
		this.view = view;

	}

	/**
	 * 
	 * @return time, <B> NOTE!: </B> it is statically typed which means we get
	 *         the static Time, we might want to have the dynamic time as
	 *         well...?
	 */
	public static double getSimTime() {// TODO we might want this method to
										// return the dynamic time! Because now
										// we have one time that is constant
										// across all different types of
										// simulations!
		return time;
	}

	/**
	 * Starts the simulation if there is no emergency break and there a nonempty
	 * eventlist.
	 * 
	 * @question1 How do we pass the first event to this method?
	 * @question2 How do we even know that there is a eventlist that is made? do
	 *            we create all of this in the main method?
	 * @question3 Shouldn't we just pass a new StartEvent and a StopEvent to
	 *            this method?
	 */
	public void start() {
		view.startPrint();
		Event e;
		while (!(eventList.isEmpty())) {
			e = eventList.first();
			e.execute(this);
			time = e.getTime();
			eventList.removeFirst();
			eventList.first();

		}
		view.stopPrint();

	}

}
