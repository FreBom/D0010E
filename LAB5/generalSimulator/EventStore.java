package generalSimulator;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Observable;

/**
 * EventStore holds an Arraylist with events and different methods specified
 * below.
 * 
 * @author arostr-5@student.ltu.se, fanny, dexmo
 *
 *
 */
public class EventStore extends Observable {

	private ArrayList<Event> eventList = new ArrayList<Event>();// TODO varför
																// har vi en
																// eventlist här
																// och en i i
																// simulator,
																// lätt att
																// tappa bort
																// sig vilken
																// man menar?
																// Förslag: byt
																// namn på en av
																// dem.

	/**
	 * 
	 * @param e
	 *            is the event that will be added to the list. Note that this
	 *            add method will add two events in time order. and if they
	 *            occur at the same time they simply are added one after another
	 *            beased on when the add method is called.
	 */
	public void add(Event e) {

		for (int i = 0; i < eventList.size(); i++) {
			if (e.getTime() >= eventList.get(i).getTime()) {
				eventList.add(i, e);
			}

		}

	}

	/**
	 * calls the setChanged(); and notifyObservers(); methods.
	 * 
	 * @return the first element in the eventList.
	 * @throws NoSuchElementException
	 *             if the eventList is empty.
	 * 
	 */
	public Event first() {
		if (eventList.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			setChanged();
			notifyObservers();

			return eventList.get(0);
		}

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
		if (eventList.size() == 0) {
			return true;
		}
		return false;

	}

	public void clear() {
		eventList.clear();
	}

	/**
	 * 
	 * @param E
	 *            is the event that will be removed from the eventList
	 */
	public void remove(Event E) {
		for (int i = 0; i < eventList.size(); i++) {
			if (eventList.get(i) == E) {
				eventList.remove(i);
			}
		}

	}

	/**
	 * removes the first element at index 0 in the eventList
	 * 
	 * @throws NoSuchElementException
	 *             if the eventList is empty
	 * 
	 */
	public void removeFirst() {
		if (eventList.isEmpty()) {
			throw new NoSuchElementException();
		} else {
			eventList.remove(0);
		}
	}

}
