package labSession06;

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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class phoneList implements Initializable {
    public static ObservableList<PhoneNumber> list = FXCollections.observableArrayList();
    public TableView<Account> tableView = new TableView<>();
    public TableColumn<Account, Integer> accountId = new TableColumn<>();
    public TableColumn<Account, String> name = new TableColumn<>();
    public TableColumn<Account, String> workplace = new TableColumn<>();
    public TableColumn<Account, String> address = new TableColumn<>();

    public ListView<Account> lvName = new ListView<>();

    static Account something;

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

    public void something() throws SQLException, IOException {
        something = lvName.getSelectionModel().getSelectedItem();
        String query = "select * from phone_list where phone_owner like ?";
        PreparedStatement ppstm = Main.cnt.prepareStatement(query);
        ppstm.setInt(1, something.getId());
        list.clear();
        try {
            ResultSet rs = ppstm.executeQuery();
            while (rs.next()) {
                list.add(new PhoneNumber(rs.getInt("phone_id"), rs.getString("phone_type")));
            }
        } catch (Exception ignore) {}
        Stage ns = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Detail.fxml"));
        ns.setTitle("So dien thoai");
        ns.setScene(new Scene(root, 200, 250));
        ns.show();
    }
}
