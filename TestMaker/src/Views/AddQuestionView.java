package Views;

import static constants.Constants.QUESTION_TO_USER_03_2;
import static constants.Constants.SUCCESS_MESSAGE_01;
import static constants.Constants.UPDATE;
import static constants.Constants.answerNumberX;
import static entities.Manager.isMoreThanOneCorrect;
import static entities.Manager.isNoneCorrect;

import entities.Manager;
import entities.Set;
import entities.questions.MultipleChoiceOption;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class AddQuestionView {
    private BorderPane addQuestion = new BorderPane();
    private Label lblwhatQuestion = new Label("What is the question?");
    private TextField tfwhatQuestion = new TextField();
    private Label lblwhatAnswer = new Label("What is the answer?");
    private TextField tfwhatAnswer = new TextField();
    private Label lblanswer1 = new Label(answerNumberX(1));
    private Label lblanswer2 = new Label(answerNumberX(2));
    private Label lblanswer3 = new Label(answerNumberX(3));
    private Label lblanswer4 = new Label(answerNumberX(4));
    private Label lblanswer5 = new Label(answerNumberX(5));
    private Label lblanswer6 = new Label(answerNumberX(6));
    private Label lblanswer7 = new Label(answerNumberX(7));
    private Label lblanswer8 = new Label(answerNumberX(8));
    private TextField tfanswer1 = new TextField();
    private TextField tfanswer2 = new TextField();
    private TextField tfanswer3 = new TextField();
    private TextField tfanswer4 = new TextField();
    private TextField tfanswer5 = new TextField();
    private TextField tfanswer6 = new TextField();
    private TextField tfanswer7 = new TextField();
    private TextField tfanswer8 = new TextField();
    private CheckBox cbAnswer1 = new CheckBox();
    private CheckBox cbAnswer2 = new CheckBox();
    private CheckBox cbAnswer3 = new CheckBox();
    private CheckBox cbAnswer4 = new CheckBox();
    private CheckBox cbAnswer5 = new CheckBox();
    private CheckBox cbAnswer6 = new CheckBox();
    private CheckBox cbAnswer7 = new CheckBox();
    private CheckBox cbAnswer8 = new CheckBox();
    private Label lblIsTrue1 = new Label(QUESTION_TO_USER_03_2);
    private Label lblIsTrue2 = new Label(QUESTION_TO_USER_03_2);
    private Label lblIsTrue3 = new Label(QUESTION_TO_USER_03_2);
    private Label lblIsTrue4 = new Label(QUESTION_TO_USER_03_2);
    private Label lblIsTrue5 = new Label(QUESTION_TO_USER_03_2);
    private Label lblIsTrue6 = new Label(QUESTION_TO_USER_03_2);
    private Label lblIsTrue7 = new Label(QUESTION_TO_USER_03_2);
    private Label lblIsTrue8 = new Label(QUESTION_TO_USER_03_2);
    private Label lblVerdict = new Label();
    private Button btnSendNewQuestion = new Button(UPDATE);
    private Button btnNewMultiOptions = new Button(UPDATE);

    public BorderPane getBPaddQuestion() {
        return this.addQuestion;
    }

    public void reset() {
        textClear();
        lblVerdict.setVisible(false);
    }

    private void textClear() {
        tfwhatQuestion.setText("");
        tfwhatAnswer.setText("");
        tfanswer1.setText("");
        tfanswer2.setText("");
        tfanswer3.setText("");
        tfanswer4.setText("");
        tfanswer5.setText("");
        tfanswer6.setText("");
        tfanswer7.setText("");
        tfanswer8.setText("");
    }

    private void setVisibilityFor8(boolean val) {
        lblanswer1.setVisible(val);
        lblanswer2.setVisible(val);
        lblanswer3.setVisible(val);
        lblanswer4.setVisible(val);
        lblanswer5.setVisible(val);
        lblanswer6.setVisible(val);
        lblanswer7.setVisible(val);
        lblanswer8.setVisible(val);

        tfanswer1.setVisible(val);
        tfanswer2.setVisible(val);
        tfanswer3.setVisible(val);
        tfanswer4.setVisible(val);
        tfanswer5.setVisible(val);
        tfanswer6.setVisible(val);
        tfanswer7.setVisible(val);
        tfanswer8.setVisible(val);

        cbAnswer1.setVisible(val);
        cbAnswer2.setVisible(val);
        cbAnswer3.setVisible(val);
        cbAnswer4.setVisible(val);
        cbAnswer5.setVisible(val);
        cbAnswer6.setVisible(val);
        cbAnswer7.setVisible(val);
        cbAnswer8.setVisible(val);

        lblIsTrue1.setVisible(val);
        lblIsTrue2.setVisible(val);
        lblIsTrue3.setVisible(val);
        lblIsTrue4.setVisible(val);
        lblIsTrue5.setVisible(val);
        lblIsTrue6.setVisible(val);
        lblIsTrue7.setVisible(val);
        lblIsTrue8.setVisible(val);
    }

    public AddQuestionView() {
        addQuestion.setVisible(false);
        addQuestion.setPadding(new Insets(10));
        Button btnOpenQuestion = new Button("Open end question");
        Button btnMultiQuestion = new Button("multi-optional question");
        HBox typeQuestion = new HBox();
        typeQuestion.setPadding(new Insets(10));
        typeQuestion.getChildren().addAll(btnOpenQuestion, btnMultiQuestion);
        addQuestion.setTop(typeQuestion);
        BorderPane gettingQuestionMulti = new BorderPane();
        addQuestion.setTop(typeQuestion);
        addQuestion.setCenter(gettingQuestionMulti);
        GridPane gettingQuestionAnswers = new GridPane();
        gettingQuestionMulti.setCenter(gettingQuestionAnswers);
        gettingQuestionAnswers.setVgap(10);
        gettingQuestionAnswers.setHgap(10);
        btnSendNewQuestion.setVisible(false);
        btnNewMultiOptions.setVisible(false);
        Label lblEmptyField2 = new Label("One of the required fields are empty");
        lblEmptyField2.setVisible(false);
        lblEmptyField2.setPadding(new Insets(10));
        lblEmptyField2.setTextFill(Color.RED);
        lblwhatQuestion.setVisible(false);
        tfwhatQuestion.setVisible(false);
        lblwhatAnswer.setVisible(false);
        tfwhatAnswer.setVisible(false);
        setVisibilityFor8(false);

        gettingQuestionAnswers.add(lblwhatQuestion, 1, 1);
        gettingQuestionAnswers.add(tfwhatQuestion, 2, 1);
        gettingQuestionAnswers.add(lblwhatAnswer, 1, 2);
        gettingQuestionAnswers.add(tfwhatAnswer, 2, 2);
        gettingQuestionAnswers.add(lblanswer1, 1, 2);
        gettingQuestionAnswers.add(tfanswer1, 2, 2);
        gettingQuestionAnswers.add(lblIsTrue1, 3, 2);
        gettingQuestionAnswers.add(cbAnswer1, 4, 2);
        gettingQuestionAnswers.add(lblanswer2, 1, 3);
        gettingQuestionAnswers.add(tfanswer2, 2, 3);
        gettingQuestionAnswers.add(lblIsTrue2, 3, 3);
        gettingQuestionAnswers.add(cbAnswer2, 4, 3);
        gettingQuestionAnswers.add(lblanswer3, 1, 4);
        gettingQuestionAnswers.add(tfanswer3, 2, 4);
        gettingQuestionAnswers.add(lblIsTrue3, 3, 4);
        gettingQuestionAnswers.add(cbAnswer3, 4, 4);
        gettingQuestionAnswers.add(lblanswer4, 1, 5);
        gettingQuestionAnswers.add(tfanswer4, 2, 5);
        gettingQuestionAnswers.add(lblIsTrue4, 3, 5);
        gettingQuestionAnswers.add(cbAnswer4, 4, 5);
        gettingQuestionAnswers.add(lblanswer5, 1, 6);
        gettingQuestionAnswers.add(tfanswer5, 2, 6);
        gettingQuestionAnswers.add(lblIsTrue5, 3, 6);
        gettingQuestionAnswers.add(cbAnswer5, 4, 6);
        gettingQuestionAnswers.add(lblanswer6, 1, 7);
        gettingQuestionAnswers.add(tfanswer6, 2, 7);
        gettingQuestionAnswers.add(lblIsTrue6, 3, 7);
        gettingQuestionAnswers.add(cbAnswer6, 4, 7);
        gettingQuestionAnswers.add(lblanswer7, 1, 8);
        gettingQuestionAnswers.add(tfanswer7, 2, 8);
        gettingQuestionAnswers.add(lblIsTrue7, 3, 8);
        gettingQuestionAnswers.add(cbAnswer7, 4, 8);
        gettingQuestionAnswers.add(lblanswer8, 1, 9);
        gettingQuestionAnswers.add(tfanswer8, 2, 9);
        gettingQuestionAnswers.add(lblIsTrue8, 3, 9);
        gettingQuestionAnswers.add(cbAnswer8, 4, 9);
        gettingQuestionAnswers.add(lblVerdict, 2, 10);
        gettingQuestionAnswers.add(btnSendNewQuestion, 2, 13);
        gettingQuestionAnswers.add(btnNewMultiOptions, 2, 13);
        gettingQuestionAnswers.add(lblEmptyField2, 0, 14);
        gettingQuestionAnswers.setColumnSpan(lblEmptyField2, 12);
        gettingQuestionMulti.setCenter(gettingQuestionAnswers);
        addQuestion.setCenter(gettingQuestionMulti);
        btnOpenQuestion.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                for (int i = 0; i < gettingQuestionAnswers.getChildren().size(); i++)
                    gettingQuestionAnswers.getChildren().get(i).setVisible(false);

                textClear();
                lblwhatQuestion.setVisible(true);
                tfwhatQuestion.setVisible(true);
                lblwhatAnswer.setVisible(true);
                tfwhatAnswer.setVisible(true);
                btnSendNewQuestion.setVisible(true);
                btnSendNewQuestion.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent arg0) {
                        lblEmptyField2.setVisible(tfwhatQuestion.getText().equals("") || tfwhatAnswer.getText().equals(""));
                        String verdict = Manager.addOpenEndToBank(tfwhatQuestion.getText(), tfwhatAnswer.getText());
                        lblVerdict.setText(verdict);
                        if (verdict.equals(SUCCESS_MESSAGE_01))
                            lblVerdict.setTextFill(Color.GREEN);
                        else
                            lblVerdict.setTextFill(Color.RED);
                        lblVerdict.setVisible(true);


                    }
                });

            }

        });

        btnMultiQuestion.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                for (int i = 0; i < gettingQuestionAnswers.getChildren().size(); i++)
                    gettingQuestionAnswers.getChildren().get(i).setVisible(false);

                textClear();
                lblwhatQuestion.setVisible(true);
                tfwhatQuestion.setVisible(true);
                setVisibilityFor8(true);

                btnNewMultiOptions.setVisible(true);
                btnNewMultiOptions.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent arg0) {
                        boolean AnswerFilled = false;

                        AnswerFilled = !tfanswer1.getText().equals("") || !tfanswer2.getText().equals("") || !tfanswer3.getText().equals("") || !tfanswer4.getText().equals("") || !tfanswer5.getText().equals("") || !tfanswer6.getText().equals("") || !tfanswer7.getText().equals("") || !tfanswer8.getText().equals("");
                        lblEmptyField2.setVisible(tfwhatQuestion.getText().equals("") || !(AnswerFilled));

                        Set<MultipleChoiceOption> set = new Set<>(MultipleChoiceOption.class);

                        MultipleChoiceOption choice1;
                        if (!tfanswer1.getText().equals("")) {
                            choice1 = new MultipleChoiceOption(tfanswer1.getText(), cbAnswer1.isSelected());
                            set.add(choice1);
                        }

                        MultipleChoiceOption choice2;
                        if (!tfanswer2.getText().equals("")) {
                            choice2 = new MultipleChoiceOption(tfanswer2.getText(), cbAnswer2.isSelected());
                            set.add(choice2);
                        }

                        MultipleChoiceOption choice3;
                        if (!tfanswer3.getText().equals("")) {
                            choice3 = new MultipleChoiceOption(tfanswer3.getText(), cbAnswer3.isSelected());
                            set.add(choice3);

                        }

                        MultipleChoiceOption choice4;
                        if (!tfanswer4.getText().equals("")) {
                            choice4 = new MultipleChoiceOption(tfanswer4.getText(), cbAnswer4.isSelected());
                            set.add(choice4);
                        }

                        MultipleChoiceOption choice5;
                        if (!tfanswer5.getText().equals("")) {
                            choice5 = new MultipleChoiceOption(tfanswer5.getText(), cbAnswer5.isSelected());
                            set.add(choice5);
                        }

                        MultipleChoiceOption choice6;
                        if (!tfanswer6.getText().equals("")) {
                            choice6 = new MultipleChoiceOption(tfanswer6.getText(), cbAnswer6.isSelected());
                            set.add(choice6);
                        }

                        MultipleChoiceOption choice7;
                        if (!tfanswer7.getText().equals("")) {
                            choice7 = new MultipleChoiceOption(tfanswer7.getText(), cbAnswer7.isSelected());
                            set.add(choice7);
                        }

                        MultipleChoiceOption choice8;
                        if (!tfanswer8.getText().equals("")) {
                            choice8 = new MultipleChoiceOption(tfanswer8.getText(), cbAnswer8.isSelected());
                            set.add(choice8);
                        }

                        set.add(new MultipleChoiceOption("More than one answer is correct", isMoreThanOneCorrect(set)));
                        set.add(new MultipleChoiceOption("None of the above", isNoneCorrect(set)));

                        String verdict = Manager.addMultiChoiceToBank(tfwhatQuestion.getText(), set);
                        lblVerdict.setText(verdict);
                        if (verdict.equals(SUCCESS_MESSAGE_01))
                            lblVerdict.setTextFill(Color.GREEN);
                        else
                            lblVerdict.setTextFill(Color.RED);
                        lblVerdict.setVisible(true);


                    }
                });

            }
        });

    }
}
