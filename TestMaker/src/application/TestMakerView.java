package application;

import static constants.Constants.QUESTION_TO_USER_01;
import static constants.Constants.QUESTION_TO_USER_03_2;
import static constants.Constants.QUESTION_TO_USER_05_5;
import static constants.Constants.QUESTION_TO_USER_08;
import static constants.Constants.QUESTION_TO_USER_09;
import static constants.Constants.QUESTION_TO_USER_20;
import static constants.Constants.REMOVE;
import static constants.Constants.SUCCESS_MESSAGE_01;
import static constants.Constants.UPDATE;
import static constants.Constants.answerNumberX;
import static entities.Manager.clearWindowQuestions;
import static entities.Manager.createManagedWindowQuiz;
import static entities.Manager.isMoreThanOneCorrect;
import static entities.Manager.isNoneCorrect;
import static entities.Manager.lastCreatedQuizBank;
import static entities.Manager.questionBankProvider;
import static entities.Manager.questionBankSize;
import static entities.Manager.updateQuestionTextInWindow;
import static entities.Manager.windowAddQuestion;

import java.util.Collection;

import entities.Manager;
import entities.Quiz;
import entities.Set;
import entities.questions.MultipleChoiceOption;
import entities.questions.MultipleChoiceQuestion;
import entities.questions.OpenEndQuestion;
import entities.questions.Question;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class TestMakerView {
	public TestMakerView(Stage theStage) {
	BorderPane root = new BorderPane();
    Button btnHome = new Button("Home");
    Button btn1 = new Button("Question Bank");
    Button btn2 = new Button("Add a question");
    Button btn3 = new Button("Update Question");
    Button btn4 = new Button("Update answer");
    Button btn5 = new Button("Remove an answer");
    Button btn6 = new Button("Create user managed quiz");
    Button btn7 = new Button("Create random quiz");
    Button btn8 = new Button("Copy quiz");
    HBox hbRootbuttons = new HBox();
    hbRootbuttons.setAlignment(Pos.CENTER);
    hbRootbuttons.setPadding(new Insets(10));
    hbRootbuttons.getChildren().addAll(btnHome,btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8);

    Label lblThisIsTheQuestion = new Label("The is the question:");
    Label questionText = new Label();


    lblThisIsTheQuestion.setVisible(false);
    questionText.setVisible(false);



    StackPane root2 = new StackPane();

    BorderPane OpenWindow = new BorderPane();
    OpenWindow.setPadding(new Insets(10));
    OpenWindow.setVisible(true);
    Label lblWelcome = new Label("Welcome to the Test Maker!");
    lblWelcome.setVisible(true);
    HBox hbWelcome = new HBox(lblWelcome);
    hbWelcome.setAlignment(Pos.CENTER);
    lblWelcome.setStyle("-fx-font-size: 2.0em;");
    lblWelcome.setUnderline(true);
    Label lblMadeBy = new Label("made by Guy Zvilich and Dimitry Gordon");
    lblMadeBy.setVisible(true);
    Label lblWhatIsHere = new Label(" - You can look at our question bank. \n - You can create your own questions and add them to our bank. \n - You can update a qustion/answer as you like or even remove an answer. \n -  You can create your own managed quiz and if you feel lazy you can create quiz randomly! \n - You Can copy a quiz from one that is already exist!");
    OpenWindow.setTop(hbWelcome);
    OpenWindow.setCenter(lblWhatIsHere);
    OpenWindow.setBottom(lblMadeBy);
    lblMadeBy.setPadding(new Insets(10));


    GridPane RandomQuiz = new GridPane();
    RandomQuiz.setPadding(new Insets(10));
    RandomQuiz.setHgap(10);
    RandomQuiz.setVgap(10);
    Label lblRandomQuiz = new Label(QUESTION_TO_USER_09);
    TextField tfGetQuizSize = new TextField();
    Button btnGenerateQuiz = new Button("Generate");
    Label lblEmptyField7 = new Label("This field cannot be empty");
    RandomQuiz.add(lblRandomQuiz, 1, 1);
    RandomQuiz.add(tfGetQuizSize, 2, 1);
    RandomQuiz.add(btnGenerateQuiz, 3, 1);
    RandomQuiz.add(lblEmptyField7, 1, 2);
    lblRandomQuiz.setVisible(true);
    tfGetQuizSize.setVisible(true);
    btnGenerateQuiz.setVisible(true);
    lblEmptyField7.setVisible(false);
    lblEmptyField7.setTextFill(Color.RED);
    RandomQuiz.setVisible(false);
    ScrollPane RandomQuizPresenter = new ScrollPane();
    RandomQuizPresenter.setPadding(new Insets(10));
    RandomQuizPresenter.setVisible(false);
    RandomQuizPresenter.setVbarPolicy(ScrollBarPolicy.ALWAYS);

    ScrollPane copyQuizPresenter = new ScrollPane();
    copyQuizPresenter.setPadding(new Insets(10));
    copyQuizPresenter.setVisible(false);
    copyQuizPresenter.setVbarPolicy(ScrollBarPolicy.ALWAYS);

    BorderPane CopyQuiz = new BorderPane();
    CopyQuiz.setPadding(new Insets(10));
    Button btnByDate = new Button("By Date");
    Button btnByLast10 = new Button("By Last 10");
    Label warning = new Label("No Exam was created yet. The clone bank of exams is empty");
    HBox hbCopyOptions = new HBox();
    CopyQuiz.setPadding(new Insets(10));
    hbCopyOptions.getChildren().addAll(btnByDate, btnByLast10);
    CopyQuiz.setTop(hbCopyOptions);
    CopyQuiz.setVisible(false);
    Label lblGetDate = new Label(QUESTION_TO_USER_20);
    TextField tfGetDay = new TextField();
    TextField tfGetMonth = new TextField();
    TextField tfGetYear = new TextField();
    Label lblSlash1 = new Label("/");
    Label lblSlash2 = new Label("/");
    HBox hbGetDate = new HBox();
    hbGetDate.getChildren().addAll(tfGetDay, lblSlash1, tfGetMonth, lblSlash2, tfGetYear);
    BorderPane copyByDate = new BorderPane();
    copyByDate.setVisible(false);
    GridPane ByDate = new GridPane();
    Button btnCopyByDate = new Button("Copy");
    copyByDate.setCenter(ByDate);
    copyByDate.setBottom(btnCopyByDate);
    btnByDate.setAlignment(Pos.CENTER);
    ByDate.setHgap(10);
    ByDate.setVgap(10);
    ByDate.add(lblGetDate, 1, 1);
    ByDate.add(hbGetDate, 1, 2);
    BorderPane copyByLast10 = new BorderPane();
    copyByLast10.setVisible(false);
    GridPane ByLast10 = new GridPane();
    Button btnCopyByLast10 = new Button("Copy");
    copyByLast10.setCenter(ByLast10);
    copyByLast10.setBottom(btnCopyByLast10);
    btnByDate.setAlignment(Pos.CENTER);
    ByLast10.setHgap(10);
    ByLast10.setVgap(10);
    ByLast10.add(warning, 1, 1);

    btnCopyByDate.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            String date = tfGetDay.getText() + "/" + tfGetMonth.getText() + "/" + tfGetYear.getText();
            Label Quiz = new Label(Manager.copyQuizFromFileToWindow(date));
            copyQuizPresenter.setContent(Quiz);
            copyQuizPresenter.setVisible(true);
        }
    });

    btnCopyByLast10.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            int index = 0;
            VBox node = (VBox) ByLast10.getChildren().get(1);
            for (Node child : node.getChildren()) {
                RadioButton radioButton = (RadioButton) child;
                if (radioButton.isSelected())
                    index = Integer.parseInt(radioButton.getText()) - 1;
            }
            Quiz copyQuiz = lastCreatedQuizBank.get(index);
            String test = null;
            if (copyQuiz != null) {
                test = copyQuiz.toString();
                Manager.quizCopyFile(copyQuiz);
            }
            Label Quiz = new Label(test);
            copyQuizPresenter.setContent(Quiz);
            copyQuizPresenter.setVisible(true);
        }
    });

    StackPane copyOption = new StackPane(copyByDate, copyByLast10);
    CopyQuiz.setCenter(copyOption);

    copyByDate.setVisible(false);
    copyByLast10.setVisible(false);

    btnByDate.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
            for (int i = 0; i < copyOption.getChildren().size(); i++) {
                copyOption.getChildren().get(i).setVisible(false);
            }
            copyByDate.setVisible(true);

        }
    });
    btnByLast10.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
            for (int i = 0; i < copyOption.getChildren().size(); i++) {
                copyOption.getChildren().get(i).setVisible(false);
            }
            ByLast10.getChildren().removeAll();
            ToggleGroup tglLast10Quiezes = new ToggleGroup();
            VBox vb10Options = new VBox();
            vb10Options.setSpacing(5);
            int sizeOfBank = lastCreatedQuizBank.size();
            if (sizeOfBank == 0) {
                warning.setVisible(true);
            }
            for (int i = 1; i < sizeOfBank + 1; i++) {
                RadioButton temp = new RadioButton(i + "");
                temp.setToggleGroup(tglLast10Quiezes);
                vb10Options.getChildren().add(temp);
            }
            ByLast10.add(vb10Options, 1, 1);
            copyByLast10.setVisible(true);
        }
    });


    Button btnGetQuestion = new Button("Get");
    Label questionState = new Label();
    GridPane questionWording = new GridPane();
    Button btnSendQuestionOn = new Button("Add To Quiz");
    ScrollPane listOfQuestions = new ScrollPane();
    Button btnGenerate = new Button("Generate");

    ScrollPane managedQuizPresenter = new ScrollPane();
    managedQuizPresenter.setPadding(new Insets(10));
    managedQuizPresenter.setVisible(false);
    managedQuizPresenter.setVbarPolicy(ScrollBarPolicy.ALWAYS);

    GridPane userManaged = new GridPane();
    userManaged.setPadding(new Insets(10));
    userManaged.setHgap(10);
    userManaged.setVgap(10);

    userManaged.add(new Label("Choose a Question:"), 1,1);
    userManaged.add(new ComboBox<String>(), 1,2);
    userManaged.add(btnGetQuestion, 1,3);

    btnGetQuestion.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            String index= null;
            questionWording.getChildren().clear();
            for(Node node: userManaged.getChildren()){
                if(node instanceof ComboBox){
                    index = (String) ((ComboBox<?>) node).getValue();
                }
            }
            if(index != null)
                index = index.replace("Question ","");
            else
                index = "0";

            String verdict;
            if(index.equals("0")) {
                verdict = "No Question Selected";
                questionState.setText(verdict);
                questionState.setVisible(true);
            } else {
                questionState.setText(null);
                questionState.setVisible(false);
            }

            if(!questionState.isVisible()){
                Question question = questionBankProvider().get(Integer.parseInt(index)-1);
                Label questionText = new Label("Question: " + question.getText());
                if(question instanceof OpenEndQuestion) {
                    questionWording.add(questionText, 1, 1);
                    questionWording.add(new Label("Answer: " + ((OpenEndQuestion) question).getRightAnswer()), 1, 2);
                }
                if(question instanceof MultipleChoiceQuestion){
                    questionWording.add(questionText, 1, 1);
                    questionWording.add(new Label("Answers:") , 1, 2);
                    int i = 3;
                    for(MultipleChoiceOption mco: ((MultipleChoiceQuestion) question).getOptions().getSet())
                        if(mco != null) {
                            questionWording.add(new CheckBox(mco.getOptionText()), 1, i);
                            i++;
                        }
                }
                questionWording.setVisible(true);
                btnSendQuestionOn.setVisible(true);
            }
        }
    });

    userManaged.add(questionState, 3,1);
    userManaged.add(questionWording, 3,2);
    userManaged.add(btnSendQuestionOn, 3,3);

    btnSendQuestionOn.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            btnGenerate.setVisible(true);
            listOfQuestions.setVisible(true);

            String index= null;
            for(Node node: userManaged.getChildren()){
                if(node instanceof ComboBox){
                    index = (String) ((ComboBox<?>) node).getValue();
                }
            }
            index = index.replace("Question ","");
            Question question = questionBankProvider().get(Integer.parseInt(index) -1);
            String content = "";
            if(question instanceof OpenEndQuestion) {
                windowAddQuestion(question);
            }
            if(question instanceof MultipleChoiceQuestion){
                Set<MultipleChoiceOption> set = new Set(MultipleChoiceOption.class);
                int i=0;
                for(Node node: questionWording.getChildren()){
                    if(node instanceof CheckBox){
                        if(((CheckBox) node).isSelected())
                            set.add(((MultipleChoiceQuestion) question).getOptions().get(i));
                        i++;
                    }
                }
                windowAddQuestion(new MultipleChoiceQuestion(question.getText(), set));
            }
            if(listOfQuestions.getContent() != null){
                Node node = listOfQuestions.getContent();
                if(node instanceof Label)
                    content = ((Label) node).getText();
            }
            listOfQuestions.setContent(new Label(content + "\nQuestion " + question.getQuestionId()));

        }
    });

    userManaged.add(listOfQuestions, 5,2);
    userManaged.add(btnGenerate, 5,3);

    btnGenerate.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Label Quiz = new Label(createManagedWindowQuiz().toString());
            managedQuizPresenter.setContent(Quiz);
            managedQuizPresenter.setVisible(true);
        }
    });


    userManaged.setVisible(false);




    Label lblHowMany = new Label("How many questions would you like the Test to have?");
    TextField tfHowMany = new TextField();
    Button btnHowMany = new Button("Next");
    lblHowMany.setVisible(true);
    tfHowMany.setVisible(true);
    btnHowMany.setVisible(true);


    QuestionBankView questionBank = new QuestionBankView();
    AddQuestionView addQuestion = new AddQuestionView();
    UpdateQuestionView updateQuestion = new UpdateQuestionView();
    UpdateAnswerView updateAnswer = new UpdateAnswerView();
    RemoveAnswerView removeAnswer = new RemoveAnswerView();
    root.setTop(hbRootbuttons);
    root2.getChildren().addAll(OpenWindow,questionBank.getQuestionBank(), addQuestion.getBPaddQuestion(), updateQuestion.getGPupdateQuestion(), updateAnswer.getGPupdateAnswer(), removeAnswer.getGPremoveAnswer(), RandomQuiz, CopyQuiz,userManaged, RandomQuizPresenter, copyQuizPresenter, managedQuizPresenter);
    
    btnHome.setOnAction(new EventHandler<ActionEvent>() {

		@Override
		public void handle(ActionEvent arg0) {
            for (int i = 0; i < root2.getChildren().size(); i++) {
                root2.getChildren().get(i).setVisible(false);
            }
            OpenWindow.setVisible(true);
			
		}
	});
    btn1.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
            for (int i = 0; i < root2.getChildren().size(); i++) {
                root2.getChildren().get(i).setVisible(false);
            }
            questionBank.getQuestionBank().setVisible(true);
            Label bank = new Label(Manager.showQuestionBank());
            questionBank.getQuestionBank().setContent(bank);

        }

    });

    btn2.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
            for (int i = 0; i < root2.getChildren().size(); i++) {
                root2.getChildren().get(i).setVisible(false);
            }
            addQuestion.reset();
            addQuestion.getBPaddQuestion().setVisible(true);

        }

    });

    btn3.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
            for (int i = 0; i < root2.getChildren().size(); i++) {
                root2.getChildren().get(i).setVisible(false);
            }
            updateQuestion.reset();

        }

    });

    btn4.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
            for (int i = 0; i < root2.getChildren().size(); i++) {
                root2.getChildren().get(i).setVisible(false);
            }
            updateAnswer.reset();

        }

    });

    btn5.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
            for (int i = 0; i < root2.getChildren().size(); i++) {
                root2.getChildren().get(i).setVisible(false);
            }
            removeAnswer.reset();

        }

    });

    btn6.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
            clearWindowQuestions();
            questionWording.getChildren().clear();
            listOfQuestions.setContent(null);

            questionState.setVisible(false);
            questionWording.setVisible(false);
            btnSendQuestionOn.setVisible(false);
            btnGenerate.setVisible(false);
            listOfQuestions.setVisible(false);


            for (int i = 0; i < root2.getChildren().size(); i++) {
                root2.getChildren().get(i).setVisible(false);
            }
            for(int i=0; i < userManaged.getChildren().size(); i++){
                if(userManaged.getChildren().get(i) instanceof ComboBox){
                    ((ComboBox<?>) userManaged.getChildren().get(i)).getItems().clear();
                    for(int j=0; j< questionBankSize(); j++){
                        ((ComboBox) userManaged.getChildren().get(i)).getItems().add("Question " + (j+1));
                    }
                }
            }
            userManaged.setVisible(true);


        }

    });

    btn7.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
            for (int i = 0; i < root2.getChildren().size(); i++) {
                root2.getChildren().get(i).setVisible(false);
            }
            RandomQuiz.setVisible(true);
            btnGenerateQuiz.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent arg0) {
                    if (tfGetQuizSize.getText().equals("")) {
                        lblEmptyField7.setVisible(true);
                    } else {
                        lblEmptyField7.setVisible(false);
                        RandomQuiz.setVisible(false);
                        Label Quiz = new Label(Manager.createRandomQuiz(Integer.parseInt(tfGetQuizSize.getText())).toString());
                        RandomQuizPresenter.setContent(Quiz);
                        RandomQuizPresenter.setVisible(true);
                    }

                }
            });


        }

    });

    btn8.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent arg0) {
            for (int i = 0; i < root2.getChildren().size(); i++) {
                root2.getChildren().get(i).setVisible(false);
            }
            warning.setVisible(false);
            CopyQuiz.setVisible(true);

        }

    });

    root.setCenter(root2);
    Scene scene = new Scene(root, 1000, 600);
    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    theStage.setScene(scene);
    theStage.show();
	}
}
