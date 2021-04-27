//Written by Joshua Harris
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class AlarmApp extends Application {
    public void start (Stage mainStage) {
        //Panes
        Pane back = new Pane();
        back.setStyle("-fx-background-color: white;");

        Pane a = new Pane();
        a.setStyle("-fx-background-color: white; -fx-border-color: gray; -fx-padding: 4 4;");
        a.setPrefSize(200, 90);
        a.relocate(10, 10);

        Pane b = new Pane();
        b.setStyle("-fx-background-color: white; -fx-border-color: gray; -fx-padding: 4 4;");
        b.setPrefSize(200, 40);
        b.relocate(220, 10);

        Pane c = new Pane();
        c.setStyle("-fx-background-color: white; -fx-border-color: gray; -fx-padding: 4 4;");
        c.setPrefSize(200, 40);
        c.relocate(220, 60);

        //labels
        Label labelA = new Label("Remaining Time: ");
        labelA.setStyle("-fx-background-color: white; -fx-translate-y: -8; -fx-translate-x: 10;");
        labelA.relocate(10, 10);

        Label labelB = new Label("Current Time: ");
        labelB.setStyle("-fx-background-color: white; -fx-translate-y: -8; -fx-translate-x: 10;");
        labelB.relocate(220, 10);

        Label labelC = new Label("Alarm Time: ");
        labelC.setStyle("-fx-background-color: white; -fx-translate-y: -8; -fx-translate-x: 10;");
        labelC.relocate(220, 60);

        //labels and textfields IN panes
        Label txtA = new Label("00:00:00");
        txtA.setStyle("-fx-font: 48 label; -fx-text-fill: darkgreen;");
        txtA.relocate(22, 20);

        TextField txtB = new TextField("01:54:16 PM");
        txtB.setAlignment(Pos.CENTER_RIGHT);
        txtB.setPrefSize(190,25);
        txtB.relocate(225,20);

        TextField txtC = new TextField("10:30:00 AM");
        txtC.setAlignment(Pos.CENTER_RIGHT);
        txtC.setPrefSize(190,25);
        txtC.relocate(225,70);

        ObservableList<String> list = FXCollections.observableArrayList("Weekday", "Saturday", "Sunday");
        ComboBox combo = new ComboBox(list);
        combo.setValue("Select Alarm");
        combo.setPrefSize(410, 30);
        combo.relocate(10, 110);

        //bottom at bottom
        Button btnA = new Button("New Alarm");
        btnA.setPrefSize(100, 30);
        btnA.relocate(10, 150);

        Button btnB = new Button("Edit");
        btnB.setPrefSize(80, 30);
        btnB.relocate(120, 150);


        Button btnC = new Button("Delete");
        btnC.setPrefSize(80, 30);
        btnC.relocate(210, 150);


        ToggleGroup toggleButton = new ToggleGroup();
        RadioButton[] rdBtns;
        rdBtns = new RadioButton[2];
        String[] btnOptions = {"ON", "OFF"};
        for (int i = 0; i < 2; i++) {
            rdBtns[i] = new RadioButton(btnOptions[i]);
            rdBtns[i].setPrefSize(50, 30);
            back.getChildren().add(rdBtns[i]);
            rdBtns[i].setToggleGroup(toggleButton);
            rdBtns[i].relocate(310 +( i * 50), 150);
            rdBtns[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                }
            });
        }


        back.getChildren().addAll(a, b, c, labelA, labelB, labelC, txtA, txtB, txtC, combo, btnA, btnB, btnC);
        mainStage.setTitle("Alarm App");
        mainStage.setScene(new Scene(back, 430,190));
        mainStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    }

