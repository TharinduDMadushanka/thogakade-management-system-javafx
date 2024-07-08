import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Thogakade Management System");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("edu/practice/view/LoginForm.fxml"))));
        stage.show();
        stage.centerOnScreen();
    }
}