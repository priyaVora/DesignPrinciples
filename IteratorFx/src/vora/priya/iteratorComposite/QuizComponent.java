package vora.priya.iteratorComposite;

import java.util.Iterator;

public abstract class QuizComponent {

	public String name;
	abstract Iterator<QuizComponent> getChildIterator();
	public abstract void print();
}
