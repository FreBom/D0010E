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
		
//		FIFO fifo = new FIFO();
        EventStore store = new EventStore();
        State state = new HairdressState();
        
        HairdressView view = new HairdressView(state); // Detta funkar ej. M�ste t�nka om, hantera mer via state.
        
        Simulator sim = new Simulator(state);

        sim.start(); 	
       

	}

}
