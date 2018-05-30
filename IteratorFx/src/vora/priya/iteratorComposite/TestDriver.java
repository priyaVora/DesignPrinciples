package vora.priya.iteratorComposite;

import java.util.ArrayList;
import java.util.Iterator;

public class TestDriver {

	public static void main(String[] args) {
		Category c = new Category();
		Category section = new Category();
		section.name = "\nNew Section";
		ArrayList<QuizComponent> listOfQuestions = new ArrayList<QuizComponent>();

		Question q = new Question();
		q.name = "Question One";
		q.question = "What is your name?";
		q.answer = "My name is Priya!";

		Question q2 = new Question();
		q2.name = "Question Two";
		q2.question = "How old are you?";
		q2.answer = "I am 20 years old!";

		Question q3 = new Question();
		q3.name = "Question Three";
		q3.question = "How tall are you?";
		q3.answer = "I am 5 feet tall.";

		Question q4 = new Question();
		q4.name = "Question Four";
		q4.question = "How much do you weight?";
		q4.answer = "I weigh 90lbs.";

		Question q5 = new Question();
		q5.name = "Question Five";
		q5.question = "Where are you?";
		q5.answer = "I am at home.";

		listOfQuestions.add(q3);
		listOfQuestions.add(q4);
		listOfQuestions.add(q5);
		section.setQuizEntrikes(listOfQuestions);

		ArrayList<QuizComponent> listOfQuizEntries = new ArrayList<QuizComponent>();

		listOfQuizEntries.add(q);
		listOfQuizEntries.add(q2);
		listOfQuizEntries.add(section);
		c.setQuizEntrikes(listOfQuizEntries);

		Iterator<QuizComponent> iterator = c.getQuizEntries().iterator();

		while (iterator.hasNext()) {
			iterator.next().print();
		}
	}

}
