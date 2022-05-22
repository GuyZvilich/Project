package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import entities.Manager;
import entities.Quiz;
import entities.interfaces.Menu;
import entities.questions.MultipleChoiceOption;
import javafx.scene.control.TextField;

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
			Button btnOpenQuestion = new Button("Open end question");
			Button btnMultiQuestion = new Button("multi-optional question");
			Button btnSendNewQuestion = new Button("Send");
			Button btnSendUpdateQuestion = new Button("Send");
			Button btnSendQuestionID = new Button("Get");
			Button btnNextNumOfOptions = new Button("Next");
			BorderPane addQuestion = new BorderPane();
			HBox typeQuestion = new HBox();
			typeQuestion.setPadding(new Insets(10));
			typeQuestion.getChildren().addAll(btnOpenQuestion,btnMultiQuestion);
			Label lblwhatQuestion = new Label("What is the question?");
			Label lblwhatAnswer = new Label("What is the answer?");
			Label lblHowManyAnswers = new Label("How many options between 2 to 10 would you like the questions to have? \n Please note that 2 options are constant: \n ('More than one answer is correct' , 'None of the above')");
			Label lblgetQuestionID = new Label("What is the ID of the question you'd like to update?");
			Label lblUpdateQuestion = new Label("What is the new/updated text of the question?");
			Label emptyField1 = new Label("This field cannot be empty");
			Label emptyField2 = new Label("This field cannot be empty");
			Label emptyField3 = new Label("One of the required fields are empty");
			Label emptyField4 = new Label("One of the required fields are empty");
			emptyField1.setTextFill(Color.RED);
			emptyField1.setVisible(false);
			emptyField2.setTextFill(Color.RED);
			emptyField2.setVisible(false);
			emptyField3.setTextFill(Color.RED);
			emptyField3.setVisible(false);
			emptyField3.setPadding(new Insets(10));
			emptyField4.setTextFill(Color.RED);
			emptyField4.setVisible(false);
			TextField tfwhatQuestion = new TextField();
			TextField tfwhatAnswer = new TextField();
			TextField tfHowManyAnswers = new TextField();
			TextField tfgetQuestionID = new TextField();
			TextField tfUpdateQuestion = new TextField();
			GridPane gettingQuestionAnswers = new GridPane();
			gettingQuestionAnswers.setVgap(10);
			gettingQuestionAnswers.setHgap(10);
			gettingQuestionAnswers.add(lblwhatQuestion, 1, 1);
			gettingQuestionAnswers.add(tfwhatQuestion, 2, 1);
			gettingQuestionAnswers.add(lblwhatAnswer, 1, 2);
			gettingQuestionAnswers.add(tfwhatAnswer, 2, 2);
			gettingQuestionAnswers.add(lblHowManyAnswers,1,2);
			gettingQuestionAnswers.add(tfHowManyAnswers, 2, 2);
			gettingQuestionAnswers.add(btnSendNewQuestion,2,10);
			gettingQuestionAnswers.add(btnNextNumOfOptions, 2, 10);
			gettingQuestionAnswers.add(emptyField3, 0, 3);
			gettingQuestionAnswers.setColumnSpan(emptyField3,3);
			lblwhatQuestion.setVisible(false);
			tfwhatQuestion.setVisible(false);
			lblwhatAnswer.setVisible(false);
			tfwhatAnswer.setVisible(false);
			lblHowManyAnswers.setVisible(false);
			tfHowManyAnswers.setVisible(false);
			btnSendNewQuestion.setVisible(false);
			btnNextNumOfOptions.setVisible(false);
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
								emptyField3.setVisible(true);
							} else {
								emptyField3.setVisible(false);
							}
							
						}
					});
					
				}
				
			});
			btnMultiQuestion.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					for(int i=0;i<gettingQuestionAnswers.getChildren().size();i++) 
						gettingQuestionAnswers.getChildren().get(i).setVisible(false);
					
					
					lblwhatQuestion.setVisible(true);
					tfwhatQuestion.setVisible(true);
					lblHowManyAnswers.setVisible(true);
					tfHowManyAnswers.setVisible(true);
					btnNextNumOfOptions.setVisible(true);
					btnNextNumOfOptions.setOnAction(new EventHandler<ActionEvent>() {
						
						@Override
						public void handle(ActionEvent arg0) {
							if(tfwhatQuestion.getText().isBlank()||tfHowManyAnswers.getText().isBlank()) {
								emptyField3.setVisible(true);
							}else {
								emptyField3.setVisible(false);
							}
							
						}
					});
					
				}
			});
	
			addQuestion.setTop(typeQuestion);
			addQuestion.setCenter(gettingQuestionAnswers);
			GridPane UpdateQuestion = new GridPane();
			UpdateQuestion.setVgap(10);
			UpdateQuestion.setHgap(10);
			UpdateQuestion.add(lblgetQuestionID, 1, 1);
			UpdateQuestion.add(tfgetQuestionID, 2, 1);
			UpdateQuestion.add(emptyField1,1,3);
			UpdateQuestion.setColumnSpan(emptyField1, 2);
			UpdateQuestion.add(btnSendQuestionID, 3, 1);
			UpdateQuestion.add(lblUpdateQuestion, 1, 3);
			UpdateQuestion.add(tfUpdateQuestion, 2, 3);
			UpdateQuestion.add(btnSendUpdateQuestion, 3, 3);
			UpdateQuestion.add(emptyField2,1,4);
			UpdateQuestion.setColumnSpan(emptyField2, 4);
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
						emptyField1.setVisible(false);
						lblUpdateQuestion.setVisible(true);
						tfUpdateQuestion.setVisible(true);
						btnSendUpdateQuestion.setVisible(true);
					}else {
						emptyField1.setVisible(true);
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
						emptyField2.setVisible(false);
					}else {
						emptyField2.setVisible(true);

					}
					
				}
			});
			////
			HBox hbRootbuttons = new HBox();
			hbRootbuttons.setPadding(new Insets(10));
			hbRootbuttons.getChildren().addAll(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8);
			StackPane root2 = new StackPane();
			ScrollPane QuestionBank = new ScrollPane();
			QuestionBank.setVbarPolicy(ScrollBarPolicy.ALWAYS);
			
			GridPane UpdateAnswer = new GridPane();
			Label lblGetQuestionIDForAnswer = new Label("What is the ID of the question you'd like to update?");
			TextField tfGetQuestionIDForAnswer = new TextField();
			Button btnGetQuestionIDForAnswer = new Button("Get");
			Label emptyField5 = new Label("This field cannot be empty");
			UpdateAnswer.setVgap(10);
			UpdateAnswer.setHgap(10);
			UpdateAnswer.add(lblGetQuestionIDForAnswer, 1, 1);
			UpdateAnswer.add(tfGetQuestionIDForAnswer, 2, 1);
			UpdateAnswer.add(btnGetQuestionIDForAnswer, 3, 1);
			UpdateAnswer.add(emptyField5, 1, 2);
			lblGetQuestionIDForAnswer.setVisible(true);
			tfGetQuestionIDForAnswer.setVisible(true);
			btnGetQuestionIDForAnswer.setVisible(true);
			emptyField5.setVisible(false);
			emptyField5.setTextFill(Color.RED);
			btnGetQuestionIDForAnswer.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					if(tfGetQuestionIDForAnswer.getText().isBlank()) {
						emptyField5.setVisible(true);
					}else {
						emptyField5.setVisible(false);
					}
				}
			});
			
			GridPane RemoveAnswer = new GridPane();
			RemoveAnswer.setHgap(10);
			RemoveAnswer.setVgap(10);
			Label lblGetQuestionIDToRemove = new Label("What is the ID of the question you'd like to update?");
			TextField tfGetQuestionIDToRemove = new TextField();
			Button btnGetQuestionIDToRemove = new Button("Get");
			Label emptyField6 = new Label("This field cannot be empty");
			RemoveAnswer.add(lblGetQuestionIDToRemove, 1, 1);
			RemoveAnswer.add(tfGetQuestionIDToRemove, 2, 1);
			RemoveAnswer.add(btnGetQuestionIDToRemove, 3, 1);
			RemoveAnswer.add(emptyField6, 1, 2);
			lblGetQuestionIDToRemove.setVisible(true);
			tfGetQuestionIDToRemove.setVisible(true);
			btnGetQuestionIDToRemove.setVisible(true);
			emptyField6.setVisible(false);
			emptyField6.setTextFill(Color.RED);
			btnGetQuestionIDToRemove.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					if(tfGetQuestionIDToRemove.getText().isBlank()) {
						emptyField6.setVisible(true);
					}else {
						emptyField6.setVisible(false);
					}
				}
			});
			
			
			//GridPane createUserManaged = new GridPane();
			//createUserManaged.setHgap(10);
			//createUserManaged.setVgap(10);
			Label lblHowMany = new Label("How many questions would you like the Test to have?");
			TextField tfHowMany = new TextField();
			Button btnHowMany = new Button("Next");
			Label emptyField7 = new Label("This field cannot be empty");
			emptyField7.setTextFill(Color.RED);
			lblHowMany.setVisible(true);
			tfHowMany.setVisible(true);
			btnHowMany.setVisible(true);
			emptyField7.setVisible(false);
			//createUserManaged.add(lblHowMany, 1, 1);
			//createUserManaged.add(tfHowMany, 2, 1);
			//createUserManaged.add(btnHowMany, 3, 1);
			//createUserManaged.add(lblHowMany, 1, 2);
			
			Label lbl6 = new Label("6");
			Label lbl7 = new Label("7");
			Label lbl8 = new Label("8");
			QuestionBank.setVisible(false);
			addQuestion.setVisible(false);
			UpdateAnswer.setVisible(false);
			RemoveAnswer.setVisible(false);
			//createUserManaged.setVisible(false);
			lbl6.setVisible(false);
			lbl7.setVisible(false);
			lbl8.setVisible(false);

			root.setTop(hbRootbuttons);
			root2.getChildren().addAll(QuestionBank,addQuestion,UpdateQuestion,UpdateAnswer,RemoveAnswer,lbl6,lbl7,lbl8);
			btn1.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					for (int i =0;i<root2.getChildren().size();i++) {
						root2.getChildren().get(i).setVisible(false);
					}
					QuestionBank.setVisible(true);
					
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
					lbl6.setVisible(true);
					
				}
				
			});

			btn7.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					for (int i =0;i<root2.getChildren().size();i++) {
						root2.getChildren().get(i).setVisible(false);
					}
					lbl7.setVisible(true);
					
				}
				
			});

			btn8.setOnAction(new EventHandler<ActionEvent>(){

				@Override
				public void handle(ActionEvent arg0) {
					for (int i =0;i<root2.getChildren().size();i++) {
						root2.getChildren().get(i).setVisible(false);
					}
					lbl8.setVisible(true);
					
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
