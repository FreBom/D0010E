package generalsimulator;

/**
 * 
 * @author Dexmo  
 * 			specific contents that describe the specific simulation. An
 *         event has an effect and a time when it should occur. The effect is
 *         coded as a method and it is when this method is called the event
 *         occurs. Note the difference between creating an event (an object) and
 *         making the event occur (calling the method in the object). The time
 *         of the event is computed by the code that creates the event (not the
 *         event itself) and transferred to the event when it is created. At the
 *         time of creation, the event also get references to the particular
 *         event store (see below for an explanation) that belongs to the
 *         simulation and the state it effects. Recall that apart from changing
 *         the state, an event might also create new, future, events. The effect
 *         an event has on the state depends on the code in the method, which is
 *         turn depends of the current state. Note that during a simulation, it
 *         is only code in events that may create new future events. As part of
 *         the general simulator we include a general event and a general stop
 *         event (a subclass of the general event) whose effect is just that it
 *         activates the emergency break. We also include a general start event.
 *         The last two types of events could be inherited and adapted to
 *         specific start and stop events that base their action also on the
 *         state of the specific simulation.
 *
 */
public class eventFactory {

}
