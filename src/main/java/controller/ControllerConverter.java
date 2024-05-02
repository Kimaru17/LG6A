package controller;

import domain.stack.StackException;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.Stack;

public class ControllerConverter {
    @javafx.fxml.FXML
    private TextField txt_ExI;
    @javafx.fxml.FXML
    private TextField txt_ExII;
    @javafx.fxml.FXML
    private TextField txt_ExIII;
    @javafx.fxml.FXML
    private TextField txt_ExIV;
    @javafx.fxml.FXML
    private TextField txt_ExV;
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
    private Pane ConvertPane;


    @javafx.fxml.FXML
    public  void  initialize(){
        this.alert = util.UtilityFX.alert("Converter","Expression");
        cleanOnAction(new ActionEvent());
    }

    @javafx.fxml.FXML
    public void btn_PrefixOnAction(ActionEvent actionEvent) {
        this.msg1text.setText("Prefix");
        this.msg2text.setText("Posfix");
        this.msg3text.setText("Infix");

        this.rbtn_Pre.setSelected(true);
        this.rbtn_In.setSelected(false);
        this.rbtn_Pos.setSelected(false);

        ConvertPane.setVisible(true);
    }

    @javafx.fxml.FXML
    public void btn_PosfixOnAction(ActionEvent actionEvent) {
        this.msg1text.setText("Posfix");
        this.msg2text.setText("Prefix");
        this.msg3text.setText("Infix");

        this.rbtn_Pre.setSelected(false);
        this.rbtn_In.setSelected(false);
        this.rbtn_Pos.setSelected(true);

        ConvertPane.setVisible(true);
    }

    @javafx.fxml.FXML
    public void btn_InfixOnAction(ActionEvent actionEvent) {
        this.msg1text.setText("Infix");
        this.msg2text.setText("Posfix");
        this.msg3text.setText("Prefix");

        this.rbtn_Pre.setSelected(false);
        this.rbtn_In.setSelected(true);
        this.rbtn_Pos.setSelected(false);

        ConvertPane.setVisible(true);
    }

    @javafx.fxml.FXML
    public void convertOnAction(ActionEvent actionEvent) {

        if(rbtn_In.isSelected()) { //Solo si está marcado el InFix

            //Primera Expression InFix
            String infixExpression1_1 = txt_ExI.getText();
            String postfixExpression1_1 = infixToPostfixConverter(infixExpression1_1);
            String prefixExpression1_1 = infixToPrefixConverter(infixExpression1_1);
            result1Text1.setText(postfixExpression1_1);
            result2Text1.setText(prefixExpression1_1);

            //Segunda expression InFix
            String infixExpression2_1 = txt_ExII.getText();
            String postfixExpression2_1 = infixToPostfixConverter(infixExpression2_1);
            String prefixExpression2_1 = infixToPrefixConverter(infixExpression2_1);
            result1Text2.setText(postfixExpression2_1);
            result2Text2.setText(prefixExpression2_1);

            //Tercera Expression InFix
            String infixExpression3_1 = txt_ExIII.getText();
            String postfixExpression3_1 = infixToPostfixConverter(infixExpression3_1);
            String prefixExpression3_1 = infixToPrefixConverter(infixExpression3_1);
            result1Text3.setText(postfixExpression3_1);
            result2Text3.setText(prefixExpression3_1);

            //Cuarta Expression InFix
            String infixExpression4_1 = txt_ExIV.getText();
            String postfixExpression4_1 = infixToPostfixConverter(infixExpression4_1);
            String prefixExpression4_1 = infixToPrefixConverter(infixExpression4_1);
            result1Text4.setText(postfixExpression4_1);
            result2Text4.setText(prefixExpression4_1);

            //Quinta Expression InFix
            String infixExpression5_1 = txt_ExV.getText();
            String postfixExpression5_1 = infixToPostfixConverter(infixExpression5_1);
            String prefixExpression5_1 = infixToPrefixConverter(infixExpression5_1);
            result1Text5.setText(postfixExpression5_1);
            result2Text5.setText(prefixExpression5_1);
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////

        if(rbtn_Pos.isSelected()) { //Solo si está marcado el PostFix

            //Primera Expression Postfix
            String postfixExpresion1_2 = txt_ExI.getText();
            String infixExpression1_2 = postfixToInfixConverter(postfixExpresion1_2);
            String prefixExpression1_2 = postfixToPrefixConverter(postfixExpresion1_2);
            result2Text1.setText(infixExpression1_2);
            result1Text1.setText(prefixExpression1_2);

            //Segunda Expression Postfix
            String postfixExpresion2_2 = txt_ExII.getText();
            String infixExpression2_2 = postfixToInfixConverter(postfixExpresion2_2);
            String prefixExpression2_2 = postfixToPrefixConverter(postfixExpresion2_2);
            result2Text2.setText(infixExpression2_2);
            result1Text2.setText(prefixExpression2_2);

            //Tercera Expression Postfix
            String postfixExpresion3_2 = txt_ExIII.getText();
            String infixExpression3_2 = postfixToInfixConverter(postfixExpresion3_2);
            String prefixExpression3_2 = postfixToInfixConverter(postfixExpresion3_2);
            result2Text3.setText(infixExpression3_2);
            result1Text3.setText(prefixExpression3_2);

            //Cuarta Expression Postfix
            String postfixExpresion4_2 = txt_ExIV.getText();
            String infixExpression4_2 = postfixToInfixConverter(postfixExpresion4_2);
            String prefixExpression4_2 = postfixToInfixConverter(postfixExpresion4_2);
            result2Text4.setText(infixExpression4_2);
            result1Text4.setText(prefixExpression4_2);

            //Quinta Expression Postfix
            String postfixExpresion5_2 = txt_ExV.getText();
            String infixExpression5_2 = postfixToInfixConverter(postfixExpresion5_2);
            String prefixExpression5_2 = postfixToInfixConverter(postfixExpresion5_2);
            result2Text5.setText(infixExpression5_2);
            result1Text5.setText(prefixExpression5_2);
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////

        if(rbtn_Pre.isSelected()) { //Solo si está marcado el PreFix

            //Primera Expression PreFix
            String prefixExpresion1_3 = txt_ExI.getText();
            String infixExpression1_3 = prefixToInfixConverter(prefixExpresion1_3);
            String postfixExpression1_3 = prefixToPostfixConverter(prefixExpresion1_3);
            result2Text1.setText(infixExpression1_3);
            result1Text1.setText(postfixExpression1_3);

            //Segunda Expression PreFix
            String prefixExpresion2_3 = txt_ExII.getText();
            String infixExpression2_3 = prefixToInfixConverter(prefixExpresion2_3);
            String postExpression2_3 = prefixToInfixConverter(prefixExpresion2_3);
            result2Text2.setText(infixExpression2_3);
            result1Text2.setText(postExpression2_3);

            //Tercera Expression PreFix
            String prefixExpresion3_3 = txt_ExIII.getText();
            String infixExpression3_3 = prefixToInfixConverter(prefixExpresion3_3);
            String postExpression3_3 = prefixToInfixConverter(prefixExpresion3_3);
            result2Text3.setText(infixExpression3_3);
            result1Text3.setText(postExpression3_3);

            //Cuarta Expression PreFix
            String prefixExpresion4_3 = txt_ExIV.getText();
            String infixExpression4_3 = prefixToInfixConverter(prefixExpresion4_3);
            String postExpression4_3 = prefixToInfixConverter(prefixExpresion4_3);
            result2Text4.setText(infixExpression4_3);
            result1Text4.setText(postExpression4_3);

            //Quinta Expression PreFix
            String prefixExpresion5_3 = txt_ExV.getText();
            String infixExpression5_3 = prefixToInfixConverter(prefixExpresion5_3);
            String postExpression5_3 = prefixToInfixConverter(prefixExpresion5_3);
            result2Text5.setText(infixExpression5_3);
            result1Text5.setText(postExpression5_3);
        }
    }

    @javafx.fxml.FXML
    public void cleanOnAction(ActionEvent actionEvent) {
        this.txt_ExI.setText("");this.txt_ExII.setText("");
        this.txt_ExIII.setText("");this.txt_ExIV.setText("");
        this.txt_ExV.setText("");

        this.result1Text1.setText("");this.result1Text2.setText("");
        this.result1Text3.setText("");this.result1Text4.setText("");
        this.result1Text5.setText("");

        this.result2Text1.setText("");this.result2Text2.setText("");
        this.result2Text3.setText("");this.result2Text4.setText("");
        this.result2Text5.setText("");
    }

    // Método para convertir:

    //De InFix a PostFix y PreFix
    public String infixToPostfixConverter(String infixExpression) {
        StringBuilder postfixExpression = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infixExpression.length(); i++) {
            char c = infixExpression.charAt(i);

            // Si el caracter es una letra o un dígito, agregar directamente a la expresión postfija
            if (Character.isLetterOrDigit(c)) {
                postfixExpression.append(c);
            }
            // Si es un paréntesis abierto, agregar a la pila
            else if (c == '(') {
                stack.push(c);
            }
            // Si es un paréntesis cerrado, sacar operadores de la pila y agregar a la expresión postfija
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfixExpression.append(stack.pop());
                }
                stack.pop(); // Sacar el paréntesis abierto correspondiente
            }
            // Si es un operador, sacar operadores de la pila y agregar a la expresión postfija
            // hasta que se encuentre un operador con menor prioridad o se llegue al final de la pila
            else {
                while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(c)) {
                    postfixExpression.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Sacar los operadores restantes de la pila y agregar a la expresión postfija
        while (!stack.isEmpty()) {
            postfixExpression.append(stack.pop());
        }

        return postfixExpression.toString();
    }
    public String infixToPrefixConverter(String infixExpression) {
        // Invertir la expresión infija y reemplazar los paréntesis
        StringBuilder reversedInfix = new StringBuilder(infixExpression).reverse();
        for (int i = 0; i < reversedInfix.length(); i++) {
            if (reversedInfix.charAt(i) == '(') {
                reversedInfix.setCharAt(i, ')');
            } else if (reversedInfix.charAt(i) == ')') {
                reversedInfix.setCharAt(i, '(');
            }
        }

        Stack<Character> operatorStack = new Stack<>();
        StringBuilder prefixExpression = new StringBuilder();

        for (int i = 0; i < reversedInfix.length(); i++) {
            char c = reversedInfix.charAt(i);

            // Si el caracter es una letra o un dígito (operando), se agrega directamente a la expresión prefija
            if (Character.isLetterOrDigit(c)) {
                prefixExpression.append(c);
            }
            // Si es un paréntesis abierto, se agrega a la pila
            else if (c == '(') {
                operatorStack.push(c);
            }
            // Si es un paréntesis cerrado, se sacan los operadores de la pila y se agregan a la expresión prefija
            else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    prefixExpression.append(operatorStack.pop());
                }
                operatorStack.pop(); // Sacar el paréntesis abierto correspondiente
            }
            // Si es un operador
            else {
                while (!operatorStack.isEmpty() && getPriority(operatorStack.peek()) >= getPriority(c)) {
                    prefixExpression.append(operatorStack.pop());
                }
                operatorStack.push(c);
            }
        }

        // Sacar los operadores restantes de la pila y agregar a la expresión prefija
        while (!operatorStack.isEmpty()) {
            prefixExpression.append(operatorStack.pop());
        }

        // Invertir la expresión prefija para obtener el resultado final
        return prefixExpression.reverse().toString();
    }

    //De PostFix a InFix y PreFix
    public String postfixToInfixConverter(String postfixExpression) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < postfixExpression.length(); i++) {
            char c = postfixExpression.charAt(i);

            // Si el caracter es una letra o un dígito (operando), se agrega a la pila
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            }
            // Si es un operador
            else {
                // Extraer los dos operandos de la pila
                String ope2 = stack.pop();
                String ope1 = stack.pop();

                // Construir la expresión infija con paréntesis y el operador
                String infix = "(" + ope1 + c + ope2 + ")";

                // Agregar la expresión infija resultante a la pila
                stack.push(infix);
            }
        }

        // El tope de la pila contendrá la expresión infija final
        return stack.pop();
    }
    public String postfixToPrefixConverter(String postfixExpression) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < postfixExpression.length(); i++) {
            char c = postfixExpression.charAt(i);

            // Si el caracter es una letra o un dígito (operando), se agrega a la pila
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            }
            // Si es un operador
            else {
                // Extraer los dos operandos de la pila
                String ope2 = stack.pop();
                String ope1 = stack.pop();

                // Construir la expresión prefija con el operador y los operandos
                String prefix = c + ope1 + ope2;

                // Agregar la expresión prefija resultante a la pila
                stack.push(prefix);
            }
        }

        // El tope de la pila contendrá la expresión prefija final
        return stack.pop();
    }

    //De PreFix a PostFix y InFix
    public String prefixToInfixConverter(String prefixExpression) {
        Stack<String> stack = new Stack<>();

        for (int i = prefixExpression.length() - 1; i >= 0; i--) {
            char c = prefixExpression.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                String ope1 = stack.pop();
                String ope2 = stack.pop();

                String infix = "(" + ope1 + c + ope2 + ")";

                stack.push(infix);
            }
        }

        return stack.pop();
    }
    public String prefixToPostfixConverter(String prefixExpression) {
        Stack<String> stack = new Stack<>();

        for (int i = prefixExpression.length() - 1; i >= 0; i--) {
            char c = prefixExpression.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                String ope1 = stack.pop();
                String ope2 = stack.pop();

                String postfix = ope1 + ope2 + c;

                stack.push(postfix);
            }
        }

        return stack.pop();
    }

    // Método para obtener la prioridad de un operador
    private int getPriority(char operator) {
        if (operator == '^') {
            return 3;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else {
            return 0; // Para cualquier otro carácter (por ejemplo, paréntesis)
        }
    }


}
