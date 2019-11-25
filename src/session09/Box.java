package session09;

import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class Box implements Initializable {
    public RadioButton rVN = new RadioButton();
    public RadioButton rEN = new RadioButton();

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    private void changeLang() {
        ResourceBundle bundle = ResourceBundle.getBundle("session09.Messages");
        rEN.setText(bundle.getString("hello"));
        rVN.setText(bundle.getString("what"));
    }

    private void unselectAll() {
        rEN.setSelected(false);
        rVN.setSelected(false);
    }

    public void langVN() {
        Locale.setDefault(new Locale("vi", "VN"));
        unselectAll();
        rVN.setSelected(true);
        changeLang();
    }

    public void langEN() {
        Locale.setDefault(Locale.US);
        unselectAll();
        rEN.setSelected(true);
        changeLang();
    }
}
