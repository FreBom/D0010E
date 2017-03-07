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
	
	private final int maxCustomer = 50; //maxkunder per dag
	private final int minCustomer = 5;
	public static void main(String[] args){		
	   
	}
	
    public void run() {
        EventStore store = new EventStore();
        State state = new HairdressState();
        HairdressView view = new HairdressView();
        Customer customer;
        store.add(new StartHSS());
        store.add(new StopHSS());
//        int randomCustomer = (int) (Math.floor(Math.random() * (maxCustomer - minCustomer + 1)) + minCustomer);
//        for(int i = 1; i <= randomCustomer; i++){
//        	customer = hairdresser.NewCustomer.create();
//        	store.add(new CustomerArrives(state, store, customer));
//        }
        start(); //kör alla event 	
       
    }
    //kï¿½r simulatorn som kï¿½r alla event

		
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
