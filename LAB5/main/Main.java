package main;

import generalSimulator.EventStore;
import generalSimulator.Simulator;
import generalSimulator.State;
import generalSimulator.View;
import hairdresser.Customer;
import hairdresser.CustomerArrives;
import hairdresser.HairdressState;
import hairdresser.HairdressView;
import hairdresser.StartHSS;
import hairdresser.StopHSS;
import hairdresser.FIFO;

public class Main{
	

	public static void main(String[] args){		
		
		

        State state = new HairdressState();
        HairdressView view = new HairdressView(state);
        Simulator sim = new Simulator(state, view);

        sim.start(); 	
       

	}

}
