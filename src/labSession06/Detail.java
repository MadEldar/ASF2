package labSession06;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Detail implements Initializable {
    public TableView<PhoneNumber> tbview = new TableView<>();
    public TableColumn<PhoneNumber, Integer> number = new TableColumn<>();
    public TableColumn<PhoneNumber, String> type = new TableColumn<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));

        tbview.setItems(phoneList.list);
    }
}
