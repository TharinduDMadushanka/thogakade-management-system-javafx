package edu.practice.UIController;

import edu.practice.dto.CustomerDto;
import edu.practice.dto.OrderDetailDto;
import edu.practice.service.custom.impl.CustomerServiceImpl;
import edu.practice.service.custom.impl.ItemServiceImpl;
import edu.practice.service.custom.impl.OrderServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    public TableView<OrderDetailDto> orderTable;
    public TableColumn<OrderDetailDto, String>  colItemCode;
    public TableColumn<OrderDetailDto, String> colQty;
    public TableColumn<OrderDetailDto, String> colDiscount;

    private CustomerServiceImpl customerService = new CustomerServiceImpl();
    private ItemServiceImpl itemService = new ItemServiceImpl();
    private OrderServiceImpl orderService = new OrderServiceImpl();
    private ObservableList<OrderDetailDto> orderDetails = FXCollections.observableArrayList();

    public void initialize() {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));

        orderTable.setItems(orderDetails);
    }

    public void customerSearchOnAction(ActionEvent actionEvent) {
        try {

            String customerId = txtCustomerId.getText();
            CustomerDto customer = customerService.getCustomer(customerId);

            if (customer != null) {
                txtCustomerShow.setText(customer.getTitle()+". "+customer.getName()+" | "+customer.getCity());
            }else {
                txtCustomerShow.setText("Customer Not Found");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void itemSearchOnAction(ActionEvent actionEvent) {
    }

    public void addItemOnAction(ActionEvent actionEvent) {
    }

    public void placeOrderOnAction(ActionEvent actionEvent) {

    }
}
