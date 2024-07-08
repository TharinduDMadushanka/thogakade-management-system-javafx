package edu.practice.UIController;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CustomerFormController {
    public AnchorPane customerContext;
    public TextField txtTitle;
    public TextField txtName;
    public TextField txtId;
    public TextField txtAddress;
    public TextField txtCity;
    public TextField txtSalary;
    public TextField txtPostal;
    public TextField txtProvince;
    public DatePicker txtDob;
    public TableView customerTable;
    public TableColumn colId;
    public TableColumn colTitle;
    public TableColumn colName;
    public TableColumn colDob;
    public TableColumn colSalary;
    public TableColumn colAddress;
    public TableColumn colCity;
    public TableColumn colProvince;
    public TableColumn colPostal;

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    public void saveOnAction(ActionEvent actionEvent) {
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void clearOnAction(ActionEvent actionEvent) {
    }
}
