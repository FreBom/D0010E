package generalSimulator;

public class StartEvent extends Event{
	
	public StartEvent(double time) {
		super(time);
	}
	
	public void effect() {
		Simulator.start();
	}
	

}
