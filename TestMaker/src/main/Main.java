package main;

import entities.Manager;
import entities.Quiz;
import entities.interfaces.Menu;
import entities.questions.MultipleChoiceOption;

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

public class Main {

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

    public static void main(String[] args) {
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
