package Views;

import entities.Manager;
import entities.Quiz;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import static constants.Constants.QUESTION_TO_USER_20;
import static entities.Manager.lastCreatedQuizBank;

public class CopyQuizView {
    private BorderPane CopyQuiz = new BorderPane();
    private ScrollPane copyQuizPresenter = new ScrollPane();
    private Label warning = new Label("No Exam was created yet. The clone bank of exams is empty");

    public BorderPane getCopyQuiz() {
        return CopyQuiz;
    }

    public ScrollPane getCopyQuizPresenter() {
        return copyQuizPresenter;
    }

    public Label getWarning() {
        return warning;
    }

    public CopyQuizView() {
        Label lblGetDate = new Label(QUESTION_TO_USER_20);
        TextField tfGetDay = new TextField();
        TextField tfGetMonth = new TextField();
        TextField tfGetYear = new TextField();
        Label lblSlash1 = new Label("/");
        Label lblSlash2 = new Label("/");
        HBox hbGetDate = new HBox();
        hbGetDate.getChildren().addAll(tfGetDay, lblSlash1, tfGetMonth, lblSlash2, tfGetYear);
        BorderPane copyByDate = new BorderPane();
        copyByDate.setVisible(false);
        GridPane ByDate = new GridPane();
        Button btnCopyByDate = new Button("Copy");
        copyByDate.setCenter(ByDate);
        copyByDate.setBottom(btnCopyByDate);
        BorderPane copyByLast10 = new BorderPane();
        copyByLast10.setVisible(false);
        GridPane ByLast10 = new GridPane();
        Button btnCopyByLast10 = new Button("Copy");
        copyByLast10.setCenter(ByLast10);
        copyByLast10.setBottom(btnCopyByLast10);
        ByDate.setHgap(10);
        ByDate.setVgap(10);
        ByDate.add(lblGetDate, 1, 1);
        ByDate.add(hbGetDate, 1, 2);
        ByLast10.setHgap(10);
        ByLast10.setVgap(10);
        ByLast10.add(warning, 1, 1);
        StackPane copyOption = new StackPane(copyByDate, copyByLast10);

        copyQuizPresenter.setPadding(new Insets(10));
        copyQuizPresenter.setVisible(false);
        copyQuizPresenter.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        Button btnByDate = new Button("By Date");
        btnByDate.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                for (int i = 0; i < copyOption.getChildren().size(); i++) {
                    copyOption.getChildren().get(i).setVisible(false);
                }
                copyByDate.setVisible(true);

            }
        });

        Button btnByLast10 = new Button("By Last 10");
        btnByLast10.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                for (int i = 0; i < copyOption.getChildren().size(); i++) {
                    copyOption.getChildren().get(i).setVisible(false);
                }
                ByLast10.getChildren().removeAll();
                ToggleGroup tglLast10Quiezes = new ToggleGroup();
                VBox vb10Options = new VBox();
                vb10Options.setSpacing(5);
                int sizeOfBank = lastCreatedQuizBank.size();
                if (sizeOfBank == 0) {
                    warning.setVisible(true);
                }
                for (int i = 1; i < sizeOfBank + 1; i++) {
                    RadioButton temp = new RadioButton(i + "");
                    temp.setToggleGroup(tglLast10Quiezes);
                    vb10Options.getChildren().add(temp);
                }
                ByLast10.add(vb10Options, 1, 1);
                copyByLast10.setVisible(true);
            }
        });

        HBox hbCopyOptions = new HBox();
        hbCopyOptions.getChildren().addAll(btnByDate, btnByLast10);
        btnByDate.setAlignment(Pos.CENTER);

        CopyQuiz.setCenter(copyOption);
        CopyQuiz.setPadding(new Insets(10));
        CopyQuiz.setTop(hbCopyOptions);
        CopyQuiz.setVisible(false);

        btnCopyByDate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String date = tfGetDay.getText() + "/" + tfGetMonth.getText() + "/" + tfGetYear.getText();
                Label Quiz = new Label(Manager.copyQuizFromFileToWindow(date));
                copyQuizPresenter.setContent(Quiz);
                copyQuizPresenter.setVisible(true);
            }
        });
        btnCopyByLast10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int index = 0;
                VBox node = (VBox) ByLast10.getChildren().get(1);
                for (Node child : node.getChildren()) {
                    RadioButton radioButton = (RadioButton) child;
                    if (radioButton.isSelected())
                        index = Integer.parseInt(radioButton.getText()) - 1;
                }
                Quiz copyQuiz = lastCreatedQuizBank.get(index);
                String test = null;
                if (copyQuiz != null) {
                    test = copyQuiz.toString();
                    Manager.quizCopyFile(copyQuiz);
                }
                Label Quiz = new Label(test);
                copyQuizPresenter.setContent(Quiz);
                copyQuizPresenter.setVisible(true);
            }
        });
        copyByDate.setVisible(false);
        copyByLast10.setVisible(false);
    }
}
