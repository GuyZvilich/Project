package Views;

import static constants.Constants.QUESTION_TO_USER_05_5;
import static constants.Constants.QUESTION_TO_USER_08;
import static constants.Constants.UPDATE;

import entities.Manager;
import entities.questions.MultipleChoiceQuestion;
import entities.questions.OpenEndQuestion;
import entities.questions.Question;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class UpdateAnswerView {
    private GridPane UpdateAnswer = new GridPane();
    private Label lblGetQuestionIDForAnswer = new Label(QUESTION_TO_USER_08);
    private TextField tfGetQuestionIDForAnswer = new TextField();
    private Button btnGetQuestionIDForAnswer = new Button("Get");
    private Label lblEmptyField4 = new Label("One of the required fields are empty");

    private String style = "-fx-text-fill: #191970;-fx-font-size: 1.1em;";

    public GridPane getGPupdateAnswer() {
        return this.UpdateAnswer;
    }

    public void reset() {
        for (int i = 4; i < UpdateAnswer.getChildren().size(); i++) {
            UpdateAnswer.getChildren().get(i).setVisible(false);
        }
        tfGetQuestionIDForAnswer.setText("");
        UpdateAnswer.setVisible(true);
    }

    public UpdateAnswerView() {
        UpdateAnswer.setStyle("-fx-background-color: #AFDCEC	");
        btnGetQuestionIDForAnswer.setStyle("-fx-background-color: #eaf6fa; -fx-background-radius: 20;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
        lblGetQuestionIDForAnswer.setStyle("-fx-text-fill: #191970;-fx-font-size: 1.1em;");
        UpdateAnswer.setPadding(new Insets(10));
        UpdateAnswer.setVgap(10);
        UpdateAnswer.setHgap(10);
        UpdateAnswer.add(lblGetQuestionIDForAnswer, 1, 1);
        UpdateAnswer.add(tfGetQuestionIDForAnswer, 2, 1);
        UpdateAnswer.add(btnGetQuestionIDForAnswer, 3, 1);
        UpdateAnswer.add(lblEmptyField4, 1, 2);

        lblEmptyField4.setTextFill(Color.RED);
        lblEmptyField4.setVisible(false);

        lblGetQuestionIDForAnswer.setVisible(true);
        tfGetQuestionIDForAnswer.setVisible(true);
        btnGetQuestionIDForAnswer.setVisible(true);
        lblEmptyField4.setVisible(false);
        lblEmptyField4.setTextFill(Color.RED);

        btnGetQuestionIDForAnswer.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                ToggleGroup tglOptions = new ToggleGroup();
                TextField textFieldAnswer = new TextField();
                Label successLabel = new Label();
                Button sendButton = new Button(UPDATE);
                sendButton.setStyle("-fx-background-color: #eaf6fa; -fx-background-radius: 20;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
                sendButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if(!textFieldAnswer.getText().equals("")){
                            Question quest = Manager.questionBankProvider().get(Integer.parseInt(tfGetQuestionIDForAnswer.getText()) - 1);
                            int opt = 0;
                            if (quest instanceof MultipleChoiceQuestion) {
                                for (Node node : UpdateAnswer.getChildren()) {
                                    if (node instanceof RadioButton) {
                                        opt++;
                                        if (((RadioButton) node).isSelected())
                                            successLabel.setText(Manager.updateQuestionAnswerInWindow((quest.getQuestionId()), opt, textFieldAnswer.getText()));
                                    }
                                }
                            } else {
                                successLabel.setText(Manager.updateQuestionAnswerInWindow((quest.getQuestionId()), opt, textFieldAnswer.getText()));
                            }
                            successLabel.setTextFill(Color.GREEN);
                        } else {
                            successLabel.setText("The answer may not be empty");
                            successLabel.setTextFill(Color.RED);
                        }
                        successLabel.setVisible(true);

                    }
                });
                for (int i = 4; i < UpdateAnswer.getChildren().size(); i++) {
                    UpdateAnswer.getChildren().get(i).setVisible(false);
                }
                lblEmptyField4.setVisible(tfGetQuestionIDForAnswer.getText().equals(""));
                if (!tfGetQuestionIDForAnswer.getText().equals("")) {
                    if (Manager.isNumeric(tfGetQuestionIDForAnswer.getText())) {
                        Question quest = Manager.questionBankProvider().get(Integer.parseInt(tfGetQuestionIDForAnswer.getText()) - 1);
                        int i = 0;
                        if (quest instanceof OpenEndQuestion) {
                            Label ans = new Label("The answer to the question is:");
                            ans.setStyle(style);
                            UpdateAnswer.add(ans, 1, 3);
                            Label right = new Label(((OpenEndQuestion) quest).getRightAnswer());
                            right.setStyle(style);
                            UpdateAnswer.add(right, 1, 4);
                        }
                        if (quest instanceof MultipleChoiceQuestion) {
                            UpdateAnswer.add(new Label("The answer options to the question are:"), 1, 3);
                            for (; i < ((MultipleChoiceQuestion) quest).getOptions().getSize(); i++) {
                                String optionText = ((MultipleChoiceQuestion) quest).getOptions().get(i).getOptionText();
                                RadioButton temp = new RadioButton(optionText);
                                temp.setToggleGroup(tglOptions);
                                UpdateAnswer.add(temp, 1, i + 4);
                            }
                        }
                        Label info = new Label(QUESTION_TO_USER_05_5);
                        info.setStyle(style);
                        UpdateAnswer.add(info, 1, i + 5);
                        UpdateAnswer.add(textFieldAnswer, 2, i + 5);
                        UpdateAnswer.add(sendButton, 3, i + 5);
                        UpdateAnswer.add(successLabel, 1, i + 6);
                    }
                }
            }
        });
        UpdateAnswer.setVisible(false);
    }
}
