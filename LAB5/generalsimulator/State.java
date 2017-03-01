package generalsimulator;

/**
 * 
 * @author Dexmo 
 * 			
 *         A general simulator has to have a class for the state, which
 *         during runtime is an object that keeps track of all details during
 *         the simulation. The state should always contain a boolean flag that
 *         signals the end of the simulation. We call this flag the emergency
 *         break. The specific simulator (about a hair salon, for instance) will
 *         typically extend this state into a specific state and add specific
 *         contents that describe the specific simulation
 */
public class State {
	boolean flagEmergencyBreak;// ska konstruktrn ta flaggan? tänker att vare instans borde väl ha en egen flagga? 
	public State() {// konstruktorn
		// TODO Auto-generated constructor stub
	}

}
