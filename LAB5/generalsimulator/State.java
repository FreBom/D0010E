package generalsimulator;

import java.util.Observable;
public class State extends Observable{
	private boolean emergencyBreak = false;
	
	public boolean pullEmergencyBreak(){
		emergencyBreak = true;
		return emergencyBreak;
		//if (time >= startTime && time < stopTime){
			//emergencyBreak = false;
			
		//}
		//else{ 
			//emergencyBreak = true;
			//}
		
		//return emergencyBreak;
		
	}

}

