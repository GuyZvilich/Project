package application;

import Controllers.TestMakerController;
import Views.TestMakerView;
import javafx.application.Application;
import javafx.stage.Stage;
import entities.Manager;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Test maker project");
            TestMakerView theView = new TestMakerView(primaryStage);
            TestMakerController controller = new TestMakerController(theView);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
        Manager.saveQuestionBank();
    }
}
