package drawShapes;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MiniView extends DrawingView {
    Canvas miniCanvas;
    GraphicsContext gc;
    DrawingModel model;
    InteractionModel iModel;


    MiniView(){
        setStyle("-fx-background-color: LIGHTGRAY");
        miniCanvas = new Canvas(10,10);
        setMaxHeight(myCanvas.getHeight()/5);
        setMaxWidth(myCanvas.getHeight()/5);
        gc = miniCanvas.getGraphicsContext2D();
    }

    public void Draw(){
        gc.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
        model.shapelist.forEach(item -> {
            switch (item) {
                case XCircle e -> this.drawCIRCLE(e.x, e.y, e.height/5, e.width/5, e.colour);
                case XOval e -> this.drawOVAL(e.x, e.y, e.height/5, e.width/5, e.colour);
                case XSquare e -> this.drawSQUARE(e.x, e.y, e.height/5, e.width/5, e.colour);
                case XRectangle e -> this.drawRECTANGLE(e.x, e.y, e.height/5, e.width/5, e.colour);
                case XLine e -> this.drawLINE(e.x, e.y, e.height/5, e.width/5, e.colour);
                case XShape di -> System.out.println("Error: fell through to DrawingItem");
            }
        });
    }
    private void drawCIRCLE(double x, double y, double height, double width, Colour colour) {
        gc.setFill(getColor(colour));
        gc.fillOval(x, y, width, width);
    }
    private void drawOVAL(double x, double y, double height, double width, Colour colour) {
        gc.setFill(getColor(colour));
        gc.fillOval(x, y, width, height);
    }
    private void drawSQUARE(double x, double y, double height, double width, Colour colour) {
        gc.setFill(getColor(colour));
        gc.fillRect(x, y, width, width);
    }
    private void drawRECTANGLE(double x, double y, double height, double width, Colour colour) {
        gc.setFill(getColor(colour));
        gc.fillRect(x, y, width, height);
    }

    private void drawLINE(double x, double y, double height, double width, Colour colour) {
        gc.setFill(getColor(colour));
        gc.fillRect(x, y, width, 4);
    }

    public static Color getColor(Colour color) {
        Color result = Color.RED;
        switch (color){
            case AQUA -> result = Color.AQUA;
            case VIOLET -> result = Color.VIOLET;
            case GREEN -> result = Color.GREEN;
            case GOLD -> result = Color.GOLD;
            case CORAL -> result = Color.CORAL;
            case FUCHSIA -> result = Color.FUCHSIA;
            case PERU -> result = Color.PERU;
            case ORANGE -> result = Color.ORANGE;
        }
        return result;
    }

    @Override
    public void update() {
        this.Draw();
    }

}
