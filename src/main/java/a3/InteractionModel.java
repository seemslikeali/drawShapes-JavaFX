package a3;

import java.util.ArrayList;

public class InteractionModel {
    Colour selectedColour;
    Shape selectedShape;
    private ArrayList<ModelListener> subscribers;


    public void addSubscriber(ModelListener aSub){
        subscribers.add(aSub);
    }
    private void notifySubscribers() {
        for (ModelListener temp : subscribers) {
            temp.update();
        }
    }

    public InteractionModel() {
        this.selectedColour = Colour.AQUA;
        this.selectedShape = Shape.RECTANGLE;
        this.subscribers = new ArrayList<>();
    }

    public void selectedColor(Colour colour) {

        this.selectedColour = colour;
        notifySubscribers();
        System.out.println(selectedColour);
    }

    public void setSelectedShape(Shape shape) {
        this.selectedShape = shape;
        System.out.println(selectedShape);
        notifySubscribers();
    }

    public Colour getSelectedColor() {
        return selectedColour;

    }

    public Shape getSelectedShape() {
        return selectedShape;
    }
}
