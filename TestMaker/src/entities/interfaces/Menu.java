package entities.interfaces;

public interface Menu {
    void displayQuestionBank();
    void addToQuestionBank();
    void updateTextWording();
    void updateAnswerWording();
    void removeAnswer();
    void makeManagedQuiz();
    void makeRandomQuiz();
    void makeCopyQuiz();

}
