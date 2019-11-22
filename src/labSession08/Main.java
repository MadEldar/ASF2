package labSession08;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    static ObservableList<Account> list;
    static DataAccessObjectNumber daoNumber = new DataAccessObjectNumber();
    static DataAccessObjectAccount daoAccount = new DataAccessObjectAccount();

    public static void main(String[] args) throws SQLException {
        list = FXCollections.observableArrayList(daoAccount.read());

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PhoneList.fxml"));
        primaryStage.setTitle("Lab session 07");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
