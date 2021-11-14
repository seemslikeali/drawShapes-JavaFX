package drawShapes;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.application.Application;

public class DrawApp extends Application {
    @Override
    public void start(Stage stage) {
//        HBox mainUI = new HBox();
        BorderPane root = new BorderPane();

        DrawingView main = new DrawingView();
        DrawingModel model = new DrawingModel();
        ShapeToolbar shapeTB = new ShapeToolbar();
        ColourToolbar colorTB = new ColourToolbar();
        InteractionModel iModel = new InteractionModel();
        DrawingController controller = new DrawingController();

        shapeTB.setiModel(iModel);
        colorTB.setiModel(iModel);

        model.addSubscriber(main);
        model.addSubscriber(shapeTB);
        iModel.addSubscriber(shapeTB);

        main.setModel(model);
        controller.setModel(model);
        controller.setiModel(iModel);


        main.setOnMousePressed(controller::handleMousePressed);
        main.setOnMouseDragged(controller::handleMouseDragged);

//        mainUI.getChildren().addAll(shapeTB.getShapes(), main,colorTB.getColors());
//        root.getChildren().addAll(shapeTB.getShapes(), main,colorTB.getColors());
        root.setLeft(shapeTB.getShapes());
        root.setCenter(main);
        root.setRight(colorTB.getColors());
        Scene scene = new Scene(root);
        stage.setTitle("Assignment 3");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}