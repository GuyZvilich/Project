package Views;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;

public class QuestionBankView {
    private ScrollPane QuestionBank = new ScrollPane();

    public ScrollPane getQuestionBank() {
        return this.QuestionBank;
    }

    public QuestionBankView() {
        QuestionBank.setPadding(new Insets(10));
        QuestionBank.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        QuestionBank.setVisible(false);
        QuestionBank.setStyle("-fx-color: #1aa7ff;-fx-background: #ADDFFF");


    }
}
