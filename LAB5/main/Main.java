package main;

import generalSimulator.EventStore;
import generalSimulator.Simulator;
import hairdresser.Customer;
import hairdresser.CustomerArrives;
import hairdresser.HairdressState;
import hairdresser.FIFO;

public class Main extends Simulator{
	
	public static void main(String[] args){		
	   
	}
	
    void start() {
        EventStore store = new EventStore();
        HairdressState state = new HairdressState();
        HaidressView view = new HaidressView(state);
        Customer customer;

        customer = hairdresser.NewCustomer.create();
        store.add(new CustomerArrives(state, store, customer));
    
        	
        }
    //k�r simulatorn som k�r alla event
    }
		
//		HairdressState state = new HairdressState();
//		EventStore store = new EventStore();
//		HaidressView view = new HaidressView(state);
//		
//		//set time
//		
//		
//		store.add(new CustomerArrives());
//		
//		// Start simulation
//		
//		Simulator simulation = new Simulator(state, store, view);
//		simulation.start();
//		
		
		
	}

}
