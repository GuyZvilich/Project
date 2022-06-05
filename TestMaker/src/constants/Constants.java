package constants;

public class Constants {

    public static final String SUCCESS_MESSAGE_01 = "The question was added successfully";
    public static final String SUCCESS_MESSAGE_02 = "Your quiz was created successfully";
    public static final String SUCCESS_MESSAGE_03 = "Questions option was removed successfully";
    public static final String SUCCESS_MESSAGE_04 = "Question text updated successfully";
    public static final String SUCCESS_MESSAGE_05 = "Answer updated successfully";
    public static final String SUCCESS_MESSAGE_06 = "Setting question options was successful";

    public static final String GENERIC_MESSAGE_01 = "Sorry. This question is an open ended question. You may not remove the answer for this sort of questions and leave it null";
    public static final String GENERIC_MESSAGE_02 = "Please note that 2 options are constant. ('More than one answer is correct' , 'None of the above')";
    public static final String GENERIC_MESSAGE_04 = "Please provide a list of question ids you would like the test to have\nSeparate the ids using ',' and end the input by hitting 'Enter'";
    public static final String GENERIC_MESSAGE_05 = "Please provide a list of options ids you would like the question to have\nSeparate the ids using ',' and end the input by hitting 'Enter'\nPlease note the options 'More than one answer is correct' & 'None of the above' will be added regardless so don't list their ids";

    public static final String ERROR_001 = "No type of question was chosen.\nProceeding cancellation";
    public static final String ERROR_002 = "No question ID was provided.\nProceeding cancellation";
    public static final String ERROR_003 = "No value for number of questions.\nProceeding cancellation";
    public static final String ERROR_004 = "There are not enough questions in the bank to build a test this big.\nPick a smaller quiz size";
    public static final String ERROR_005 = "No list of questions exists.\nProceeding cancellation";
    public static final String ERROR_006 = "Number of questions and the actual amount of ids given was mismatched.\nPlease try again";
    public static final String ERROR_007 = "Wrong input. Expected numeric values.\nShutting Down.";
    public static final String ERROR_008 = "Wrong input. Expected numeric values.\nCanceling operation.";
    public static final String ERROR_009 = "Wrong input. Expected numeric values.\nTry again";
    public static final String ERROR_010 = "Not all values were numeric.\nCanceling operation.";
    public static final String ERROR_011 = "File not found";
    public static final String ERROR_012 = "Such a question already exists";
    public static final String ERROR_013 = "Number of options was not provided correctly.\nProceeding cancellation";
    public static final String ERROR_015 = "No valid option was selected";
    public static final String ERROR_016 = "No option id for removal/update was provided.\nCanceling operation.";
    public static final String ERROR_017 = "Index out of range for available options.\nTry again";
    public static final String ERROR_022 = "Invalid option";
    public static final String ERROR_023 = "An invalid amount of options was given. Please a numeric value between 2 and 10";
    public static final String ERROR_024 = "No quiz exists in the quiz bank";

    public static final String QUESTION_TO_USER_01 = "What is the new/updated text of the question?";
    public static final String QUESTION_TO_USER_02 = "What is the question?";
    public static final String QUESTION_TO_USER_03 = "What is the right answer for the question?";
    public static final String QUESTION_TO_USER_03_2 = "Is this answer correct?";
    public static final String QUESTION_TO_USER_04 = "What is the new/updated correct answer for the question?";
    public static final String QUESTION_TO_USER_05 = "What is the new/updated option for the question?";
    public static final String QUESTION_TO_USER_05_5 = "What is the new/updated answer for the question?";
    public static final String QUESTION_TO_USER_06 = "Which would you like to do?\n1 - Update existing options wording\n2 - Add a new option to the list";
    public static final String QUESTION_TO_USER_07 = "Which of the last 10 quizzes you'd like to have a copy of?\nProvide the index in reverse order (i.e. 0 is the oldest quiz 10 is the most resent)";
    public static final String QUESTION_TO_USER_08 = "What is the ID of the question you'd like to update?";
    public static final String QUESTION_TO_USER_09 = "How many questions would you like the Test to have?";
    public static final String QUESTION_TO_USER_10 = "What type of question would you like to add?\n1 - open end question\n2 - multi-optional question";
    public static final String QUESTION_TO_USER_12 = "How many options between 2 to 10 would you like the questions to have?";
    public static final String QUESTION_TO_USER_13 = "Which option, among the following, do you wish to update?";
    public static final String QUESTION_TO_USER_14 = "Which option, among the following, do you wish to remove?";
    public static final String QUESTION_TO_USER_16 = "is a multiple choice question with several options available. Would you like to have all it's available options as they are\nor choose options among them yourself?\n1 - Get all options as they are\n2 - Choose your own option among those available";
    public static final String QUESTION_TO_USER_17 = "Is this option a correct answer to the question?(Y/N)";
    public static final String QUESTION_TO_USER_18 = "What is the creation date of the Quiz you'd like to make a copy of?\nPlease provide it in a dd/mm/yyyy format";
    public static final String QUESTION_TO_USER_19 = "How would you like to copy a quiz?\n1 - From existing files\n2 - Clone a previously made quiz (with the _copy extension)\nPlease note; if no file exist/there is no clone available, no action will take place";
    public static final String QUESTION_TO_USER_20 = "What is the creation date of the Quiz you'd like to make a copy of?";

    public static final String EXIT_MESSAGE = "Wrong option";
    public static final String UPDATE = "Update";
    public static final String REMOVE = "Remove";

    public static String initialOptions(int num){
        return "Please fill the " + (num - 2) + " initial options";
    }
    public static String provideOption(int i){
        return "Please provide option #" + (i + 1);
    }
    public static String answerNumberX(int x){
        return "Answer " + x + ":";
    }

    public static final String MENU_OPTION_1 = "Display question bank";
    public static final String MENU_OPTION_2 = "Add a question to the bank";
    public static final String MENU_OPTION_3 = "Update wording for question";
    public static final String MENU_OPTION_4 = "Update wording for questions answer";
    public static final String MENU_OPTION_5 = "Remove an answer";
    public static final String MENU_OPTION_6 = "Create a user managed Quiz";
    public static final String MENU_OPTION_7 = "Create a random Quiz";
    public static final String MENU_OPTION_8 = "Copy existing Quiz";
    public static final String MENU_OPTION_9 = "Quit out";

    public static final String MENU_MESSAGE = "Hello and welcome to the Quiz Maker.\n\nPlease choose which action you'd like to make\n======================================================";
}
