package hairdresser;

import java.util.ArrayList;
/**
 * 
 * @author Dexmo ,Aron ,Fanny
 *
 */


public class FIFO extends generalSimulator.EventStore{
	private int numCustomers = 0;
	private int numLost = 0;
	
	private ArrayList<Customer> newCustomerQueue = new ArrayList<Customer>();
	private ArrayList<Customer> oldCustomerQueue = new ArrayList<Customer>();
	private ArrayList<Customer> customerGetHaircut = new ArrayList<Customer>();
	
	private int queueLength = hairdresser.HairdressState.getQueueLength(); //Vill s�tta den till antalet v�ntplatser fr�n metoden getQueueLength()
	private int numberOfChairs = hairdresser.HairdressState.getNumberOfChairs(); //Vill s�tta den till antalet platser fr�n metoden getNumberOfchairs()
	private boolean newCustomer;  //ska nog inte ligga h�r, alla objekt ska ha denna
	
	
	public int idle(){
		return numberOfChairs - customerGetHaircut.size();
	}
	

	
	public void add(Customer customer) {
		if(customerGetHaircut.size() == numberOfChairs){  //kollar om alla platser f�r klippning �r upptagna
			addQueue(customer);      //l�gger in i k� mha metoder addQueue()
			}
		else{
			customerGetHaircut.add(customer);	//om det finns n�gon plats ledig s� placeras kunden p� den
		}

	}
	
	
	public int numWaiting() {
		return (oldCustomerQueue.size() + newCustomerQueue.size());
	}
	
	public void removeLast(){
		newCustomerQueue.remove(-1);  //tar den bort den sista i listan?	
	}
	
	public void addQueue(Customer customer){
		if(this.newCustomer){  //ska �ndras, alla customers ska ha den boolska variablen
			numCustomers ++; //sparar antalet kunder
			if((oldCustomerQueue.size() + newCustomerQueue.size()) == queueLength){ //kollar om k�n �r full, om den �r det f�rloras kunden
				numLost ++;
			}
			else{  								//om k�n inte �r full l�ggs den nya kunden till i k�n newCustomerQueue
				this.newCustomer = false;
				newCustomerQueue.add(customer); //l�gga in sist i listan av alla nya kunder
			}
		}
		
		else{
			if((oldCustomerQueue.size() + newCustomerQueue.size()) == queueLength){ //kollar om k�n �r full  FUNDERING: Om k�n �r full och ALLA �r missn�jda kunder. Vad h�nder d� n�r man f�rs�ker placera in en till missn�jd kund?
				removeLast();     //tar bort den sista i k�n f�r att kunna placera in den missn�jda kunden
				numLost ++;
			}
			oldCustomerQueue.add(customer);//l�gga in sist av alla missn�jda kunder
		
		}
	}
	/**
	 * 
	 * @param readyCustomer
	 */
	public void addGetHaircut(Customer readyCustomer){  //kallas p� n�r en kund g�r och en plats blir ledig
		for(int i = 0; i < customerGetHaircut.size() ; i++ ){  //kollar igenom listan f�r dem som klipper sig, tar bort den som var klar ur den listan
			if(customerGetHaircut.get(i) == readyCustomer){
				customerGetHaircut.remove(i);
			}
		}
		int i = 1;  //platsen som �r ledig
		Customer customerInQueue;
		if(oldCustomerQueue.size() >= i){  //kollar f�rst om det finns n�gra gamla kunder
			customerInQueue = oldCustomerQueue.get(i);
			customerGetHaircut.add(customerInQueue);
			oldCustomerQueue.remove(i); //tar bort kunden som nu f�r klippning fr�n oldCustomerQueue
		}
		else if(newCustomerQueue.size() >= i){  //ifall det inte fanns n�gra gamla kunder i k�n, kollar man om det finns nyga kunder i k�
			customerInQueue = newCustomerQueue.get(i); //b�rjar kolla fr�n f�rsta i listan i newCustomer. Om det fanns en oldcustomer i k�n
			customerGetHaircut.add(customerInQueue);
			newCustomerQueue.remove(i);	//tar bort kunden som nu f�r klippning fr�n newCustomerQueue
		}	
	}
	
}
