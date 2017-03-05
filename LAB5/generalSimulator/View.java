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
	
	
	
	public void display(){
		
	}
	
	public abstract void startPrint();
	
	public abstract void stopPrint();
	
	
	
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
