package Views;

import static constants.Constants.REMOVE;

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

public class RemoveAnswerView {
    private GridPane RemoveAnswer = new GridPane();
    private Label lblGetQuestionIDToRemove = new Label("What is the ID of the question you'd like to update?");
    private TextField tfGetQuestionIDToRemove = new TextField();
    private Button btnGetQuestionIDToRemove = new Button("Get");
    private Label lblEmptyField5 = new Label("This field cannot be empty");

    public GridPane getGPremoveAnswer() {
        return this.RemoveAnswer;
    }

    public void reset() {
        for (int i = 4; i < RemoveAnswer.getChildren().size(); i++) {
            RemoveAnswer.getChildren().get(i).setVisible(false);
        }
        tfGetQuestionIDToRemove.setText("");
        RemoveAnswer.setVisible(true);
    }

    public RemoveAnswerView() {
    	RemoveAnswer.setStyle("-fx-background-color: #AFDCEC	");
    	btnGetQuestionIDToRemove.setStyle("-fx-background-color: #eaf6fa; -fx-background-radius: 20;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
    	lblGetQuestionIDToRemove.setStyle("-fx-text-fill: #191970;-fx-font-size: 1.1em;");
    	RemoveAnswer.setPadding(new Insets(10));
        RemoveAnswer.setHgap(10);
        RemoveAnswer.setVgap(10);
        RemoveAnswer.add(lblGetQuestionIDToRemove, 1, 1);
        RemoveAnswer.add(tfGetQuestionIDToRemove, 2, 1);
        RemoveAnswer.add(btnGetQuestionIDToRemove, 3, 1);
        RemoveAnswer.add(lblEmptyField5, 1, 2);
        lblEmptyField5.setVisible(false);
        lblEmptyField5.setTextFill(Color.RED);

        lblGetQuestionIDToRemove.setVisible(true);
        tfGetQuestionIDToRemove.setVisible(true);
        btnGetQuestionIDToRemove.setVisible(true);

        btnGetQuestionIDToRemove.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                ToggleGroup tglOptions = new ToggleGroup();
                Label successLabel = new Label();
                Label lblText = new Label();
                lblText.setStyle("-fx-text-fill: #191970;-fx-font-size: 1.1em;");
                Button sendRemoveButton = new Button(REMOVE);
                sendRemoveButton.setStyle("-fx-background-color: #eaf6fa; -fx-background-radius: 20;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
                sendRemoveButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        Question quest = Manager.questionBankProvider().get(Integer.parseInt(tfGetQuestionIDToRemove.getText()) - 1);
                        for (Node node : RemoveAnswer.getChildren()) {
                            if (node instanceof RadioButton) {
                                if (((RadioButton) node).isSelected()) {
                                    int index = Manager.getIdByText(quest.getQuestionId(), ((RadioButton) node).getText());
                                    successLabel.setText(Manager.removeAnswerInWindow((quest.getQuestionId()), index));
                                    break;
                                }
                            }
                        }
                        successLabel.setTextFill(Color.GREEN);
                        successLabel.setVisible(true);
                    }
                });
                for (int i = 4; i < RemoveAnswer.getChildren().size(); i++) {
                    RemoveAnswer.getChildren().get(i).setVisible(false);
                }
                lblEmptyField5.setVisible(tfGetQuestionIDToRemove.getText().equals(""));
                if (!tfGetQuestionIDToRemove.getText().equals("")) {
                    RemoveAnswer.add(lblText, 1, 3);
                    Question quest = Manager.questionBankProvider().get(Integer.parseInt(tfGetQuestionIDToRemove.getText()) - 1);
                    int i = 0;
                    if (quest instanceof OpenEndQuestion) {
                        lblText.setText("Open end question answers may not be removed");
                    }
                    if (quest instanceof MultipleChoiceQuestion) {
                        lblText.setText("The question options available for removal:");
                        for (; i < ((MultipleChoiceQuestion) quest).getOptions().getSize(); i++) {
                            String optionText = ((MultipleChoiceQuestion) quest).getOptions().get(i).getOptionText();
                            RadioButton temp = new RadioButton(optionText);
                            temp.setToggleGroup(tglOptions);
                            RemoveAnswer.add(temp, 1, i + 4);
                        }
                        RemoveAnswer.add(sendRemoveButton, 1, i + 5);
                    }
                    RemoveAnswer.add(successLabel, 1, i + 6);
                }
            }
        });
        RemoveAnswer.setVisible(false);

    }
}
