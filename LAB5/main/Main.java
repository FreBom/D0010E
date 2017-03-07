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
        FIFO fifo = new FIFO();
        State state = new HairdressState();
        HairdressView view = new HairdressView(state, null, null, fifo);
        
        Simulator sim = new Simulator(state, store, view);

        store.add(new StartHSS(0.00, store, fifo));
        store.add(new StopHSS(999));

        sim.start(); 	
       

	}

}
