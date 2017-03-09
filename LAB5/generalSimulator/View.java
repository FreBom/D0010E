package generalSimulator;

import java.util.Observer;
/**
 * View displays the state data, the entire simulation
 * 
 * @author arostr-5@, fanny, dexmo
 *
 */
public abstract class View implements Observer {
	
	/**
	 * The view needs specified state to get access to datas
	 * 
	 * @param state given by the user
	 */
	public View(State state){

	}
	/**
	 * Making sure the methods is used by the specific view (OPTIONAL)
	 * 
	 */
	public abstract void startPrint();
	public abstract void stopPrint();
	

	

}
