package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private ToggleGroup filter;

    @FXML
    private Label lblCost;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TextField tfFilter;

    private Cart cart;
    private Store store;

    public CartController(Cart cart, Store store) {
        this.cart = cart;
        this.store = store;
    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("ID"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        if (cart.getItemsOrdered() != null) {
            tblMedia.setItems(cart.getItemsOrdered());
            lblCost.setText("Total: " + cart.totalCost() + "$");
        }

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (((RadioButton) filter.getSelectedToggle()).getText().equals("By Title")) {
                    FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered(),
                            p -> p.isMatchByTitle(newValue));
                    tblMedia.setItems(filteredList);
                } else {
                    try {
                        FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered(),
                                p -> p.getID() == Integer.parseInt(newValue));
                        tblMedia.setItems(filteredList);
                    } catch (NumberFormatException e) {
                        FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered(),
                                p -> true);
                        tblMedia.setItems(filteredList);
                    }

                }
            }
        });
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Place order successfully!");
        alert.showAndWait();
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        StringBuffer content = new StringBuffer();
        content.append("Title: " + media.getTitle() + "\n");
        content.append("Category: " + media.getCategory() + "\n");
        alert.setContentText(content.toString());
        alert.setHeaderText("Playing Media");
        alert.showAndWait();
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        tblMedia.getItems().remove(media);
        lblCost.setText("Total: " + cart.totalCost() + "$");
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(getClass().getResource("../view/Store.fxml"));
            loader.setController(new StoreController(store, cart));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("View Store");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
