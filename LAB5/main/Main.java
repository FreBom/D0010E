package main;

import generalSimulator.Simulator;
import generalSimulator.State;
import hairdresser.HairdressState;
import hairdresser.HairdressView;

/**
 * This class initiate the simulation
 * 
 * @author aronh
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {

		State state = new HairdressState();
		HairdressView view = new HairdressView(state);
		Simulator sim = new Simulator(state, view);

		sim.start(); // Simulation initiates

	}

}
