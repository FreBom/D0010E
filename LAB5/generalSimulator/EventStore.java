package generalSimulator;

import java.awt.Event;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class EventStore {

	private ArrayList<Event> eventList = new ArrayList<Event>();

	public void add(Event E) {
		eventList.add(E);
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

	public Event first() {
		if (eventList.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return eventList.get(0);
		}
	}

	public void removeFirst() {
		if (eventList.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			eventList.remove(0);
		}
	}
	public String toString() {
		String out = "Queue: ";
		for(Object e : eventList) {
			out += "(" + e.toString() + ") ";
		}
		return out;
	}

}
