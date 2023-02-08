/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentinformationlist.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Dell
 */
public class MainController implements Initializable {
    
    private Label label;
    @FXML
    private MenuItem closeItem;
    @FXML
    private MenuItem deleteItem;
    @FXML
    private MenuItem aboutItem;
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private RadioButton maleRadioBtn;
    @FXML
    private ToggleGroup gender;
    @FXML
    private RadioButton femaleRadioBtn;
    @FXML
    private Button saveButton;
    @FXML
    private DatePicker dobPicker;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveStudentInfo(ActionEvent event) {
    }
    
}
