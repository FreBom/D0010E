package hairdresser;

import generalSimulator.Event;
import generalSimulator.EventStore;
import generalSimulator.State;
/**
 * This class handles the Start event, the initiation of the simulation making sure a customer enters
 * 
 * @author arostr-5, Fanny, Dexmo
 *
 */
public class StartHSS extends Event {

	HairdressState HSState;
	
	/**
	 * Constructor with the time when to start and were it's stored
	 * 
	 * @param time of the event
	 * @param store were the event is stored
	 */
	public StartHSS(double time, EventStore store) {
		super(time, store);

	}
	/**
	 * The effect of this event
	 * 
	 */
	public void execute(State state) {

		HSState = (HairdressState) state;
		HSState.setEventName(toString());
		

		getStore().add(new Enter(getTime() + HSState.timeToArrival(), getStore()));
		getStore().add(new Closing(HairdressState.simStopTime, getStore()));
		HSState.setTime(getTime());
		HSState.update();

	}

}
