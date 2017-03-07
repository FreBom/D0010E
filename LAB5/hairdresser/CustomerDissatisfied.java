package hairdresser;

import random.UniformRandomStream;
import hairdresser.HairdressState;

public class CustomerDissatisfied {
	
	private static double probDissatisfiedMin = 0.0;
	private static double probDissatisfiedMax = 1.0;
	
	private static UniformRandomStream disPro = new UniformRandomStream(probDissatisfiedMin, probDissatisfiedMax, HairdressState.seed);

	
	public static boolean getDissatisfied() {
		 if(disPro.next() < HairdressState.probDissatisfied)  {
			 return true;
		 }
		return false;
			 		
	}
		
		
	}
	
	
	
	


