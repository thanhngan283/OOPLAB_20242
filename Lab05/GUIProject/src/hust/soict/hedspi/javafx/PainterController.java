package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class PainterController {
    private double x, y;
    private Rectangle eraser = new Rectangle(0, 0, 10, 10);

    @FXML
    private ColorPicker colorSelector;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private ToggleGroup tools;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseClicked(MouseEvent event) {
        Shape shape;
        if (((RadioButton) tools.getSelectedToggle()).getText().equals("Eraser")) {
            shape = new Rectangle(event.getX() - 5, event.getY() - 5, 10, 10);
            shape.styleProperty().set("-fx-fill: white;");
        } else {
            shape = new Circle(event.getX(), event.getY(), 2, Color.BLACK);
            shape.styleProperty().set("-fx-fill: " + colorSelector.getValue().toString().replace("0x", "#") + ";");
        }
        drawingAreaPane.getChildren().add(shape);
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Line newLine = new Line(x, y, event.getX(), event.getY());
        if (((RadioButton) tools.getSelectedToggle()).getText().equals("Eraser")) {
            newLine.styleProperty().set("-fx-stroke: white; -fx-stroke-width: 10;");
            eraser.setX(event.getX() - 5);
            eraser.setY(event.getY() - 5);
        } else {
            newLine.styleProperty().set(
                    "-fx-stroke: " + colorSelector.getValue().toString().replace("0x", "#") + "; -fx-stroke-width: 2;");
        }
        drawingAreaPane.getChildren().add(newLine);
        x = event.getX();
        y = event.getY();
    }

    @FXML
    void drawingAreaMouseMoved(MouseEvent event) {
        if (((RadioButton) tools.getSelectedToggle()).getText().equals("Eraser")) {
            eraser.setX(event.getX() - 5);
            eraser.setY(event.getY() - 5);
        }
        x = event.getX();
        y = event.getY();
    }

    @FXML
    void selectPen(ActionEvent event) {
        drawingAreaPane.getChildren().remove(eraser);
    }

    @FXML
    void selectEraser(ActionEvent event) {
        eraser.styleProperty().set("-fx-fill: white;-fx-stroke: black;");
        drawingAreaPane.getChildren().add(eraser);
    }

}