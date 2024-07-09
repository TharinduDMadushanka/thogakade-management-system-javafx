package edu.practice.UIController;

import edu.practice.dto.CustomerDto;
import edu.practice.dto.ItemDto;
import edu.practice.dto.OrderDetailDto;
import edu.practice.dto.OrderDto;
import edu.practice.service.custom.impl.CustomerServiceImpl;
import edu.practice.service.custom.impl.ItemServiceImpl;
import edu.practice.service.custom.impl.OrderServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;
import java.util.ArrayList;

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

        try {

            String itemId = txtItemId.getText();
            ItemDto item = itemService.get(itemId);

            if (item != null) {
                txtItemShow.setText(item.getDescription());
            }else
                txtItemShow.setText("Item Not Found");

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addItemOnAction(ActionEvent actionEvent) {

        try{

            String itemId = txtItemId.getText();
            int qty = Integer.parseInt(txtQty.getText());
            int discount = Integer.parseInt(txtDiscount.getText());

            OrderDetailDto orderDetail = new OrderDetailDto("",itemId,qty,discount);
            orderDetails.add(orderDetail);

            new Alert(Alert.AlertType.INFORMATION, "Item Added Successfully").show();

            txtItemId.clear();
            txtQty.clear();
            txtDiscount.clear();
            txtItemShow.clear();

        }catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.INFORMATION,"Failed to add item").show();
        }

    }

    public void placeOrderOnAction(ActionEvent actionEvent) {

        try {

            String orderId = txtOrderId.getText();
            String customerId = txtCustomerId.getText();
            String date = LocalDate.now().toString();

            ArrayList<OrderDetailDto> orderDetailList = new ArrayList<>(orderDetails);

            OrderDto order = new OrderDto(orderId,customerId,date,orderDetailList);
            String result = orderService.placeOrder(order);

            if (result != null) {
                new Alert(Alert.AlertType.INFORMATION,"Order Placed Successfully").show();
            }else {
                new Alert(Alert.AlertType.INFORMATION,"Failed to place order").show();
            }

        }catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.INFORMATION,"Failed to add order").show();
        }

    }
}
