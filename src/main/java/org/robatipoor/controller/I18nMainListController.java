package org.robatipoor.controller;

import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import com.github.naoghuman.lib.i18n.core.I18NBindingBuilder;

import org.robatipoor.model.Employee;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * I18nMainListController
 */
public class I18nMainListController extends MainListController implements Initializable {

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

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        this.bind(firstname.textProperty(), "firstname");
        System.out.println("+++++++))))))))))))))))))))))))))++++"+firstname.textProperty().get());
        this.bind(lastname.textProperty(), "lastname");
        this.bind(birthday.textProperty(), "birthday");
        this.bind(age.textProperty(), "age"); 
        this.bind(closeButton.textProperty(), "closeButton"); 
        this.bind(newEmployeeButton.textProperty(), "newEmployeeButton"); 
    }

    private void bind(final StringProperty stringProperty, final String key) {
        final Optional<StringBinding> optionalStringBinding = I18NBindingBuilder.bind().key(key).build();
        optionalStringBinding.ifPresent(stringBinding -> {
            stringProperty.bind(stringBinding);
        });
    }
}