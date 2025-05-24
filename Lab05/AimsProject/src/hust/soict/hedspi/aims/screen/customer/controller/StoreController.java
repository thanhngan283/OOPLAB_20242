package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StoreController {
    private Store store;
    private Cart cart;

    @FXML
    private GridPane gridPane;

    @FXML
    void btnViewCartPressed(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();

        try {
            loader.setLocation(getClass().getResource("../view/Cart.fxml"));
            loader.setController(new CartController(cart, store));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("View Cart");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public StoreController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    public void initialize() {
        int cols = 0;
        int rows = 1;
        for (var media : store.getItemsInStore()) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Item.fxml"));
                ItemController itemController = new ItemController(cart);
                loader.setController(itemController);
                AnchorPane anchorPane = loader.load();
                itemController.setData(media);

                if (cols == 3) {
                    cols = 0;
                    rows++;
                }
                gridPane.add(anchorPane, cols++, rows);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}