package generalSimulator;

/**
 * 
 * @author arostr-5@student.ltu.se, fanny, dexmo
 *
 *
 */
public class StopEvent extends Event {

	public StopEvent(double time) {
		super(time);

	}

	/**
	 * 
	 * @param s the current simulation that we want to pull the emergencyBreak on.
	 */
	public void activateEmergencyBreak(State s) {
		s.setEmergencyBreak(true);
	}

	@Override
	public void execute(State state, EventStore store) {
		// TODO Auto-generated method stub

	}

}
