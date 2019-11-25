package assignmentFinal;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application {
    public static ObservableList<Student> studentList = FXCollections.observableArrayList();
    public static Stage mainStage;
    public static String fileText = "";
    public static File f = new File("/Users/DELL/Desktop/students.txt");

    public static void main(String[] args) {
        if (f.canRead()) {
            try {
                FileInputStream fis = new FileInputStream(f);
                DataInputStream dis = new DataInputStream(fis);
                String line = "";
                while ((line = dis.readLine()) != null) {
                    fileText += line + "\n";
                    String[] strings = line.split("-");
                    studentList.add(new Student(
                            strings[0],
                            strings[1],
                            strings[2],
                            strings[3]
                    ));
                }
                dis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        mainStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        mainStage.setTitle("Student management program");
        mainStage.setScene(new Scene(root, 250, 300));
        mainStage.show();
    }
}
