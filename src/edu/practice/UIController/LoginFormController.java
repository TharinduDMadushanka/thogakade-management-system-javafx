package edu.practice.UIController;

import edu.practice.db.DBConnection;
import edu.practice.dto.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class LoginFormController {
    public AnchorPane context;
    public TextField txtUserName;
    public PasswordField txtPassword;
    public Button btnLogin;


    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        Optional<Admin> selectAdmin = DBConnection.userTable.stream().filter(e -> e.getUsername().equals(userName)).findFirst();

        if (selectAdmin.isPresent()) {
            if(password.equals(selectAdmin.get().getPassword())) {
                new Alert(Alert.AlertType.INFORMATION,"Login Successful").showAndWait();
                setUI("MainView");
            }else {
                new Alert(Alert.AlertType.ERROR,"Incorrect Password").showAndWait();
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"User not found").showAndWait();
        }

    }

    private void setUI(String location) throws IOException {
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/edu/practice/view/" + location + ".fxml"))));
        stage.show();
        stage.centerOnScreen();
    }
}
