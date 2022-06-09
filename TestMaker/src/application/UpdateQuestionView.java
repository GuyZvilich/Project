package application;

import static constants.Constants.QUESTION_TO_USER_01;
import static constants.Constants.QUESTION_TO_USER_08;
import static constants.Constants.UPDATE;
import static entities.Manager.updateQuestionTextInWindow;

import entities.Manager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class UpdateQuestionView {
	private GridPane UpdateQuestion = new GridPane();
	private Label lblgetQuestionID = new Label(QUESTION_TO_USER_08);
	private TextField tfgetQuestionID = new TextField();
	private Button btnSendQuestionID = new Button("Get");
	private Label lblEmptyField3 = new Label("This field cannot be empty");
	private Label lblThisIsTheQuestion = new Label("The is the question:");
	private Label questionText = new Label();
	private Label lblUpdateQuestion = new Label(QUESTION_TO_USER_01);
	private TextField tfUpdateQuestion = new TextField();
	private Button btnSendUpdateQuestion = new Button(UPDATE);
	private Label lblEmptyField3_3 = new Label("This field cannot be empty");
	private Label successOfUpdate = new Label();
	
	public GridPane getGPupdateQuestion() {
		return this.UpdateQuestion;
	}
	
	public void reset() {
        tfgetQuestionID.setText("");
        lblUpdateQuestion.setVisible(false);
        tfUpdateQuestion.setVisible(false);
        btnSendUpdateQuestion.setVisible(false);
        lblThisIsTheQuestion.setVisible(false);
        questionText.setVisible(false);
        UpdateQuestion.setVisible(true);
	}
	
	public UpdateQuestionView() {
	    UpdateQuestion.setPadding(new Insets(10));
	    UpdateQuestion.setVgap(10);
	    UpdateQuestion.setHgap(10);
	    UpdateQuestion.add(lblgetQuestionID, 1, 1);
	    UpdateQuestion.add(tfgetQuestionID, 2, 1);
	    UpdateQuestion.add(btnSendQuestionID, 3, 1);
	    UpdateQuestion.add(lblEmptyField3, 1, 2);
	    UpdateQuestion.setColumnSpan(lblEmptyField3, 2);
	    UpdateQuestion.add(lblThisIsTheQuestion, 1, 3);
	    UpdateQuestion.add(questionText, 2, 3);
	    UpdateQuestion.add(lblUpdateQuestion, 1, 5);
	    UpdateQuestion.add(tfUpdateQuestion, 2, 5);
	    UpdateQuestion.add(btnSendUpdateQuestion, 3, 5);
	    UpdateQuestion.add(lblEmptyField3_3, 1, 6);
	    UpdateQuestion.setColumnSpan(lblEmptyField3_3, 6);
	    UpdateQuestion.add(successOfUpdate, 2, 6);
	    UpdateQuestion.setVisible(false);
	    successOfUpdate.setVisible(false);
	    successOfUpdate.setTextFill(Color.GREEN);
	    lblEmptyField3.setTextFill(Color.RED);
	    lblEmptyField3.setVisible(false);
	    lblEmptyField3_3.setTextFill(Color.RED);
	    lblEmptyField3_3.setVisible(false);
	    //UpdateQuestion.setPadding(new Insets(10));
	    //UpdateQuestion.setVgap(10);
	    //UpdateQuestion.setHgap(10);
	    //UpdateQuestion.add(lblgetQuestionID, 1, 1);
	    //UpdateQuestion.add(tfgetQuestionID, 2, 1);
	    //UpdateQuestion.add(btnSendQuestionID, 3, 1);
	   // UpdateQuestion.add(lblEmptyField3, 1, 2);
	    //UpdateQuestion.setColumnSpan(lblEmptyField3, 2);
	   // UpdateQuestion.add(lblThisIsTheQuestion, 1, 3);
	   // UpdateQuestion.add(questionText, 2, 3);
	    //UpdateQuestion.add(lblUpdateQuestion, 1, 5);
	    //UpdateQuestion.add(tfUpdateQuestion, 2, 5);
	    //UpdateQuestion.add(btnSendUpdateQuestion, 3, 5);
	    //UpdateQuestion.add(lblEmptyField3_3, 1, 6);
	    //UpdateQuestion.setColumnSpan(lblEmptyField3_3, 6);
	    //UpdateQuestion.add(successOfUpdate, 2, 6);
	    //UpdateQuestion.setVisible(false);
	    lblgetQuestionID.setVisible(true);
	    tfgetQuestionID.setVisible(true);
	    btnSendQuestionID.setVisible(true);
	    lblUpdateQuestion.setVisible(false);
	    tfUpdateQuestion.setVisible(false);
	    btnSendUpdateQuestion.setVisible(false);
	    btnSendQuestionID.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        public void handle(ActionEvent arg0) {
	            lblUpdateQuestion.setVisible(false);
	            tfUpdateQuestion.setVisible(false);
	            btnSendUpdateQuestion.setVisible(false);
	            lblThisIsTheQuestion.setVisible(false);
	            questionText.setVisible(false);

	            if (!(tfgetQuestionID.getText().equals(""))) {
	                lblThisIsTheQuestion.setVisible(true);
	                questionText.setText(Manager.questionBankProvider().get(Integer.parseInt(tfgetQuestionID.getText()) - 1).getText());
	                questionText.setVisible(true);
	                lblEmptyField3.setVisible(false);
	                lblUpdateQuestion.setVisible(true);
	                tfUpdateQuestion.setVisible(true);
	                btnSendUpdateQuestion.setVisible(true);
	            } else {
	                lblEmptyField3.setVisible(true);
	            }

	        }
	    });
	    
	    btnSendUpdateQuestion.setOnAction(new EventHandler<ActionEvent>() {

	        @Override
	        public void handle(ActionEvent arg0) {
	            lblEmptyField3_3.setVisible(tfUpdateQuestion.getText().equals(""));
	            if (!lblEmptyField3_3.isVisible()) {
	                successOfUpdate.setText(updateQuestionTextInWindow(Integer.parseInt(tfgetQuestionID.getText()) - 1, tfUpdateQuestion.getText()));
	                successOfUpdate.setVisible(true);
	            }

	        }
	    });
	}
}
