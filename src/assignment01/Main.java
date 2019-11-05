package assignment01;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static ObservableList<Product> list = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ProductList.fxml"));
        primaryStage.setTitle("Hell World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        list.add(new Product("Moxpad X3", 450000, 5));
        list.add(new Product("Moxpad X6", 650000, 3));
        list.add(new Product("Moxpad X9", 860000, 4));
        launch(args);
    }
}
