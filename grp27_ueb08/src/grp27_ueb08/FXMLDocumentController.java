/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grp27_ueb08;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Robin
 */
public class FXMLDocumentController implements Initializable {

    Calculator calculator = new Calculator();
    String lastPressedButton = "Not pressed yet";
    String lastOperation = "No operatioon yet";
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btnSub;
    @FXML
    private Button btn0;
    @FXML
    private Button btnPoint;
    @FXML
    private Button btnCalc;
    @FXML
    private Button btnAdd;
    @FXML
    private TextField txtFldDisplay;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btnMult;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button btnDiv;
    @FXML
    private Button btnMC;
    @FXML
    private Button btnMR;
    @FXML
    private Button btnC;
    @FXML
    private Button btnAC;
    @FXML
    private Button btnMPlus;
    @FXML
    private Button btnMMinus;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleBtnDigit(ActionEvent event) {
        String oldText = txtFldDisplay.getText();

        if (lastPressedButton.equals("Calculate") || lastPressedButton.equals("MemRead")) {
            this.handleBtnAllClear(event);
            oldText = "";
        }

        if (lastPressedButton.equals("Operator")) {
            oldText = "";
        }

        txtFldDisplay.setText(oldText + ((Button) event.getSource()).getText());
        lastPressedButton = "Digit";
    }

    @FXML
    private void handleBtnPoint(ActionEvent event) {
        String oldText = txtFldDisplay.getText();
        if (!oldText.contains(".")) {
            txtFldDisplay.setText(oldText + ".");
        }

        lastPressedButton = "Point";
    }

    @FXML
    private void handleBtnCalc(ActionEvent event) {

        double value;

        try {
            value = Double.valueOf(txtFldDisplay.getText());;

            if (calculator.getOp1() != null) {
                if (!lastPressedButton.equals("Calculate")) {
                    calculator.setOp2(value);
                }
                double result = calculator.calculate();
                txtFldDisplay.setText(Double.toString(result));
                calculator.setOp1(result);
            }

        } catch (RuntimeException e) {

            System.out.println("Value on display is not a number");

        } finally {
            lastPressedButton = "Calculate";
            lastOperation = "Calculate";
        }
    }

    @FXML
    private void handleBtnOperator(ActionEvent event) {
        double value;

        try {
            value = Double.valueOf(txtFldDisplay.getText());

            if (lastOperation.equals("Operator") && !lastPressedButton.equals("Operator")) {
                this.handleBtnCalc(event);
            } else {
                calculator.setOp1(value);
            }
            calculator.setOperator(((Button) event.getSource()).getText());
        } catch (RuntimeException e) {

            System.out.println("Value on display is not a number");

        } finally {
            lastPressedButton = "Operator";
            lastOperation = "Operator";
        }
    }

    @FXML
    private void handleBtnMemClear(ActionEvent event) {
        calculator.setMemory(null);
        lastPressedButton = "MemClear";
    }

    @FXML
    private void handleBtnMemRead(ActionEvent event) {

        if (calculator.getMemory() != null) {
            txtFldDisplay.setText(Double.toString(calculator.getMemory()));
        } else {
            txtFldDisplay.setText("");
        }

        lastPressedButton = "MemRead";
    }

    @FXML
    private void handleBtnClear(ActionEvent event) {
        txtFldDisplay.setText("");
        lastPressedButton = "Clear";
    }

    @FXML
    private void handleBtnAllClear(ActionEvent event) {
        txtFldDisplay.setText("");
        calculator.setOp1(null);
        calculator.setOp2(null);
        calculator.setOperator("");
        lastPressedButton = "AllClear";
    }

    @FXML
    private void handleBtnMemAdd(ActionEvent event) {
        if (calculator.getMemory() == null) {
            calculator.setMemory(0.0);
        }
        try {
            double value = Double.valueOf(txtFldDisplay.getText());
            calculator.setMemory(calculator.getMemory() + value);
        } catch (RuntimeException e) {
            System.out.println("Value on display is not a number");
        } finally {
            lastPressedButton = "MemAdd";
        }
    }

    @FXML
    private void handleBtnMemSub(ActionEvent event
    ) {
        if (calculator.getMemory() == null) {
            calculator.setMemory(0.0);
        }
        try {
            double value = Double.valueOf(txtFldDisplay.getText());
            calculator.setMemory(calculator.getMemory() - value);
        } catch (RuntimeException e) {

            System.out.println("Value on display is not a number");
        } finally {
            lastPressedButton = "MemSub";
        }
    }

}
