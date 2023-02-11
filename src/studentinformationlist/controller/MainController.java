/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentinformationlist.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import studentinformationlist.dao.StudentDAO;
import studentinformationlist.model.Student;

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
    @FXML
    private TableView<Student> tableId;
    
    StudentDAO stdao;
    @FXML
    private TableColumn<Student, Integer> idCol;
    @FXML
    private TableColumn<Student, String> nameCol;
    @FXML
    private TableColumn<Student, String> emailCol;
    @FXML
    private TableColumn<Student, String> genderCol;
    @FXML
    private TableColumn<Student, Date> dobCol;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        maleRadioBtn.setUserData("Male");
        femaleRadioBtn.setUserData("Female");
        stdao=new StudentDAO();
        
        initColumn();
        loadTableData();
    }    

    @FXML
    private void saveStudentInfo(ActionEvent event) {
        String name=nameField.getText();
        String email=emailField.getText();
        RadioButton selectedradio=(RadioButton)gender.getSelectedToggle();
        String genderstr=(String)selectedradio.getUserData();
        LocalDate localdob=dobPicker.getValue();
        
        if( name==null || email==null || localdob==null)
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Please,fill out all fields");
            alert.show();
            clearForm();
            return;
        }
        else if(!emailField.getText().matches("^(.+)@(\\S+)$"))
        {
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Email");
            alert.setContentText("Enter a valid Email");
            alert.show();
            emailField.clear();
            return;
        }
        Date dob=Date.valueOf(localdob);
        
        Student student=new Student(name,email,genderstr,dob);
        try {
            stdao.saveStudents(student);
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Student's Information is successful saved");
            alert.show();
            clearForm();
            loadTableData();
        } catch (SQLException ex) {
            System.out.println("Error");
       }
    }

    @FXML
    private void closeWindow(ActionEvent event) {
        Stage stage=(Stage)nameField.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void deleteTableRow(ActionEvent event) throws SQLException {
        int id=tableId.getSelectionModel().getSelectedItem().getId();
        stdao.DeleteStudent(id);
        loadTableData();
    }

    @FXML
    private void goAboutProject(ActionEvent event) throws IOException {
        Stage newstage=new Stage();
        Parent root=FXMLLoader.load(getClass().getResource("/studentinformationlist/aboutproject/about.fxml"));
        Scene scene=new Scene(root);
        Stage mainstage=(Stage)nameField.getScene().getWindow();
        newstage.initOwner(mainstage);
        newstage.initModality(Modality.WINDOW_MODAL);
        newstage.setTitle("About Project");
        newstage.setScene(scene);
        newstage.show();
    }
    
    @FXML
    private void clearForm()
    {
        nameField.clear();
        emailField.clear();
        maleRadioBtn.setSelected(true);
        dobPicker.setValue(null);
    }
    @FXML
    private void initColumn()
    {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        dobCol.setCellValueFactory(new PropertyValueFactory<>("dob"));
    }
    @FXML
    private  void loadTableData()
    {
        try {
            List<Student> studentlist=stdao.getStudents();
            tableId.getItems().setAll(studentlist);
        } catch (SQLException ex) {
            System.out.println("Loading Error");
        }
    }
}
