package edmodo.viewController;

import com.edmodo.model.Bid;
import com.edmodo.model.Item;
import com.edmodo.model.User;
import com.edmodo.modelController.BidRec;
import com.edmodo.modelController.ItemRec;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

/**
 * Created by pc on 30.01.2017.
 */
public class TradeContr extends ObjController {

    @FXML
    private Label welcome;
    @FXML
    private Label info;
    @FXML
    private TextField itemName;
    @FXML
    private TextField itemDescr;
    @FXML
    private TextField itemSearch;
    @FXML
    private Label searchInfo;
    @FXML
    private TableView<Item> myItems;
    @FXML
    private TableColumn<Item, String> myItemNameColumn;
    @FXML
    private TableColumn<Item, String> myItemDescrColumn;
    @FXML
    private TableColumn<Item, String> nameItemColumn;
    @FXML
    private TableColumn<Item, String> descrItemColumn;
    @FXML
    private TableView<Item> foundItems;

    private Item item;
    private ItemRec itemRec = new ItemRec();
    private Bid bid;
    private BidRec bidRec = new BidRec();
    private Item itemToBuy;
    private ObservableList<Item> itemListObs = FXCollections.observableArrayList();
    private ObservableList<Item> boughtListObs = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        welcome.setText(" Здравствуйте, " + AccessContr.user.getName());
        showUserItems();
        foundItems.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> itemToBuy = newValue);
    }

    @FXML
    void clickAddItemBth() {
        info.setText("");
        if (itemName.getText().isEmpty() || itemDescr.getText().isEmpty()) {
            info.setText("Укажите наименование и описание товара");
        } else {
            item = new Item(itemName.getText(), itemDescr.getText(), AccessContr.user);
            itemRec.addRecord(2, null, item, null);
            info.setText("Товар выставлен на торги");
        }
    }

    @FXML
    void clickSearchBtn() {
        itemListObs.removeAll();
        foundItems.getItems().clear();
        searchInfo.setText("");
        if (itemSearch.getText().isEmpty()) {
            searchInfo.setText("Укажите наименование/описание");
        } else {
            List<Item> selectedItems = itemRec.search(itemSearch.getText(), AccessContr.user.getId());
            if (selectedItems == null) {
                searchInfo.setText("Товар не найден");
            } else {
                itemListObs.addAll(selectedItems);
                nameItemColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
                descrItemColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("description"));
                foundItems.setItems(itemListObs);
            }
        }
    }

    @FXML
    void clickExitBtn() {
        AccessContr.user = null;
        super.getMain().showAccessForm();
    }

    @FXML
    void clickBuyBtn() {
        bid = new Bid();
        bid.setItem(itemToBuy);
        bid.setUser(AccessContr.user);
        bidRec.addRecord(3, null, null, bid);
        info.setText("Товар приобретен");
    }

    private void showUserItems() {
        List<Item> boughtItems = itemRec.showMyItems(AccessContr.user.getId());
        if (boughtItems != null) {
            boughtListObs.addAll(boughtItems);
            myItemNameColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
            myItemDescrColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("description"));
            myItems.setItems(boughtListObs);
        }
    }
}


