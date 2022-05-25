package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import entities.Manager;
import entities.Quiz;
import entities.interfaces.Menu;
import entities.questions.MultipleChoiceOption;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static constants.Constants.*;
import static entities.Manager.lastCreatedQuizBank;

/*The question bank currently contains questions of a certain subject (Basic Trivia).
It is impossible to make two different quizzes with a different subject matter.
This is due to there being only one question bank.
Even if you fill it with questions of different subjects there is no tag system to categorize
the question type and built a test of that subject respectively.
Therefore, to allow multiple test subjects, more banks should be created with a tagging
field to identify the subject matter of the questions within.
Or to have each question have a subject field of its own and update the logic of the
system from the bottom-up to take this change into account.*/

public class Main extends Application {

    public static Scanner input = new Scanner(System.in);

    public static int menuGraphics() {
        int selection;
        System.out.println(MENU_MESSAGE);
        System.out.println("1 - " + MENU_OPTION_1);
        System.out.println("2 - " + MENU_OPTION_2);
        System.out.println("3 - " + MENU_OPTION_3);
        System.out.println("4 - " + MENU_OPTION_4);
        System.out.println("5 - " + MENU_OPTION_5);
        System.out.println("6 - " + MENU_OPTION_6);
        System.out.println("7 - " + MENU_OPTION_7);
        System.out.println("8 - " + MENU_OPTION_8);
        System.out.println("9 - " + MENU_OPTION_9);
        System.out.println();

        try {
            selection = input.nextInt();
            input.nextLine();
            return selection;
        } catch (InputMismatchException e) {
            System.out.println(ERROR_007);
            return 8;
        }
    }
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Test maker project");
			BorderPane root = new BorderPane();
			Button btn1 = new Button("Question Bank");
			Button btn2 = new Button("Add a question");
			Button btn3 = new Button("Update Question");
			Button btn4 = new Button("Update answer");
			Button btn5 = new Button("Remove an answer");
			Button btn6 = new Button("Create user managed quiz");
			Button btn7 = new Button("Create random quiz");
			Button btn8 = new Button("Copy quiz");
			HBox hbRootbuttons = new HBox();
			hbRootbuttons.setPadding(new Insets(10));
			hbRootbuttons.getChildren().addAll(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8);
			Button btnOpenQuestion = new Button("Open end question");
			GridPane gettingQuestionAnswers = new GridPane();
			Label lblanswer1 = new Label("Answer 1:");
			Label lblanswer2 = new Label("Answer 2:");
			Label lblanswer3 = new Label("Answer 3:");
			Label lblanswer4 = new Label("Answer 4:");
			Label lblanswer5 = new Label("Answer 5:");
			Label lblanswer6 = new Label("Answer 6:");
			Label lblanswer7 = new Label("Answer 7:");
			Label lblanswer8 = new Label("Answer 8:");
			Label lblwhatQuestion = new Label("What is the question?");
			Label lblwhatAnswer = new Label("What is the answer?");
			Label lblEmptyField2 = new Label("One of the required fields are empty");
			lblEmptyField2.setVisible(false);
			lblEmptyField2.setPadding(new Insets(10));
			lblEmptyField2.setTextFill(Color.RED);
			TextField tfanswer1 = new TextField();
			TextField tfanswer2 = new TextField();
			TextField tfanswer3 = new TextField();
			TextField tfanswer4 = new TextField();
			TextField tfanswer5 = new TextField();
			TextField tfanswer6 = new TextField();
			TextField tfanswer7 = new TextField();
			TextField tfanswer8 = new TextField();
			CheckBox cbAnswer1 = new CheckBox();
			CheckBox cbAnswer2 = new CheckBox();
			CheckBox cbAnswer3 = new CheckBox();
			CheckBox cbAnswer4 = new CheckBox();
			CheckBox cbAnswer5 = new CheckBox();
			CheckBox cbAnswer6 = new CheckBox();
			CheckBox cbAnswer7 = new CheckBox();
			CheckBox cbAnswer8 = new CheckBox();
			Label lblIsTrue1 = new Label("Is this answer is true?");
			Label lblIsTrue2 = new Label("Is this answer is true?");
			Label lblIsTrue3 = new Label("Is this answer is true?");
			Label lblIsTrue4 = new Label("Is this answer is true?");
			Label lblIsTrue5 = new Label("Is this answer is true?");
			Label lblIsTrue6 = new Label("Is this answer is true?");
			Label lblIsTrue7 = new Label("Is this answer is true?");
			Label lblIsTrue8 = new Label("Is this answer is true?");
			Button btnSendNewQuestion = new Button("Send");
			Button btnNewMultiOptions = new Button("Send");
			TextField tfwhatQuestion = new TextField();
			TextField tfwhatAnswer = new TextField();
			BorderPane gettingQuestionMulti = new BorderPane();
			gettingQuestionMulti.setCenter(gettingQuestionAnswers);
			gettingQuestionAnswers.setVgap(10);
			gettingQuestionAnswers.setHgap(10);
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
			gettingQuestionAnswers.add(btnSendNewQuestion,2,11);
			gettingQuestionAnswers.add(btnNewMultiOptions, 2, 11);
			gettingQuestionAnswers.add(lblEmptyField2, 0, 12);
			gettingQuestionAnswers.setColumnSpan(lblEmptyField2,12);
			lblwhatQuestion.setVisible(false);
			tfwhatQuestion.setVisible(false);
			lblwhatAnswer.setVisible(false);
			tfwhatAnswer.setVisible(false);
			lblanswer1.setVisible(false);
			tfanswer1.setVisible(false);
			lblanswer2.setVisible(false);
			tfanswer2.setVisible(false);
			lblanswer3.setVisible(false);
			tfanswer3.setVisible(false);
			lblanswer4.setVisible(false);
			tfanswer4.setVisible(false);
			lblanswer5.setVisible(false);
			tfanswer5.setVisible(false);
			lblanswer6.setVisible(false);
			tfanswer6.setVisible(false);
			lblanswer7.setVisible(false);
			tfanswer7.setVisible(false);
			lblanswer8.setVisible(false);
			tfanswer8.setVisible(false);
			cbAnswer1.setVisible(false);
			cbAnswer2.setVisible(false);
			cbAnswer3.setVisible(false);
			cbAnswer4.setVisible(false);
			cbAnswer5.setVisible(false);
			cbAnswer6.setVisible(false);
			cbAnswer7.setVisible(false);
			cbAnswer8.setVisible(false);
			lblIsTrue1.setVisible(false);
			lblIsTrue2.setVisible(false);
			lblIsTrue3.setVisible(false);
			lblIsTrue4.setVisible(false);
			lblIsTrue5.setVisible(false);
			lblIsTrue6.setVisible(false);
			lblIsTrue7.setVisible(false);
			lblIsTrue8.setVisible(false);
			btnOpenQuestion.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					for(int i=0;i<gettingQuestionAnswers.getChildren().size();i++) 
						gettingQuestionAnswers.getChildren().get(i).setVisible(false);
					
					
					
					lblwhatQuestion.setVisible(true);
					tfwhatQuestion.setVisible(true);
					lblwhatAnswer.setVisible(true);
					tfwhatAnswer.setVisible(true);
					btnSendNewQuestion.setVisible(true);
					btnSendNewQuestion.setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent arg0) {
							if(tfwhatQuestion.getText().isBlank()||tfwhatAnswer.getText().isBlank()) {
								lblEmptyField2.setVisible(true);
							} else {
								lblEmptyField2.setVisible(false);
							}
							
						}
					});
					
				}
				
			});
			Button btnMultiQuestion = new Button("multi-optional question");
			Button btnSendUpdateQuestion = new Button("Send");
			Button btnSendQuestionID = new Button("Get");
			
			BorderPane addQuestion = new BorderPane();
			HBox typeQuestion = new HBox();
			typeQuestion.setPadding(new Insets(10));
			typeQuestion.getChildren().addAll(btnOpenQuestion,btnMultiQuestion);

			Label lblgetQuestionID = new Label("What is the ID of the question you'd like to update?");
			Label lblUpdateQuestion = new Label("What is the new/updated text of the question?");
			Label lblEmptyField3 = new Label("This field cannot be empty");
			Label lblEmptyField3_3 = new Label("This field cannot be empty");
			Label lblEmptyField4 = new Label("One of the required fields are empty");

			lblEmptyField3.setTextFill(Color.RED);
			lblEmptyField3.setVisible(false);
			lblEmptyField3_3.setTextFill(Color.RED);
			lblEmptyField3_3.setVisible(false);
			

			lblEmptyField4.setTextFill(Color.RED);
			lblEmptyField4.setVisible(false);

			TextField tfgetQuestionID = new TextField();
			TextField tfUpdateQuestion = new TextField();


			btnSendNewQuestion.setVisible(false);
			btnNewMultiOptions.setVisible(false);

			btnMultiQuestion.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					for(int i=0;i<gettingQuestionAnswers.getChildren().size();i++) 
						gettingQuestionAnswers.getChildren().get(i).setVisible(false);
					
					
					lblwhatQuestion.setVisible(true);
					tfwhatQuestion.setVisible(true);
					lblanswer1.setVisible(true);
					tfanswer1.setVisible(true);
					lblIsTrue1.setVisible(true);
					cbAnswer1.setVisible(true);
					lblanswer2.setVisible(true);
					tfanswer2.setVisible(true);
					lblIsTrue2.setVisible(true);
					cbAnswer2.setVisible(true);
					lblanswer3.setVisible(true);
					tfanswer3.setVisible(true);
					lblIsTrue3.setVisible(true);
					cbAnswer3.setVisible(true);
					lblanswer4.setVisible(true);
					tfanswer4.setVisible(true);
					lblIsTrue4.setVisible(true);
					cbAnswer4.setVisible(true);
					lblanswer5.setVisible(true);
					tfanswer5.setVisible(true);
					lblIsTrue5.setVisible(true);
					cbAnswer5.setVisible(true);
					lblanswer6.setVisible(true);
					tfanswer6.setVisible(true);
					lblIsTrue6.setVisible(true);
					cbAnswer6.setVisible(true);
					lblanswer7.setVisible(true);
					tfanswer7.setVisible(true);
					lblIsTrue7.setVisible(true);
					cbAnswer7.setVisible(true);
					lblanswer8.setVisible(true);
					tfanswer8.setVisible(true);
					lblIsTrue8.setVisible(true);
					cbAnswer8.setVisible(true);
					
					
				
					
					btnNewMultiOptions.setVisible(true);
					btnNewMultiOptions.setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent arg0) {
							boolean AnswerFilled = false;
							
								if(tfanswer1.getText().isBlank()&&tfanswer2.getText().isBlank()&&tfanswer3.getText().isBlank()&&tfanswer4.getText().isBlank()&&tfanswer5.getText().isBlank()&&tfanswer6.getText().isBlank()&&tfanswer7.getText().isBlank()&&tfanswer8.getText().isBlank()) {
									AnswerFilled = false;
								}else AnswerFilled=true;
								
							
							if(tfwhatQuestion.getText().isBlank()||!(AnswerFilled)) {
								lblEmptyField2.setVisible(true);
							}else {
								lblEmptyField2.setVisible(false);
							}
							
						}
					});
					
				}
			});
	
			addQuestion.setTop(typeQuestion);
			addQuestion.setCenter(gettingQuestionMulti);
			GridPane UpdateQuestion = new GridPane();
			UpdateQuestion.setVgap(10);
			UpdateQuestion.setHgap(10);
			UpdateQuestion.add(lblgetQuestionID, 1, 1);
			UpdateQuestion.add(tfgetQuestionID, 2, 1);
			UpdateQuestion.add(lblEmptyField3,1,3);
			UpdateQuestion.setColumnSpan(lblEmptyField3, 2);
			UpdateQuestion.add(btnSendQuestionID, 3, 1);
			UpdateQuestion.add(lblUpdateQuestion, 1, 3);
			UpdateQuestion.add(tfUpdateQuestion, 2, 3);
			UpdateQuestion.add(btnSendUpdateQuestion, 3, 3);
			UpdateQuestion.add(lblEmptyField3_3,1,4);
			UpdateQuestion.setColumnSpan(lblEmptyField3_3, 4);
			UpdateQuestion.setVisible(false);
			lblgetQuestionID.setVisible(true);
			tfgetQuestionID.setVisible(true);
			btnSendQuestionID.setVisible(true);
			lblUpdateQuestion.setVisible(false);
			tfUpdateQuestion.setVisible(false);
			btnSendUpdateQuestion.setVisible(false);
			btnSendQuestionID.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					if(!(tfgetQuestionID.getText().isBlank())) {
						lblEmptyField3.setVisible(false);
						lblUpdateQuestion.setVisible(true);
						tfUpdateQuestion.setVisible(true);
						btnSendUpdateQuestion.setVisible(true);
					}else {
						lblEmptyField3.setVisible(true);
						lblUpdateQuestion.setVisible(false);
						tfUpdateQuestion.setVisible(false);
						btnSendUpdateQuestion.setVisible(false);
					}
					
				}
			});
			btnSendUpdateQuestion.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					if(!(tfUpdateQuestion.getText().isBlank())) {
						lblEmptyField3_3.setVisible(false);
					}else {
						lblEmptyField3_3.setVisible(true);

					}
					
				}
			});
			////
		
			StackPane root2 = new StackPane();
			ScrollPane QuestionBank = new ScrollPane();
			QuestionBank.setVbarPolicy(ScrollBarPolicy.ALWAYS);
			GridPane OpenWindow = new GridPane();
			OpenWindow.setVisible(true);
			Label lblWelcome = new Label("Welcome to the Test Maker!");
			lblWelcome.setVisible(true);
			
			lblWelcome.setStyle("-fx-font-size: 2.0em;");
			Label lblMadeBy = new Label("made by Guy Zvilich and Dimitry Gordon");
			lblMadeBy.setVisible(true);
			Label lblWhatIsHere = new Label(" - You can look at our question bank. \n - You can create your own questions and add them to our bank. \n - You can update a qustion/answer as you like or even remove an answer. \n -  You can create your own managed quiz and if you feel lazy you can create quiz randomly! \n - You Can copy a quiz from one that is already exist!");
			OpenWindow.add(lblWelcome,3,1);
			OpenWindow.add(lblWhatIsHere,3,6);
			
			OpenWindow.add(lblMadeBy,1,10);
			lblMadeBy.setPadding(new Insets(10));
			
			GridPane UpdateAnswer = new GridPane();
			Label lblGetQuestionIDForAnswer = new Label("What is the ID of the question you'd like to update?");
			TextField tfGetQuestionIDForAnswer = new TextField();
			Button btnGetQuestionIDForAnswer = new Button("Get");
			Label lblEmptyField5 = new Label("This field cannot be empty");
			lblEmptyField5.setVisible(false);
			lblEmptyField5.setTextFill(Color.RED);
			UpdateAnswer.setVgap(10);
			UpdateAnswer.setHgap(10);
			UpdateAnswer.add(lblGetQuestionIDForAnswer, 1, 1);
			UpdateAnswer.add(tfGetQuestionIDForAnswer, 2, 1);
			UpdateAnswer.add(btnGetQuestionIDForAnswer, 3, 1);
			UpdateAnswer.add(lblEmptyField4, 1, 2);
			lblGetQuestionIDForAnswer.setVisible(true);
			tfGetQuestionIDForAnswer.setVisible(true);
			btnGetQuestionIDForAnswer.setVisible(true);
			lblEmptyField4.setVisible(false);
			lblEmptyField4.setTextFill(Color.RED);
			btnGetQuestionIDForAnswer.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					if(tfGetQuestionIDForAnswer.getText().isBlank()) {
						lblEmptyField4.setVisible(true);
					}else {
						lblEmptyField4.setVisible(false);
					}
				}
			});
			
			GridPane HowManyRandom = new GridPane();
			HowManyRandom.setHgap(10);
			HowManyRandom.setVgap(10);
			Label lblRandomQuiz = new Label(QUESTION_TO_USER_09);
			TextField tfGetQuizSize = new TextField();
			Button btnGenerateQuiz = new Button("Generate");
			Label lblEmptyField7 = new Label("This field cannot be empty"); 
			HowManyRandom.add(lblRandomQuiz, 1, 1);
			HowManyRandom.add(tfGetQuizSize, 2, 1);
			HowManyRandom.add(btnGenerateQuiz, 3, 1);
			HowManyRandom.add(lblEmptyField7, 1, 2);
			lblRandomQuiz.setVisible(true);
			tfGetQuizSize.setVisible(true);
			btnGenerateQuiz.setVisible(true);
			lblEmptyField7.setVisible(false);
			lblEmptyField7.setTextFill(Color.RED);
			HowManyRandom.setVisible(false);
			ScrollPane RandomQuiz= new ScrollPane();
			RandomQuiz.setVisible(false);
			RandomQuiz.setVbarPolicy(ScrollBarPolicy.ALWAYS);
			
			BorderPane CopyQuiz = new BorderPane();
			Button btnByDate = new Button("By Date");
			Button btnByLast10 = new Button("By Last 10");
			HBox hbCopyOptions = new HBox();
			CopyQuiz.setPadding(new Insets(10));
			hbCopyOptions.getChildren().addAll(btnByDate,btnByLast10);
			CopyQuiz.setTop(hbCopyOptions);
			CopyQuiz.setVisible(false);
			Label lblGetDate = new Label(QUESTION_TO_USER_20);
			TextField tfGetDay = new TextField();
			TextField tfGetMonth = new TextField();
			TextField tfGetYear = new TextField();
			Label lblSlash1 = new Label("/");
			Label lblSlash2 = new Label("/");
			HBox hbGetDate = new HBox();
			hbGetDate.getChildren().addAll(tfGetDay,lblSlash1,tfGetMonth,lblSlash2,tfGetYear);
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
			ByDate.add(hbGetDate, 1,2);
			BorderPane copyByLast10 = new BorderPane();
			copyByLast10.setVisible(false);
			GridPane ByLast10 = new GridPane();
			Button btnCopyByLast10 = new Button("Copy");
			copyByLast10.setCenter(ByLast10);
			copyByLast10.setBottom(btnCopyByLast10);
			btnByDate.setAlignment(Pos.CENTER);
			ByLast10.setHgap(10);
			ByLast10.setVgap(10);
			
			
			StackPane copyOption = new StackPane(copyByDate,copyByLast10);
			CopyQuiz.setCenter(copyOption);

			copyByDate.setVisible(false);
			copyByLast10.setVisible(false);
			
			btnByDate.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					for(int i =0;i<copyOption.getChildren().size();i++) {
						copyOption.getChildren().get(i).setVisible(false);
					}
					copyByDate.setVisible(true);
					
				}
			});
			btnByLast10.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					for(int i =0;i<copyOption.getChildren().size();i++) {
						copyOption.getChildren().get(i).setVisible(false);
					}
					ToggleGroup tglLast10Quiezes = new ToggleGroup();
					VBox vb10Options = new VBox();
					vb10Options.setSpacing(5);
					for (int i=1;i<11;i++) {
						RadioButton temp = new RadioButton(i+"");
						temp.setToggleGroup(tglLast10Quiezes);
						vb10Options.getChildren().add(temp);
						}
					ByLast10.add(vb10Options, 1, 1);
					copyByLast10.setVisible(true);
				}
			});
			
			BorderPane userManaged = new BorderPane();
			GridPane fp = new GridPane();
			Label lblInstructionsForUserManaged = new Label("hhh");
			Button btnGenerateUserManaged = new Button("Generate");
			GridPane RemoveAnswer = new GridPane();
			userManaged.setTop(lblInstructionsForUserManaged);
			userManaged.setBottom(btnGenerateUserManaged);
			userManaged.setCenter(fp);
			userManaged.setVisible(false);
			RemoveAnswer.setHgap(10);
			RemoveAnswer.setVgap(10);
			Label lblGetQuestionIDToRemove = new Label("What is the ID of the question you'd like to update?");
			TextField tfGetQuestionIDToRemove = new TextField();
			Button btnGetQuestionIDToRemove = new Button("Get");
			
			RemoveAnswer.add(lblGetQuestionIDToRemove, 1, 1);
			RemoveAnswer.add(tfGetQuestionIDToRemove, 2, 1);
			RemoveAnswer.add(btnGetQuestionIDToRemove, 3, 1);
			RemoveAnswer.add(lblEmptyField5, 1, 2);
			lblGetQuestionIDToRemove.setVisible(true);
			tfGetQuestionIDToRemove.setVisible(true);
			btnGetQuestionIDToRemove.setVisible(true);

			btnGetQuestionIDToRemove.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					if(tfGetQuestionIDToRemove.getText().isBlank()) {
						lblEmptyField5.setVisible(true);
					}else {
						lblEmptyField5.setVisible(false);
					}
				}
			});
			
			
			
			Label lblHowMany = new Label("How many questions would you like the Test to have?");
			TextField tfHowMany = new TextField();
			Button btnHowMany = new Button("Next");
			lblHowMany.setVisible(true);
			tfHowMany.setVisible(true);
			btnHowMany.setVisible(true);
			

			
			
			
			QuestionBank.setVisible(false);
			addQuestion.setVisible(false);
			UpdateAnswer.setVisible(false);
			RemoveAnswer.setVisible(false);
			
			fp.setHgap(10);
			fp.setVgap(10);
			root.setTop(hbRootbuttons);
			root2.getChildren().addAll(OpenWindow,userManaged,QuestionBank,addQuestion,UpdateQuestion,UpdateAnswer,RemoveAnswer,HowManyRandom,CopyQuiz,RandomQuiz);
			btn1.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					for (int i =0;i<root2.getChildren().size();i++) {
						root2.getChildren().get(i).setVisible(false);
					}
					QuestionBank.setVisible(true);
					Label bank = new Label(Manager.showQuestionBank());
					QuestionBank.setContent(bank);
					
				}
				
			});
			
			btn2.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					for (int i =0;i<root2.getChildren().size();i++) {
						root2.getChildren().get(i).setVisible(false);
					}
					addQuestion.setVisible(true);
					
				}
				
			});
			
			btn3.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					for (int i =0;i<root2.getChildren().size();i++) {
						root2.getChildren().get(i).setVisible(false);
					}
					UpdateQuestion.setVisible(true);
					
				}
				
			});
			
			btn4.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					for (int i =0;i<root2.getChildren().size();i++) {
						root2.getChildren().get(i).setVisible(false);
					}
					UpdateAnswer.setVisible(true);
					
				}
				
			});
			
			btn5.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					for (int i =0;i<root2.getChildren().size();i++) {
						root2.getChildren().get(i).setVisible(false);
					}
					RemoveAnswer.setVisible(true);
					
				}
				
			});

			btn6.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					for (int i =0;i<root2.getChildren().size();i++) {
						root2.getChildren().get(i).setVisible(false);
					}
					VBox v = new VBox();
					
					for(int i=0; i<(Manager.questionBankSize()/5);i++) {
						HBox temp = new HBox();
						for(int j=0;j<5;j++) {
							temp.getChildren().add(new CheckBox("Question "+((i*5)+j+1)));
						}
						v.getChildren().add(temp);
						
					}
					fp.getChildren().add(v);
					userManaged.setVisible(true);

					
				}
				
			});

			btn7.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					for (int i =0;i<root2.getChildren().size();i++) {
						root2.getChildren().get(i).setVisible(false);
					}
					HowManyRandom.setVisible(true);
					btnGenerateQuiz.setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent arg0) {
							if(tfGetQuizSize.getText().isBlank()) {
								lblEmptyField7.setVisible(true);
							} else {
								lblEmptyField7.setVisible(false);
								HowManyRandom.setVisible(false);
								Label Quiz = new Label(Manager.createRandomQuiz(Integer.parseInt(tfGetQuizSize.getText())).toString());
								RandomQuiz.setContent(Quiz);
								RandomQuiz.setVisible(true);
							}

						}
					});
					
					
				}
				
			});

			btn8.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					for (int i =0;i<root2.getChildren().size();i++) {
						root2.getChildren().get(i).setVisible(false);
					}
					CopyQuiz.setVisible(true);
					
				}
				
			});

			root.setCenter(root2);
			Scene scene = new Scene(root,900,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void main(String[] args) {
    	launch(args);
        int choice = menuGraphics();

        Menu consoleOrientedMenu = new Menu() {
            @Override
            public void displayQuestionBank() {
                Manager.showQuestionBank();
            }

            @Override
            public void addToQuestionBank() {
                int questionType = Main.integerOptionDistributor(3);
                if (questionType == 0) {
                    System.out.println(ERROR_001);
                    return;
                }
                Manager.addQuestionToBank(questionType);
                System.out.println(SUCCESS_MESSAGE_01);
            }

            @Override
            public void updateTextWording() {
                int qid = Main.integerOptionDistributor(1);
                if (qid == 0) {
                    System.out.println(ERROR_002);
                    return;
                }
                Manager.updateQuestionText(qid);
            }

            @Override
            public void updateAnswerWording() {
                int qid = Main.integerOptionDistributor(1);
                if (qid == 0) {
                    System.out.println(ERROR_002);
                    return;
                }
                Manager.updateQuestionAnswer(qid);
            }

            @Override
            public void removeAnswer() {
                int qid = Main.integerOptionDistributor(1);
                if (qid == 0) {
                    System.out.println(ERROR_002);
                    return;
                }
                Manager.removeAnswer(qid);
            }

            @Override
            public void makeManagedQuiz() {
                int numOfQuestions = Main.integerOptionDistributor(2);
                Manager.validationMessenger(numOfQuestions);
                ArrayList<Integer> list = Main.listOfQuestions();
                if (list == null) {
                    System.out.println(ERROR_005);
                    return;
                }
                if (list.size() != numOfQuestions) {
                    System.out.println(ERROR_006);
                    return;
                }

                System.out.println(Manager.createManagedQuiz(numOfQuestions, list));
                System.out.println(SUCCESS_MESSAGE_02);
            }

            @Override
            public void makeRandomQuiz() {
                int numOfQuestions = Main.integerOptionDistributor(2);
                Manager.validationMessenger(numOfQuestions);
                System.out.println(Manager.createRandomQuiz(numOfQuestions));
                System.out.println(SUCCESS_MESSAGE_02);
            }

            @Override
            public void makeCopyQuiz() {
                int choice = integerOptionDistributor(8);
                switch (choice) {
                    case 1:
                        String date = stringOptionDistributor(7);
                        Manager.readQuizFromFile(date);
                        System.out.println(SUCCESS_MESSAGE_02);
                        break;
                    case 2:
                        int index = integerOptionDistributor(10);
                        try {
                            Quiz copyQuiz = lastCreatedQuizBank.get(index);
                            if (copyQuiz != null) {
                                System.out.println(copyQuiz);
                                Manager.quizCopyFile(copyQuiz);
                                System.out.println(SUCCESS_MESSAGE_02);
                            }
                            break;
                        } catch (NullPointerException e) {
                            System.out.println(ERROR_024);
                        }
                }
            }
        };

        while (choice != 9) {
            switch (choice) {
                case 1:
                    consoleOrientedMenu.displayQuestionBank();
                    break;
                case 2:
                    consoleOrientedMenu.addToQuestionBank();
                    break;
                case 3:
                    consoleOrientedMenu.updateTextWording();
                    break;
                case 4:
                    consoleOrientedMenu.updateAnswerWording();
                    break;
                case 5:
                    consoleOrientedMenu.removeAnswer();
                    break;
                case 6:
                    consoleOrientedMenu.makeManagedQuiz();
                    break;
                case 7:
                    consoleOrientedMenu.makeRandomQuiz();
                    break;
                case 8:
                    consoleOrientedMenu.makeCopyQuiz();
                    break;
                default:
                    System.out.println(EXIT_MESSAGE);
                    break;
            }
            choice = menuGraphics();

        }

        Manager.saveQuestionBank();
    }

    public static int integerOptionDistributor(int id) {
        switch (id) {
            case 1:
                try {
                    System.out.println(QUESTION_TO_USER_08);
                    int num = input.nextInt();
                    input.nextLine();
                    return num;
                } catch (InputMismatchException e) {
                    System.out.println(ERROR_008);
                    return 0;
                }
            case 2:
                try {
                    System.out.println(QUESTION_TO_USER_09);
                    int index = input.nextInt();
                    input.nextLine();
                    return index;
                } catch (InputMismatchException e) {
                    System.out.println(ERROR_008);
                    return 0;
                }
            case 3:
                try {
                    System.out.println(QUESTION_TO_USER_10);
                    int num = input.nextInt();
                    while ((num != 1) && (num != 2)) {
                        System.out.println(ERROR_022);
                        num = input.nextInt();
                    }
                    input.nextLine();
                    return num;
                } catch (InputMismatchException e) {
                    System.out.println(ERROR_008);
                    return 0;
                }
            case 4:
                try {
                    System.out.println(QUESTION_TO_USER_06);
                    int num = input.nextInt();
                    input.nextLine();
                    return num;
                } catch (InputMismatchException e) {
                    System.out.println(ERROR_008);
                    return 0;
                }
            case 5:
                try {
                    System.out.println(QUESTION_TO_USER_12);
                    System.out.println(GENERIC_MESSAGE_02);
                    int number = input.nextInt();
                    while (number > 10 || number < 2) {
                        System.out.println(ERROR_023);
                        number = input.nextInt();
                    }
                    input.nextLine();
                    return number;
                } catch (InputMismatchException e) {
                    System.out.println(ERROR_008);
                    return 0;
                }
            case 6:
                try {
                    System.out.println(QUESTION_TO_USER_13);
                    int index = input.nextInt();
                    input.nextLine();
                    return index;
                } catch (InputMismatchException e) {
                    System.out.println(ERROR_008);
                    return 0;
                }
            case 7:
                try {
                    System.out.println(QUESTION_TO_USER_14);
                    int index = input.nextInt();
                    input.nextLine();
                    return index;
                } catch (InputMismatchException e) {
                    System.out.println(ERROR_008);
                    return 0;
                }
            case 8:
                try {
                    System.out.println(QUESTION_TO_USER_19);
                    int index = input.nextInt();
                    input.nextLine();
                    return index;
                } catch (InputMismatchException e) {
                    System.out.println(ERROR_008);
                    return 0;
                }
            case 9:
                try {
                    System.out.println(QUESTION_TO_USER_16);
                    int index = input.nextInt();
                    input.nextLine();
                    return index;
                } catch (InputMismatchException e) {
                    System.out.println(ERROR_009);
                    return 0;
                }
            case 10:
                try {
                    System.out.println(QUESTION_TO_USER_07);
                    int index = input.nextInt();
                    input.nextLine();
                    return index;
                } catch (InputMismatchException e) {
                    System.out.println(ERROR_009);
                    return 0;
                }
        }
        return 0;
    }

    public static String stringOptionDistributor(int id) {
        switch (id) {
            case 1:
                System.out.println(GENERIC_MESSAGE_04);
                return input.nextLine();
            case 2:
                System.out.println(QUESTION_TO_USER_01);
                return input.nextLine();
            case 3:
                System.out.println(QUESTION_TO_USER_02);
                return input.nextLine();
            case 4:
                System.out.println(QUESTION_TO_USER_03);
                return input.nextLine();
            case 5:
                System.out.println(QUESTION_TO_USER_04);
                return input.nextLine();
            case 6:
                System.out.println(QUESTION_TO_USER_05);
                return input.nextLine();
            case 7:
                System.out.println(QUESTION_TO_USER_18);
                return input.nextLine();
            case 8:
                System.out.println(GENERIC_MESSAGE_05);
                return input.nextLine();
            case 9:
                System.out.println(QUESTION_TO_USER_17);
                return input.nextLine();
        }
        return "";
    }

    public static ArrayList<Integer> listOfQuestions() { //don't know how to change the function split.
        try {
            String indexes = stringOptionDistributor(1);
            indexes = indexes.replaceAll(" ", "");
            String[] list = indexes.split(",");
            int[] arr = new int[list.length];
            for (int i = 0; i < list.length; i++) {
                arr[i] = Integer.parseInt(list[i]);
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int num : arr) {
                arrayList.add(num);
            }
            return arrayList;
        } catch (NumberFormatException e) {
            System.out.println(ERROR_010);
            return null;
        }
    }

    public static MultipleChoiceOption optionSetter() {
        String text = input.nextLine();
        System.out.println(QUESTION_TO_USER_17);
        char yn = input.nextLine().toLowerCase().charAt(0);
        boolean verdict = yn == 'y';
        return new MultipleChoiceOption(text, verdict);
    }





	

}
