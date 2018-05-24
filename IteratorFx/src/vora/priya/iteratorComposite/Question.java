package vora.priya.iteratorComposite;

import java.util.Iterator;

public class Question extends QuizComponent {

	public String question;
	public String answer;

	@Override
	Iterator<QuizComponent> getChildIterator() {
		return new Iterator<QuizComponent>() {

			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public QuizComponent next() {
				return null;
			}
		};
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
