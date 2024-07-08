package edu.practice.UIController;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class OrderFormController {
    public AnchorPane orderContext;
    public TextField txtCustomerId;
    public TextField txtOrderId;
    public TextField txtCustomerShow;
    public TextField txtItemId;
    public TextField txtItemShow;
    public TextField txtDiscount;
    public TextField txtQty;
    public TableView orderTable;
    public TableColumn colItemCode;
    public TableColumn colQty;
    public TableColumn colDiscount;

    public void customerSearchOnAction(ActionEvent actionEvent) {
    }

    public void itemSearchOnAction(ActionEvent actionEvent) {
    }

    public void addItemOnAction(ActionEvent actionEvent) {
    }

    public void placeOrderOnAction(ActionEvent actionEvent) {

    }
}
