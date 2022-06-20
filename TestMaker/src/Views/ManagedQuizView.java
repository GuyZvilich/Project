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

    private String style = "-fx-text-fill: #191970;-fx-font-size: 1.1em;";

    public GridPane getUserManaged() {
        return userManaged;
    }

    public ScrollPane getManagedQuizPresenter() {
        return managedQuizPresenter;
    }

    public ManagedQuizView() {
    	questionState.setStyle("-fx-text-fill: #191970;-fx-font-size: 1.1em;");
    	btnGenerate.setStyle("-fx-background-color: #eaf6fa; -fx-background-radius: 20;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
    	btnSendQuestionOn.setStyle("-fx-background-color: #eaf6fa; -fx-background-radius: 20;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
    	userManaged.setStyle("-fx-background-color: #AFDCEC	");
    	managedQuizPresenter.setStyle("-fx-color: #1aa7ff;-fx-background: #ADDFFF");
        listOfQuestions.setStyle("-fx-color: #1aa7ff;-fx-background: #ADDFFF; -fx-min-width: 250; -fx-padding: 10");
    	
    	
    	Button btnGetQuestion = new Button("Get");
    	btnGetQuestion.setStyle("-fx-background-color: #eaf6fa; -fx-background-radius: 20;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
        

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
                    questionText.setStyle("-fx-text-fill: #191970;-fx-font-size: 1.1em;");
                    if (question instanceof OpenEndQuestion) {
                        questionWording.add(questionText, 1, 1);
                        Label ans1 = new Label("Answer: " + ((OpenEndQuestion) question).getRightAnswer());
                        ans1.setStyle(style);
                        questionWording.add(ans1, 1, 2);
                    }
                    if (question instanceof MultipleChoiceQuestion) {
                        questionWording.add(questionText, 1, 1);
                        Label ans2 = new Label("Answers:");
                        ans2.setStyle(style);
                        questionWording.add(ans2, 1, 2);
                        int i = 3;
                        for (MultipleChoiceOption mco : ((MultipleChoiceQuestion) question).getOptions().getSet())
                            if (mco != null) {
                                CheckBox check = new CheckBox(mco.getOptionText());
                                check.setStyle(style);
                                questionWording.add(check, 1, i);
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
                Label lbl = new Label(content + "\nQuestion " + question.getQuestionId());
                lbl.setStyle(style);
                listOfQuestions.setContent(lbl);

            }
        });
        btnGenerate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label Quiz = new Label(createManagedWindowQuiz().toString());
                Quiz.setStyle("-fx-text-fill: #191970;-fx-font-size: 1.1em;");
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
        Label choose = new Label("Choose a Question:");
        choose.setStyle(style);
        userManaged.add(choose, 1, 1);
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
