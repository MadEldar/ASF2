package assignmentFinal;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Menu implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    public void addStudent() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddStudent.fxml"));
        Main.mainStage.setTitle("Add new student");
        Main.mainStage.setScene(new Scene(root, 250, 300));
        Main.mainStage.show();
    }

    public void displayList() throws IOException {
        Stage listStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Display.fxml"));
        listStage.setTitle("Student list");
        listStage.setScene(new Scene(root, 600, 400));
        listStage.show();
    }

    public void saveList() {
        if(Main.f.canWrite()){
            try{
                FileOutputStream fos = new FileOutputStream(Main.f);
                DataOutputStream dos = new DataOutputStream(fos);
                dos.writeBytes(Main.fileText);
                dos.close();
                fos.close();
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void exit() {
        Main.mainStage.close();
    }
}
