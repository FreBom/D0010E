package generalSimulator;

/**
 * 
 * @author arostr-5@student.ltu.se, fanny, dexmo
 *
 *
 */
public class StopEvent extends Event {

	public void activateEmergencyBreak(State state) {
		state.setEmergencyBreak(true);
	}

	@Override
	public void execute(State state) {
		// TODO Auto-generated method stub

	}

}
