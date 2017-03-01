package generalsimulator;
import java.awt.Event;
import java.util.ArrayList;

public class EventStore  {
	
	private ArrayList<Event> eventList = new ArrayList<Event>();
	
	public void add(Event E){
		eventList.add(E);
	}
	
	public int size(){
		return eventList.size();
	}
	
	public boolean isEmpty(){
		if (eventList.size() == 0){
			return true;
		}
		return false;
		
	}
	
	public void clear(){
		for(int i = 0 ; i < eventList.size() ; i++){
			eventList.remove(i);
		}
	}
	
	public void remove(Event E){
		for(int i = 0 ; i < eventList.size() ; i++){
			if(eventList.get(i) == E){
				eventList.remove(i);
			}
		}
		
		
	}
	
	public Event first(){
		return eventList.get(0);
	}
	
	public void removeFirst(){
		eventList.remove(0);
	}

}

