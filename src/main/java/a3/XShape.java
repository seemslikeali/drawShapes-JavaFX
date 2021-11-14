package a3;

public class XShape {
    double x;
    double y;
    Colour colour;
    double height;
    double width;
    double fX;
    double fY;

    public XShape(double x, double y, Colour colour, double width, double height) {
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.width = width;
        this.height = height;

    }

    public void updateCoord(double x, double y){
        this.x = x;
        this.y = y;

    }

    public void setfX(double fX) {
        this.fX = fX;
    }

    public void setfY(double fY) {
        this.fY = fY;
    }
}
