package Views;

import Listeners.UIEventListener;
import entities.Manager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static entities.Manager.clearWindowQuestions;
import static entities.Manager.questionBankSize;


public class TestMakerView implements AbstractView {
    private ArrayList<UIEventListener> allListeners = new ArrayList<>();
    StackPane root2 = new StackPane();

    HomeView homeView = new HomeView();
    QuestionBankView questionBankView = new QuestionBankView();
    AddQuestionView addQuestion = new AddQuestionView();
    UpdateQuestionView updateQuestion = new UpdateQuestionView();
    UpdateAnswerView updateAnswer = new UpdateAnswerView();
    RemoveAnswerView removeAnswer = new RemoveAnswerView();
    ManagedQuizView managedQuiz = new ManagedQuizView();
    RandomQuizView randomQuiz = new RandomQuizView();
    CopyQuizView copyQuiz = new CopyQuizView();


    public TestMakerView(Stage theStage) {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #98AFC7");
        
        ImageView homeImage = new ImageView("file:///C:/Users/guzyv/git/TestMakerJFX/TestMaker/src/pictures/home.png");
        homeImage.setFitHeight(17);
        homeImage.setFitWidth(17);
        Button btnHome = new Button("",homeImage);
        btnHome.setStyle("-fx-background-color: #45add3; -fx-background-radius: 6;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
        btnHome.setGraphic(homeImage);
        Button btn1 = new Button("Question Bank");
        btn1.setStyle("-fx-background-color: #45add3; -fx-background-radius: 6;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

        Button btn2 = new Button("Add a question");
        btn2.setStyle("-fx-background-color: #45add3; -fx-background-radius: 6;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
        Button btn3 = new Button("Update Question");
        btn3.setStyle("-fx-background-color: #45add3; -fx-background-radius: 6;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
        Button btn4 = new Button("Update answer");
        btn4.setStyle("-fx-background-color: #45add3; -fx-background-radius: 6;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
        Button btn5 = new Button("Remove an answer");
        btn5.setStyle("-fx-background-color: #45add3; -fx-background-radius: 6;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
        Button btn6 = new Button("Create user managed quiz");
        btn6.setStyle("-fx-background-color: #45add3; -fx-background-radius: 6;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
        Button btn7 = new Button("Create random quiz");
        btn7.setStyle("-fx-background-color: #45add3; -fx-background-radius: 6;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
        Button btn8 = new Button("Copy quiz");
        btn8.setStyle("-fx-background-color: #45add3; -fx-background-radius: 6;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
        HBox hbRootbuttons = new HBox();
        hbRootbuttons.setAlignment(Pos.CENTER);
        hbRootbuttons.setPadding(new Insets(10));
        hbRootbuttons.getChildren().addAll(btnHome, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8);
        hbRootbuttons.setSpacing(3);
        root.setTop(hbRootbuttons);
        root2.getChildren().addAll(homeView.getHome(), questionBankView.getQuestionBank(), addQuestion.getBPaddQuestion(), updateQuestion.getGPupdateQuestion(), updateAnswer.getGPupdateAnswer(), removeAnswer.getGPremoveAnswer(), randomQuiz.getRandomQuiz(), randomQuiz.getQuizPresenter(), copyQuiz.getCopyQuiz(), copyQuiz.getCopyQuizPresenter(), managedQuiz.getUserManaged(), managedQuiz.getManagedQuizPresenter());

        btnHome.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                for (UIEventListener l : allListeners)
                    l.showHome();
                for(int i=0;i<hbRootbuttons.getChildren().size();i++) 
                	hbRootbuttons.getChildren().get(i).setStyle("-fx-background-color: #45add3;");
                
                btnHome.setStyle("-fx-background-color: #227391;");
            }
        });
        btn1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                for (UIEventListener l : allListeners)
                    l.showQuestionBank();
                for(int i=0;i<hbRootbuttons.getChildren().size();i++) 
                	hbRootbuttons.getChildren().get(i).setStyle("-fx-background-color: #45add3;");
                
                btn1.setStyle("-fx-background-color: #227391;");
            }

        });
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                for (UIEventListener l : allListeners)
                    l.showAddQuestion();
                for(int i=0;i<hbRootbuttons.getChildren().size();i++) 
                	hbRootbuttons.getChildren().get(i).setStyle("-fx-background-color: #45add3;");
                
                btn2.setStyle("-fx-background-color: #227391;");

            }

        });
        btn3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                for (UIEventListener l : allListeners)
                    l.showUpdateQuestion();
                for(int i=0;i<hbRootbuttons.getChildren().size();i++) 
                	hbRootbuttons.getChildren().get(i).setStyle("-fx-background-color: #45add3;");
                
                btn3.setStyle("-fx-background-color: #227391;");
            }

        });
        btn4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                for (UIEventListener l : allListeners)
                    l.showUpdateAnswer();
                for(int i=0;i<hbRootbuttons.getChildren().size();i++) 
                	hbRootbuttons.getChildren().get(i).setStyle("-fx-background-color: #45add3;");
                
                btn4.setStyle("-fx-background-color: #227391;");
            }

        });
        btn5.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                for (UIEventListener l : allListeners)
                    l.showRemoveAnswer();
                for(int i=0;i<hbRootbuttons.getChildren().size();i++) 
                	hbRootbuttons.getChildren().get(i).setStyle("-fx-background-color: #45add3;");
                
                btn5.setStyle("-fx-background-color: #227391;");
            }

        });
        btn6.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                for (UIEventListener l : allListeners)
                    l.showManagedQuiz();
                for(int i=0;i<hbRootbuttons.getChildren().size();i++) 
                	hbRootbuttons.getChildren().get(i).setStyle("-fx-background-color: #45add3;");
                
                btn6.setStyle("-fx-background-color: #227391;");
            }

        });
        btn7.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                for (UIEventListener l : allListeners)
                    l.showRandomQuiz();
                for(int i=0;i<hbRootbuttons.getChildren().size();i++) 
                	hbRootbuttons.getChildren().get(i).setStyle("-fx-background-color: #45add3;");
                
                btn7.setStyle("-fx-background-color: #227391;");
            }

        });
        btn8.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                for (UIEventListener l : allListeners)
                    l.showCopyQuiz();
                for(int i=0;i<hbRootbuttons.getChildren().size();i++) 
                	hbRootbuttons.getChildren().get(i).setStyle("-fx-background-color: #45add3;");
                
                btn8.setStyle("-fx-background-color: #227391;");

            }

        });

        root.setCenter(root2);
        Scene scene = new Scene(root, 1000, 600);
        scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
        theStage.setScene(scene);
        theStage.show();
    }

    @Override
    public void registerListener(UIEventListener newListener) {
        allListeners.add(newListener);
    }

    @Override
    public void showHomeView() {
        refreshRoot();
        homeView.visible(true);
    }

    @Override
    public void showQuestionBankView() {
        refreshRoot();
        questionBankView.getQuestionBank().setVisible(true);
        Label bank = new Label(Manager.showQuestionBank());
        bank.setStyle("-fx-text-fill: #191970;-fx-font-size: 1.1em;");
        questionBankView.getQuestionBank().setContent(bank);
    }

    @Override
    public void showAddQuestionView() {
        refreshRoot();
        addQuestion.reset();
        addQuestion.getBPaddQuestion().setVisible(true);
    }

    @Override
    public void showUpdateQuestionView() {
        refreshRoot();
        updateQuestion.reset();
    }

    @Override
    public void showUpdateAnswerView() {
        refreshRoot();
        updateAnswer.reset();
    }

    @Override
    public void showRemoveAnswerView() {
        refreshRoot();
        removeAnswer.reset();
    }

    @Override
    public void showManagedQuizView() {
        clearWindowQuestions();
        managedQuiz.reset();
        refreshRoot();
        GridPane userManaged = managedQuiz.getUserManaged();
        for (int i = 0; i < userManaged.getChildren().size(); i++) {
            if (userManaged.getChildren().get(i) instanceof ComboBox) {
                ((ComboBox<?>) userManaged.getChildren().get(i)).getItems().clear();
                for (int j = 0; j < questionBankSize(); j++) {
                    ((ComboBox) userManaged.getChildren().get(i)).getItems().add("Question " + (j + 1));
                }
            }
        }
        userManaged.setVisible(true);
    }

    @Override
    public void showRandomQuizView() {
        refreshRoot();
        randomQuiz.getRandomQuiz().setVisible(true);
        randomQuiz.genQuizButton();
    }

    @Override
    public void showCopyQuizView() {
        refreshRoot();
        copyQuiz.getWarning().setVisible(false);
        copyQuiz.getCopyQuiz().setVisible(true);
    }

    private void refreshRoot() {
        for (int i = 0; i < root2.getChildren().size(); i++) {
            root2.getChildren().get(i).setVisible(false);
        }
    }
}
