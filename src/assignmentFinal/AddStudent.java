package assignmentFinal;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddStudent implements Initializable {
    public TextField textID = new TextField();
    public TextField textName = new TextField();
    public TextField textAddress = new TextField();
    public TextField textPhone = new TextField();

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    public void addStudent() throws IOException {
        Main.fileText += textID.getText() + "-" + textName.getText() + "-" + textAddress.getText() + "-" + textPhone.getText() + "\n";
        Main.studentList.add(new Student(
                textID.getText(),
                textName.getText(),
                textAddress.getText(),
                textPhone.getText()
        ));

        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Main.mainStage.setTitle("Student management program");
        Main.mainStage.setScene(new Scene(root, 250, 300));
        Main.mainStage.show();
    }

    public void cancel() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Main.mainStage.setTitle("Student management program");
        Main.mainStage.setScene(new Scene(root, 250, 300));
        Main.mainStage.show();
    }
}
