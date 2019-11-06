package assignment03;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Timer implements Initializable {
    public TextField txtTimer = new TextField();
    public Text min = new Text();
    public Text sec = new Text();
    public Button btn = new Button();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void startTimer() {
        String timer = txtTimer.getText();
        int minute;
        try {
            minute = Integer.parseInt(timer);
        } catch (Exception e) {
            minute = 10;
        }
        int finalMinute = minute;
        Runnable r = () -> {
            for (int i = finalMinute - 1; i >= 0; --i) {
                for (int j = 59; j >= 0; --j) {
                    min.setText(String.format("%02d", i));
                    sec.setText(String.format("%02d", j));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        btn.setDisable(true);
        Thread t = new Thread(r);
        t.start();
    }
}
