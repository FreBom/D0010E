package hairdresser;
import generalSimulator.Event;
import generalSimulator.EventStore;
import generalSimulator.State;

public class StartHSS extends Event {

	public StartHSS() {
		time = 0.00;
	}
	
	public void execute(State state) {
		EventStore.add(new CustomerArrives());
	}
	
	
	
}
