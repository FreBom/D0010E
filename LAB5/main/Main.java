package main;


import generalSimulator.Simulator;
import generalSimulator.State;
import hairdresser.HairdressState;
import hairdresser.HairdressView;

public class Main{
	

	public static void main(String[] args){		
		
		

        State state = new HairdressState();
        HairdressView view = new HairdressView(state);
        Simulator sim = new Simulator(state, view);

        sim.start(); 	
       

	}

}
