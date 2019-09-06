package org.robatipoor.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import org.robatipoor.dao.EmployeeDAOImpl;
import org.robatipoor.model.Employee;
import org.robatipoor.service.EmployeeService;
import org.robatipoor.util.Resources;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * MainListController
 */
public class MainListController implements Initializable {

    @FXML
    TableView<Employee> employeeTable;
    @FXML
    TableColumn<Employee, String> firstname;
    @FXML
    TableColumn<Employee, String> lastname;
    @FXML
    TableColumn<Employee, Date> birthday;
    @FXML
    TableColumn<Employee, Integer> age;
    @FXML
    Button closeButton;
    @FXML
    Button newEmployeeButton;
    @FXML
    Button sortListButton;
    EmployeeService service;

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        firstname.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstname"));
        lastname.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastname"));
        birthday.setCellValueFactory(new PropertyValueFactory<Employee, Date>("birthday"));
        age.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("age"));
        service = new EmployeeService(new EmployeeDAOImpl());
        employeeTable.setItems(FXCollections.observableList(service.findAll()));
        employeeTable.setRowFactory(tv -> {
            TableRow<Employee> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Employee rowData = row.getItem();
                    System.out.println("Double click on: " + rowData);
                    try {
                        Parent root = FXMLLoader.load(Resources.getURLFXMLFile("details-employee"));
                        Stage stage = new Stage();
                        stage.setTitle("Save Employee");
                        stage.setScene(new Scene(root, 450, 450));
                        stage.show();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            });
            return row;
        });

        newEmployeeButton.setOnAction((event) -> {
            Parent root;
            try {
                root = FXMLLoader.load(Resources.getURLFXMLFile("save-employee"));
                Stage stage = new Stage();
                stage.setTitle("Save Employee");
                stage.setScene(new Scene(root, 600, 450));
                stage.show();
                // Hide this current window (if this is what you want)
                // ((Node) (event.getSource())).getScene().getWindow().hide();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        });
    }
}