package entities.questions;

import java.io.Serializable;

public class OpenEndQuestion extends Question implements Serializable {

    private static final long serialVersionUID = -5707421170553731812L;

    private String rightAnswer;

    public OpenEndQuestion(String text, String rightAnswer){
        super(text);
        this.rightAnswer = rightAnswer;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public int getAnswerLength() {
    	return rightAnswer.length();
    }

    public boolean setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
        return true;
    }

    @Override
    public String toString(){
        return super.toString() + "\n" + "The answer is: " + this.rightAnswer;
    }

    @Override
    public String noAnswer() {
        return super.toString();
    }

    @Override
    public boolean equals(Object other){
        if(!(other instanceof OpenEndQuestion))
            return false;
        OpenEndQuestion op = (OpenEndQuestion)other;
        return (op.text.equals(this.text))&&(op.rightAnswer.equals(this.rightAnswer));
    }
}
