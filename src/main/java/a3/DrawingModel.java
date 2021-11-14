package a3;

import java.util.ArrayList;

public class DrawingModel {
    public ArrayList<XShape> shapelist;
    private ArrayList<ModelListener> subscribers;

    public void addSubscriber(ModelListener aSub) {
        subscribers.add(aSub);
    }

    public DrawingModel() {
        this.shapelist = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public void DragSizer() {
        subscribers.get(0).update();
//        System.out.println("updated drawsizer");
    }

    public void addShape(XShape xShape) {
        System.out.println(xShape.colour);
        this.shapelist.add(xShape);
        System.out.println(shapelist.size());
        notifySubscribers();
    }

    public ArrayList<XShape> getShapelist() {
        return shapelist;
    }

    private void notifySubscribers() {
        for (ModelListener temp : subscribers) {
            temp.update();
        }
    }
}
