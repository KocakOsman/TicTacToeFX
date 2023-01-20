package Controller;

import Model.Board;
import Model.Player;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import kocak.View.Game;

import java.io.IOException;
import java.util.HashMap;

public class GameController {

    private boolean player1_active;
    private Player player1;
    private Player player2;
    private int moveCounter;
    private boolean player1Won;
    private boolean player2Won;

    private Board board;

    public void initialize(){
        this.player1_active = true;
        this.board = new Board();
        this.moveCounter = 0;
        this.player1 = new Player("X");
        this.player2 = new Player("O");
        this.player1Won = false;
        this.player2Won = false;
    }

    @FXML
    private Button seven ;

    @FXML
    private Button four;

    @FXML
    private Button three;

    @FXML
    private Button eight;

    @FXML
    private Button zero;

    @FXML
    private Button six;

    @FXML
    private Button five;

    @FXML
    private Button two;

    @FXML
    private Button one;

    @FXML
    void buttonPressed(ActionEvent event) throws IOException {
        Button pressedField = (Button) event.getSource();
        int i = board.getValue().get(pressedField.getId());
        if (player1_active){
            board.setMove(i,player1.getC());
            pressedField.setText(player1.getC());
            pressedField.setDisable(true);
            player1_active = false;
            if (board.isWinner(player1.getC())){
                player1Won = true;
                gameEnded();
            }
            moveCounter++;
        }else{
            board.setMove(i,player2.getC());
            pressedField.setText(player2.getC());
            pressedField.setDisable(true);
            player1_active = true;
            if (board.isWinner(player2.getC())){
                player2Won = true;
                gameEnded();
            }
            moveCounter++;
        }
        if (moveCounter == 9){
            gameEnded();
        }
    }

    public void gameEnded() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("End.fxml"));
        Parent root = fxmlLoader.load();
        EndController endController = (EndController) fxmlLoader.getController();
        if (player1Won){
            endController.updateWinnerLabel("Player 1 Won the Game");
        }else if (player2Won) {
            endController.updateWinnerLabel("Player 2 Won the Game");
        }else {
            endController.updateWinnerLabel("Tie");
        }
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        Stage thisStage = (Stage) one.getScene().getWindow();
        thisStage.close();
        player1Won = false;
        player2Won = false;
    }

}
