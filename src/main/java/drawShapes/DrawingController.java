package drawShapes;

import javafx.scene.input.MouseEvent;

public class DrawingController {
    DrawingModel model;
    private double x;
    private double y;
    InteractionModel iModel;


    public DrawingController() {
    }

    public void setModel(DrawingModel model) {
        this.model = model;
    }

    public void setiModel(InteractionModel iModel){
        this.iModel = iModel;
    }

    public void handleMousePressed(MouseEvent e) {
       x = e.getX();
       y = e.getY();
       System.out.println(x);
       System.out.println(y);

        double xVal = (e.getX());
        double yVal = (e.getY());

        switch (this.iModel.getSelectedShape()) {
            case RECTANGLE -> {
                this.model.addShape(new XRectangle(xVal, yVal, iModel.getSelectedColor(), 60, 50));
                this.model.shapelist.get(this.model.shapelist.size() - 1).fX = xVal;
                this.model.shapelist.get(this.model.shapelist.size() - 1).fY = yVal;
            }
            case SQUARE -> {
                this.model.addShape(new XSquare(xVal, yVal, iModel.getSelectedColor(), 50, 50));
                this.model.shapelist.get(this.model.shapelist.size() - 1).fX = xVal;
                this.model.shapelist.get(this.model.shapelist.size() - 1).fY = yVal;
            }
            case CIRCLE -> {
                this.model.addShape(new XCircle(xVal, yVal, iModel.getSelectedColor(), 50, 50));
                this.model.shapelist.get(this.model.shapelist.size() - 1).fX = xVal;
                this.model.shapelist.get(this.model.shapelist.size() - 1).fY = yVal;
            }
            case OVAL -> {
                this.model.addShape(new XOval(xVal, yVal, iModel.getSelectedColor(), 60, 36));
                this.model.shapelist.get(this.model.shapelist.size() - 1).fX = xVal;
                this.model.shapelist.get(this.model.shapelist.size() - 1).fY = yVal;
            }
            case LINE -> {
                this.model.addShape(new XLine(xVal, yVal, iModel.getSelectedColor(), 50, 3));
                this.model.shapelist.get(this.model.shapelist.size() - 1).fX = xVal;
                this.model.shapelist.get(this.model.shapelist.size() - 1).fY = yVal;
            }
        }
    }

    public void handleMouseDragged(MouseEvent e) {
        XShape shape = this.model.shapelist.get(this.model.shapelist.size() - 1);
        shape.width =  Math.abs(e.getX() - shape.fX);
        shape.height =  Math.abs(e.getY() - shape.fY);
        if (e.getX() - shape.fX < 0)
            shape.x = e.getX();
        if ((e.getY() - shape.fY) < 0)
            shape.y = e.getY();

        model.DragSizer();
    }


}
