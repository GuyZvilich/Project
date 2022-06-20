package views;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;

import static constants.Constants.STYLE_BLUE_DUO;

public class QuestionBankView {
    private ScrollPane QuestionBank = new ScrollPane();

    public ScrollPane getQuestionBank() {
        return this.QuestionBank;
    }

    public QuestionBankView() {
        QuestionBank.setPadding(new Insets(10));
        QuestionBank.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        QuestionBank.setVisible(false);
        QuestionBank.setStyle(STYLE_BLUE_DUO);


    }
}
