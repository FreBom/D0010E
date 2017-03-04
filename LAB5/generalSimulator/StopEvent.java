package generalSimulator;

public abstract class StopEvent extends Event{
	
	public StopEvent(double time) {
		this.time = time;
		
	}
	
	public void effect() {
		State.setEmergencyBreak(false);
	}
	

}
