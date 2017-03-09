package generalSimulator;

import java.util.Observable;
	
/**
* The general state which is abstract making in possible to force extends but now only holds the state if the simulation
* 
* @arostr-5, Fanny, Dexmo
*/
public abstract class State extends Observable {
	
	
	private boolean emergencyBreak = false;

	/**
	 * 
	 * @param setBreak <B> true </B> if the break is <B> ON </B> and <B> false </B> if <B> OFF </B>         
	 *            
	 */
	public void setEmergencyBreak(boolean setBreak) {
		emergencyBreak = setBreak;

	}

	/**
	 * 
	 * @return the boolean value of the emergencyBreak for the state used by simulator
	 *         
	 */
	public boolean getEmergencyBreak() {
		return emergencyBreak;
	}

}
