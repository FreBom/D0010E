package generalSimulator;

/**
 * 
 * @author arostr-5@student.ltu.se, fanny, dexmo
 *
 *
 */
public class StartEvent extends Event {

	public StartEvent() {
		
	}

	public void deActivateEmergencyBreak(State s) {// Fredrik : Motsvarande den
													// metoden som finns i
													// stopevent. fast den
													// funakr tv�rt om, kan vara
													// anv�ndbar
		s.setEmergencyBreak(false);
	}

	public void execute(State state) {

	}

	@Override
	public void execute(State state, EventStore store) {
		// TODO Auto-generated method stub

	}

}
