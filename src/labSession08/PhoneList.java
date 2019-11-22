package labSession08;

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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PhoneList implements Initializable {
    public static ObservableList<PhoneNumber> list = FXCollections.observableArrayList();
    private static Stage numberStage = new Stage();
    private static Stage newAccountStage = new Stage();
    public TableView<Account> tableView = new TableView<>();
    public TableColumn<Account, Integer> accountId = new TableColumn<>();
    public TableColumn<Account, String> name = new TableColumn<>();
    public TableColumn<Account, String> workplace = new TableColumn<>();
    public TableColumn<Account, String> address = new TableColumn<>();

    public static ListView<Account> lvName = new ListView<>();

    public static Text message = new Text();

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

    public void getPhone() throws SQLException, IOException {
        Account a = lvName.getSelectionModel().getSelectedItem();
        if (a != null) {
            list.clear();
            ResultSet result = Connector.findPhoneById(a.getId());
            while (result.next()) {
                list.add(new PhoneNumber(
                        result.getInt("phone_id"),
                        result.getString("phone_type"),
                        result.getInt("phone_owner"))
                );
            }
            Parent root = FXMLLoader.load(getClass().getResource("Detail.fxml"));
            numberStage.setTitle("So dien thoai");
            numberStage.setScene(new Scene(root, 200, 250));
            numberStage.show();
        }
    }

    public void addAccount() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddAccount.fxml"));
        newAccountStage.setTitle("Add account");
        newAccountStage.setScene(new Scene(root, 400, 225));
        newAccountStage.show();
    }
    
    public void deleteAccount() throws SQLException {
        Account account = lvName.getSelectionModel().getSelectedItem();
        int row = Main.daoAccount.delete(account);
        if (row > 0) {
            Main.list.remove(account);

            lvName.refresh();

            for (Account a : Main.list) {
                lvName.getItems().add(a);
            }
            message.setText("Successfully deleted chosen account");
        } else {
            message.setText("Failed to delete chosen account");
        }
    }
}
