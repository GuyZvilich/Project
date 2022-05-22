package entities.comparators;

import entities.questions.Question;

import java.util.Comparator;

public class compareByAnswerLength implements Comparator<Question>{

	@Override
	public int compare(Question q1, Question q2) {
		return Integer.compare(q1.getAnswerLength(), q2.getAnswerLength());
	}

}
