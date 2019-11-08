package labSession05;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
}
