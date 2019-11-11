package labSession05;

import javafx.scene.control.TextField;

public class NewUser {
    public TextField nameField = new TextField();
    public TextField ageField = new TextField();
    public TextField markField = new TextField();

    public void addToList() {
        User u = new User(
                nameField.getText(),
                Integer.parseInt(ageField.getText()),
                Integer.parseInt(markField.getText())
        );
        Main.list.add(u);
    }
}
