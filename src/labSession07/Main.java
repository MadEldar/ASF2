package labSession07;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class Main extends Application {
    static ObservableList<Account> list = FXCollections.observableArrayList();

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ResultSet rs = Connector.findAccountByName("%");

        while (rs.next()) {
            Account a = new Account(
                    rs.getInt("account_id"),
                    rs.getString("account_name"),
                    rs.getString("account_company"),
                    rs.getString("account_address")
            );
            list.add(a);
        }

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("phoneList.fxml"));
        primaryStage.setTitle("Lab session 07");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
