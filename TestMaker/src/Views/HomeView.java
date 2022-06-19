package Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class HomeView {

    private BorderPane HomeWindow = new BorderPane();

    public HomeView(){
        HomeWindow.setStyle("-fx-background-color: #AFDCEC	");
    	HomeWindow.setPadding(new Insets(10));
        HomeWindow.setVisible(true);

        Label lblWelcome = new Label("Welcome to the Test Maker!");
        lblWelcome.setVisible(true);
        lblWelcome.setStyle("-fx-text-fill: #151B54;-fx-font-size: 3.0em;-fx-font-weight: bold;");
        lblWelcome.setUnderline(true);
        HBox hbWelcome = new HBox(lblWelcome);
        hbWelcome.setAlignment(Pos.CENTER);
        Label lblWhatIsHere = new Label(" - You can look at our question bank. \n - You can create your own questions and add them to our bank. \n - You can update a qustion/answer as you like or even remove an answer. \n - You can create your own managed quiz and if you feel lazy you can create quiz randomly! \n - You Can copy a quiz from one that is already exist!");
        lblWhatIsHere.setStyle("-fx-text-fill: #191970;-fx-font-size: 1.5em;");
        Label lblMadeBy = new Label("made by Guy Zvilich and Dimitry Gordon");
        lblMadeBy.setStyle("-fx-text-fill: #191970;-fx-font-size: 1.1em;");
        lblMadeBy.setVisible(true);
        lblMadeBy.setPadding(new Insets(10));

        HomeWindow.setTop(hbWelcome);
        HomeWindow.setCenter(lblWhatIsHere);
        HomeWindow.setBottom(lblMadeBy);
    }

    public void visible(boolean val){
        this.HomeWindow.setVisible(val);
    }

    public BorderPane getHome() {
        return this.HomeWindow;
    }

}
