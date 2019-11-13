package labSession05;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {
    static ObservableList<User> list = FXCollections.observableArrayList();
    static Connection cnt;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/scratch";
        String username = "root";
        String password = "";
        cnt = DriverManager.getConnection(url, username, password);

        Statement stm = cnt.createStatement();

        String query = "SELECT * FROM user";

        ResultSet rs = stm.executeQuery(query);

        while (rs.next()) {
            list.add(new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getInt("mark")
            ));
            System.out.println();
        }
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("userList.fxml"));
        primaryStage.setTitle("Hell World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
