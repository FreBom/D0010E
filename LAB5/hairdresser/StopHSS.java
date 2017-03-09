package hairdresser;

import generalSimulator.Event;
import generalSimulator.EventStore;
import generalSimulator.State;
/**
 * This class handles the stop event, when the simulation stops
 * 
 * @author arostr-5, Fanny, Dexmo
 *
 */
public class StopHSS extends Event {

	HairdressState HSState;
	
	/**
	 * 
	 * @param time when to stop the simulation
	 * @param store were the event is stored
	 */
	public StopHSS(double time, EventStore store) {

		super(time, store);

	}
	/**
	 * The effect of this event
	 * 
	 */
	public void execute(State state) {

		HSState = (HairdressState) state;
		HSState.setEventName(toString());
		HSState.setTime(getTime());
		state.setEmergencyBreak(true);
		HSState.update();

	}

}
