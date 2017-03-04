package generalSimulator;

public abstract class StopEvent extends Event{
	
	public StopEvent(double time) {
		super(double time);
		
	}
	
	public void effect() {
		State.setEmergencyBreak(false);
	}
	

}
