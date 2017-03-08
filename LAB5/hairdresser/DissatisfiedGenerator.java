package hairdresser;

import random.UniformRandomStream;
import hairdresser.HairdressState;

public class DissatisfiedGenerator {
	
	public final static double probDissatisfiedMin = 0.0;
	public final static double probDissatisfiedMax = 1.0;
	
	private UniformRandomStream disPro = new UniformRandomStream(probDissatisfiedMin, probDissatisfiedMax, HairdressState.seed);

	
	public boolean getDissatisfied() {
		 if(disPro.next() < HairdressState.probDissatisfied)  {
			 return true;
		 }
		return false;
			 		
	}
		
		
	}
	
	
	
	


