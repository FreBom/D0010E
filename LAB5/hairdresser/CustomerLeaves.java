package hairdresser;

import java.awt.Event;

import hairdresserState.Customer;

public class CustomerLeaves extends hairdresser.FIFO {
	
	private boolean dissatisfied;

	public CustomerLeaves(Customer readyCustomer, Event state ,int time){  //vet inte riktigt vad som ska st� h�r �n
		addGetHaircut(readyCustomer);  //tar bort den som l�mnat ur k�n f�r de som klipper sig, och g�r s� att det som st�r f�rst i k�n kan klippa sig
		
		
	}
}
