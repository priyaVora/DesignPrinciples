package vora.priya.iteratorComposite;

import java.util.ArrayList;
import java.util.Iterator;

public class TestDriver {

	public static void main(String[] args) {
		Category c = new Category();

		Question q = new Question();
		q.name = "Question One";
		q.question = "What is your name?";
		q.answer = "My name is Priya!";

		Question q2 = new Question();
		q2.name = "Question Two";
		q2.question = "How old are you?";
		q2.answer = "I am 20 years old!";

		ArrayList<QuizComponent> listOfQuizEntries = new ArrayList<QuizComponent>();

		listOfQuizEntries.add(q);
		listOfQuizEntries.add(q2);
		c.setQuizEntrikes(listOfQuizEntries);
		Iterator<QuizComponent> iterator = c.getQuizEntries().iterator();

		while (iterator.hasNext()) {
			iterator.next().print(); 
		}
	}

}
