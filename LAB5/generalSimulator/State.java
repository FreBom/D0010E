package generalSimulator;

import java.util.Observable;

public class State extends Observable {

	private boolean emergencyBreak = true;

	/**
	 * 
	 * @param setBreak <B> true </B> if the break is <B> ON </B> and  <B> false </B> if <B> OFF </B>
	 */
	public void setEmergencyBreak(boolean setBreak) {
		emergencyBreak = setBreak;
		
	}
	/**
	 * 
	 * @return the boolean value of the emergencyBreak of the current simulation.
	 */
	public boolean getEmergencyBreak() {
		return emergencyBreak;
	}


	public void update(Observable o, Object arg) {
		setChanged();
		notifyObservers();
	}

}
