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
							// skule g�ra n�gt i stil med activateEmergencyBreak
							// s� skapade den ist�llet
		//TODO: ska vi ta bort den h�r metoden? vad g�r den?

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
