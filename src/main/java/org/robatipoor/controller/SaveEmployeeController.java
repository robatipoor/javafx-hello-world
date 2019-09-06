package org.robatipoor.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.robatipoor.dao.EmployeeDAOImpl;
import org.robatipoor.model.Employee;
import org.robatipoor.service.EmployeeService;
import org.robatipoor.util.Resources;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * SaveEmployee
 */
public class SaveEmployeeController implements Initializable {

    @FXML
    TextField firstname;

    @FXML
    TextField lastname;

    @FXML
    TextField age;

    @FXML
    DatePicker birthday;

    @FXML
    Button saveButton;

    private EmployeeService service;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        saveButton.setOnAction((event) -> {
            Parent root;
            try {
                service = new EmployeeService(new EmployeeDAOImpl());
                Employee employee = new Employee();
                employee.setFirstname(firstname.getText());
                employee.setLastname(lastname.getText());
                employee.setAge(Integer.valueOf(age.getText()));
                employee.setBirthday(java.sql.Date.valueOf(birthday.getValue()));                
                service.save(employee);
                root = FXMLLoader.load(Resources.getURLFXMLFile("ok"));
                Stage stage = new Stage();
                stage.setTitle("Save Employee");
                stage.setScene(new Scene(root, 450, 450));
                stage.show();
                // Hide this current window (if this is what you want)
                // ((Node) (event.getSource())).getScene().getWindow().hide();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        });
    }

}