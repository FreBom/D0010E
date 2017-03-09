package hairdresser;

import generalSimulator.State;
import generalSimulator.Event;
import generalSimulator.EventStore;
/**
 * This class handle the event closing which closes access for new arrivals to the store
 * 
 * @author arostr-5, Fanny, Dexmo
 *
 */
public class Closing extends Event {
	
	private HairdressState HSState;
	/**
	 * Constructor needs the time of the closing event and where it's hold
	 * 
	 * @param time to close the store
	 * @param store where the events are stored
	 */
	public Closing(double time, EventStore store) {
	
		super(time, store);

	}
	/**
	 * The effect of the event, assigning, changes and notifies
	 * 
	 * @param the specific state
	 */
	public void execute(State state) {

		HSState = (HairdressState) state;
		HSState.setEventName(toString());
		HSState.setTime(getTime());

		HSState.update();

		HSState.setClosed(true);
		getStore().add(new StopHSS(999.0, getStore()));

	}

}
