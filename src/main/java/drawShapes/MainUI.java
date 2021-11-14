package drawShapes;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class MainUI extends Pane {
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
