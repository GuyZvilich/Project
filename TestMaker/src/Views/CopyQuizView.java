package Views;

import entities.Manager;
import entities.Quiz;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import static constants.Constants.QUESTION_TO_USER_20;
import static entities.Manager.lastCreatedQuizBank;

public class CopyQuizView {
    private BorderPane CopyQuiz = new BorderPane();
    private ScrollPane copyQuizPresenter = new ScrollPane();
    private Label warning = new Label("No Exam was created yet. The clone bank of exams is empty");
    private Label lblGetDate = new Label(QUESTION_TO_USER_20);
    private TextField tfGetDay = new TextField();
    private TextField tfGetMonth = new TextField();
    private TextField tfGetYear = new TextField();
    private Label lblSlash1 = new Label("/");
    private Label lblSlash2 = new Label("/");
    private HBox hbGetDate = new HBox();
    private BorderPane copyByDate = new BorderPane();
    private GridPane ByDate = new GridPane();
    private Button btnCopyByDate = new Button("Copy");
    private BorderPane copyByLast10 = new BorderPane();
    private GridPane ByLast10 = new GridPane();
    private Button btnCopyByLast10 = new Button("Copy");
    private StackPane copyOption = new StackPane(copyByDate, copyByLast10);
    private Button btnByDate = new Button("By Date");
    private Button btnByLast10 = new Button("By Last 10");
    
    public BorderPane getCopyQuiz() {
        return CopyQuiz;
    }

    public ScrollPane getCopyQuizPresenter() {
        return copyQuizPresenter;
    }

    public Label getWarning() {
        return warning;
    }

    public void reset(){
        lblGetDate.setVisible(false);
        for(Node node: hbGetDate.getChildren())
            node.setVisible(false);
        ByLast10.setVisible(false);
    }

    public CopyQuizView() {
    	CopyQuiz.setStyle("-fx-background-color: #AFDCEC	");
    	copyQuizPresenter.setStyle("-fx-color: #1aa7ff;-fx-background: #ADDFFF");
    	warning.setStyle("-fx-text-fill: Red;");
    	lblGetDate.setStyle("-fx-text-fill: #191970;-fx-font-size: 1.1em;");
    	lblSlash1.setStyle("-fx-text-fill: #191970;-fx-font-size: 2.0em;");
    	lblSlash2.setStyle("-fx-text-fill: #191970;-fx-font-size: 2.0em;");
    	tfGetDay.setMaxWidth(50.0);
    	tfGetMonth.setMaxWidth(50.0);
    	tfGetYear.setMaxWidth(80.0);
    	tfGetDay.setMaxHeight(30.0);
    	tfGetMonth.setMaxHeight(30.0);
    	tfGetYear.setMaxHeight(30.0);

        hbGetDate.getChildren().addAll(tfGetDay, lblSlash1, tfGetMonth, lblSlash2, tfGetYear);
        Label lblIsValid = new Label();
        lblIsValid.setVisible(false);
        copyByDate.setVisible(false);
       
        btnCopyByDate.setStyle("-fx-background-color: #eaf6fa; -fx-background-radius: 20;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
        copyByDate.setCenter(ByDate);
        copyByDate.setBottom(btnCopyByDate);
        
        copyByLast10.setVisible(false);

        btnCopyByLast10.setStyle("-fx-background-color: #eaf6fa; -fx-background-radius: 20;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
        copyByLast10.setCenter(ByLast10);
        copyByLast10.setBottom(btnCopyByLast10);
        ByDate.setHgap(10);
        ByDate.setVgap(10);
        ByDate.add(lblGetDate, 1, 1);
        ByDate.add(hbGetDate, 1, 2);
        ByDate.add(lblIsValid, 1, 3);
        ByLast10.setHgap(10);
        ByLast10.setVgap(10);
        ByLast10.add(warning, 1, 1);
        

        copyQuizPresenter.setPadding(new Insets(10));
        copyQuizPresenter.setVisible(false);
        copyQuizPresenter.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        
        btnByDate.setStyle("-fx-background-color: #45add3; -fx-background-radius: 6;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
        btnByLast10.setStyle("-fx-background-color: #45add3; -fx-background-radius: 6;-fx-background-insets: 0,1,1;-fx-text-fill: black;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");


        HBox hbCopyOptions = new HBox();
        hbCopyOptions.getChildren().addAll(btnByDate, btnByLast10);
        hbCopyOptions.setSpacing(3);
        btnByDate.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                for (int i = 0; i < copyOption.getChildren().size(); i++) {
                    copyOption.getChildren().get(i).setVisible(false);
                }
                copyByDate.setVisible(true);
                for(int i=0;i<hbCopyOptions.getChildren().size();i++) 
                	hbCopyOptions.getChildren().get(i).setStyle("-fx-background-color: #45add3;");
                lblGetDate.setVisible(true);
                tfGetDay.setVisible(true);
                lblSlash1.setVisible(true);
                tfGetMonth.setVisible(true);
                lblSlash2.setVisible(true);
                tfGetYear.setVisible(true);
                btnByDate.setStyle("-fx-background-color: #227391;");
            }
        });
        
        btnByLast10.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                ByLast10.setVisible(true);
                for (int i = 0; i < copyOption.getChildren().size(); i++) {
                    copyOption.getChildren().get(i).setVisible(false);
                }
                for(int i=0;i<hbCopyOptions.getChildren().size();i++) 
                	hbCopyOptions.getChildren().get(i).setStyle("-fx-background-color: #45add3;");
                
                btnByLast10.setStyle("-fx-background-color: #227391;");
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
        btnByDate.setAlignment(Pos.CENTER);

        CopyQuiz.setCenter(copyOption);
        CopyQuiz.setPadding(new Insets(10));
        CopyQuiz.setTop(hbCopyOptions);
        CopyQuiz.setVisible(false);

        btnCopyByDate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean status = Manager.isNumeric(tfGetDay.getText()) && Manager.isNumeric(tfGetMonth.getText()) && Manager.isNumeric(tfGetYear.getText());
                boolean isValid;
                if(status){
                    String date = tfGetDay.getText() + "/" + tfGetMonth.getText() + "/" + tfGetYear.getText();
                    isValid = Manager.isValid(date);
                    if(isValid){
                        Label Quiz = new Label(Manager.copyQuizFromFileToWindow(date));
                        Quiz.setStyle("-fx-text-fill: #191970;-fx-font-size: 1.1em;");
                        copyQuizPresenter.setContent(Quiz);
                        copyQuizPresenter.setVisible(true);
                    } else {
                        lblIsValid.setText("The date is not valid");
                        lblIsValid.setStyle("-fx-text-fill: red;-fx-font-size: 1.1em;");
                        lblIsValid.setVisible(true);
                    }
                }
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
                Quiz.setStyle("-fx-text-fill: #191970;-fx-font-size: 1.1em;");
                copyQuizPresenter.setContent(Quiz);
                copyQuizPresenter.setVisible(true);
            }
        });
        copyByDate.setVisible(false);
        copyByLast10.setVisible(false);
    }
}
