package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.Playable;
import hust.soict.hedspi.aims.media.Media;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
    private Media media;
    private Cart cart;

    @FXML
    private Button btnAddtoCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    public ItemController(Cart cart) {
        this.cart = cart;
    }

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + "$");
        if (media instanceof Playable) {
            btnPlay.setVisible(true);

        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddtoCart, new Insets(0, 0, 0, 100));
        }
    }

    @FXML
    void btnAddtoCartClicked(ActionEvent event) {
        cart.addMedia(media);
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        StringBuffer content = new StringBuffer();
        content.append("Title: " + media.getTitle() + "\n");
        content.append("Category: " + media.getCategory() + "\n");
        alert.setContentText(content.toString());
        alert.setHeaderText("Playing Media");
        alert.showAndWait();
    }

}
