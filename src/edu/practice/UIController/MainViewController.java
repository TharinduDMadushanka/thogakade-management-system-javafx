package edu.practice.UIController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {
    public AnchorPane mainContext;
    public Button btnLogOut;

    public void addItemOnAction(ActionEvent actionEvent) throws IOException {
        setContext("ItemForm");
    }

    public void addCustomerOnAction(ActionEvent actionEvent) throws IOException {
        setContext("CustomerForm");
    }

    public void placeOrderOnAction(ActionEvent actionEvent) {
    }

    public void signoutOnAction(ActionEvent actionEvent) throws IOException {
        setUI("LoginForm");
    }

    private void setUI(String location) throws IOException {
        Stage stage = (Stage) btnLogOut.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/edu/practice/view/" + location + ".fxml"))));
        stage.show();
        stage.centerOnScreen();
    }

    private void setContext(String location) throws IOException {
        try{
            mainContext.getChildren().clear();
            mainContext.getChildren().add(FXMLLoader.load(getClass().getResource("/edu/practice/view/" + location + ".fxml")));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
