package assignment01;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class ProductList implements Initializable {
    public static boolean flag = true;
    public TableView<Product> tbView = new TableView<>();

    public TableColumn<Product, Integer> idCol = new TableColumn<>();
    public TableColumn<Product, String> nameCol = new TableColumn<>();
    public TableColumn<Product, Integer> priceCol = new TableColumn<>();
    public TableColumn<Product, Integer> quantityCol = new TableColumn<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        tbView.setItems(Main.list);
    }

    private static boolean getFlag() {
        flag = !flag;
        return flag;
    }

    public void sortByName() {
        if (getFlag()) Main.list.sort(Comparator.comparing(Product::getName));
        else Main.list.sort(Comparator.comparing(Product::getName).reversed());
    }

    public void sortByPrice() {
        if (getFlag()) Main.list.sort(Comparator.comparing(Product::getPrice));
        else Main.list.sort(Comparator.comparing(Product::getPrice).reversed());
    }

    public void sortByQuantity() {
        if (getFlag()) Main.list.sort(Comparator.comparing(Product::getQuantity));
        else Main.list.sort(Comparator.comparing(Product::getQuantity).reversed());
    }
}
