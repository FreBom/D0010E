package generalSimulator;

import java.util.Observable;

public class State extends Observable {

	private boolean emergencyBreak = true;


	public void setEmergencyBreak(boolean setBreak) {
		emergencyBreak = setBreak;
		
	}
	
	public boolean getEmergencyBreak() {
		return emergencyBreak;
	}

	public void observable(Event event) {
		setChanged();
		notifyObservers(event);
	}

}
