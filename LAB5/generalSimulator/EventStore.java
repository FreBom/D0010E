package generalSimulator;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Observable;
/**
 * 
 * @author arostr-5@student.ltu.se, fanny, dexmo
 *
 *
 */
public class EventStore extends Observable {
	

	private ArrayList<Event> eventList = new ArrayList<Event>();

	public void add(Event e) {
		for(int i = 0; i < eventList.size() - 1; i++) {
			if(e.gettime() > eventList.get(i).gettime()) {
				eventList.add(i, e);
			}
			
		}
		
	}
	
	public Event first() {
		if (eventList.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			setChanged();
			notifyObservers();
			
			return eventList.get(0);
		}
		
	}

	public int size() {
		return eventList.size();
	}

	public boolean isEmpty() {
		if (eventList.size() == 0) {
			return true;
		}
		return false;

	}

	public void clear() {
		eventList.clear();
	}

	public void remove(Event E) {
		for (int i = 0; i < eventList.size(); i++) {
			if (eventList.get(i) == E) {
				eventList.remove(i);
			}
		}

	}

	public void removeFirst() {
		if (eventList.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			eventList.remove(0);
		}
	}
	

}
