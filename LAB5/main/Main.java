package main;

import generalSimulator.EventStore;
import hairdresser.HairdressState;

public class Main {
	
	public static void main(String[] args){
		
		HairdressState state = new HairdressState();
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
