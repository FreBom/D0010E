package hairdresser;

import java.awt.Event;

import hairdresserState.Customer;

public class CustomerLeaves extends hairdresser.FIFO {
	
	private boolean dissatisfied;

	public CustomerLeaves(Customer readyCustomer, Event state ,int time){  //vet inte riktigt vad som ska stå här än
		addGetHaircut(readyCustomer);  //tar bort den som lämnat ur kön för de som klipper sig, och gör så att det som står först i kön kan klippa sig
		
		
	}
}
