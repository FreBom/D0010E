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

public class Main extends Simulator{
	

	public static void main(String[] args){		
	   
	}
	
    public void run() {
        EventStore store = new EventStore();
        FIFO fifo = new FIFO();
        State state = new HairdressState();
        HairdressView view = new HairdressView(state, Event);
        Customer customer;
        store.add(new StartHSS(0.00, store, fifo));
        store.add(new StopHSS(999));

        start(); 	
       
    }


}
