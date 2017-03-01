package generalsimulator;

import java.util.Observable;

public  abstract class GeneralEvent extends Observable {
	public abstract int time();
	public  abstract String toString();

}
