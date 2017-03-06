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

<<<<<<< HEAD
	}

=======
	}
>>>>>>> branch 'master' of https://github.com/FreBom/D0010E.git
	public void activateEmergencyBreak(State s) {
		s.setEmergencyBreak(true);
	}

	@Override
	public void execute(State state, EventStore store) {
		// TODO Auto-generated method stub

	}

}
