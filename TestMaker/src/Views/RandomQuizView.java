package Views;

import entities.Manager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import static constants.Constants.QUESTION_TO_USER_09;

public class RandomQuizView {
    GridPane RandomQuiz = new GridPane();
    ScrollPane RandomQuizPresenter = new ScrollPane();
    TextField tfGetQuizSize = new TextField();
    Label lblEmptyField7 = new Label("This field cannot be empty");
    Button btnGenerateQuiz = new Button("Generate");


    public GridPane getRandomQuiz() {
        return RandomQuiz;
    }

    public ScrollPane getQuizPresenter() {
        return RandomQuizPresenter;
    }

    public void reset(){
        tfGetQuizSize.setText("");
    }

    public RandomQuizView() {
       RandomQuiz.setStyle("-fx-background-color: #AFDCEC	");
       RandomQuizPresenter.setStyle("-fx-color: #1aa7ff;-fx-background: #ADDFFF");
       btnGenerateQuiz.setStyle("-fx-background-color: #eaf6fa; -fx-background-radius: 20;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
    	Label lblRandomQuiz = new Label(QUESTION_TO_USER_09);
    	lblRandomQuiz.setStyle("-fx-text-fill: #191970;-fx-font-size: 1.1em;");

        RandomQuiz.setPadding(new Insets(10));
        RandomQuiz.setHgap(10);
        RandomQuiz.setVgap(10);
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

        RandomQuizPresenter.setPadding(new Insets(10));
        RandomQuizPresenter.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        RandomQuizPresenter.setVisible(false);
    }

    public void genQuizButton() {
        btnGenerateQuiz.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                if(Manager.isNumeric(tfGetQuizSize.getText())){
                    if (tfGetQuizSize.getText().equals("")) {
                        lblEmptyField7.setVisible(true);
                    } else {
                        lblEmptyField7.setVisible(false);
                        RandomQuiz.setVisible(false);
                        Label Quiz = new Label(Manager.createRandomQuiz(Integer.parseInt(tfGetQuizSize.getText())).toString());
                        Quiz.setStyle("-fx-text-fill: #191970;-fx-font-size: 1.1em;");
                        RandomQuizPresenter.setContent(Quiz);
                        RandomQuizPresenter.setVisible(true);
                    }
                }
            }
        });
    }

}
