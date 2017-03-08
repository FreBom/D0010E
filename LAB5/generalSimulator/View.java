package generalSimulator;

import java.util.Observable;
import java.util.Observer;
/**
 * 
 * @author arostr-5@student.ltu.se, fanny, dexmo
 *
 *
 */
public abstract class View implements Observer {
	
	State state;
	
	
	public View(State state){
		this.state = state;
	}
	
	public abstract void startPrint();
	
	public abstract void stopPrint();
	
	
	public void update(Observable o, Obj arg) {
		
		view();
		
	}


}
