package generalSimulator;
/**
 * 
 * @author arostr-5@student.ltu.se, fanny, dexmo
 *
 *
 */
public class StopEvent extends Event{
	
	public StopEvent(double time) {
		super(time);
		
	}
	
	
	public void effect() {
		State.setEmergencyBreak(false);
	}
	
	
	
	
	

}
