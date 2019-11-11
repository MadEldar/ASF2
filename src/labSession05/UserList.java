package labSession05;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserList implements Initializable {
    public TableView<User> tableView = new TableView<>();

    public TableColumn<User, Integer> id = new TableColumn<>();
    public TableColumn<User, String> name = new TableColumn<>();
    public TableColumn<User, Integer> age = new TableColumn<>();
    public TableColumn<User, Integer> mark = new TableColumn<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        mark.setCellValueFactory(new PropertyValueFactory<>("mark"));

        tableView.setItems(Main.list);
    }

    public void addNew() throws IOException {
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("newUser.fxml"));
        newStage.setTitle("Add new user");
        newStage.setScene(new Scene(root, 400, 250));
        newStage.show();
    }
}
