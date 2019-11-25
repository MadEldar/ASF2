package assignmentFinal;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Display implements Initializable {
    public TableView<Student> tableView = new TableView<>();
    public TableColumn<Student, String> studentID = new TableColumn<>();
    public TableColumn<Student, String> studentName = new TableColumn<>();
    public TableColumn<Student, String> studentAddress = new TableColumn<>();
    public TableColumn<Student, String> studentPhone = new TableColumn<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentID.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        studentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        studentAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        studentPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

        tableView.setItems(Main.studentList);
    }
}
