package com.example.xo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class playarea {

    @FXML
    Label xcounter;
    @FXML
    Label ocounter;
    @FXML
    ImageView board;
    @FXML
    Label label;
    @FXML
    Label p1;
    @FXML
    Label p2;
    @FXML
    Button b0;
    @FXML
    Button b1;
    @FXML
    Button b2;
    @FXML
    Button b3;
    @FXML
    Button b4;
    @FXML
    Button b5;
    @FXML
    Button b6;
    @FXML
    Button b7;
    @FXML
    Button b8;
    @FXML
    Button again;
    @FXML
    Button restart;

    private boolean first;

    public boolean progress=true;
    static int i=0,j=0;


    public void btnlist(){
        List<Button> btn = Arrays.asList(b0, b1, b2, b3, b4, b5, b6, b7, b8);
        for(Button button:btn){
            button.setBackground(Background.EMPTY);
        }
    }
    public void display(String player) {
        label.setText(player+ " plays first!");
        first = true;
    }
    public void displayname1(String name1){
        p1.setText(name1);
    }
    public void displayname2(String name2){
        p2.setText(name2);
    }

    public void actionPerformed(ActionEvent e) {
        Button clicked = (Button) e.getSource();

            if (clicked.getText().equals("") && progress) {
                if (first) {
                    clicked.setText("X");
                    clicked.setTextFill(Color.RED);
                    label.setText("O turn");
                    first = false;
                    checkfull();
                    check();
                } else {
                    clicked.setText("O");
                    clicked.setTextFill(Color.BLUE);
                    label.setText("X turn");
                    first = true;
                    checkfull();
                    check();
                }
            }
        }

    public void checkfull() {
        List<Button> btn = Arrays.asList(b0, b1, b2, b3, b4, b5, b6, b7, b8);
        int counter=0;
        for (Button button : btn) {
            if(button.getText().equals("O")||button.getText().equals("X"))
                counter++;
        }
        if(counter==9)
            reMatch();
    }


    public void check(){
        if(b0.getText().equals("X")&&b1.getText().equals("X")&&b2.getText().equals("X")){
            xwins();
        }
        if(b3.getText().equals("X")&&b4.getText().equals("X")&&b5.getText().equals("X")){
            xwins();
        }
        if(b6.getText().equals("X")&&b7.getText().equals("X")&&b8.getText().equals("X")){
            xwins();
        }
        if(b0.getText().equals("X")&&b3.getText().equals("X")&&b6.getText().equals("X")){
            xwins();
        }if(b1.getText().equals("X")&&b4.getText().equals("X")&&b7.getText().equals("X")){
            xwins();
        }if(b2.getText().equals("X")&&b5.getText().equals("X")&&b8.getText().equals("X")){
            xwins();
        }if(b0.getText().equals("X")&&b4.getText().equals("X")&&b8.getText().equals("X")){
            xwins();
        }if(b2.getText().equals("X")&&b4.getText().equals("X")&&b6.getText().equals("X")){
            xwins();
        }


        if(b0.getText().equals("O")&&b1.getText().equals("O")&&b2.getText().equals("O")){
            owins();
        }
        if(b3.getText().equals("O")&&b4.getText().equals("O")&&b5.getText().equals("O")){
            owins();
        }
        if(b6.getText().equals("O")&&b7.getText().equals("O")&&b8.getText().equals("O")){
            owins();
        }
        if(b0.getText().equals("O")&&b3.getText().equals("O")&&b6.getText().equals("O")){
            owins();
        }if(b1.getText().equals("O")&&b4.getText().equals("O")&&b7.getText().equals("O")){
            owins();
        }if(b2.getText().equals("O")&&b5.getText().equals("O")&&b8.getText().equals("O")){
            owins();
        }if(b0.getText().equals("O")&&b4.getText().equals("O")&&b8.getText().equals("O")){
            owins();
        }if(b2.getText().equals("O")&&b4.getText().equals("O")&&b6.getText().equals("O")){
            owins();
        }
    }
    public void xcount(){
        i++;
        xcounter.setText(String.valueOf(i));
        if (i==3) {
            label.setText(p1.getText() + " won :)");
            progress = false;
        }
    }
    public void xwins(){
        label.setText("O turn");
        xcount();
        progress=false;
        first=false;
        reMatch();
    }
    public void ocount(){
        j++;
        ocounter.setText(String.valueOf(j));
        if (j==3) {
            label.setText(p2.getText() + " won :)");
            progress = false;
        }
    }
    public void owins(){
        label.setText("X turn");
        ocount();
        progress=false;
        first=true;
        reMatch();
    }
    public void reMatch() {
        List<Button> btn = Arrays.asList(b0, b1, b2, b3, b4, b5, b6, b7, b8);
        for (Button button : btn) {
            button.setText("");
            button.setBackground(Background.EMPTY);
        }
        progress=true;
    }
    public void again(){
        progress=false;
        i=j=0;
        ocounter.setText(String.valueOf(j));
        xcounter.setText(String.valueOf(i));
        display(p1.getText());
        reMatch();
       /* for ending game with no rounds if(i>j)
            label.setText(p1.getText()+" won :)");
        else if (j>i) {
            label.setText(p2.getText()+" won :)");
        }else
            label.setText(" It is tie :)");*/
    }
    public void restart(ActionEvent e) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("home.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}

