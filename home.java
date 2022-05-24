package com.example.xo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class home {
    @FXML
    TextField namep1;
    @FXML
    TextField namep2;

    private String player1;
    private String player2;
    private playarea playarea;
    Random random=new Random();
    public void switchToPlayArea(ActionEvent e)throws IOException {
         player1=namep1.getText();
         player2=namep2.getText();

        FXMLLoader loader=new FXMLLoader(getClass().getResource("playarea.fxml"));
        Parent root = loader.load();

        playarea=loader.getController();
        playarea.btnlist();
        fTurn();

        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void fTurn(){
        int i=random.nextInt(2);
        if(i==1){
            playarea.display(player1);
            playarea.displayname1(player1);
            playarea.displayname2(player2);
        }else {
            playarea.display(player2);
            playarea.displayname1(player2);
            playarea.displayname2(player1);
        }
    }

}