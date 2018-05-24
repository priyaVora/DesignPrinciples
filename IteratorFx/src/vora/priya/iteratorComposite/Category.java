package vora.priya.iteratorComposite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Category extends QuizComponent{	
	List<QuizComponent> quizEntries = new ArrayList<>();
	
	@Override
	Iterator<QuizComponent> getChildIterator() {
		System.out.println(this.name + "\r\n---------------------------\r\n");
		this.quizEntries.sort((l,r) -> (l instanceof Question ? -1 : 1));
		Iterator<QuizComponent> entryIterator = this.quizEntries.iterator();
		while(entryIterator.hasNext()) { 
			QuizComponent component = entryIterator.next();
			System.out.println(component.name);
		}
		return entryIterator;
	}
	
	public List<QuizComponent> getQuizEntries() {
		return quizEntries;
	}

	public void setQuizEntries(List<QuizComponent> quizEntries) {
		this.quizEntries = quizEntries;
	}
}
