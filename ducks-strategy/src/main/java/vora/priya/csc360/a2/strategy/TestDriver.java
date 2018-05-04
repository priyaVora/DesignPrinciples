package vora.priya.csc360.a2.strategy;

import java.util.ArrayList;
import java.util.List;

public class TestDriver {
	// strategy pattern: do not have two tier/3 tier hierarchy , less repeats
	// when can i can behavior
	// Good: you can change duck zero's flying behavior
	//Though: if we want to add swimming property then we would have to change duck, we need new behavior called SwimmingBehavior
	//-----but have to change ducks class
	//---We want to follow open/close principles , Open to be extended, close for modifications
	//---we didn't change existing methods within the duck class 
	//---in child class we would have to change the definition: constructor
	

	public static void main(String[] args) {
		List<Duck> ducks = new ArrayList<Duck>();
		ducks.add(new MallerDuck());
		ducks.add(new SteamerDuck());

		for (Duck duck : ducks) {
			duck.getFlyingBehavior().fly();
		}

		ducks.get(0).setFlyingBehavior(new CannotFlyBehavior());
	}
}
