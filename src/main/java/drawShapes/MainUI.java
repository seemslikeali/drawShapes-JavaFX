package drawShapes;

import javafx.geometry.Pos;
import javafx.scene.layout.*;

public class MainUI extends BorderPane {
    StackPane canvasMini;
    ShapeToolbar shapes;
    ColourToolbar colors;
    DrawingView canvas;
    MiniView mini;

    public MainUI(MiniView m) {

        this.canvasMini = new StackPane();
        this.mini = m;
        this.shapes = new ShapeToolbar();
        this.colors = new ColourToolbar();
        this.canvas = new DrawingView();

        canvasMini.getChildren().addAll(canvas, mini);
        canvasMini.setAlignment(mini, Pos.TOP_LEFT);

        this.setLeft(shapes);
        this.setCenter(canvasMini);
        this.setRight(colors);

    }

    public DrawingView getCanvas() {
        return canvas;
    }

}
