package drawShapes;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class MainUI extends BorderPane {
    HBox container;
    ShapeToolbar shapes;
    ColourToolbar colors;
    DrawingView canvas;

    public MainUI() {
        this.container = new HBox();
        this.shapes = new ShapeToolbar();
        this.colors = new ColourToolbar();
        this.canvas = new DrawingView();
    }


    public Node getView() {
        return container;
    }

    public DrawingView getCanvas() {
        return canvas;
    }

}
