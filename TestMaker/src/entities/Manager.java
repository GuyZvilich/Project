package entities;

import entities.questions.MultipleChoiceOption;
import entities.questions.MultipleChoiceQuestion;
import entities.questions.OpenEndQuestion;
import entities.questions.Question;
import main.Main;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

import static constants.Constants.*;
import static main.Main.integerOptionDistributor;

public class Manager {

    private static final String filepath = "questionBank";

    private static ArrayList<Question> questionBank = getQuestionBank();

    public static ArrayList<Quiz> lastCreatedQuizBank = new ArrayList<>();

    /*public static ArrayList<Question> getQuestionBank() {
        Set<MultipleChoiceOption> set1 = new Set<>(MultipleChoiceOption.class);
        set1.add(new MultipleChoiceOption("2015", false));
        set1.add(new MultipleChoiceOption("2019", true));
        set1.add(new MultipleChoiceOption("More than one answer is correct", false));
        set1.add(new MultipleChoiceOption("None of the above", false));

        Set<MultipleChoiceOption> set2 = new Set<>(MultipleChoiceOption.class);
        set2.add(new MultipleChoiceOption("English", true));
        set2.add(new MultipleChoiceOption("French", true));
        set2.add(new MultipleChoiceOption("More than one answer is correct", true));
        set2.add(new MultipleChoiceOption("None of the above", false));

        Set<MultipleChoiceOption> set3 = new Set<>(MultipleChoiceOption.class);
        set3.add(new MultipleChoiceOption("Peacock", false));
        set3.add(new MultipleChoiceOption("Markhor", true));
        set3.add(new MultipleChoiceOption("More than one answer is correct", false));
        set3.add(new MultipleChoiceOption("None of the above", false));

        Set<MultipleChoiceOption> set4 = new Set<>(MultipleChoiceOption.class);
        set4.add(new MultipleChoiceOption("Carrots", true));
        set4.add(new MultipleChoiceOption("Potatoes", false));
        set4.add(new MultipleChoiceOption("More than one answer is correct", false));
        set4.add(new MultipleChoiceOption("None of the above", false));

        Set<MultipleChoiceOption> set5 = new Set<>(MultipleChoiceOption.class);
        set5.add(new MultipleChoiceOption("Salt", true));
        set5.add(new MultipleChoiceOption("Butter", false));
        set5.add(new MultipleChoiceOption("More than one answer is correct", false));
        set5.add(new MultipleChoiceOption("None of the above", false));

        Set<MultipleChoiceOption> set6 = new Set<>(MultipleChoiceOption.class);
        set6.add(new MultipleChoiceOption("Coffee", false));
        set6.add(new MultipleChoiceOption("Sugar", true));
        set6.add(new MultipleChoiceOption("More than one answer is correct", false));
        set6.add(new MultipleChoiceOption("None of the above", false));

        Set<MultipleChoiceOption> set7 = new Set<>(MultipleChoiceOption.class);
        set7.add(new MultipleChoiceOption("Coal", false));
        set7.add(new MultipleChoiceOption("Gas", false));
        set7.add(new MultipleChoiceOption("More than one answer is correct", false));
        set7.add(new MultipleChoiceOption("None of the above", true));

        Set<MultipleChoiceOption> set8 = new Set<>(MultipleChoiceOption.class);
        set8.add(new MultipleChoiceOption("Afghanistan", false));
        set8.add(new MultipleChoiceOption("India", true));
        set8.add(new MultipleChoiceOption("More than one answer is correct", false));
        set8.add(new MultipleChoiceOption("None of the above", false));

        Set<MultipleChoiceOption> set9 = new Set<>(MultipleChoiceOption.class);
        set9.add(new MultipleChoiceOption("Red Chili Powder", false));
        set9.add(new MultipleChoiceOption("Turmeric", true));
        set9.add(new MultipleChoiceOption("More than one answer is correct", false));
        set9.add(new MultipleChoiceOption("None of the above", false));

        Set<MultipleChoiceOption> set10 = new Set<>(MultipleChoiceOption.class);
        set10.add(new MultipleChoiceOption("Rupee", true));
        set10.add(new MultipleChoiceOption("Riyal", false));
        set10.add(new MultipleChoiceOption("More than one answer is correct", false));
        set10.add(new MultipleChoiceOption("None of the above", false));

        Set<MultipleChoiceOption> set11 = new Set<>(MultipleChoiceOption.class);
        set11.add(new MultipleChoiceOption("Rupee", true));
        set11.add(new MultipleChoiceOption("Riyal", false));
        set11.add(new MultipleChoiceOption("More than one answer is correct", false));
        set11.add(new MultipleChoiceOption("None of the above", false));

        Set<MultipleChoiceOption> set12 = new Set<>(MultipleChoiceOption.class);
        set12.add(new MultipleChoiceOption("Savory", false));
        set12.add(new MultipleChoiceOption("Sweet", false));
        set12.add(new MultipleChoiceOption("More than one answer is correct", false));
        set12.add(new MultipleChoiceOption("None of the above", true));

        Set<MultipleChoiceOption> set13 = new Set<>(MultipleChoiceOption.class);
        set13.add(new MultipleChoiceOption("Freedom", true));
        set13.add(new MultipleChoiceOption("Goodwill", false));
        set13.add(new MultipleChoiceOption("More than one answer is correct", false));
        set13.add(new MultipleChoiceOption("None of the above", false));

        Set<MultipleChoiceOption> set14 = new Set<>(MultipleChoiceOption.class);
        set14.add(new MultipleChoiceOption("Vegetable", false));
        set14.add(new MultipleChoiceOption("Herb", false));
        set14.add(new MultipleChoiceOption("More than one answer is correct", false));
        set14.add(new MultipleChoiceOption("None of the above", true));

        Set<MultipleChoiceOption> set15 = new Set<>(MultipleChoiceOption.class);
        set15.add(new MultipleChoiceOption("Wood", true));
        set15.add(new MultipleChoiceOption("Clay", false));
        set15.add(new MultipleChoiceOption("More than one answer is correct", false));
        set15.add(new MultipleChoiceOption("None of the above", false));

        Set<MultipleChoiceOption> set16 = new Set<>(MultipleChoiceOption.class);
        set16.add(new MultipleChoiceOption("Cotton", true));
        set16.add(new MultipleChoiceOption("Linen", true));
        set16.add(new MultipleChoiceOption("More than one answer is correct", true));
        set16.add(new MultipleChoiceOption("None of the above", false));

        Set<MultipleChoiceOption> set17 = new Set<>(MultipleChoiceOption.class);
        set17.add(new MultipleChoiceOption("Beer", true));
        set17.add(new MultipleChoiceOption("Wine", true));
        set17.add(new MultipleChoiceOption("More than one answer is correct", true));
        set17.add(new MultipleChoiceOption("None of the above", false));

        Set<MultipleChoiceOption> set18 = new Set<>(MultipleChoiceOption.class);
        set18.add(new MultipleChoiceOption("Green tea", false));
        set18.add(new MultipleChoiceOption("Black tea", false));
        set18.add(new MultipleChoiceOption("More than one answer is correct", false));
        set18.add(new MultipleChoiceOption("None of the above", true));

        Set<MultipleChoiceOption> set19 = new Set<>(MultipleChoiceOption.class);
        set19.add(new MultipleChoiceOption("Hazelnuts", false));
        set19.add(new MultipleChoiceOption("Mint leaves", true));
        set19.add(new MultipleChoiceOption("More than one answer is correct", false));
        set19.add(new MultipleChoiceOption("None of the above", false));

        Set<MultipleChoiceOption> set20 = new Set<>(MultipleChoiceOption.class);
        set20.add(new MultipleChoiceOption("4 kilos", true));
        set20.add(new MultipleChoiceOption("4000 grams", true));
        set20.add(new MultipleChoiceOption("More than one answer is correct", true));
        set20.add(new MultipleChoiceOption("None of the above", false));

        return new ArrayList<Question>(Arrays.asList(new OpenEndQuestion("What is the capitol of France?", "Paris"),
                new OpenEndQuestion("Who wrote The Lord of the Rings?", "J.R.R Tolkien"),
                new OpenEndQuestion("When was end of WW2?", "1945"),
                new OpenEndQuestion("What does 'www' stand for in a website browser?", "World Wide Web"),
                new OpenEndQuestion("How long is an Olympic swimming pool (in meters)?", "50 meters"),
                new OpenEndQuestion("What countries made up the original Axis powers in WW2?", "Germany, Italy, and Japan"),
                new OpenEndQuestion("Which country do cities of Perth, Adelade & Brisbane belong to?", "Australia"),
                new OpenEndQuestion("What geometric shape is generally used for stop signs?", "Octagon"),
                new OpenEndQuestion("What is 'cynophobia'?", "Fear of dogs"),
                new OpenEndQuestion("Who named the Pacific Ocean?", "Ferdinand Magellan"),
                new OpenEndQuestion("How many languages are written from right to left?", "12"),
                new OpenEndQuestion("What is the name of the man who launched eBay back in 1995?", "Pierre Omidyar"),
                new OpenEndQuestion("What is the name of the biggest technology company in South Korea?", "Samsung"),
                new OpenEndQuestion("Which animal can be seen on the Porsche logo?", "Horse"),
                new OpenEndQuestion("Which monarch officially made Valentine's Day a holiday in 1537?", "Henry VIII"),
                new OpenEndQuestion("Who was the first woman to win a Nobel Prize (in 1903)?", "Marie Curie"),
                new OpenEndQuestion("The first dictionary was written by?", "Robert Cawdrey"),
                new OpenEndQuestion("Worship of Krishna is observed by which Religious Faith?", "Hinduism"),
                new OpenEndQuestion("What is the romanized Arabic word for 'moon'?", "Qamar"),
                new OpenEndQuestion("Who was the first woman pilot to fly solo across the Atlantic?", "Amelia Earhart"),
                new MultipleChoiceQuestion("When did Jonas Brothers make their comeback to the music world?",set1),
                new MultipleChoiceQuestion("What is the national language of Canada?",set2),
                new MultipleChoiceQuestion("What is the national animal of Pakistan?",set3),
                new MultipleChoiceQuestion("A la Crecy is a French dish made of what?",set4),
                new MultipleChoiceQuestion("Which core ingredient is important to cook a savory dish?",set5),
                new MultipleChoiceQuestion("Brazil is the biggest producer of?",set6),
                new MultipleChoiceQuestion("Saudi Arabia is the biggest producer of?",set7),
                new MultipleChoiceQuestion("Which country is infamously known as Arch Rival of Pakistan?",set8),
                new MultipleChoiceQuestion("Which is ingredient found in traditional garam masala spice?",set9),
                new MultipleChoiceQuestion("What is the currency of Pakistan?",set10),
                new MultipleChoiceQuestion("What is the currency of India?",set11),
                new MultipleChoiceQuestion("What term is used for sweet dishes in English?",set12),
                new MultipleChoiceQuestion("What does independence mean?",set13),
                new MultipleChoiceQuestion("What is a tomato?",set14),
                new MultipleChoiceQuestion("Ancient Egyptian Houses were built of what?",set15),
                new MultipleChoiceQuestion("What fabric is made of flax?",set16),
                new MultipleChoiceQuestion("Which is the most common drink in Europe",set17),
                new MultipleChoiceQuestion("What is a great remedy for weight loss?",set18),
                new MultipleChoiceQuestion("What is a helpful remedy for stomach ache?",set19),
                new MultipleChoiceQuestion("What is the average weight of the human brain?",set20)));
    }*/

    public static ArrayList<Question> getQuestionBank() {
        try {

            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            ArrayList<Question> obj = (ArrayList<Question>) objectIn.readObject();
            objectIn.close();

            for (Question question : obj) {
                if (question != null)
                    Question.increment();
            }

            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static int questionBankSize() {
        return questionBank.size();
    }

    public static void saveQuestionBank() {
        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(questionBank);
            objectOut.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void writeQuizToFile(Quiz quiz) throws FileNotFoundException {
        LocalDateTime date = LocalDateTime.now();
        String examFilepath = "Quizzes/exam_" + date.getYear() + "_" + String.format("%02d", date.getMonthValue()) + "_" + String.format("%02d", date.getDayOfMonth());
        String solutionFilepath = "Quizzes/solution_" + date.getYear() + "_" + String.format("%02d", date.getMonthValue()) + "_" + String.format("%02d", date.getDayOfMonth());
        fileWriter(examFilepath, solutionFilepath, quiz);
    }

    public static void readQuizFromFile(String dateString) {
        try {
            String[] dateParts = dateString.split("/");
            String examFilepath = "Quizzes/exam_" + dateParts[2] + "_" + String.format("%02d", Integer.parseInt(dateParts[1])) + "_" + dateParts[0];
            String solutionFilepath = "Quizzes/solution_" + dateParts[2] + "_" + String.format("%02d", Integer.parseInt(dateParts[1])) + "_" + dateParts[0];

            File examFile = new File(examFilepath);
            File solutionFile = new File(solutionFilepath);
            Scanner examReader = new Scanner(examFile);
            Scanner solutionReader = new Scanner(solutionFile);

            LocalDateTime date = LocalDateTime.now();
            String examCopyFilepath = "Quizzes/exam_" + date.getYear() + "_" + String.format("%02d", date.getMonthValue()) + "_" + String.format("%02d", date.getDayOfMonth());
            String solutionCopyFilepath = "Quizzes/solution_" + date.getYear() + "_" + String.format("%02d", date.getMonthValue()) + "_" + String.format("%02d", date.getDayOfMonth());

            File examCopyFile = new File(examCopyFilepath);
            File solutionCopyFile = new File(solutionCopyFilepath);
            PrintWriter examPW = new PrintWriter(examCopyFile);
            PrintWriter solutionPW = new PrintWriter(solutionCopyFile);
            copyWriter(examReader, examPW);
            copyWriter(solutionReader, solutionPW);


        } catch (FileNotFoundException e) {
            System.out.println(ERROR_011);
        }
    }

    public static void quizCopyFile(Quiz quiz) {
        LocalDateTime date = LocalDateTime.now();
        String examFilepath = "Quizzes/exam_" + date.getYear() + "_" + String.format("%02d", date.getMonthValue()) + "_" + String.format("%02d", date.getDayOfMonth()) + "_copy";
        String solutionFilepath = "Quizzes/solution_" + date.getYear() + "_" + String.format("%02d", date.getMonthValue()) + "_" + String.format("%02d", date.getDayOfMonth()) + "_copy";
        fileWriter(examFilepath, solutionFilepath, quiz);
    }

    private static void fileWriter(String examFilepath, String solutionFilepath, Quiz quiz) {
        try {
            File examFile = new File(examFilepath);
            File solutionFile = new File(solutionFilepath);
            PrintWriter pwExam = new PrintWriter(examFile);
            PrintWriter pwSolution = new PrintWriter(solutionFile);
            pwExam.println(quiz.questionsWithNoAnswer());
            pwExam.close();
            pwSolution.println(quiz);
            pwSolution.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void copyWriter(Scanner reader, PrintWriter printWriter) {
        while (reader.hasNext()) {
            printWriter.println(reader.nextLine());
        }
        printWriter.close();
        reader.close();
    }


    public static Quiz createRandomQuiz(int numOfQuestions) {
        Quiz quiz = new Quiz(questionBank, numOfQuestions);
        quizTryCatcher(quiz);
        return quiz;
    }

    public static Quiz createManagedQuiz(int numOfQuestions, ArrayList<Integer> arr) {
        Quiz quiz = new Quiz(questionBank, numOfQuestions, arr);
        quizTryCatcher(quiz);
        return quiz;
    }


    public static void questionAdder(ArrayList<Question> questionBank, Question question) {
        int length = questionBank.size();
        if (isEmpty(questionBank)) {
            for (int i = 0; i < length; i++) {
                if (questionBank.get(i) == null) {
                    questionBank.set(i, question);
                    break;
                }
            }
        } else {
            questionBank.add(length, question);
        }
    }

    public static void addQuestionToBank(int num) {
        switch (num) {
            case 1:
                String text = Main.stringOptionDistributor(3);
                String answer = Main.stringOptionDistributor(4);
                OpenEndQuestion question = new OpenEndQuestion(text, answer);
                if (Manager.isQuestionNotExists(questionBank, question))
                    questionAdder(questionBank, question);
                else
                    System.out.println(ERROR_012);
                break;
            case 2:
                text = Main.stringOptionDistributor(3);
                int number = integerOptionDistributor(5);
                if (number == 0) {
                    System.out.println(ERROR_013);
                }
                Set<MultipleChoiceOption> mco = new Set<>(MultipleChoiceOption.class);
                System.out.println(initialOptions(number));
                for (int i = 0; i < number - 2; i++) {
                    mco.add(optionSetterWithProvide(i));
                }
                mco.add(new MultipleChoiceOption("More than one answer is correct", isMoreThanOneCorrect(mco)));
                mco.add(new MultipleChoiceOption("None of the above", isNoneCorrect(mco)));

                MultipleChoiceQuestion question2 = new MultipleChoiceQuestion(text, mco);
                if (Manager.isQuestionNotExists(questionBank, question2))
                    questionAdder(questionBank, question2);
                else
                    System.out.println(ERROR_012);
                break;
            default:
                System.out.println(ERROR_015);
                break;
        }
    }


    public static boolean isEmpty(ArrayList<Question> array) {
        for (Object s : array) {
            if (s == null) return true;
        }
        return false;
    }

    public static boolean isQuestionNotExists(ArrayList<Question> questionBank, Question question) {
        for (Question quest : questionBank) {
            if (question.equals(quest)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMoreThanOneCorrect(Set<MultipleChoiceOption> optionSet) {
        boolean[] arr = new boolean[optionSet.getSize()];
        int i = 0;
        for (MultipleChoiceOption mco : optionSet.getSet()) {
            if (mco != null) {
                arr[i] = mco.isCorrectOption();
                i++;
            }
        }
        return isMoreThanOneTrue(arr);
    }

    public static boolean isNoneCorrect(Set<MultipleChoiceOption> optionSet) {
        boolean[] arr = new boolean[optionSet.getSize()];
        int i = 0;
        for (MultipleChoiceOption mco : optionSet.getSet()) {
            if (mco != null) {
                arr[i] = mco.isCorrectOption();
                i++;
            }
        }
        return areNoneTrue(arr);
    }

    public static boolean isMoreThanOneTrue(boolean[] array) {
        int num = 0;
        for (boolean b : array)
            if (b)
                num++;
        return num >= 2;
    }

    public static boolean areNoneTrue(boolean[] array) {
        for (boolean b : array)
            if (b)
                return false;
        return true;
    }


    private static void quizTryCatcher(Quiz quiz) {
        try {
            writeQuizToFile(quiz);
        } catch (FileNotFoundException e) {
            System.out.println(ERROR_011);
        }
        try {
            rotatingQuizBank(quiz.clone());
        } catch (CloneNotSupportedException e) {
            System.out.println("Clone not supported");
        }
    }

    private static void rotatingQuizBank(Quiz quiz){
        if(lastCreatedQuizBank.size() > 10){
            lastCreatedQuizBank.remove(0);
        }
        lastCreatedQuizBank.add(quiz);
    }

    public static String showQuestionBank() {
    	StringBuffer quests = new StringBuffer();
        for (Question question : questionBank)
        	quests.append(question == null ? "" : question + "\n\n");
        return quests.toString();
    }

    public static void removeAnswer(int num) {
        for (Question question : questionBank) {
            if (question.getQuestionId() == num) {
                if (question.getClass().getName().equals("entities.questions.OpenEndQuestion")) {
                    System.out.println(GENERIC_MESSAGE_01);
                } else {

                    int i = 1;
                    for (MultipleChoiceOption mco : ((MultipleChoiceQuestion) question).getOptions().getSet()) {
                        if (mco != null) {
                            System.out.println(i + " - " + mco.getOptionText());
                            i++;
                        }
                    }
                    int index = integerOptionDistributor(7);
                    if (index == 0) {
                        System.out.println(ERROR_016);
                        return;
                    }
                    if (index > ((MultipleChoiceQuestion) question).getOptions().getSize()) {
                        System.out.println(ERROR_017);
                        return;
                    }
                    if (((MultipleChoiceQuestion) question).removeOption(index))
                        System.out.println(SUCCESS_MESSAGE_03);
                }
            }
        }
    }

    public static void updateQuestionText(int num) {
        for (Question question : questionBank) {
            if (question.getQuestionId() == num) {
                if (question.setText(Main.stringOptionDistributor(2)))
                    System.out.println(SUCCESS_MESSAGE_04);
                break;
            }
        }
    }

    public static void updateQuestionAnswer(int num) {
        for (Question question : questionBank) {
            if (question.getQuestionId() == num) {
                switch (question.getClass().getName()) {
                    case "entities.questions.OpenEndQuestion":
                        if (((OpenEndQuestion) question).setRightAnswer(Main.stringOptionDistributor(5)))
                            System.out.println(SUCCESS_MESSAGE_05);
                        break;
                    case "entities.questions.MultipleChoiceQuestion":
                        int i = 1;
                        for (MultipleChoiceOption mco : ((MultipleChoiceQuestion) question).getOptions().getSet()) {
                            if (mco != null) {
                                System.out.println(i + " - " + mco.getOptionText());
                                i++;
                            }
                        }
                        int index = integerOptionDistributor(6);
                        if (index == 0) {
                            System.out.println(ERROR_016);
                            return;
                        }
                        if (index > ((MultipleChoiceQuestion) question).getOptions().getSize()) {
                            System.out.println(ERROR_017);
                            return;
                        }
                        Set<MultipleChoiceOption> set = ((MultipleChoiceQuestion) question).getOptions();
                        MultipleChoiceOption mco = revalueOptionSetter();
                        set.getSet()[index - 1] = mco;
                        set.remove(set.getSize(), MultipleChoiceOption.class);
                        set.remove(set.getSize(), MultipleChoiceOption.class);
                        set.add(new MultipleChoiceOption("More than one answer is correct", isMoreThanOneCorrect(set)));
                        set.add(new MultipleChoiceOption("None of the above", isNoneCorrect(set)));

                        System.out.println(SUCCESS_MESSAGE_03);
                        break;
                }
                break;
            }
        }
    }

    public static void validationMessenger(int numOfQuestions) {
        if (numOfQuestions == 0) {
            System.out.println(ERROR_003);
            return;
        }
        if (numOfQuestions > Manager.questionBankSize()) {
            System.out.println(ERROR_004);
        }
    }

    public static MultipleChoiceOption revalueOptionSetter() {
        System.out.println(QUESTION_TO_USER_05);
        return Main.optionSetter();
    }

    public static MultipleChoiceOption optionSetterWithProvide(int i) {
        System.out.println(provideOption(i));
        return Main.optionSetter();
    }

    public static void printToConsole(String text) {
        System.out.println(text);
    }

}
