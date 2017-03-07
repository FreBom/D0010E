package main;

import generalSimulator.EventStore;
import generalSimulator.Simulator;
import generalSimulator.State;
import hairdresser.Customer;
import hairdresser.CustomerArrives;
import hairdresser.HairdressState;
import hairdresser.HairdressView;
import hairdresser.StartHSS;
import hairdresser.StopHSS;
import hairdresser.FIFO;

public class Main{
	

	public static void main(String[] args){		

        EventStore store = new EventStore();
        State state = new HairdressState();
        HairdressView view = new HairdressView(state, null, null, null); // Detta funkar ej. Måste tänka om, hantera mer via state.
       
        Simulator sim = new Simulator(state, store, view);

        store.add(new StartHSS(0.00, store, null));
        store.add(new StopHSS(999));

        sim.start(); 	
       

	}

}
