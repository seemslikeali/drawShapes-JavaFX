package drawShapes;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class ShapeToolbar extends VBox implements ModelListener {
    Button rect, square, circle, oval, line;
    Rectangle rectangle;
    Rectangle sqr;
    Circle crlc;
    Ellipse ovl;
    Rectangle ln;
    InteractionModel iModel;

    public ShapeToolbar() {

        this.rectangle = new Rectangle(30,20);
        this.rect = new Button("Rect",rectangle);
        rect.contentDisplayProperty().setValue(ContentDisplay.TOP);

        this.sqr = new Rectangle(20,20);
        this.square = new Button("Square",sqr);
        square.contentDisplayProperty().setValue(ContentDisplay.TOP);

        // color = selectedShape == RECT ? getColor(iModel.selectedColor) : black;
        this.crlc = new Circle(10);
        this.circle = new Button("Circle",crlc);
        circle.contentDisplayProperty().setValue(ContentDisplay.TOP);

        this.ovl = new Ellipse(15,10);
        this.oval = new Button("Oval",ovl);
        oval.contentDisplayProperty().setValue(ContentDisplay.TOP);

        this.ln = new Rectangle(26,3);
        ln.setRotate(345);
        this.line = new Button("Line",ln);
        line.contentDisplayProperty().setValue(ContentDisplay.TOP);


        rect.setMaxWidth(Double.MAX_VALUE);
        rect.prefHeightProperty().bind(this.heightProperty());
        rect.setOnAction(e -> {
            this.iModel.setSelectedShape(Shape.RECTANGLE);
        });

        square.setMaxWidth(Double.MAX_VALUE);
        square.prefHeightProperty().bind(this.heightProperty());
        square.setOnAction(e -> this.iModel.setSelectedShape(Shape.SQUARE));

        circle.setMaxWidth(Double.MAX_VALUE);
        circle.prefHeightProperty().bind(this.heightProperty());
        circle.setOnAction(e -> this.iModel.setSelectedShape(Shape.CIRCLE));

        oval.setMaxWidth(Double.MAX_VALUE);
        oval.prefHeightProperty().bind(this.heightProperty());
        oval.setOnAction(e -> this.iModel.setSelectedShape(Shape.OVAL));

        line.setMaxWidth(Double.MAX_VALUE);
        line.prefHeightProperty().bind(this.heightProperty());
        line.setOnAction(e -> this.iModel.setSelectedShape(Shape.LINE));

        this.getChildren().addAll(rect,square,circle,oval,line);

    }

    public void changeColorsShape(){
        if (this.iModel.getSelectedShape() == Shape.RECTANGLE) {
            this.rectangle.setFill(DrawingView.getColor(this.iModel.selectedColour));
        } else {
            this.rectangle.setFill(Color.BLACK);
        }

        if (this.iModel.getSelectedShape() == Shape.SQUARE) {
            this.sqr.setFill(DrawingView.getColor(this.iModel.selectedColour));
        } else {
            this.sqr.setFill(Color.BLACK);
        }

        if (this.iModel.getSelectedShape() == Shape.CIRCLE) {
            this.crlc.setFill(DrawingView.getColor(this.iModel.selectedColour));
        } else {
            this.crlc.setFill(Color.BLACK);
        }

        if (this.iModel.getSelectedShape() == Shape.OVAL) {
            this.ovl.setFill(DrawingView.getColor(this.iModel.selectedColour));
        } else {
            this.ovl.setFill(Color.BLACK);
        }

        if (this.iModel.getSelectedShape() == Shape.LINE) {
            this.ln.setFill(DrawingView.getColor(this.iModel.selectedColour));
        } else {
            this.ln.setFill(Color.BLACK);
        }
    }

    public void setiModel(InteractionModel iModel) {
        this.iModel = iModel;
    }

    @Override
    public void update() {
        changeColorsShape();
    }
}
