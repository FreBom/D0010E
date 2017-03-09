package generalSimulator;

import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * EventStore holds an PriorityQueue with events that are sorted in falling order.
 * 
 * @author arostr-5@student.ltu.se, fanny, dexmo
 *
 */
public class EventStore {
	
	/**
	 * An internal comparison class which do the ordering and a class holding the EventStore
	 * 
	 * @author aronh@student.ltu.se, Fanny, Dexmo
	 */
	static class sortEvents implements Comparator<Event> {
		
		/**
		 * 
		 * @return positive integer if the first arguments is greater, or if less it returns a
		 * negative integer
		 */
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
	sortEvents sort = new sortEvents(); //	Get the Comparator and create a queue with initial size(x, and comparator)
	PriorityQueue<Event> eventList = new PriorityQueue<Event>(10, sort);
	/**
	 * 
	 * @param the given event to offer to the EventStore, offer instead of add ("lighter")
	 */
	public void add(Event e) {
		eventList.offer(e);

	}
	/**
	 * 
	 * @return the top event of the queue and removes it
	 */
	public Event getFirstAndRemove() {
		return eventList.poll();

	}

	/**
	 * 
	 * @return the eventLists size.
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
