package Controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import kocak.View.Game;

import java.io.IOException;

public class EndController {




    @FXML
    private Label winnerLabel;
    @FXML
    private Button exitButton;

    @FXML
    private Button playAgain;

    @FXML
    void exitButtonPressed(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void playAgainPressed(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Game.class.getResource("Game.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        winnerLabel.setText("Tie");
        Stage stage1 = (Stage) playAgain.getScene().getWindow();
        stage1.close();
    }

    public void updateWinnerLabel(String s){
        this.winnerLabel.setText(s);
    }

}
