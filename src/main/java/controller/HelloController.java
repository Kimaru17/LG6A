package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import ucr.lab.HelloApplication;

import java.io.IOException;

public class HelloController {
    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;
    @FXML
    private Text messageText;

    private void loadPage(String page){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(page));
        try {
            this.bp.setCenter(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void home(ActionEvent event) {
        this.messageText.setText("Laboratory 6");
        this.bp.setCenter(ap);
    }

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void messengerServiceOnAction(ActionEvent actionEvent) {
        loadPage("messengerService.fxml");
    }

    @FXML
    public void converterOnAction(ActionEvent actionEvent) {
        loadPage("converter.fxml");
    }
}