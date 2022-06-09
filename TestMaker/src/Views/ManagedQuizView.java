package Views;

import entities.Set;
import entities.questions.MultipleChoiceOption;
import entities.questions.MultipleChoiceQuestion;
import entities.questions.OpenEndQuestion;
import entities.questions.Question;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import static entities.Manager.*;

public class ManagedQuizView {
    private GridPane userManaged = new GridPane();
    private ScrollPane managedQuizPresenter = new ScrollPane();

    private ScrollPane listOfQuestions = new ScrollPane();
    private GridPane questionWording = new GridPane();
    private Label questionState = new Label();
    private Button btnGenerate = new Button("Generate");
    private Button btnSendQuestionOn = new Button("Add To Quiz");

    public GridPane getUserManaged() {
        return userManaged;
    }

    public ScrollPane getManagedQuizPresenter() {
        return managedQuizPresenter;
    }

    public ManagedQuizView() {
        Button btnGetQuestion = new Button("Get");

        btnGetQuestion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String index = null;
                questionWording.getChildren().clear();
                for (Node node : userManaged.getChildren()) {
                    if (node instanceof ComboBox) {
                        index = (String) ((ComboBox<?>) node).getValue();
                    }
                }
                if (index != null)
                    index = index.replace("Question ", "");
                else
                    index = "0";

                String verdict;
                if (index.equals("0")) {
                    verdict = "No Question Selected";
                    questionState.setText(verdict);
                    questionState.setVisible(true);
                } else {
                    questionState.setText(null);
                    questionState.setVisible(false);
                }

                if (!questionState.isVisible()) {
                    Question question = questionBankProvider().get(Integer.parseInt(index) - 1);
                    Label questionText = new Label("Question: " + question.getText());
                    if (question instanceof OpenEndQuestion) {
                        questionWording.add(questionText, 1, 1);
                        questionWording.add(new Label("Answer: " + ((OpenEndQuestion) question).getRightAnswer()), 1, 2);
                    }
                    if (question instanceof MultipleChoiceQuestion) {
                        questionWording.add(questionText, 1, 1);
                        questionWording.add(new Label("Answers:"), 1, 2);
                        int i = 3;
                        for (MultipleChoiceOption mco : ((MultipleChoiceQuestion) question).getOptions().getSet())
                            if (mco != null) {
                                questionWording.add(new CheckBox(mco.getOptionText()), 1, i);
                                i++;
                            }
                    }
                    questionWording.setVisible(true);
                    btnSendQuestionOn.setVisible(true);
                }
            }
        });
        btnSendQuestionOn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnGenerate.setVisible(true);
                listOfQuestions.setVisible(true);

                String index = null;
                for (Node node : userManaged.getChildren()) {
                    if (node instanceof ComboBox) {
                        index = (String) ((ComboBox<?>) node).getValue();
                    }
                }
                index = index.replace("Question ", "");
                Question question = questionBankProvider().get(Integer.parseInt(index) - 1);
                String content = "";
                if (question instanceof OpenEndQuestion) {
                    windowAddQuestion(question);
                }
                if (question instanceof MultipleChoiceQuestion) {
                    Set<MultipleChoiceOption> set = new Set(MultipleChoiceOption.class);
                    int i = 0;
                    for (Node node : questionWording.getChildren()) {
                        if (node instanceof CheckBox) {
                            if (((CheckBox) node).isSelected())
                                set.add(((MultipleChoiceQuestion) question).getOptions().get(i));
                            i++;
                        }
                    }
                    windowAddQuestion(new MultipleChoiceQuestion(question.getText(), set));
                }
                if (listOfQuestions.getContent() != null) {
                    Node node = listOfQuestions.getContent();
                    if (node instanceof Label)
                        content = ((Label) node).getText();
                }
                listOfQuestions.setContent(new Label(content + "\nQuestion " + question.getQuestionId()));

            }
        });
        btnGenerate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label Quiz = new Label(createManagedWindowQuiz().toString());
                managedQuizPresenter.setContent(Quiz);
                managedQuizPresenter.setVisible(true);
            }
        });

        managedQuizPresenter.setPadding(new Insets(10));
        managedQuizPresenter.setVisible(false);
        managedQuizPresenter.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        userManaged.setPadding(new Insets(10));
        userManaged.setHgap(10);
        userManaged.setVgap(10);
        userManaged.add(new Label("Choose a Question:"), 1, 1);
        userManaged.add(new ComboBox<String>(), 1, 2);
        userManaged.add(btnGetQuestion, 1, 3);
        userManaged.add(questionState, 3, 1);
        userManaged.add(questionWording, 3, 2);
        userManaged.add(btnSendQuestionOn, 3, 3);
        userManaged.add(listOfQuestions, 5, 2);
        userManaged.add(btnGenerate, 5, 3);
        userManaged.setVisible(false);
    }

    public void reset(){
        questionWording.getChildren().clear();
        listOfQuestions.setContent(null);
        questionState.setVisible(false);
        questionWording.setVisible(false);
        btnSendQuestionOn.setVisible(false);
        btnGenerate.setVisible(false);
        listOfQuestions.setVisible(false);
    }
}
