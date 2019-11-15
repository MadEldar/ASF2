package labSession07;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class phoneList implements Initializable {
    public static ObservableList<PhoneNumber> list = FXCollections.observableArrayList();
    private static Stage listStage = new Stage();
    public TableView<Account> tableView = new TableView<>();
    public TableColumn<Account, Integer> accountId = new TableColumn<>();
    public TableColumn<Account, String> name = new TableColumn<>();
    public TableColumn<Account, String> workplace = new TableColumn<>();
    public TableColumn<Account, String> address = new TableColumn<>();

    public ListView<Account> lvName = new ListView<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        accountId.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        workplace.setCellValueFactory(new PropertyValueFactory<>("workplace"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));

        tableView.setItems(Main.list);

        for (Account a : Main.list) {
            lvName.getItems().add(a);
        }
    }

    public void getPhone() throws IOException {
        Account something = lvName.getSelectionModel().getSelectedItem();
        list.clear();
        try {
            ResultSet rs = Connector.findPhoneById(something.getId());
            while (rs.next()) {
                list.add(new PhoneNumber(rs.getInt("phone_id"), rs.getString("phone_type")));
            }
        } catch (Exception ignore) {
        }
        Parent root = FXMLLoader.load(getClass().getResource("Detail.fxml"));
        listStage.setTitle("So dien thoai");
        listStage.setScene(new Scene(root, 200, 250));
        listStage.show();
    }
}
