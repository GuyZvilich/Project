package application;

import controllers.TestMakerController;
import javafx.scene.image.Image;
import views.TestMakerView;
import javafx.application.Application;
import javafx.stage.Stage;
import entities.Manager;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Test Maker");
            primaryStage.getIcons().add(new Image("application/assets/pictures/TestMaker.png"));
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
