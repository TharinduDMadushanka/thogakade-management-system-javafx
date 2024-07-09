package edu.practice.UIController;

import edu.practice.dto.CustomerDto;
import edu.practice.service.custom.impl.CustomerServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

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

    public TableView<CustomerDto> customerTable;
    public TableColumn<CustomerDto, String> colId;
    public TableColumn<CustomerDto, String> colTitle;
    public TableColumn<CustomerDto, String> colName;
    public TableColumn<CustomerDto, String> colDob;
    public TableColumn<CustomerDto, String> colSalary;
    public TableColumn<CustomerDto, String> colAddress;
    public TableColumn<CustomerDto, String> colCity;
    public TableColumn<CustomerDto, String> colProvince;
    public TableColumn<CustomerDto, String> colPostal;

    private final CustomerServiceImpl customerService = new CustomerServiceImpl();
    private final ObservableList<CustomerDto> customerList = FXCollections.observableArrayList();

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostal.setCellValueFactory(new PropertyValueFactory<>("postal"));

        loadCustomer();

        customerTable.setItems(customerList);
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    public void saveOnAction(ActionEvent actionEvent) {
        String dobString = txtDob.getValue().toString();

        CustomerDto customer = new CustomerDto(
                txtId.getText(),
                txtTitle.getText(),
                txtName.getText(),
                dobString,
                Double.parseDouble(txtSalary.getText()),
                txtAddress.getText(),
                txtCity.getText(),
                txtProvince.getText(),
                txtPostal.getText()
        );

        try {

            String result = customerService.save(customer);
            if ("Success".equals(result)) {
                customerList.add(customer);
                customerTable.refresh();
                clearFields();
                new Alert(Alert.AlertType.INFORMATION, "Customer successfully added").show();
            }

        }catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.INFORMATION,"Customer save Fail..!").show();
        }

    }

    public void updateOnAction(ActionEvent actionEvent) {
        String dobString = txtDob.getValue().toString();

        CustomerDto customer = new CustomerDto(
                txtId.getText(),
                txtTitle.getText(),
                txtName.getText(),
                dobString,
                Double.parseDouble(txtSalary.getText()),
                txtAddress.getText(),
                txtCity.getText(),
                txtProvince.getText(),
                txtPostal.getText()
        );

        try {

            String result = customerService.update(customer);
            if ("Success".equals(result)) {
                loadCustomer();
                clearFields();
                new Alert(Alert.AlertType.INFORMATION, "Customer successfully updated").show();
            }

        }catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.INFORMATION,"Customer update Fail..!").show();
        }

    }

    public void clearOnAction(ActionEvent actionEvent) {
        clearFields();
    }

    public void loadCustomer(){
        try{

            ArrayList<CustomerDto> customers = customerService.getAll();
            if(customers != null){
                customerList.setAll(customers);
                customerTable.setItems(customerList);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void clearFields(){
        txtId.clear();
        txtTitle.clear();
        txtName.clear();
        txtDob.setValue(null);
        txtSalary.clear();
        txtAddress.clear();
        txtCity.clear();
        txtProvince.clear();
        txtPostal.clear();
    }
}
