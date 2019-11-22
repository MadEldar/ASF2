package labSession08;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddAccount implements Initializable {
    public TextField account_id = new TextField();
    public TextField account_name = new TextField();
    public TextField account_company = new TextField();
    public TextField account_address = new TextField();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void addAccount() throws SQLException {
        Account account = new Account(
                Account.accountId++,
                account_name.getText(),
                account_company.getText(),
                account_address.getText()
        );
        boolean success = Main.daoAccount.create(account);
        if (success) {
            Main.list.add(account);

            PhoneList.lvName.refresh();

            for (Account a : Main.list) {
                PhoneList.lvName.getItems().add(a);
            }
            PhoneList.message.setText("Successfully created a new account");
        } else {
            PhoneList.message.setText("Failed to create a new account");
        }
    }
}
