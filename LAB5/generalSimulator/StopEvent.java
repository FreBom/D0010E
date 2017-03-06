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

	public void effect() {// Fredrik : jag tog ej bort denna men antog att den 
							// skule göra någt i stil med activateEmergencyBreak
							// så skapade den istället
		//TODO: ska vi ta bort den här metoden? vad gör den?

		State.setEmergencyBreak(false);

	}

	public void activateEmergencyBreak(State s) {
		s.setEmergencyBreak(true);
	}

	@Override
	public void execute(State state, EventStore store) {
		// TODO Auto-generated method stub

	}

}
