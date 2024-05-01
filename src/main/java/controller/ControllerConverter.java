package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class ControllerConverter {
    @javafx.fxml.FXML
    private TextField txt_ExI;
    @javafx.fxml.FXML
    private TextField txt_ExII;
    @javafx.fxml.FXML
    private TextField txt_ExV;
    @javafx.fxml.FXML
    private TextField txt_ExIII;
    @javafx.fxml.FXML
    private TextField txt_ExVI;
    @javafx.fxml.FXML
    private RadioButton rbtn_Pos;
    @javafx.fxml.FXML
    private RadioButton rbtn_Pre;
    @javafx.fxml.FXML
    private RadioButton rbtn_In;
    @javafx.fxml.FXML
    private Text result2Text1;
    @javafx.fxml.FXML
    private Text result1Text2;
    @javafx.fxml.FXML
    private Text result1Text1;
    @javafx.fxml.FXML
    private Text result1Text4;
    @javafx.fxml.FXML
    private Text result1Text3;
    @javafx.fxml.FXML
    private Text result1Text5;
    @javafx.fxml.FXML
    private Text result2Text4;
    @javafx.fxml.FXML
    private Text result2Text5;
    @javafx.fxml.FXML
    private Text result2Text2;
    @javafx.fxml.FXML
    private Text result2Text3;
    @javafx.fxml.FXML
    private Label msg1text;
    @javafx.fxml.FXML
    private Label msg3text;
    @javafx.fxml.FXML
    private Label msg2text;
    Alert alert;


    @javafx.fxml.FXML
    public  void  initialize(){
        this.alert = util.UtilityFX.alert("Converter","Expression");
        cleanOnAction(new ActionEvent());
    }

    @javafx.fxml.FXML
    public void btn_PrefixOnAction(ActionEvent actionEvent) {
        this.msg1text.setText("Prefix");
        this.msg2text.setText("Infix");
        this.msg3text.setText("Posfix");

        this.rbtn_Pre.setSelected(true);
        this.rbtn_In.setSelected(false);
        this.rbtn_Pos.setSelected(false);

    }

    @javafx.fxml.FXML
    public void btn_PosfixOnAction(ActionEvent actionEvent) {
        this.msg1text.setText("Posfix");
        this.msg2text.setText("Prefix");
        this.msg3text.setText("Infix");

        this.rbtn_Pre.setSelected(false);
        this.rbtn_In.setSelected(false);
        this.rbtn_Pos.setSelected(true);
    }

    @javafx.fxml.FXML
    public void btn_InfixOnAction(ActionEvent actionEvent) {
        this.msg1text.setText("Infix");
        this.msg2text.setText("Posfix");
        this.msg3text.setText("Prefix");

        this.rbtn_Pre.setSelected(false);
        this.rbtn_In.setSelected(true);
        this.rbtn_Pos.setSelected(false);
    }

    @javafx.fxml.FXML
    public void convertOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void cleanOnAction(ActionEvent actionEvent) {
        this.txt_ExI.setText("");this.txt_ExII.setText("");
        this.txt_ExIII.setText("");this.txt_ExVI.setText("");
        this.txt_ExV.setText("");

        this.result1Text1.setText("");this.result1Text2.setText("");
        this.result1Text3.setText("");this.result1Text4.setText("");
        this.result1Text5.setText("");

        this.result2Text1.setText("");this.result2Text2.setText("");
        this.result2Text3.setText("");this.result2Text4.setText("");
        this.result2Text5.setText("");
    }
}
