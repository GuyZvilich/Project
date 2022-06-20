package views;

import listeners.UIEventListener;

public interface AbstractView {
    void registerListener(UIEventListener listener);

    void showHomeView();

    void showQuestionBankView();

    void showAddQuestionView();

    void showUpdateQuestionView();

    void showUpdateAnswerView();

    void showRemoveAnswerView();

    void showManagedQuizView();

    void showRandomQuizView();

    void showCopyQuizView();

}
