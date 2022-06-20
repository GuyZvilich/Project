package controllers;

import listeners.UIEventListener;
import views.AbstractView;


public class TestMakerController implements UIEventListener {
    private AbstractView tmView;


    public TestMakerController(AbstractView view) {
        tmView = view;
        tmView.registerListener(this);

    }

    @Override
    public void showHome() {
        tmView.showHomeView();
    }

    @Override
    public void showQuestionBank() {
        tmView.showQuestionBankView();
    }

    @Override
    public void showAddQuestion() {
        tmView.showAddQuestionView();
    }

    @Override
    public void showUpdateQuestion() {
        tmView.showUpdateQuestionView();
    }

    @Override
    public void showUpdateAnswer() {
        tmView.showUpdateAnswerView();
    }

    @Override
    public void showRemoveAnswer() {
        tmView.showRemoveAnswerView();
    }

    @Override
    public void showManagedQuiz() {
        tmView.showManagedQuizView();
    }

    @Override
    public void showRandomQuiz() {
        tmView.showRandomQuizView();
    }

    @Override
    public void showCopyQuiz() {
        tmView.showCopyQuizView();
    }
}
