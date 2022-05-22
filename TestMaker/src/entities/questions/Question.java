package entities.questions;

import java.io.Serializable;

public abstract class Question implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    private final int questionId;
    protected String text;
    private static int ID = 1;

    public static void increment() {
        ID++;
    }

    public Question(String text){
        this.text = text;
        this.questionId = ID;
        ID++;
    }

    public boolean setText(String text){
        this.text = text;
        return true;
    };

    public String getText(){
        return this.text;
    }

    public int getQuestionId() {
        return questionId;
    }

    public abstract int getAnswerLength();

    public abstract String noAnswer();

    @Override
    public String toString(){
        return "Question " + this.questionId + " is: " + this.text;
    }

    @Override
    public Question clone() throws CloneNotSupportedException {
        return (Question) super.clone();
    }
}
