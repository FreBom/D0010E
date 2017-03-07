package generalSimulator;

import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * EventStore holds an Arraylist with events and different methods specified
 * below.
 * 
 * @author arostr-5@student.ltu.se, fanny, dexmo
 *
 *
 */
public class EventStore {

	static class sortEvents implements Comparator<Event> {

		public int compare(Event e1, Event e2) {
			if (e1.getTime() < e2.getTime()) {
				return -1;
			}
			if (e1.getTime() > e2.getTime()) {
				return +1;
			} else {
				return 0;
			}

		}
	}

	sortEvents sort = new sortEvents();
	PriorityQueue<Event> eventList = new PriorityQueue<Event>(sort);

	public void add(Event e) {
		eventList.offer(e);

	}

	public Event first() {
		return eventList.poll();

	}

	/**
	 * 
	 * @return the eventLists length.
	 */
	public int size() {
		return eventList.size();
	}

	/**
	 * 
	 * @return <b> true </b> if empty else <b>false</b>
	 */
	public boolean isEmpty() {
		return eventList.size() == 0 ? true : false;

	}
}
