// package org.robatipoor.controller;

// import java.io.IOException;
// import java.net.URL;
// import java.util.List;
// import java.util.ResourceBundle;

// import org.robatipoor.model.Employee;

// import javafx.collections.FXCollections;
// import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
// import javafx.fxml.Initializable;
// import javafx.scene.Node;
// import javafx.scene.Parent;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.TableColumn;
// import javafx.scene.control.TableRow;
// import javafx.scene.control.TableView;
// import javafx.scene.control.cell.PropertyValueFactory;
// import javafx.stage.Stage;

// /**
//  * Controller
//  */
// public class Controller implements Initializable {

//     @FXML
//     TableView<Employee> tableView;
//     @FXML
//     TableColumn<Employee, String> name;
//     @FXML
//     TableColumn<Employee, String> family;
//     @FXML
//     Button button;

//     @FXML
//     public void initialize(URL location, ResourceBundle resources) {
//         name.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
//         family.setCellValueFactory(new PropertyValueFactory<Employee, String>("family"));
//         List<Employee> list = List.of(new Employee("name", "family"));
//         tableView.setItems(FXCollections.observableList(list));
//         tableView.setRowFactory(tv -> {
//             TableRow<Employee> row = new TableRow<>();
//             row.setOnMouseClicked(event -> {
//                 if (event.getClickCount() == 2 && (!row.isEmpty())) {
//                     Employee rowData = row.getItem();
//                     System.out.println("Double click on: " + rowData.getName());
//                     try {
//                         Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ok.fxml"));
//                         Stage stage = new Stage();
//                         stage.setTitle("My New Stage Title");
//                         stage.setScene(new Scene(root, 450, 450));
//                         stage.show();
//                     } catch (IOException e) {
//                         // TODO Auto-generated catch block
//                         e.printStackTrace();
//                     }

//                 }
//             });
//             return row;
//         });
//         button.setOnAction((event) -> {
//             Parent root;
//             try {
//                 root = FXMLLoader.load(getClass().getClassLoader().getResource("ok.fxml"));
//                 Stage stage = new Stage();
//                 stage.setTitle("My New Stage Title");
//                 stage.setScene(new Scene(root, 450, 450));
//                 stage.show();
//                 // Hide this current window (if this is what you want)
//                 ((Node) (event.getSource())).getScene().getWindow().hide();
//             } catch (Exception e) {
//                 System.out.println(e.toString());
//             }
//         });
//     }
// }