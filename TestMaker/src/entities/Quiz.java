package entities;

import entities.comparators.compareByAnswerLength;
import entities.questions.MultipleChoiceOption;
import entities.questions.MultipleChoiceQuestion;
import entities.questions.Question;
import main.Main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import static constants.Constants.*;
import static entities.Manager.*;

public class Quiz implements Cloneable{
    private ArrayList<Question> questions;

    public Quiz(ArrayList<Question> questions, int numOfQuestions) {
        ArrayList<Question> questionBankCopy = new ArrayList<>(questions);
    	ArrayList<Question> list = new ArrayList<>(numOfQuestions);

        for (int i = 0; i < numOfQuestions; i++) {
            int random = new Random().nextInt(questionBankCopy.size());
            while (questions.get(random) == null) {
                random = new Random().nextInt(questionBankCopy.size());
            }
            list.add(questionBankCopy.get(random));
            reduceArray(questionBankCopy, random);
        }
        this.questions = sortByAnswerLength(list, new compareByAnswerLength());
    }

    public Quiz(ArrayList<Question> questionBank, int numOfQuestions, ArrayList<Integer> indexes) {
    	ArrayList<Question> list = new ArrayList<Question>(numOfQuestions);
        int j = 0;
        for (int id : indexes) {
            for (int i = 0; i < questionBank.size(); i++) {
                if (questionBank.get(i) == null)
                    break;
                if (questionBank.get(i).getQuestionId() == id) {
                    if (questionBank.get(i) instanceof MultipleChoiceQuestion) {
                        System.out.print("Question " + questionBank.get(i).getQuestionId() + " ");
                        int index = Main.integerOptionDistributor(9);
                        while (index == 0) {
                            index = Main.integerOptionDistributor(9);
                        }
                        if (index == 1)
                            list.add(questionBank.get(i));
                        else {
                            Set<MultipleChoiceOption> multipleChoiceSet = new Set<>(MultipleChoiceOption.class);
                            String options = Main.stringOptionDistributor(8);
                            String[] opt = options.split(",");
                            for (String str : opt) {
                                int slot = Integer.parseInt(str);
                                String text = ((MultipleChoiceQuestion) questionBank.get(i)).getOptions().get(slot).getOptionText();
                                boolean verdict = ((MultipleChoiceQuestion) questionBank.get(i)).getOptions().get(slot).isCorrectOption();
                                multipleChoiceSet.add(new MultipleChoiceOption(text,verdict));
                            }

                            multipleChoiceSet.add(new MultipleChoiceOption("More than one answer is correct", isMoreThanOneCorrect(multipleChoiceSet)));
                            multipleChoiceSet.add(new MultipleChoiceOption("None of the above", isNoneCorrect(multipleChoiceSet)));

                            list.add(questionBank.get(i));
                            if (((MultipleChoiceQuestion) list.get(j)).setOptions(multipleChoiceSet))
                                System.out.println(SUCCESS_MESSAGE_06);
                        }
                    } else {
                        list.add(questionBank.get(i));
                    }
                    j++;
                }
            }
        }
        this.questions = list;
    }

    public Quiz(ArrayList<Question> questions){
        this.questions = questions;
    }

    @Override
    protected Quiz clone() throws CloneNotSupportedException {
        ArrayList<Question> ques = new ArrayList<>();
        for(Question question: this.questions){
            ques.add(question.clone());
        }
        Quiz quiz = (Quiz) super.clone();
        quiz.questions = ques;
        return quiz;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (Question question : this.questions) {
            ret.append(question.toString()).append("\n\n");
        }
        return ret.toString();
    }

    public String questionsWithNoAnswer(){
        StringBuilder ret = new StringBuilder();
        for (Question question : this.questions) {
            ret.append(question.noAnswer()).append("\n\n");
        }
        return ret.toString();
    }


    private static void reduceArray(ArrayList<Question> questionBank, int random) {
        questionBank.remove(random);
    }

    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    public static ArrayList<Question> sortByAnswerLength(ArrayList<Question> arr, Comparator<Question> c) {
        arr.sort(c);
    	return arr;
    }
}
