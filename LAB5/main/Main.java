package main;

import generalSimulator.EventStore;
import hairdresser.HSState;

public class Main {
	
	public static void main(String[] args){
		
		HSState state = new HSState();
		EventStore store = new EventStore();
		HaidressView view = new HaidressView(state);
		
		//set time
		
		
		store.add(new CustomerArrives());
		
		// Start simulation
		
		Simulator simulation = new Simulator(state, store, view);
		simulation.start();
		
		// hejsan
		
	}

}
